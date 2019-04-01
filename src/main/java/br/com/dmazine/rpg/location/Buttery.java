package br.com.dmazine.rpg.location;

import br.com.dmazine.rpg.item.MagicPotion;

public class Buttery extends Location {

    public Buttery() {
        super("buttery", "The Buttery");
        setDescription("A small room containing shelves full of dusty bottles.\n" +
                "There are no windows or doors, except that I entered.");
        setItem(new MagicPotion());
    }

}
