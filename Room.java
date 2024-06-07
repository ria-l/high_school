import java.util.*;
import java.io.*;
/**
 * adds exits and items to room, can also retrieve exits and items
 * @author Ria Ludemann
 * @version 052004
 */
class Room extends ZorkObject
{
    private HashMap exits = new HashMap();
    private HashSet items = new HashSet();
    public Room(String name) { super(name, null); }
    /** adds an exit in the direction specified */
    public void addExit(String direction, Room exit) { exits.put(direction, exit); }
    /** adds an item to the specified room */
    public void addItem(ZorkObject item) { items.add(item); }
    /** prints items in the room, not including player */
    public void printItems(Player dontShow)
    {
        for(Iterator it = items.iterator(); it.hasNext();)
        {
            ZorkObject i = (ZorkObject)it.next();
            if (i != dontShow)
            {
                System.out.println("There is " + i.getName() + ".");
            }
        }
    }
    /** @return exit in specified direction */
    public Room getExit(String direction) { return (Room)exits.get(direction); }
    /** @return items in room */
    public HashSet getItems() { return items; }
}