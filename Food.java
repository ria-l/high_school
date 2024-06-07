/**
 * Defines reactions to actions
 * @author Ria Ludemann
 * @version 052004
 */
class Food extends CarryableObject
{
    public Food(String name, Room initialLocation) { super(name, initialLocation); }
    public void eat() { System.out.println("You ate the food. Now it's gone."); }
    public void toss() { System.out.println("You tossed the food."); }
    /** feed the owl food, and you win */
    public void feed(Zork zork)
    {
        System.out.println("You fed the food to the owl. Its energy replenished, it flies you out of the cave. You win!");
        zork.finish();
    }
}