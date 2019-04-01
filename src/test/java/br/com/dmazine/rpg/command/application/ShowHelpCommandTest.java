package br.com.dmazine.rpg.command.application;

import br.com.dmazine.rpg.Application;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ShowHelpCommandTest {

    @Test
    public void executingComand_shouldCallApplication() {
        final Application application = mock(Application.class);

        final ShowHelpCommand command = new ShowHelpCommand(application);
        command.execute();

        verify(application, times(1)).showHelp();
    }

}