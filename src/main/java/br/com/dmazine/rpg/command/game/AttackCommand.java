package br.com.dmazine.rpg.command.game;

import br.com.dmazine.rpg.Game;

public class AttackCommand extends AbstractGameCommand {

    public AttackCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        getGame().getPlayer().attack();
    }

}
