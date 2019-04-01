package br.com.dmazine.rpg.command.application;

import br.com.dmazine.rpg.Application;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class NewGameCommandTest {

    @Test
    public void executingComand_shouldCallApplication() {
        final Application application = mock(Application.class);

        final String worldId = "darkCastle";
        final String characterId = "goldenKnight";

        final NewGameCommand command = new NewGameCommand(application, worldId, characterId);
        command.execute();

        verify(application, times(1)).startGame(worldId, characterId);
    }

}