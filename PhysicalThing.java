public class PhysicalThing {

    /**
     * int x coordinate
     * int y coordinate
     */
    private int x; 
    private int y; 

    /**
     * contructs physical thing by setting x and y coordinates to 0.
     */
    public PhysicalThing() {
        this.x = 0; 
        this.y = 0; 
    }
    
    /**
     * constructs physicalthing with int x and int y
     * @param x int x coordinate
     * @param y int y coordinate
     */
    public PhysicalThing(int x, int y) {
        this.x = x; 
        this.y = y; 
    }

    /**
     * access x coordinate
     * @return int x coordinate
     */
    public int getX() {
        return this.x; 
    }

    /**
     * Access y coordinate
     * @return int y coordinate
     */
    public int getY() {
        return this.y; 
    }

    /**
     * Moves x units
     * @param x int x number of x units moved (right/left)
     */
    public void moveX(int x) {
        if((this.x + x) > Ocean.getMaxX() - 1 || (this.x + x) < 0) {
                throw new RuntimeException("Error. Your X coordinate is off the charts... You cannot move this far.");
        }
        this.x += x; 
    }

    /**
     * Moves Y units
     * @param y int y number of y units moved (up/down)
     */
    public void moveY(int y) {
        if((this.y + y) > Ocean.getMaxY() - 1 || (this.y + y) < 0) {
                throw new RuntimeException("Error. Your Y coordinate is off the charts, You can't move this far.");
        }

        this.y += y;
    }

    /**
     * Returns the x and y coordinates
     * @return String coordinate x and y 
     */
    public String printCoordinates() {
        return ("The coordinate of " + this + " is (" + this.x + ", " + this.y + "). ");
    }

    /**
     * void changes coordinate to x and y
     * @param x int x coordinate
     * @param y int y coordinate
     */
    public void changeCoordinates(int x, int y) {
        this.x = x; 
        this.y = y; 
    }
}
