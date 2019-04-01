package br.com.dmazine.rpg.location;

import br.com.dmazine.rpg.Entity;
import br.com.dmazine.rpg.character.Character;
import br.com.dmazine.rpg.item.Item;

public class Location extends Entity {

    private String name;

    private String description;

    private Location locationToNorth;

    private Location locationToSouth;

    private Location locationToEast;

    private Location locationToWest;

    private Item item;

    private Character enemy;

    public Location(String id, String name) {
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

    public Location getLocationToNorth() {
        return locationToNorth;
    }

    public void setLocationToNorth(Location locationToNorth) {
        this.locationToNorth = locationToNorth;
    }

    public Location getLocationToSouth() {
        return locationToSouth;
    }

    public void setLocationToSouth(Location locationToSouth) {
        this.locationToSouth = locationToSouth;
    }

    public Location getLocationToEast() {
        return locationToEast;
    }

    public void setLocationToEast(Location locationToEast) {
        this.locationToEast = locationToEast;
    }

    public Location getLocationToWest() {
        return locationToWest;
    }

    public void setLocationToWest(Location locationToWest) {
        this.locationToWest = locationToWest;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public Character getEnemy() {
        return enemy;
    }

    public void setEnemy(Character enemy) {
        this.enemy = enemy;
    }

}
