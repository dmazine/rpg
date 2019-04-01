package br.com.dmazine.rpg.command.application;

import br.com.dmazine.rpg.Application;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class NewCharacterCommandTest {

    @Test
    public void executingCommand_shouldCallApplication() {
        final Application application = mock(Application.class);

        final String name = "knight";

        final NewCharacterCommand command = new NewCharacterCommand(application, name);
        command.execute();

        verify(application, times(1)).createCharacter(name);
    }


}