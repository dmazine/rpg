package br.com.dmazine.rpg.command.application;

import br.com.dmazine.rpg.Application;

public class ExitCommand extends AbstractApplicationCommand {

    public ExitCommand(Application application) {
        super(application);
    }

    @Override
    public void execute() {
        getApplication().exit();
    }

}
