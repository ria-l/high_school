/**
 * Defines reactions to actions
 * @author Ria Ludemann
 * @version 052004
 */
class Owl extends CarryableObject
{
    public Owl(String name, Room initialLocation) { super(name, initialLocation); }
    public boolean canFeed() { return false; }
    /** if the empty beer bottle (not carried) is in the same room as the river, then the owl can be taken. otherwise not. */
    public boolean canTake(River river, BeerBottle beer)
    {
        if(beer.getLocation() == river.getLocation())
        {   if(beer.isFull())
            {   System.out.println("The owl is across the river!");
                return false;
            } else { return true; }
        } else {
             System.out.println("The owl is across the river!");
             return false;
        }
    }
    /** if you eat the owl, you die. */
    public void eat(Zork zork)
    {   System.out.println("You ate the owl and choked on its feathers. Game over.");
        zork.finish();
    }
    /** if you toss the owl, you die. */
    public void toss(Zork zork)
    {   System.out.println("Frightened, the owl flies away, never to return. You die of depression.");
        zork.finish();
    }
    /** feed the owl beer, and die. Feed it food, and win! */
    public void feed(ZorkObject item, Zork zork)
    {   if(item.equals("beer"))
        {   System.out.println("You gave beer to the owl. It died from alcohol poisoning. You die of depression.");
            zork.finish();
        } else if(item.equals("food")) {
            System.out.println("You fed the food to the owl, and it flew you out of the cave. You win!");
            zork.finish();
        } else { System.out.println("You can't feed that to the owl!"); }
    }
}