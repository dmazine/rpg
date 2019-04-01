package br.com.dmazine.rpg.command.game;

import br.com.dmazine.rpg.Game;

public class MoveEastCommand extends AbstractGameCommand {

    public MoveEastCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        getGame().getPlayer().moveEast();
    }

}
