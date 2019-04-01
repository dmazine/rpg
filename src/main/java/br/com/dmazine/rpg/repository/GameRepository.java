package br.com.dmazine.rpg.repository;

import br.com.dmazine.rpg.Game;

public interface GameRepository {

    void saveGame(String name, Game game);

    Game loadGame(String name);

}
