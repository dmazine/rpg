package br.com.dmazine.rpg.repository;

import br.com.dmazine.rpg.Game;

public interface GameRepository {

    void save(String name, Game game);

    Game load(String name);

}
