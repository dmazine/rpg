package br.com.dmazine.rpg.command.game;

import br.com.dmazine.rpg.Game;
import br.com.dmazine.rpg.character.Player;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class MoveSouthCommandTest {

    @Test
    public void executingComand_shouldCallApplication() {
        final Player player = mock(Player.class);

        final Game game = mock(Game.class);
        when(game.getPlayer()).thenReturn(player);

        final MoveSouthCommand command = new MoveSouthCommand(game);
        command.execute();

        verify(player, times(1)).moveSouth();
    }

}