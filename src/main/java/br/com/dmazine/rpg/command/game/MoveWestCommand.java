package br.com.dmazine.rpg.command.game;

import br.com.dmazine.rpg.Game;

public class MoveWestCommand extends AbstractGameCommand {

    public MoveWestCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        getGame().getPlayer().moveWest();
    }

}
