package br.com.dmazine.rpg;

import br.com.dmazine.rpg.character.Character;
import br.com.dmazine.rpg.command.CommandReader;
import br.com.dmazine.rpg.command.ConsoleCommandReader;
import br.com.dmazine.rpg.exception.GameOverException;
import br.com.dmazine.rpg.exception.LoadGameException;
import br.com.dmazine.rpg.exception.SaveGameException;
import br.com.dmazine.rpg.repository.*;
import br.com.dmazine.rpg.world.World;

public class Application {

    private CommandReader commandReader;

    private GameRepository gameRepository;

    private WorldRepository worldRepository;

    private CharacterRepository characterRepository;

    private boolean exit;

    private Game game;

    public Application() {
        setCommandReader(new ConsoleCommandReader(this));
        setGameRepository(new FileGameRepository(System.getProperty("java.io.tmpdir")));
        setWorldRepository(new InMemoryWorldRepository());
        setCharacterRepository(new InMemoryCharacterRepository());
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

    public WorldRepository getWorldRepository() {
        return worldRepository;
    }

    private void setWorldRepository(WorldRepository worldRepository) {
        this.worldRepository = worldRepository;
    }

    public CharacterRepository getCharacterRepository() {
        return characterRepository;
    }

    private void setCharacterRepository(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public boolean isExit() {
        return exit;
    }

    private void setExit(boolean exit) {
        this.exit = exit;
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
        Console.writeln("help                                   Shows these help message.");
        Console.writeln("exit                                   Exits from the application.");
        Console.writeln("world list                             List the available worlds.");
        Console.writeln("character list                         Lists the available characters.");
        Console.writeln("character new <name>                   Creates a new character.");
        Console.writeln("game new <world> <character>           Starts a new game.");
        Console.writeln("game load <name>                       Loads a saved the game.");
        Console.writeln("game save <name>                       Saves the game.");
        Console.writeln("game status                            Displays the game status.");
        Console.writeln("game quit                              Quits the game.");
        Console.writeln("player move [north|south|east|west]    Moves to the specified direction.");
        Console.writeln("player collect                         Collect the available items.");
        Console.writeln("player use <weapon>                    Select the weapon to use.");
        Console.writeln("player attack                          Attacks the enemy.");
    }

    public void exit() {
        setExit(true);
    }

    public void listWorlds() {
        worldRepository.findAll().forEach(character -> Console.writeln(character.getId()));
    }

    public void listCharacters() {
        characterRepository.findAll().forEach(character -> Console.writeln(character.getId()));
    }

    public void createCharacter(String name) {
        characterRepository.save(new Character(name, name));
    }

    public void startGame(String worldId, String characterId) {
        final World world = worldRepository.findById(worldId);
        final Character character = characterRepository.findById(characterId);
        final Player player = new Player(character, world.getStartLocation());

        setGame(new Game(world, player));
        getGame().showPerspective();
    }

    public void loadGame(String name) {
        try {
            Console.writeln(String.format("Loading game %s.", name));

            setGame(getGameRepository().load(name));
            getGame().showPerspective();
        } catch (Exception e) {
            throw new LoadGameException(String.format("The game could not be loaded. %s", e.getMessage()), e);
        }
    }

    public void saveGame(String name) {
        try {
            Console.writeln(String.format("Saving game %s.", name));

            getGameRepository().save(name, game);
        } catch (Exception e) {
            throw new SaveGameException(String.format("The game could not be saved. %s", e.getMessage()), e);
        }
    }


    public void run() {
        Console.writeln("Welcome to the Text Role Playing Game!", Console.Color.BLUE);
        Console.writeln("Enter a command or type help to view the list of available commands", Console.Color.WHITE);

        while (!isExit()) {
            try {
                getCommandReader().readCommand().execute();
            } catch (Exception e) {
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
