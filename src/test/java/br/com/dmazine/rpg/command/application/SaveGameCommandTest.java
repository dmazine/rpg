package br.com.dmazine.rpg.command.application;

import br.com.dmazine.rpg.Application;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class SaveGameCommandTest {

    @Test
    public void executingComand_shouldCallApplication() {
        final Application application = mock(Application.class);

        final String gameName = "myGame";

        final SaveGameCommand command = new SaveGameCommand(application, gameName);
        command.execute();

        verify(application, times(1)).saveGame(gameName);
    }

}