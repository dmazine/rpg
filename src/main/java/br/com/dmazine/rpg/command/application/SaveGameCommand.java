package br.com.dmazine.rpg.command.application;

import br.com.dmazine.rpg.Application;

public class SaveGameCommand extends AbstractApplicationCommand {

    private String name;

    public SaveGameCommand(Application application, String name) {
        super(application);
        this.name = name;
    }

    @Override
    public void execute() {
        getApplication().saveGame(name);
    }

}
