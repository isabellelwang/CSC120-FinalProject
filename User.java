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
        System.out.println("Oh no! You jumped off the boat and got eaten by a shark.");
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
        System.out.println("Options:  " + " \n 1. rowBoat() \n 2. getOnBoat() \n 3. jumpOffBoat() \n 4. swim() \n 5. extendFishingPole \n 6. catchItem() \n 7. printCoordinates()  ");
    }

    public String printCoordinates() {
        return ("Your coordinates are (" + this.getX() + ", " + this.getY() + ")."); 
    }

    public String toString() {
        return (this.name +", Welcome to Finding Necklace"); 
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