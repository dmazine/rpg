package br.com.dmazine.rpg.world;

import br.com.dmazine.rpg.location.*;

public class DarkCastle extends World {

    public DarkCastle() {
        super("darkCastle", "Dark Castle");
        setDescription("A dangerous medieval castle in the middle of nowhere.");
        addLocations();
    }

    private void addLocations() {
        final Location greatHall = new GreatHall();

        final Location throneRoom = new ThroneRoom();

        final Location buttery = new Buttery();

        final Location dungeon = new Dungeon();

        final Location bailey = new Bailey();

        final Location sunnyFields = new SunnyFields();

        greatHall.setLocationToNorth(throneRoom);
        addLocation(greatHall);

        throneRoom.setLocationToNorth(dungeon);
        throneRoom.setLocationToSouth(greatHall);
        throneRoom.setLocationToEast(buttery);
        throneRoom.setLocationToWest(bailey);
        addLocation(throneRoom);

        buttery.setLocationToWest(throneRoom);
        addLocation(buttery);

        dungeon.setLocationToSouth(throneRoom);
        addLocation(dungeon);

        bailey.setLocationToEast(throneRoom);
        bailey.setLocationToNorth(sunnyFields);
        addLocation(bailey);


        addLocation(sunnyFields);
    }

}
