# Text Based Role Playing Game

This is a simple text based RPG built for studying purposes.

## Building the application

It is a [maven](http://maven.apache.org/), it must be installed. 

Go to the project directory and type the following command:

```
mvn clean compile
```

## Running the application

After building the application, type the command bellow:

```
mvn exec:java
```

Once the application starts, you will be asked to enter a command.

The following commands are available:

* `help` Shows these help message.
* `exit` Exits from the application.
* `world list` List the available worlds.
* `character list` Lists the available characters.
* `character new <name>` Creates a new character.
* `game new <world> <character>` Starts a new game.
* `game load <name>` Loads a saved the game.
* `game save <name>` Saves the game.
* `game status` Displays the game status.
* `game quit` Quits the game.
* `player move [north|south|east|west]` Moves to the specified direction.
* `player collect` Collect the available items.
* `player use <weapon>` Select the weapon to use.
* `player attack ` Attacks the enemy.
