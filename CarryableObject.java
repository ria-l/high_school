/**
 * Base carryable object class<br>
 * This class sets the default values for all carryable objects<br>
 * @author Ria Ludemann
 * @version 052004
 */
class CarryableObject extends ZorkObject
{
    private Player carriedBy = null;
    public CarryableObject(String name, Room initialLocation) { super(name, initialLocation); }
    public boolean canTake() { return true; }
    public boolean canToss() { return true; }
    public boolean canFeed() { return true; }
    public boolean canEat()  { return true; }
    /**
     * gets location, even if being carried
     * @return location of object
     */
    public Room getLocation()
    {
        if(carriedBy == null)
            return super.getLocation();
        else
            return carriedBy.getLocation();
    }
    /** takes object and adds it to player's inventory */
    public void takeIt(Player player) { carriedBy = player; }
    /** tosses object and leaves it where it was tossed */
    public void tossIt()
    {
        setLocation(carriedBy.getLocation());
        carriedBy = null;
    }
    /** player eats object */
    public void eatIt() { carriedBy = null; }
}