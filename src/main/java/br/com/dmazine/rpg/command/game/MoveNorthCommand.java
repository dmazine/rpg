package br.com.dmazine.rpg.command.game;

import br.com.dmazine.rpg.Game;

public class MoveNorthCommand extends AbstractGameCommand {

    public MoveNorthCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        getGame().getPlayer().moveNorth();
    }

}
