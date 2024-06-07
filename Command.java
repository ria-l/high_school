/**
 * holds the commands until used
 * @author Ria Ludemann
 * @version 052004
 */
class Command
{
    private String commandWord;
    private String secondWord;
    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }
    /** Return the command (first) word. If not understood, null. */
    public String getCommandWord() { return commandWord; }
    /** Return the second word. If not understood, null. */
    public String getSecondWord()  { return secondWord;  }
    /** Return true if this command was not understood. */
    public boolean isUnknown() { return (commandWord == null); }
    /** Return true if the command has a second word. */
    public boolean hasSecondWord() { return (secondWord != null); }
    /** Returns true if second word was not understood */
    public boolean isUnknownTwo() { return (secondWord == null); }
}