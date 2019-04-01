package br.com.dmazine.rpg.repository;

import br.com.dmazine.rpg.world.World;

import java.util.Collection;

public interface WorldRepository {

    void saveWorld(World world);

    World findById(String id);

    Collection<World> findAll();

}
