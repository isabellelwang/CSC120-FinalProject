public class Boat {
    private String material = "Wood"; 
    private double length;
    private String owner; 
    public int x; 
    public int y; 
    
    public Boat(String owner, double length) {
        this.owner = owner; 
        this.length = length; 
    }

    public String getMaterial() {
        return this.material; 
    }

    public String getOwner() {
        return this.owner; 
    }

    public int getX() {
        return this.x; 
    }

    public int getY() {
        return this.y; 
    }

    public double getLength() {
        return this.length; 
    }

    public Boat() {
        this.owner = "unknown"; 
        this.length = 12.0; 
    }

    

    

    
}
