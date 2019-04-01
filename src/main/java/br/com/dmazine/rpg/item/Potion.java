package br.com.dmazine.rpg.item;

import br.com.dmazine.rpg.Player;

public class Potion extends Item {

    private int healthPoints;

    private int strengthPoints;

    public Potion(String id, String name, int healthPoints, int strengthPoints) {
        super(id, name);
        setHealthPoints(healthPoints);
        setStrengthPoints(strengthPoints);
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    private void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getStrengthPoints() {
        return strengthPoints;
    }

    private void setStrengthPoints(int strengthPoints) {
        this.strengthPoints = strengthPoints;
    }

    @Override
    public void apply(Player player) {
        player.takePotion(this);
    }

}
