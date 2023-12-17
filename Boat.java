public class Boat extends PhysicalThing {
    private User owner;
    private static int size; 
    
    public Boat(User owner) {
        super(1, 1); 
        this.owner = owner; 
        size = 2; 
    }

    public Boat() {
        super(5, 5); 
        this.owner = new User(); 
        size = 2; 
    }

    public Boat(String name) {
        super(1, 1); 
        size = 2; 
    }

    public User getOwner() {
        return this.owner; 
    }

    public static int getSize() {
        return size; 
    }

    public String toString() {
        return (this + " has a size of " + size); 
    }
}
