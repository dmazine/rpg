package br.com.dmazine.rpg.item;

import br.com.dmazine.rpg.character.Player;

public class Weapon extends Item {

    private int damage;

    public Weapon(String id, String name, int damage) {
        super(id, name);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void apply(Player player) {
        player.addWeapon(this);
    }

}
