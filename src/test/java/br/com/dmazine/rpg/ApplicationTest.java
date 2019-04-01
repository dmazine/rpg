package br.com.dmazine.rpg;

import br.com.dmazine.rpg.exception.LoadGameException;
import org.junit.Assert;
import org.junit.Test;

public class ApplicationTest {

    @Test
    public void newApplication_shouldHaveACommandReader() {
        final Application application = new Application();
        Assert.assertNotNull(application.getCommandReader());
    }

    @Test
    public void newApplication_shouldHaveAGameRepository() {
        final Application application = new Application();
        Assert.assertNotNull(application.getGameRepository());
    }

    @Test
    public void newApplication_shouldNotHaveAGame() {
        final Application application = new Application();
        Assert.assertNull(application.getGame());
    }

    @Test
    public void newApplication_shouldHaveAGameAfterStartGameCommand() {
        final Application application = new Application();
        application.startGame("darkCastle", "goldenKnight");

        Assert.assertNotNull(application.getGame());
    }

    @Test
    public void savedGame_shouldBeLoaded() {
        final Application application = new Application();
        application.startGame("darkCastle", "goldenKnight");

        application.saveGame("sample");
        application.loadGame("sample");
    }

    @Test(expected = LoadGameException.class)
    public void nonExistingGame_shouldNotBeLoaded() {
        final Application application = new Application();

        application.loadGame("nonExistingGame");
    }

}