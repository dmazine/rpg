package br.com.dmazine.rpg;

import br.com.dmazine.rpg.character.Player;
import br.com.dmazine.rpg.command.CommandReader;
import br.com.dmazine.rpg.command.ConsoleCommandReader;
import br.com.dmazine.rpg.exception.GameException;
import br.com.dmazine.rpg.exception.GameOverException;
import br.com.dmazine.rpg.exception.LoadGameException;
import br.com.dmazine.rpg.exception.SaveGameException;
import br.com.dmazine.rpg.location.DarkCastle;
import br.com.dmazine.rpg.location.World;
import br.com.dmazine.rpg.repository.FileGameRepository;
import br.com.dmazine.rpg.repository.GameRepository;

public class Application {

    private CommandReader commandReader;

    private GameRepository gameRepository;

    private boolean exit;

    private Game game;

    public Application() {
        setCommandReader(new ConsoleCommandReader(this));
        setGameRepository(new FileGameRepository(System.getProperty("java.io.tmpdir")));
    }

    public CommandReader getCommandReader() {
        return commandReader;
    }

    private void setCommandReader(CommandReader commandReader) {
        this.commandReader = commandReader;
    }

    public GameRepository getGameRepository() {
        return gameRepository;
    }

    private void setGameRepository(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public boolean isExit() {
        return exit;
    }

    private void setExit(boolean exit) {
        this.exit = exit;
    }

    public void exit() {
        setExit(true);
    }

    public Game getGame() {
        return game;
    }

    private void setGame(Game game) {
        this.game = game;
    }

    public void showHelp() {
        Console.writeln("These are the available commands:");
        Console.writeln();
        Console.writeln("help                            Shows these help message.");
        Console.writeln("exit                            Exits from the application.");
        Console.writeln("new                             Starts a new game.");
        Console.writeln("load <name>                     Loads a saved the game.");
        Console.writeln("save <name>                     Saves the game.");
        Console.writeln("quit                            Quits the game.");
        Console.writeln("move [north|south|east|west]    Moves to the specified direction.");
        Console.writeln("collect                         Collect the available items.");
        Console.writeln("use <weapon>                    Select the weapon to use.");
        Console.writeln("status                          Displays the player and enemy status.");
        Console.writeln("attack                          Attacks the enemy.");
    }

    public void newGame() {
        final World world = new DarkCastle();
        final Player player = new Player("player1", "Player 1", world.getStartLocation());

        setGame(new Game(world, player));
        getGame().showPerspective();
    }

    public void saveGame(String name) {
        try {
            Console.writeln(String.format("Saving game %s.", name));

            getGameRepository().saveGame(name, game);
        } catch (Exception e) {
            throw new SaveGameException(String.format("The game could not be saved. %s", e.getMessage()), e);
        }
    }

    public void loadGame(String name) {
        try {
            Console.writeln(String.format("Loading game %s.", name));

            setGame(getGameRepository().loadGame(name));
            getGame().showPerspective();
        } catch (Exception e) {
            throw new LoadGameException(String.format("The game could not be loaded. %s", e.getMessage()), e);
        }
    }

    public void run() {
        Console.writeln("Welcome to the Text Role Playing Game!", Console.Color.BLUE);
        Console.writeln("Enter a command or type help to view the list of available commands", Console.Color.WHITE);

        while (!isExit()) {
            try {
                getCommandReader().readCommand().execute();
            } catch (GameException e) {
                Console.writeln(e.getMessage(), Console.Color.RED);
            }
        }
    }

    public static void main(String[] args) {
        try {
            Application application = new Application();
            application.run();
        } catch (GameOverException e) {
            Console.writeln(e.getMessage(), Console.Color.RED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
