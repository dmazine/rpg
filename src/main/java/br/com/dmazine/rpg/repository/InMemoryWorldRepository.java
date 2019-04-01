package br.com.dmazine.rpg.repository;

import br.com.dmazine.rpg.world.DarkCastle;
import br.com.dmazine.rpg.world.World;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class InMemoryWorldRepository implements WorldRepository {

    private Map<String, World> worlds = new HashMap<>();

    public InMemoryWorldRepository() {
        saveWorld(new DarkCastle());
    }

    @Override
    public void saveWorld(World world) {
        worlds.put(world.getId(), world);
    }

    @Override
    public World findById(String id) {
        final World world = worlds.get(id);
        if (world == null) {
            throw new NotFoundRepositoryException(String.format("World %s not found", id));
        }

        return world;
    }

    @Override
    public Collection<World> findAll() {
        return Collections.unmodifiableCollection(worlds.values());
    }

}
