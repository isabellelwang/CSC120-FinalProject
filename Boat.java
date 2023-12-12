public class Boat extends PhysicalThing {
    private User owner;
    
    public Boat(User owner) {
        super(1, 1); 
        this.owner = owner; 
    }

    public Boat() {
        super(5, 5); 
        this.owner = new User(); 
    }

    public User getOwner() {
        return this.owner; 
    }
}
