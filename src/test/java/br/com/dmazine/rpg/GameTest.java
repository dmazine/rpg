package br.com.dmazine.rpg;

import br.com.dmazine.rpg.character.Player;
import br.com.dmazine.rpg.location.World;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {

    @Test
    public void quiting_shouldEndTheGame() {
        final World world = mock(World.class);
        final Player player = mock(Player.class);

        final Game game = new Game(world, player);
        game.quit();

        Assert.assertEquals(true, game.isEnded());
    }

    @Test
    public void deadPlayer_shouldEndTheGame() {
        final World world = mock(World.class);
        final Player player = mock(Player.class);
        when(player.isDead()).thenReturn(true);

        final Game game = new Game(world, player);

        Assert.assertEquals(true, game.isEnded());
    }

}