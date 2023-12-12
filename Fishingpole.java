public class Fishingpole extends PhysicalThing {

    private User owner;
    private double length;  
    
    public Fishingpole() {
        super(); 
        this.owner = new User(); 
        this.length = 2; 
    }

    /**
     * Constructs a fishing pole 
     * @param owner String owner's name of the fishing pole
     * @param length 
     */
    public Fishingpole(User owner, double length) {
        super(); 
        this.owner = owner;
        this.length = length; 
    }

    public Fishingpole(User owner) {
        super(); 
        new Fishingpole(owner, 2); 
    }
    
    public double getLength() {
        return this.length; 
    }

    public User getOwner() {
        return this.owner; 
    }

    public void extendFishingPole(int x, int y) {
        if(Math.abs(x) > this.getLength() || Math.abs(y) > this.getLength()){
            throw new RuntimeException("Oh no...you extended too far so your fishing pole broke.");
        }
        else if (x <= 0 || y<= 0) {
            throw new RuntimeException("You did not extend the fishing pole at all...");
        }
        this.moveX(x); 
        this.moveY(y); 
        System.out.println("You extended your fishing pole " + x + " units!");
    }

    public void rewindFishingPole() {
        this.moveX(-(owner.getX() - this.getX())); 
        System.out.println("Position of fishing pole is now " + this.getX()); 
    }
}

