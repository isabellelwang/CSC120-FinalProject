public class Ocean {
    private static PhysicalThing[][] location;
    private static int maxX; 
    private static int maxY;

    
    public Ocean(int x, int y) {
        maxX = x; 
        maxY = y; 
        location = new PhysicalThing[maxX][maxY]; 
    }


    public static int getMaxX() {
        return maxX;
    }

    public static int getMaxY() {
        return maxY; 
    }

    public static void addThing(PhysicalThing item) {
        location[item.getX()][item.getY()] = item; 
    }

    public static void removeThing(int x, int y) {
        location[x][y] = null; 
    }


    /* 
    public static void updateLocations() {
        for(int i = 0; i < maxX; i++) {
            for(int k = 0; k < maxY; k++) {
                if(location[i][k] != null){
                    int currentX = location[i][k].getX(); 
                    int currentY = location[i][k].getY(); 
                    location[currentX][currentY] = location[i][k]; 
                    location[i][k] = null; 
                }
                //System.out.println("Location updated!");
            }
        }
    }


    public static PhysicalThing thingsInLocation(int x, int y) {
        return location[x][y]; 
    }

    public static void printLocations() {
        for(int i = 0; i < location.length; i++){
            for (int k = 0; k< location[i].length; k++) {
                if(location[i][k] != null) {
                    System.out.println(location[i][k] + " at (" + i + "," + k + "). ");
                }
            }
        }
    }
    */

    public static void main(String[] args) {
        System.out.println(getMaxX()); 
        System.out.println(getMaxY()); 
    }
}
