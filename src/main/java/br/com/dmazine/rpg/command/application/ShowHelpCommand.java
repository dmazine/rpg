package br.com.dmazine.rpg.command.application;

import br.com.dmazine.rpg.Application;

public class ShowHelpCommand extends AbstractApplicationCommand {

    public ShowHelpCommand(Application application) {
        super(application);
    }

    @Override
    public void execute() {
        getApplication().showHelp();
    }

}
