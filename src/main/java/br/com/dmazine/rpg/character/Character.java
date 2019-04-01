package br.com.dmazine.rpg.character;

import br.com.dmazine.rpg.Entity;
import br.com.dmazine.rpg.damage.DamageCalculationStrategy;
import br.com.dmazine.rpg.damage.DefaultDamageCalculationStrategy;
import br.com.dmazine.rpg.item.Weapon;

public abstract class Character extends Entity {

    private String name;

    private int health = 5;

    private int strength = 1;

    private int experience = 1;

    private Weapon weapon;

    private DamageCalculationStrategy damageCalculationStrategy = new DefaultDamageCalculationStrategy();

    public Character(String id, String name) {
        super(id);
        setName(name);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void increaseHealth(int points) {
        this.health += points;
    }

    public void decreaseHealth(int points) {
        this.health -= points;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void increaseStrength(int points) {
        this.strength += points;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void increaseExperience(int points) {
        this.experience += points;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public DamageCalculationStrategy getDamageCalculationStrategy() {
        return damageCalculationStrategy;
    }

    public void setDamageCalculationStrategy(DamageCalculationStrategy damageCalculationStrategy) {
        this.damageCalculationStrategy = damageCalculationStrategy;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public boolean isDead() {
        return health <= 0;
    }

    public void attack(Character target) {
        target.decreaseHealth(damageCalculationStrategy.calculateDamage(this, target));
    }

    public String getStatus() {
        return new StringBuilder(name).append(": health=").append(health).append(", strength=").append(strength)
                .append(", experience=").append(experience).append(", weapon=").append(weapon != null ? weapon.getId() : "none")
                .toString();
    }

}
