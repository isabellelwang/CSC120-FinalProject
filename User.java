public class User extends PhysicalThing {

    /**
     * String name of user
     * Boat boat of user
     * Fishingpole pole of user
     */
    private String name;
    private Boat boat; 
    private Fishingpole pole; 

    /**
     * Constructs user with coordinate (0,0) and "unknown" as name
     */
    public User() {
        super(); 
        new User("unknown"); 
    }

    /**
     * Constructs User
     * @param name String name of user
     * @param b Boat b of user
     * @param p Fishingpole p of user
     */
    public User(String name, Boat b, Fishingpole p) {
        super(p.getX(), p.getY()); 
        this.name = name; 
        this.boat = new Boat(this); 
        this.pole = new Fishingpole(this); 
    }

    /**
     * Constructs user with name
     * @param name name of the user--String
     */
    public User(String name) {
        super(); 
        this.name = name; 
    }

    /**
     * Accesses pole
     * @return Fishingpole pole and length
     */
    public Fishingpole getPole() {
        return this.pole; 
    }

    /**
     * Accesses the boat
     * @return Boat of the user
     */
    public Boat getBoat() {
        return this.boat; 
    }

    /**
     * Prints out a statement
     */
    public void swim() { 

        System.out.println("You can't swim on the boat. Please jump off the boat if you want to swim.");
    } 

    /**
     * row boat by adding x and y units to the coordinate
     * @param x int x units being added
     * @param y int y units being added
     */
    public void rowBoat(int x, int y) {
        try{
            this.moveX(x); 
            this.moveY(y); 
            pole.moveX(x); 
            pole.moveY(y); 
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }   

    /**
     * prints out a statement
     */
    public void getOnBoat() {
        System.out.println("You are already on the boat.");
    }

    /**
     * Randomly generates a number then prints out the result corresponding to the number. Each result leads to a lose.
     */
    public void jumpOffBoat() {
        int random = (int) (Math.random() * 4);
        if(random == 0) { 
            System.out.println("You jumped off forgetting you cannot swim. So, YOU DROWNED.");
        }
        else if (random == 1) {
            System.out.println("Oh no! You jumped off the boat and got eaten by a shark.");
        }
        else if (random == 2) {
            System.out.println("You got sucked in by a whirlpool and disappeared forever.");
        }
        else {
            System.out.println("You jumped into freezing water and got paralyzed due to hypothermia.");
        }
    }

    /**
     * Extends fishing pole by adding x and y units to previous coordinate
     * @param x int x number of x units
     * @param y int y number of y units
     */
    public void extendFishingPole(int x, int y) {
        try{
            pole.extendPole(x, y); 
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Rewinds fishing pole by changing coordinates back to users' x and y coordinate
     * @param thing Physicalthing being caught
     */
    public void catchItem(PhysicalThing thing) {
        pole.changeCoordinates(this.getX(), this.getY());
        //pole.rewindFishingPole(); 
        System.out.println("You found a " + thing.getClass() + ".");
    }

    /**
     * prints out user options
     */
    public void showOptions() {
        System.out.println("Options:  " + " \n- row boat \n- get on boat \n- jump off boat \n- swim \n- extend fishing pole \n- catch item \n- print my coordinates \n- how to play");
    }

    /**
     * prints coordinates in (x,y) form
     */
    public String printCoordinates() {
        return ("Your coordinates are (" + this.getX() + ", " + this.getY() + ")."); 
    }

    /**
     * print rules of the game
     */
    public void printRules() {
        System.out.println("How to play: ");
        System.out.println("Your mission is to find the lost necklace...");
        System.out.println("The game is a 6 by 6 coordinate system that moves in the positive x and y direction.");
        System.out.println("You can only row your boat 2 units and extend your fishing pole by 3 units. When you extend the fishing pole, you will see if you catch anything. If you extend to the necklace, you win!\nP.S. rowing your boat to the necklace doesn't mean you win. ");
        System.out.println("Eels and Fish are randomly swimming in the ocean...if you extend and catch an eel, you die. If you catch a fish, you get a hint!");
    }

    /**
     * returns string of user name and welcomes user
     */
    public String toString() {
        return (this.name +", Welcome to Fisherman Finds!"); 
    }

    public static void main(String[] args) {
        Boat b = new Boat (); 
        Fishingpole p = new Fishingpole(); 
        User player = new User("Isabelle", b, p); 
        System.out.println(player.getPole());
        System.out.println(player.printCoordinates());
        System.out.println(player.getPole().printCoordinates());

        
        
    }
}