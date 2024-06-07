import java.util.*;
import java.io.*;
/**
 * Creates room, places items, interprets the commands from "command" and executes.
 * basically runs the game.
 * @author Ria Ludemann
 * @version 052004
 */
class Zork
{
    public Zork()
    {
        // initializing the rooms and their exits
        room1.addExit("north", room2);
        room2.addExit("north", room6); room2.addExit("south", room1); room2.addExit("west",  room3);
        room3.addExit("east",  room2); room3.addExit("north", room4); room3.addExit("west",  room5);
        room4.addExit("south", room3); room4.addExit("west",  room5);
        room5.addExit("east",  room4); room5.addExit("north", room6); room5.addExit("south", room3);
        room6.addExit("east",  room2); room6.addExit("south", room5); room6.addExit("west",  room7);
        room7.addExit("east",  room6); room7.addExit("west",  room8);
        room8.addExit("east",  room7);
    }
    // creates the rooms and all objects
    public Room room1 = new Room("room 1");
    public Room room2 = new Room("room 2");
    public Room room3 = new Room("room 3");
    public Room room4 = new Room("room 4");
    public Room room5 = new Room("room 5");
    public Room room6 = new Room("room 6");
    public Room room7 = new Room("room 7");
    public Room room8 = new Room("room 8");
    public Player player = new Player("player", room1);
    public BeerBottle beerBottle = new BeerBottle("beer bottle", room1);
    public Owl owl = new Owl("owl", room8);
    public River river = new River("river", room8);
    public Food food = new Food("food", room4);
    public Enemy enemy = new Enemy("enemy", room7);
    public boolean finished = false;
    /** forces game to finish */
    void finish() { finished = true; }
    /** translates Strings to ZorkObjects, so that the actions can be done */
    public ZorkObject lookupObject(String name)
    {
        if (name.equals("beer"))   { return beerBottle;}
        if (name.equals("bottle")) { return beerBottle;}
        if(name.equals("owl"))     { return owl; }
        if(name.equals("food"))    { return food; }
        return null;
    }
    /** plays the game! Sets a loop until finished is set as true. */
    void playGame()
    {
        Parser parser = new Parser();
        player.printCarrying(); // prints inventory every turn
        System.out.println("You are at: " + player.getLocation().getName());
        player.getLocation().printItems(player); // prints items in room
        while(!finished)
        {
            if(player.getLocation() == enemy.getLocation())
            // if in enemy room, enemy attacks
            {   enemy.attack(beerBottle, this); }
            // reads commands. if either word is invalid, have to try again.
            // if 'quit', then finished = true
            Command command = parser.getCommand();
            String commandWord = command.getCommandWord();
            if (commandWord == null)
            {
                System.out.print("Invalid command: try one of these: ");
                parser.showCommands();
            } else {
                String commandWordTwo = command.getSecondWord();
                if(commandWordTwo == null)
                {   System.out.print("You need a second word!"); }
                else if (commandWord.equals("quit"))
                {   finished = true; }
                else if(commandWord.equals("go"))     { player.go(commandWordTwo, enemy); }
                else if(commandWord.equals("toss"))   { player.toss(lookupObject(commandWordTwo)); }
                else if(commandWord.equals("take"))   { player.take(lookupObject(commandWordTwo)); }
                else if(commandWord.equals("feed"))   { owl.feed(lookupObject(commandWordTwo), this); }
                else if(commandWord.equals("eat"))    { player.eat(lookupObject(commandWordTwo)); }
                else if(commandWord.equals("attack")) { player.attack(enemy);}
                else                                  { System.out.println("I don't know what " + commandWord + "is."); }
            }
        }
    }
}