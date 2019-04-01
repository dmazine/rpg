package br.com.dmazine.rpg.command.game;

import br.com.dmazine.rpg.Game;
import br.com.dmazine.rpg.command.Command;
import br.com.dmazine.rpg.exception.GameEndedException;
import br.com.dmazine.rpg.exception.GameRequiredException;

abstract class AbstractGameCommand implements Command {

    private Game game;

    AbstractGameCommand(Game game) {
        if (game == null) {
            throw new GameRequiredException("No game has been started yet.");
        }
        if (game.isEnded()) {
            throw new GameEndedException("This game has already ended.");
        }

        this.game = game;
    }

    Game getGame() {
        return game;
    }

}