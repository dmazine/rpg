package br.com.dmazine.rpg.command.application;

import br.com.dmazine.rpg.Application;
import br.com.dmazine.rpg.command.Command;
import br.com.dmazine.rpg.exception.ApplicationRequiredException;

abstract class AbstractApplicationCommand implements Command {

    private Application application;

    AbstractApplicationCommand(Application application) {
        if (application == null) {
            throw new ApplicationRequiredException("An application is required to execute this command");
        }

        this.application = application;
    }

    Application getApplication() {
        return application;
    }

}
