public class Fishingpole {

    /**
     * String brand name of the fishing pole
     * double length of the fishing pole
     * int yearMade - year fishing pole was made
     * int x: x coordinate location of the fishing pole
     */

    private String owner; 
    private double length; 
    
    public Fishingpole() {
        this.length = 12.0; 
        this.owner = "unknown";
    }

    /**
     * Constructs a fishing pole 
     * @param owner String owner's name of the fishing pole
     * @param length 
     */
    public Fishingpole(String owner, double length) {
        this.owner = owner; 
        this.length = length; 
    }

    
    public void extendFishingPole() {
        System.out.println("You extended the fishing pole...");
    }

    public void rewindFishingPole() {
        System.out.println("Rewinding fishing pole...");
    }

    public void catchItem() {
        this.rewindFishingPole(); 
        System.out.println("You got something!");
    }
    

    











}