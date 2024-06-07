/**
 * Initiates game. when done, says thanks.
 * @author Ria Ludemann
 * @version 052004
 */
class Main
{
    public static void main (String[] args)
    {
        Zork game = new Zork();
        game.playGame();
        System.out.println("Thanks for playing.");
    }
}