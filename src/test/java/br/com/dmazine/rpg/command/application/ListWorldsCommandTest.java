package br.com.dmazine.rpg.command.application;

import br.com.dmazine.rpg.Application;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ListWorldsCommandTest {

    @Test
    public void executingCommand_shouldCallApplication() {
        final Application application = mock(Application.class);

        final ListWorldsCommand command = new ListWorldsCommand(application);
        command.execute();

        verify(application, times(1)).listWorlds();
    }


}