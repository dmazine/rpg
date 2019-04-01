package br.com.dmazine.rpg.character;

import br.com.dmazine.rpg.Console;
import br.com.dmazine.rpg.exception.IllegalAttackException;
import br.com.dmazine.rpg.exception.InvalidMovementException;
import br.com.dmazine.rpg.exception.WeaponNotFoundException;
import br.com.dmazine.rpg.experience.DefaultExperienceGainCalculationStrategy;
import br.com.dmazine.rpg.experience.ExperienceGainCalculationStrategy;
import br.com.dmazine.rpg.item.Item;
import br.com.dmazine.rpg.item.Weapon;
import br.com.dmazine.rpg.location.Location;

import java.util.HashMap;
import java.util.Map;

public class Player extends Character {

    private Location location;

    private ExperienceGainCalculationStrategy experienceGainCalculationStrategy = new DefaultExperienceGainCalculationStrategy(1, 2);

    private Map<String, Weapon> weapons = new HashMap<>();

    public Player(String id, String name, Location location) {
        super(id, name);
        setLocation(location);
    }

    public Location getLocation() {
        return location;
    }

    private void setLocation(Location location) {
        this.location = location;
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
        final Enemy enemy = getLocation().getEnemy();
        if (enemy == null) {
            throw new IllegalAttackException("No enemy to attack here");
        }

        attack(enemy);

        if (enemy.isDead()) {
            getLocation().setEnemy(null);
            increaseExperience(experienceGainCalculationStrategy.calculateExperienceGain());

            Console.writeln("The enemy was defeated!", Console.Color.RED);
            return;
        }

        enemy.attack(this);
        if (isDead()) {
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

        final Enemy enemy = getLocation().getEnemy();
        if (enemy != null) {
            Console.writeln(enemy.getDescription(), Console.Color.RED);
            showStatus();
        }

        Console.writeln();
    }

    public void showStatus() {
        Console.writeln(getStatus(), Console.Color.BLUE);

        final Enemy enemy = getLocation().getEnemy();
        if (enemy != null) {
            Console.writeln(enemy.getStatus(), Console.Color.CYAN);
        }

        Console.writeln();
    }

    @Override
    public String getStatus() {
        return new StringBuilder(super.getStatus()).append(", weapons=").append(weapons.keySet()).toString();
    }

}
