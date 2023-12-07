public class Necklace {
    protected String material; 
    private String owner; 
    private String condition; 

    public Necklace(String owner, String condition, String material) { 
        this.owner = owner; 
        this.condition = condition; 
        this.material = material; 
    }

    public Necklace() {
        this.owner = "unknown owner"; 
        this.condition = "New"; 
        this.material = "Pearls"; 
    }
}
