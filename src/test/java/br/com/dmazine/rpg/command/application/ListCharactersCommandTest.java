package br.com.dmazine.rpg.command.application;

import br.com.dmazine.rpg.Application;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ListCharactersCommandTest {

    @Test
    public void executingCommand_shouldCallApplication() {
        final Application application = mock(Application.class);

        final ListCharactersCommand command = new ListCharactersCommand(application);
        command.execute();

        verify(application, times(1)).listCharacters();
    }

}