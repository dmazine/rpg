package br.com.dmazine.rpg.command.game;

import br.com.dmazine.rpg.Game;

public class CollectItemsCommand extends AbstractGameCommand {

    private String itemId;

    public CollectItemsCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        getGame().getPlayer().collectItems();
    }

}
