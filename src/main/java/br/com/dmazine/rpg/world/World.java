package br.com.dmazine.rpg.world;

import br.com.dmazine.rpg.Console;
import br.com.dmazine.rpg.Entity;
import br.com.dmazine.rpg.location.Location;

import java.util.LinkedList;
import java.util.List;

public abstract class World extends Entity {

    private String name;

    private String description;

    private List<Location> locations = new LinkedList<>();

    public World(String id, String name) {
        super(id);
        setName(name);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    public Location getStartLocation() {
        return getLocations().get(0);
    }

    public void showPerspective() {
        Console.writeln(String.format("Welcome to the %s", getName()), Console.Color.CYAN);
        Console.writeln(getDescription(), Console.Color.WHITE);
        Console.writeln();
    }

}
