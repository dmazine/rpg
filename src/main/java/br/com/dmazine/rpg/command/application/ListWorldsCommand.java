package br.com.dmazine.rpg.command.application;

import br.com.dmazine.rpg.Application;

public class ListWorldsCommand extends AbstractApplicationCommand {

    public ListWorldsCommand(Application application) {
        super(application);
    }

    @Override
    public void execute() {
        getApplication().listWorlds();
    }

}
