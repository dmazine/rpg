package br.com.dmazine.rpg;

import br.com.dmazine.rpg.character.Character;
import br.com.dmazine.rpg.exception.IllegalAttackException;
import br.com.dmazine.rpg.exception.InvalidMovementException;
import br.com.dmazine.rpg.exception.WeaponNotFoundException;
import br.com.dmazine.rpg.experience.DefaultExperienceGainCalculationStrategy;
import br.com.dmazine.rpg.experience.ExperienceGainCalculationStrategy;
import br.com.dmazine.rpg.item.Item;
import br.com.dmazine.rpg.item.Potion;
import br.com.dmazine.rpg.location.Location;
import br.com.dmazine.rpg.weapon.Weapon;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Player implements Serializable {

    private Character character;

    private Location location;

    private Weapon weapon;

    private Map<String, Weapon> weapons = new HashMap<>();

    private ExperienceGainCalculationStrategy experienceGainCalculationStrategy = new DefaultExperienceGainCalculationStrategy(1, 2);

    public Player(Character character, Location location) {
        setCharacter(character);
        setLocation(location);
    }

    public Character getCharacter() {
        return character;
    }

    private void setCharacter(Character character) {
        this.character = character;
    }

    public Location getLocation() {
        return location;
    }

    private void setLocation(Location location) {
        this.location = location;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public ExperienceGainCalculationStrategy getExperienceGainCalculationStrategy() {
        return experienceGainCalculationStrategy;
    }

    public void setExperienceGainCalculationStrategy(ExperienceGainCalculationStrategy experienceGainCalculationStrategy) {
        this.experienceGainCalculationStrategy = experienceGainCalculationStrategy;
    }

    private void move(Location location) {
        if (location == null) {
            throw new InvalidMovementException("There is no path to there.");
        }

        if (getLocation().getEnemy() != null) {
            throw new InvalidMovementException("The enemy is blocking all exits.");
        }

        setLocation(location);
        showPerspective();
    }

    public void moveNorth() {
        move(getLocation().getLocationToNorth());
    }

    public void moveSouth() {
        move(getLocation().getLocationToSouth());
    }

    public void moveEast() {
        move(getLocation().getLocationToEast());
    }

    public void moveWest() {
        move(getLocation().getLocationToWest());
    }

    public void collectItems() {
        getLocation().getItem().apply(this);
        getLocation().setItem(null);

        showStatus();
    }

    public void takePotion(Potion potion) {
        getCharacter().increaseHealth(potion.getHealthPoints());
        getCharacter().increaseStrength(potion.getStrengthPoints());
    }

    public void addWeapon(Weapon weapon) {
        weapons.put(weapon.getId(), weapon);
        setWeapon(weapon);
    }

    public void selectWeapon(String weaponId) {
        final Weapon weapon = weapons.get(weaponId);
        if (weapon == null) {
            throw new WeaponNotFoundException("I do not have this weapon");
        }

        setWeapon(weapon);
        showStatus();
    }

    public void attack() {
        final Character enemy = getLocation().getEnemy();
        if (enemy == null) {
            throw new IllegalAttackException("No enemy to attack here");
        }

        character.attack(enemy, weapon);

        if (enemy.isDead()) {
            getLocation().setEnemy(null);
            character.increaseExperience(experienceGainCalculationStrategy.calculateExperienceGain());

            Console.writeln("The enemy was defeated!", Console.Color.RED);
            return;
        }

        enemy.attack(character);
        if (character.isDead()) {
            Console.writeln("You were killed by the enemy!", Console.Color.RED);
            Console.writeln("Game Over", Console.Color.RED);
            return;
        }

        showStatus();
    }

    public void showPerspective() {
        Console.writeln(String.format("You are in the %s", getLocation().getName()), Console.Color.PURPLE);
        Console.writeln(getLocation().getDescription(), Console.Color.WHITE);

        final Item item = getLocation().getItem();
        if (item != null) {
            Console.writeln(item.getDescription(), Console.Color.YELLOW);
        }

        final Character enemy = getLocation().getEnemy();
        if (enemy != null) {
            Console.writeln(enemy.getDescription(), Console.Color.RED);
            showStatus();
        }

        Console.writeln();
    }

    public void showStatus() {
        Console.writeln(getStatus(), Console.Color.BLUE);

        final Character enemy = getLocation().getEnemy();
        if (enemy != null) {
            Console.writeln(enemy.getStatus(), Console.Color.CYAN);
        }

        Console.writeln();
    }

    public String getStatus() {
        return new StringBuilder(getCharacter().getStatus()).append(weapon != null ? weapon.getId() : "none")
                .append(", weapons=").append(weapons.keySet()).toString();
    }

}
