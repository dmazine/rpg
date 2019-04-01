package br.com.dmazine.rpg.location;

import br.com.dmazine.rpg.character.KnightSkeleton;

public class ThroneRoom extends Location {

    public ThroneRoom() {
        super("throneRoom", "The Throne Room");
        setDescription("The glow of the two thrones lined with red velvet and covered with gold and diamonds illuminates the place.\n" +
                "In front of me there are stairs that lead to somewhere\n" +
                "On the left a small opening seems to lead to a gloomy place.\n"+
                "On the opposite side, I see rays of light coming in through a half-open door.");
        setEnemy(new KnightSkeleton());
    }

}
