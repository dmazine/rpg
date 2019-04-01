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
        return getScanner().nextLine().toLowerCase().split(" +");
    }

    private Command createCommand(String[] tokens) {

        final String command = tokens[0];

        switch (command) {
            case "help":
                return new ShowHelpCommand(application);

            case "exit":
                return new ExitCommand(application);

            case "new":
                return new NewGameCommand(application);

            case "load":
                return createLoadGameCommand(tokens);

            case "save":
                return createSaveGameCommand(tokens);

            case "quit":
                return new QuitGameCommand(application.getGame());

            case "move":
                return createMoveCommand(tokens);

            case "collect":
                return new CollectItemsCommand(application.getGame());

            case "use":
                return createSelectWeaponCommand(tokens);

            case "status":
                return new ShowStatusCommand(application.getGame());

            case "attack":
                return new AttackCommand(application.getGame());

            default:
                throw new InvalidCommandException(String.format("Unknown command %s", command));
        }
    }

    private Command createLoadGameCommand(String[] tokens) {
        if (tokens.length < 2) {
            throw new InvalidCommandException("You need to provide the name of the game to load");
        }

        return new LoadGameCommand(application, tokens[1]);
    }

    private Command createSaveGameCommand(String[] tokens) {
        if (tokens.length < 2) {
            throw new InvalidCommandException("You need to provide the name of the game to save");
        }

        return new SaveGameCommand(application, tokens[1]);
    }

    private Command createMoveCommand(String[] tokens) {
        if (tokens.length < 2) {
            throw new InvalidCommandException("You need to provide the direction to move to");
        }

        final String direction = tokens[1];

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

    private Command createSelectWeaponCommand(String[] tokens) {
        if (tokens.length < 2) {
            throw new InvalidCommandException("Which weapon do you wanna use?");
        }

        return new SelectWeaponCommand(application.getGame(), tokens[1]);
    }

}
