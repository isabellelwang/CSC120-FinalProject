public class Fishingpole extends PhysicalThing {

    private User owner;
    private static int length;  
    
    public Fishingpole() {
        super(); 
        this.owner = new User(); 
        length = 2; 
    }

    public Fishingpole(String name) {
        super(); 
        length = 2; 
    }

    /**
     * Constructs a fishing pole 
     * @param owner String owner's name of the fishing pole
     * @param length 
     */
    public Fishingpole(User owner, int l) {
        super(); 
        this.owner = owner;
        length = l; 
    }

    public Fishingpole(User owner) {
        super(); 
        new Fishingpole(owner, 2); 
    }
    
    public static int getLength() {
        return length; 
    }

    public User getOwner() {
        return this.owner; 
    }

    public void extendPole(int x, int y) {
        if(Math.abs(x) > getLength() || Math.abs(y) > getLength()){
            throw new RuntimeException("Oh no...you extended too far so your fishing pole broke.");
        }
        /*else if (x < 0 || y < 0) {
            throw new RuntimeException("You did not extend the fishing pole at all...");
        } 
        */
        this.moveX(x); 
        this.moveY(y); 
        System.out.println(this.printCoordinates()); 
    }

    /* 
    public void rewindFishingPole() {
        //this.moveX(-(.getX() - this.getX())); 
        //this.moveY(-(owner.getY()- this.getY()));
        System.out.println(this.printCoordinates()); 
    }
    */


    public String printCoordinates() {
        return ("The fishing pole's coordinate is (" + this.getX() + ", " + this.getY() + "). ");
    }
    public String toString() {
        return ("Fishing pole has a length of " + length);
    }
}

