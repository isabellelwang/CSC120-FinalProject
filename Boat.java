public class Boat extends PhysicalThing {
    /**
     * User owner of the boat
     * static int size of the boat- number of units user would be able to move
     */
    private User owner;
    private static int size; 
    
    /**
     * Constructs a boat with user, sets x and y coordinates, and size to 2 
     * @param owner User owner who owns boat
     */
    public Boat(User owner) {
        super(); 
        this.owner = owner; 
        size = 2; 
    }

    /**
     * Contructs a boat, sets x and y coordinates to 0, size to 2
     */
    public Boat() {
        super(); 
        this.owner = new User(); 
        size = 2; 
    }

    /**
     * Constructs a boat, takes in name, set x and y coordinates to 0, size to 2
     * @param name String name of the owner
     */
    public Boat(String name) {
        super(); 
        size = 2; 
    }

    /**
     * Access owner
     * @return User owner of the boat
     */
    public User getOwner() {
        return this.owner; 
    }

    /**
     * Access size of boat
     * @return size int of the boat
     */
    public static int getSize() {
        return size; 
    }

    /**
     * returns size of boat.
     */
    public String toString() {
        return (this + " has a size of " + size); 
    }
}
