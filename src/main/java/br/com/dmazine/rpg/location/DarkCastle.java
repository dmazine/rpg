package br.com.dmazine.rpg.location;

import br.com.dmazine.rpg.character.Enemy;
import br.com.dmazine.rpg.item.Item;
import br.com.dmazine.rpg.item.MagicPotion;
import br.com.dmazine.rpg.item.Weapon;

public class DarkCastle extends World {

    public DarkCastle() {
        super("darkCastle", "Dark Castle");
        setDescription("A dangerous medieval castle in the middle of nowhere.");
        addLocations();
    }

    private void addLocations() {
        final Location greatHall = buildGreatHall();

        final Location throneRoom = buildThroneRoom();

        final Location buttery = buildButtery();

        final Location dungeon = buildDungeon();

        final Location bailey = buildBailey();

        final Location endOfGame = buildEndOfGame();

        greatHall.setLocationToNorth(throneRoom);
        addLocation(greatHall);

        throneRoom.setLocationToNorth(dungeon);
        throneRoom.setLocationToSouth(greatHall);
        throneRoom.setLocationToEast(buttery);
        throneRoom.setLocationToWest(bailey);
        addLocation(throneRoom);

        buttery.setLocationToWest(throneRoom);
        addLocation(buttery);

        dungeon.setLocationToSouth(throneRoom);
        addLocation(dungeon);

        bailey.setLocationToEast(throneRoom);
        addLocation(bailey);

        bailey.setLocationToNorth(endOfGame);
        addLocation(endOfGame);
    }

    private Location buildGreatHall() {
        final Location location = new Location("greatHall", "The Great Hall");
        location.setDescription("Large gray stone walls, covered by beautiful decorations.\n" +
                "On the left there is a fireplace where I can see wood carvings and coats of arms.\n" +
                "A huge intimidating door in front of me seems to be the only possible way.");
        location.setItem(buildSword());
        return location;
    }

    private Weapon buildSword() {
        final Weapon weapon = new Weapon("sword", "Sword", 1);
        weapon.setDescription("A sword with the shiny blade lays on the ground.");
        return weapon;
    }

    private Location buildThroneRoom() {
        final Location location = new Location("throneRoom", "The Throne Room");
        location.setDescription("The glow of the two thrones lined with red velvet and covered with gold and diamonds illuminates the place.\n" +
                "In front of me there are stairs that lead to somewhere\n" +
                "On the left a small opening seems to lead to a gloomy place.\n"+
                "On the opposite side, I see rays of light coming in through a half-open door.");
        location.setEnemy(buildKnightSkeleton());
        return location;
    }

    private Enemy buildKnightSkeleton() {
        final Enemy enemy = new Enemy("knightSkeleton", "Knight Skeleton");
        enemy.setDescription("A knight's skeleton wielding a sword rushes towards you.");
        return enemy;
    }

    private Location buildButtery() {
        final Location location = new Location("buttery", "The Buttery");
        location.setDescription("A small room containing shelves full of dusty bottles.\n" +
                "There are no windows or doors, except that I entered.");
        location.setItem(buildMagicPotion());
        return location;
    }

    private Item buildMagicPotion() {
        final Item item = new MagicPotion("magicPotion", "Magic Potion", 3, 1);
        item.setDescription("A golden bottom containing a magic potion is on the floor.");
        return  item;
    }

    private Location buildDungeon() {
        final Location location = new Location("dungeon", "The Dungeon");
        location.setDescription("A stinking room with three skeletons still chained to the wall.\n" +
                "Rats run over my feet.\n" +
                "No door or window leaves the air with a musty smell.");
        location.setItem(buildSpear());
        return location;
    }

    private Item buildSpear() {
        final Weapon weapon = new Weapon("spear", "Spear", 2);
        weapon.setDescription("A large wooden spear is leaning against the wall.");
        return weapon;
    }

    private Location buildBailey() {
        final Location location = new Location("bailey", "The Bailey");
        location.setDescription("A neglected bed of moss-covered grass is bordered by united flower bushes.\n" +
                "The trees, weeping willows, have stood there for years, and stand like eternal guardians, drawing all attention toward them." +
                "In the distance the suspended portcullis leads out of the castle.");
        location.setEnemy(buildDragon());
        return location;
    }

    private Enemy buildDragon() {
        final Enemy enemy = new Enemy("dragon", "Dragon");
        enemy.setHealth(10);
        enemy.setStrength(3);
        enemy.setDescription("A huge winged dragon spits fire in your direction.");
        return enemy;
    }

    private Location buildEndOfGame() {
        final Location location = new Location("endOfGame", "End Of The Game");
        location.setDescription("You have escaped the dark castle and can continue you quest for new adventures.");
        return location;
    }

}
