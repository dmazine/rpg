package br.com.dmazine.rpg.location;

import br.com.dmazine.rpg.weapon.Sword;

public class GreatHall extends Location {

    public GreatHall() {
        super("greatHall", "The Great Hall");
        setDescription("Large gray stone walls, covered by beautiful decorations.\n" +
                "On the left there is a fireplace where I can see wood carvings and coats of arms.\n" +
                "A huge intimidating door in front of me seems to be the only possible way.");
        setItem(new Sword());
    }

}
