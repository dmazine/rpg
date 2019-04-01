package br.com.dmazine.rpg.command.application;

import br.com.dmazine.rpg.Application;

public class ListCharactersCommand extends AbstractApplicationCommand {

    public ListCharactersCommand(Application application) {
        super(application);
    }

    @Override
    public void execute() {
        getApplication().listCharacters();
    }

}
