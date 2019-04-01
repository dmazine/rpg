package br.com.dmazine.rpg.command.game;

import br.com.dmazine.rpg.Game;

public class MoveSouthCommand extends AbstractGameCommand {

    public MoveSouthCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        getGame().getPlayer().moveSouth();
    }

}
