public class Ocean {
    /**
     * location- 2D Array of Physical Thing
     * maxX - int highest x coordinate 
     * maxY - int highest y coordinate
     */
    private static PhysicalThing[][] location;
    private static int maxX; 
    private static int maxY;

    /**
     * Constructs Ocean with maximum x and maximum y value, also intialiazes location
     * @param x int highest x coordinate
     * @param y int highest y coordinate
     */
    public Ocean(int x, int y) {
        maxX = x; 
        maxY = y; 
        location = new PhysicalThing[maxX][maxY]; 
    }

    /**
     * Access maxmimum x coordinate
     * @return int maximum coordinate
     */
    public static int getMaxX() {
        return maxX;
    }

    /**
     * Access maximum y coordinate
     * @return int maxmimum y coordinate
     */
    public static int getMaxY() {
        return maxY; 
    }

    /**
     * add PhysicalThing item into 2D array
     * @param item PhysicalThing added 
     */
    public static void addThing(PhysicalThing item) {
        location[item.getX()][item.getY()] = item; 
    }

    public static void main(String[] args) {
        System.out.println(getMaxX()); 
        System.out.println(getMaxY()); 
    }
}
