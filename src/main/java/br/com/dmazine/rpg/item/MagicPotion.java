package br.com.dmazine.rpg.item;

import br.com.dmazine.rpg.character.Player;

public class MagicPotion extends Item {

    private int healthPoints;

    private int strengthPoints;

    public MagicPotion(String id, String name, int healthPoints, int strengthPoints) {
        super(id, name);
        this.healthPoints = healthPoints;
        this.strengthPoints = strengthPoints;
    }

    @Override
    public void apply(Player player) {
        player.increaseHealth(healthPoints);
        player.increaseStrength(strengthPoints);
    }

}
