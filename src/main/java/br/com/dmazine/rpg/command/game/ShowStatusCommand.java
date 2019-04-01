package br.com.dmazine.rpg.command.game;

import br.com.dmazine.rpg.Game;

public class ShowStatusCommand extends AbstractGameCommand {

    public ShowStatusCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        getGame().getPlayer().showStatus();
    }

}
