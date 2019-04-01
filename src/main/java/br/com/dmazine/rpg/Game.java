package br.com.dmazine.rpg;

import br.com.dmazine.rpg.world.World;

import java.util.UUID;

public class Game extends Entity {

    private World world;

    private Player player;

    private boolean quitted;

    public Game(World world, Player player) {
        super(UUID.randomUUID().toString());
        setWorld(world);
        setPlayer(player);
    }

    public World getWorld() {
        return world;
    }

    private void setWorld(World world) {
        this.world = world;
    }

    public Player getPlayer() {
        return player;
    }

    private void setPlayer(Player player) {
        this.player = player;
    }

    public void showPerspective() {
        getWorld().showPerspective();
        getPlayer().showPerspective();
    }

    public boolean isQuitted() {
        return quitted;
    }

    public void quit() {
        this.quitted = true;
    }

    public boolean isEnded() {
        return isQuitted() || getPlayer().getCharacter().isDead();
    }

}
