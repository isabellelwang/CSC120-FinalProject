public class User extends PhysicalThing {
    private String name; 
    private int age; 
    private Boat boat; 
    private Fishingpole pole; 

    public User() {
        super(); 
        new User("unknown", 20); 
    }

    public User(String name, int age) {
        this.name = name; 
        this.age = age; 
        this.boat = new Boat(this); 
        this.pole = new Fishingpole(this); 
    }
    public void swim(int x) { 

        System.out.println("You can't swim on the boat. Please jump off the boat if you want to swim.");
    } 

    public void rowBoat(int x, int y) {
        try{
            this.moveX(x); 
            this.moveY(y); 
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

    public void extendPole(int x, int y) {
        try{
            extendFishingPole(x, y); 
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void catchItem() {
        pole.rewindFishingPole(); 
        System.out.println("You got something!");
    }

    public void showOptions() {
        System.out.println("Options: \n " + "1. rowBoat() \n 2. catchItem \n 3. extendPole() \n 4. swim() \n 5. jumpOffBoat() \n 6. getOnBoat() \n 7. pickUpItem()\n 7.");
    }

    public String printCoordinates() {
        return ("Your coordinates are (" + this.getX() + ", " + this.getY() + ")."); 
    }

    public static void main(String[] args) {
        User player = new User("Isabelle", 18); 

        System.out.println(player.printCoordinates());
        
    }
}