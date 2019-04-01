package br.com.dmazine.rpg.command.application;

import br.com.dmazine.rpg.Application;

public class NewGameCommand extends AbstractApplicationCommand {

    private String world;

    private String character;

    public NewGameCommand(Application application, String world, String character) {
        super(application);
        this.world = world;
        this.character = character;
    }

    @Override
    public void execute() {
        getApplication().startGame(world, character);
    }

}
