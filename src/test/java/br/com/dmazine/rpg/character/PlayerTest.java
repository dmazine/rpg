package br.com.dmazine.rpg.character;

import br.com.dmazine.rpg.Player;
import br.com.dmazine.rpg.exception.InvalidMovementException;
import br.com.dmazine.rpg.exception.WeaponNotFoundException;
import br.com.dmazine.rpg.item.Potion;
import br.com.dmazine.rpg.weapon.Weapon;
import br.com.dmazine.rpg.location.Location;
import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

    @Test(expected = InvalidMovementException.class)
    public void movingWhenThereIsNoPath_shouldFail() {
        final Location greatHall = new Location("greatHall", "The Great Hall");

        final Character character = new Character("knight", "Knight");
        final Player player = new Player(character, greatHall);

        player.moveNorth();
    }

    @Test
    public void movingNorthWhenThereIsAPath_shouldUpdateTheCurrentLocation() {
        final Location throneRoom = new Location("throneRoom", "The Throne Room");

        final Location greatHall = new Location("greatHall", "The Great Hall");
        greatHall.setLocationToNorth(throneRoom);

        final Character character = new Character("knight", "Knight");
        final Player player = new Player(character, greatHall);
        player.moveNorth();

        Assert.assertEquals(throneRoom, player.getLocation());
    }

    @Test
    public void movingSouthWhenThereIsAPath_shouldUpdateTheCurrentLocation() {
        final Location throneRoom = new Location("throneRoom", "The Throne Room");

        final Location greatHall = new Location("greatHall", "The Great Hall");
        greatHall.setLocationToSouth(throneRoom);

        final Character character = new Character("knight", "Knight");
        final Player player = new Player(character, greatHall);
        player.moveSouth();

        Assert.assertEquals(throneRoom, player.getLocation());
    }

    @Test
    public void movingEastWhenThereIsAPath_shouldUpdateTheCurrentLocation() {
        final Location throneRoom = new Location("throneRoom", "The Throne Room");

        final Location greatHall = new Location("greatHall", "The Great Hall");
        greatHall.setLocationToEast(throneRoom);

        final Character character = new Character("knight", "Knight");
        final Player player = new Player(character, greatHall);
        player.moveEast();

        Assert.assertEquals(throneRoom, player.getLocation());
    }

    @Test
    public void movingWestWhenThereIsAPath_shouldUpdateTheCurrentLocation() {
        final Location throneRoom = new Location("throneRoom", "The Throne Room");

        final Location greatHall = new Location("greatHall", "The Great Hall");
        greatHall.setLocationToWest(throneRoom);

        final Character character = new Character("knight", "Knight");
        final Player player = new Player(character, greatHall);
        player.moveWest();

        Assert.assertEquals(throneRoom, player.getLocation());
    }

    @Test(expected = InvalidMovementException.class)
    public void movingWhenThereIsEnemy_shouldNotBeAllowed() {
        final Location throneRoom = new Location("throneRoom", "The Throne Room");

        final Location greatHall = new Location("greatHall", "The Great Hall");
        greatHall.setLocationToNorth(throneRoom);
        greatHall.setEnemy(new Character("knightSkeleton", "Knight Skeleton"));

        final Character character = new Character("knight", "Knight");
        final Player player = new Player(character, greatHall);
        player.moveNorth();
    }

    @Test
    public void collectingMagicPotion_shouldIncreaseHisHealthAndStrength() {
        final int magicPotionHealthPoints = 3;
        final int magicPotionStrengthPoints = 4;

        final Location greatHall = new Location("greatHall", "The Great Hall");
        greatHall.setItem(new Potion("magicPotion", "Magic Potion", magicPotionHealthPoints, magicPotionStrengthPoints));

        final Character character = new Character("knight", "Knight");
        final Player player = new Player(character, greatHall);
        final int oldHealth = player.getCharacter().getHealth();
        final int oldStrength = player.getCharacter().getStrength();

        player.collectItems();

        Assert.assertEquals(oldHealth + magicPotionHealthPoints, player.getCharacter().getHealth());
        Assert.assertEquals(oldStrength + magicPotionStrengthPoints, player.getCharacter().getStrength());
    }

    @Test(expected = WeaponNotFoundException.class)
    public void selectingANonExistingWeapon_shouldFail() {
        final Location greatHall = new Location("greatHall", "The Great Hall");

        final Character character = new Character("knight", "Knight");
        final Player player = new Player(character, greatHall);
        player.selectWeapon("sword");
    }

    @Test
    public void selectingAExistingWeapon_shouldUpdateTheCurrentWeapon() {
        final Location greatHall = new Location("greatHall", "The Great Hall");

        final Weapon weapon = new Weapon("sword", "Sword", 1);
        greatHall.setItem(weapon);

        final Character character = new Character("knight", "Knight");
        final Player player = new Player(character, greatHall);
        player.collectItems();

        player.selectWeapon("sword");

        Assert.assertEquals(weapon, player.getWeapon());
    }

}