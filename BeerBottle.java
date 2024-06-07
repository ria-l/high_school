/**
 * Defines reactions to actions
 * @author Ria Ludemann
 * @version 052004
 */
class BeerBottle extends CarryableObject
{
    private boolean full = true;
    private boolean broken = false;
    public BeerBottle(String name, Room initialLocation) { super(name, initialLocation); }
    /** checks if bottle is full or not. */
    public boolean isFull() { return full; }
    /** if bottle is full, you can feed it. */
    public boolean canFeed() { return full; }
    /** if not carrying and not broken, can take. */
    public boolean canTake(Player player)
    {
        if(player.isCarrying(this) || broken)
        {
            return false;
        } else {
            return true;
        }
    }
    /** if bottle is full, you can eat it. */
    public boolean canEat() { return full; }
    /** @return name, depending on state */
    public String getName()
    {
        if(broken)
        {
            return "a broken beer bottle";
        } else if(full) {
            return "a full beer bottle";
        } else {
            return "an empty beer bottle";
        }
    }
    /** if you eat it, you die. */
    public void eat(Zork zork)
    {
        if(canEat())
        {
            System.out.println("You drank the beer and got drunk. You faint, and get killed by an enemy. Game over.");
            zork.finish();
        } else {
            System.out.println("You can't drink what doesn't exist.");
        }
    }
    /**
     * if you toss it, it breaks.
     * if in river room, it sinks if full, otherwise it floats
     * if in enemy room, distracts enemy.
     */
    public void toss(Enemy enemy, Player player, River river)
    {
        if(enemy.getLocation() != player.getLocation())
        {
            if(river.getLocation() == player.getLocation())
            {
                if(full)
                {
                    System.out.println("You toss the bottle into the water. It sinks.");
                    broken = true;
                } else {
                    System.out.println("You toss the bottle into the water. It floats! You use it to float across.");
                }
            } else {
                System.out.println("You toss the bottle and it smashes to the ground.");
                full = false;
                broken = true;
            }
        } else {
            System.out.println("You toss the bottle and the enemy goes after it.");
            System.out.println("Enemy is drunk! This is your chance!");
            full = false;
        }
    }
    /** feed the beer to the owl, and you die. */
    public void feed(Zork zork)
    {
        System.out.println("You fed the beer to the owl. It died from alcohol poisoning. You die of depression. Game over.");
        zork.finish();
    }
}