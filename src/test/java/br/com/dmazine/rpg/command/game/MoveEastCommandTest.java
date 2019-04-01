package br.com.dmazine.rpg.command.game;

import br.com.dmazine.rpg.Game;
import br.com.dmazine.rpg.Player;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class MoveEastCommandTest {

    @Test
    public void executingComand_shouldCallApplication() {
        final Player player = mock(Player.class);

        final Game game = mock(Game.class);
        when(game.getPlayer()).thenReturn(player);

        final MoveEastCommand command = new MoveEastCommand(game);
        command.execute();

        verify(player, times(1)).moveEast();
    }

}