package br.com.dmazine.rpg.repository;

import br.com.dmazine.rpg.character.Character;
import br.com.dmazine.rpg.character.GoldenKnight;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class InMemoryCharacterRepository implements CharacterRepository {

    private Map<String, Character> characters = new HashMap<>();

    public InMemoryCharacterRepository() {
        save(new GoldenKnight());
    }

    @Override
    public void save(Character character) {
        characters.put(character.getId(), character);
    }

    @Override
    public void delete(String id) {
        characters.remove(id);
    }

    @Override
    public Character findById(String id) {
        final Character character = characters.get(id);
        if (character == null) {
            throw new NotFoundRepositoryException(String.format("Player %s not found", id));
        }

        return character;
    }

    @Override
    public Collection<Character> findAll() {
        return Collections.unmodifiableCollection(characters.values());
    }

}
