package br.com.dmazine.rpg.item;

import br.com.dmazine.rpg.Entity;
import br.com.dmazine.rpg.Player;

public abstract class Item extends Entity {

    private String name;

    private String description;

    public Item(String id, String name) {
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

    public abstract void apply(Player player);

}
