package br.com.dmazine.rpg.location;

import br.com.dmazine.rpg.weapon.Spear;

public class Dungeon extends Location {

    public Dungeon() {
        super("dungeon", "The Dungeon");
        setDescription("A stinking room with three skeletons still chained to the wall.\n" +
                "Rats run over my feet.\n" +
                "No door or window leaves the air with a musty smell.");
        setItem(new Spear());
    }

}
