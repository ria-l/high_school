/**
 * Does nothing
 * @author Ria Ludemann
 * @version 052004
 */
class River extends ZorkObject
{
    public River(String name, Room initialLocation) { super(name, initialLocation); }
    public boolean canEat()  { return false; }
    public boolean canTake() { return false; }
    public boolean canToss() { return false; }
    public boolean canFeed() { return false; }
}