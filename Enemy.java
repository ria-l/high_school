/**
 * Defines what the enemy does
 * @author Ria Ludemann
 * @version 052004
 */
class Enemy extends ZorkObject
{
    private boolean dead = false;
    private boolean drunk = false;
    public Enemy(String name, Room initialLocation) { super(name, initialLocation); }
    public boolean canEat()   { return false; }
    public boolean canTake()  { return false; }
    public boolean canToss()  { return false; }
    public boolean canFeed()  { return false; }
    public boolean isDrunk()  { return drunk; }
    /** if beer is in the room, it gets drunk. otherwise, 50/50 chance of killing you. */
    public void attack(BeerBottle beer, Zork zork)
    {
        if(getLocation() == beer.getLocation())
        {
            if(beer.canTake())
            {
                System.out.println("The enemy is drunk and missed!");
            }
        } else {
            double num = Math.random();
            if(num <= .5)
            {
                System.out.println("The enemy attacked you and you died. Game over.");
                zork.finish();
            } else {
                System.out.println("The enemy missed!");
            }
        }
    }
}