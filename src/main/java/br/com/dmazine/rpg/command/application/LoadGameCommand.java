package br.com.dmazine.rpg.command.application;

import br.com.dmazine.rpg.Application;

public class LoadGameCommand extends AbstractApplicationCommand {

    private String name;

    public LoadGameCommand(Application application, String name) {
        super(application);
        this.name = name;
    }

    @Override
    public void execute() {
        getApplication().loadGame(name);
    }

}
