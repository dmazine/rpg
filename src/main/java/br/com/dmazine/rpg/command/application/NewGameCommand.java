package br.com.dmazine.rpg.command.application;

import br.com.dmazine.rpg.Application;

public class NewGameCommand extends AbstractApplicationCommand {

    public NewGameCommand(Application application) {
        super(application);
    }

    @Override
    public void execute() {
        getApplication().newGame();
    }

}
