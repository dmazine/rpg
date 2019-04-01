package br.com.dmazine.rpg.location;

import br.com.dmazine.rpg.character.Dragon;

public class Bailey extends Location {

    public Bailey() {
        super("bailey", "The Bailey");
        setDescription("A neglected bed of moss-covered grass is bordered by united flower bushes.\n" +
                "The trees, weeping willows, have stood there for years, and stand like eternal guardians, drawing all attention toward them." +
                "In the distance the suspended portcullis leads out of the castle.");
        setEnemy(new Dragon());
    }

}
