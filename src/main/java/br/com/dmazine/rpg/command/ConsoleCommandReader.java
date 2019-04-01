package br.com.dmazine.rpg.command;

import br.com.dmazine.rpg.Application;
import br.com.dmazine.rpg.Console;
import br.com.dmazine.rpg.command.application.*;
import br.com.dmazine.rpg.command.game.*;
import br.com.dmazine.rpg.exception.InvalidCommandException;

import java.util.Scanner;

public class ConsoleCommandReader implements CommandReader {

    private Scanner scanner;

    private Application application;

    public ConsoleCommandReader(Application application) {
        this.application = application;
        this.scanner = new Scanner(System.in);
    }

    private Scanner getScanner() {
        return scanner;
    }

    private void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }


    @Override
    public Command readCommand() {
        Console.write("> ", Console.Color.GREEN);

        return createCommand(readInput());
    }

    private String[] readInput() {
        return getScanner().nextLine().split(" +");
    }

    private Command createCommand(String[] tokens) {

        final String command = tokens[0];

        switch (command) {
            case "help":
                return new ShowHelpCommand(application);

            case "exit":
                return new ExitCommand(application);

            case "world":
                return createCommandWorld(tokens);

            case "character":
                return createCommandCharacter(tokens);

            case "game":
                return createCommandGame(tokens);

            case "player":
                return createCommandPlayer(tokens);

            default:
                throw new InvalidCommandException(String.format("Unknown command %s", command));
        }
    }

    private Command createCommandWorld(String[] tokens) {
        if (tokens.length < 2) {
            throw new InvalidCommandException("Missing command argument");
        }

        switch (tokens[1]) {
            case "list":
                return new ListWorldsCommand(application);

            default:
                throw new InvalidCommandException(String.format("Unknown command"));
        }
    }

    private Command createCommandCharacter(String[] tokens) {
        if (tokens.length < 2) {
            throw new InvalidCommandException("Missing command argument");
        }

        switch (tokens[1]) {
            case "list":
                return new ListCharactersCommand(application);

            case "new":
                return createCommandNewCharacter(tokens);

            default:
                throw new InvalidCommandException(String.format("Unknown command"));
        }
    }

    private Command createCommandNewCharacter(String[] tokens) {
        if (tokens.length < 3) {
            throw new InvalidCommandException("Missing command argument");
        }

        return new NewCharacterCommand(application, tokens[2]);
    }

    private Command createCommandGame(String[] tokens) {
        if (tokens.length < 2) {
            throw new InvalidCommandException("Missing command argument");
        }

        switch (tokens[1]) {
            case "new":
                return createCommandNewGame(tokens);

            case "load":
                return createCommandLoadGame(tokens);

            case "save":
                return createCommandSaveGame(tokens);

            case "status":
                return new ShowStatusCommand(application.getGame());

            case "quit":
                return new QuitGameCommand(application.getGame());

            default:
                throw new InvalidCommandException(String.format("Unknown command"));
        }
    }

    private Command createCommandNewGame(String[] tokens) {
        if (tokens.length < 4) {
            throw new InvalidCommandException("Missing command argument");
        }

        return new NewGameCommand(application, tokens[2], tokens[3]);
    }

    private Command createCommandLoadGame(String[] tokens) {
        if (tokens.length < 3) {
            throw new InvalidCommandException("Missing command argument");
        }

        return new LoadGameCommand(application, tokens[2]);
    }

    private Command createCommandSaveGame(String[] tokens) {
        if (tokens.length < 3) {
            throw new InvalidCommandException("Missing command argument");
        }

        return new SaveGameCommand(application, tokens[2]);
    }

    private Command createCommandPlayer(String[] tokens) {
        if (tokens.length < 2) {
            throw new InvalidCommandException("Missing command argument");
        }

        switch (tokens[1]) {
            case "move":
                return createCommandMovePlayer(tokens);

            case "collect":
                return new CollectItemsCommand(application.getGame());

            case "use":
                return createCommandSelectWeapon(tokens);

            case "attack":
                return new AttackCommand(application.getGame());

            default:
                throw new InvalidCommandException(String.format("Unknown command"));
        }

    }

    private Command createCommandMovePlayer(String[] tokens) {
        if (tokens.length < 3) {
            throw new InvalidCommandException("Missing command argument");
        }

        final String direction = tokens[2];

        switch (direction) {
            case "north":
                return new MoveNorthCommand(application.getGame());

            case "south":
                return new MoveSouthCommand(application.getGame());

            case "east":
                return new MoveEastCommand(application.getGame());

            case "west":
                return new MoveWestCommand(application.getGame());

            default:
                throw new InvalidCommandException(String.format("Unknown direction %s", direction));
        }
    }

    private Command createCommandSelectWeapon(String[] tokens) {
        if (tokens.length < 3) {
            throw new InvalidCommandException("Missing command argument");
        }

        return new SelectWeaponCommand(application.getGame(), tokens[2]);
    }

}
