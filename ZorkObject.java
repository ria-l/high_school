import java.util.*;
import java.io.*;
/**
 * Base object class<br>
 * This class sets the default values for all the objects to be used
 * in the game.<br>
 * @author Ria Ludemann
 * @version 052004
 */
class ZorkObject
{
    private String name;
    private Room location = null;
    public ZorkObject(String name, Room initialLocation)
    {
        this.name = name;
        this.location = initialLocation;
        if (initialLocation != null)
        {
            initialLocation.addItem(this);
        }
    }
    public boolean canEat()   { return true; }
    public boolean canTake()  { return true; }
    public boolean canToss()  { return true; }
    public boolean canFeed()  { return true; }
    public void eatIt()       {}
    public void feedIt()      {}
    /** @return location of object */
    public Room getLocation() { return location; }
    /** @return name */
    public String getName()   { return name; }
    /**
     * checks if item is in the room
     * @return true if item is in the room
     */
    public boolean isLocatedIn(Room room) { return getLocation() == room; }
    /** sets old location to new location */
    public void setLocation(Room newLocation) { location = newLocation; }
    public void takeIt(Player player)   {}
    public void tossIt(ZorkObject item) {}
}