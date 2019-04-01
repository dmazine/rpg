package br.com.dmazine.rpg.repository;

import br.com.dmazine.rpg.character.Character;

import java.util.Collection;

public interface CharacterRepository {

    void save(Character player);

    void delete(String id);

    Character findById(String id);

    Collection<Character> findAll();

}
