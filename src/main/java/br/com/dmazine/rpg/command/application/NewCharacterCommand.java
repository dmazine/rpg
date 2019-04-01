package br.com.dmazine.rpg.command.application;

import br.com.dmazine.rpg.Application;

public class NewCharacterCommand extends AbstractApplicationCommand {

    private String name;

    public NewCharacterCommand(Application application, String name) {
        super(application);
        this.name = name;
    }

    @Override
    public void execute() {
        getApplication().createCharacter(name);
    }

}
