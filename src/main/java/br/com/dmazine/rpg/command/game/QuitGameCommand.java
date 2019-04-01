package br.com.dmazine.rpg.command.game;

import br.com.dmazine.rpg.Game;

public class QuitGameCommand extends AbstractGameCommand {

    public QuitGameCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        getGame().quit();
    }

}
