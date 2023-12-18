public class Fishingpole extends PhysicalThing {
    /**
     * User owner
     * static int length of fishing pole- this is number of units user can extend fishing pole
     */
    private User owner;
    private static int length;  
    
    /**
     * Constructs a fishing pole with (0,0) coordinates. intializes owner and sets length = 3
     */
    public Fishingpole() {
        super(); 
        this.owner = new User(); 
        length = 3; 
    }

    /**
     * Constructs fishing pole with (0,0) and length 3
     * @param name String name of owner
     */
    public Fishingpole(String name) {
        super(); 
        length = 3; 
    }

    /**
     * Constructs fishing pole with owner and length = 3 and (0,0)
     * @param owner User owner of the fishing pole
     */
    public Fishingpole(User owner) {
        super(); 
        new Fishingpole(owner, 3); 
    }

    /**
     * Constructs a fishing pole 
     * @param owner String owner's name of the fishing pole
     * @param length int length of fishing pole
     */
    public Fishingpole(User owner, int l) {
        super(); 
        this.owner = owner;
        length = l; 
    }
    
    /**
     * Access length of fishing pole
     * @return int length of fishing pole
     */
    public static int getLength() {
        return length; 
    }

    /**
     * Accesses the Owner
     * @return User owner
     */
    public User getOwner() {
        return this.owner; 
    }

    /**
     * extends fishing pole, throws exception if extends too far
     * @param x add length x to fishing pole X coordinate
     * @param y add length y to fishing pole y coordinate
     */
    public void extendPole(int x, int y) {
        if(Math.abs(x) > getLength() || Math.abs(y) > getLength()){
            throw new RuntimeException("Oh no...you extended too far so your fishing pole broke.");
        }
        this.moveX(x); 
        this.moveY(y); 
        System.out.println(this.printCoordinates()); 
    }

    /**
     * Prints x and y coordinate of fishing pole
     */
    public String printCoordinates() {
        return ("The fishing pole's coordinate is (" + this.getX() + ", " + this.getY() + "). ");
    }
    
    /**
     * returns fishing pole's length
     */
    public String toString() {
        return ("Fishing pole has a length of " + length);
    }
}

