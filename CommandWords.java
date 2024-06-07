/**
 * holds enumeration of all command words in the game<br>
 * recognizes commands as they are typed in
 * @author Ria Ludemann
 * @version 052004
 */
class CommandWords
{
    /** a constant array that holds all valid command words */
    private static final String validCommands[] = { "go", "quit", "take", "feed", "toss", "eat", "attack" };
    /** a constant array that holds all valid objects&direction */
    private static final String validObjects[] = { "food", "beer", "bottle", "owl", "north", "south", "east", "west", "enemy" };
    public CommandWords() {}
    /** Check whether a given String is a valid object word.  */
    public boolean isObject(String aString)
    {
        for(int i = 0; i < validObjects.length; i++)
        {
            if(validObjects[i].equals(aString))
                return true;
        }
        return false;
    }
    /** Checks whether a String is a valid command word. */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++)
        {
            if(validCommands[i].equals(aString))
                return true;
        }
        return false;
    }
    /** Print all valid commands. */
    public void showAll() 
    {
        for(int i = 0; i < validCommands.length; i++)
        {   System.out.print(validCommands[i] + "  "); }
        System.out.println();
    }
}
