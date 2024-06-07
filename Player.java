import java.util.*;
import java.io.*;
/**
 * Defines what the player does
 * @author Ria Ludemann
 * @version 052004
 */
class Player extends ZorkObject
{
    private HashSet items = new HashSet();
    private boolean canLeave = false;
    public Player(String name, Room initialLocation) { super(name, initialLocation); }
    /** if not in the enemy room, goes in specified direction */
    public void go(String direction, Enemy enemy)
    {
        if(getLocation() != enemy.getLocation())
        {
            canLeave = true;
            Room loc = getLocation();
            Room newLoc = loc.getExit(direction);
            if(newLoc == null)
            {
                System.out.println("You can't go " + direction);
            } else {
                setLocation(newLoc);
                System.out.println("You went " + direction + " and are now in " + getLocation().getName());
                getLocation().printItems(this);
                printCarrying();
            }
        } else {
            System.out.println("You can't leave yet!");
        }
    }
    /** @return if you can leave or not */ 
    public boolean canGo() { return canLeave; }
    /** if carrying an object, tosses it */
    public void toss(ZorkObject item)
    {
        if(!isCarrying(item))
        {
            System.out.println("You can't toss what you don't have.");
        } else if(!canToss()) {
            System.out.println("You can't toss that.");
        } else {
            item.tossIt(item);
            items.remove(item);
        }
    }
    /** takes object if it's there */
    public void take(ZorkObject item)
    {
        if(!isLocatedIn(item.getLocation()))
        {
           System.out.println("That isn't here.");
           return;
        }
        else if(!canTake())
        {
            System.out.println("You can't take that.");
            return;
        }
        item.takeIt(this);
        items.add(item);
        System.out.println("You took " + item.getName());
        printCarrying();
    }
    /** checks to see if you're carrying an item. */
    public boolean isCarrying(ZorkObject item) { return items.contains(item); }
    /** if you can eat it, you eat it. */
    public void eat(ZorkObject item)
    {
        if(!isLocatedIn(item.getLocation()))
        {
            System.out.println("You can't eat what isn't there.");
        } else if(!canEat()) {
            System.out.println("You can't eat that.");
        }
        item.eatIt();
    }
    /** prints out the items you're carrying */
    public void printCarrying()
    {
        if(items.size() == 0)
        {
            System.out.println("You're not carrying anything.");
        } else {
            System.out.print("You're carrying:");
            String sep = " ";
            for(Iterator it = items.iterator(); it.hasNext();)
            {
                ZorkObject i = (ZorkObject)it.next();
                System.out.print(sep + i.getName());
                sep = ", ";
            }
            System.out.println("");
        }
    }
    /** 50/50 chance of attacking, unless enemy is drunk */
    public void attack(Enemy enemy)
    {
        double num = Math.random();
        if(num <= .5)
        {
            canLeave = true;
            System.out.println("You attacked the enemy and it died.");
        } else {
            if(enemy.isDrunk())
            {
                canLeave = true;
                System.out.println("You attacked the enemy and it died.");
            } else {
                System.out.println("You missed!");
            }
        }
    }
}