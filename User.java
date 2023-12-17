public class User extends PhysicalThing {
    private String name;
    private Boat boat; 
    private Fishingpole pole; 

    public User() {
        super(); 
        new User("unknown"); 
    }

    public User(String name, Boat b, Fishingpole p) {
        super(p.getX(), p.getY()); 
        this.name = name; 
        this.boat = new Boat(this); 
        this.pole = new Fishingpole(this); 
    }

    public User(String name) {
        super(); 
        this.name = name; 
    }

    public Fishingpole getPole() {
        return this.pole; 
    }

    public Boat getBoat() {
        return this.boat; 
    }


    public void swim() { 

        System.out.println("You can't swim on the boat. Please jump off the boat if you want to swim.");
    } 

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

    public void getOnBoat() {
        System.out.println("You are already on the boat.");
    }

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

    public void extendFishingPole(int x, int y) {
        try{
            pole.extendPole(x, y); 
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void catchItem(PhysicalThing thing) {
        pole.moveX((this.getX() - pole.getX())); 
        pole.moveY((this.getY()- pole.getY()));
        //pole.rewindFishingPole(); 
        System.out.println("You found a " + thing.getClass() + ".");
    }

    public void showOptions() {
        System.out.println("Options:  " + " \n- row boat \n- get on boat \n- jump off boat \n- swim \n- extend fishing pole \n- catch item \n- print my coordinates \n- how to play");
    }

    public String printCoordinates() {
        return ("Your coordinates are (" + this.getX() + ", " + this.getY() + ")."); 
    }

    public void printRules() {
        System.out.println("How to play: ");
        System.out.println("Your mission is to find the lost necklace...");
        System.out.println("The game is a 6 by 6 coordinate system that moves in the positive x and y direction.");
    }

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