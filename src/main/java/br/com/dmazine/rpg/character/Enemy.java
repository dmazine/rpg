package br.com.dmazine.rpg.character;

public class Enemy extends Character {

    private String description;

    public Enemy(String id, String name) {
        super(id, name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
