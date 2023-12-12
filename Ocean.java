import java.util.ArrayList;

public class Ocean {
    private ArrayList<PhysicalThing>[][] location;

    private static int maxX; 
    private static int maxY;

    
    public Ocean(int x, int y) {
        maxX = x; 
        maxY = y; 
        location = new ArrayList<PhysicalThing>[maxX][maxY]; // Bug: cannot be intialized. 
    }

    public static int getMaxX() {
        return maxX;
    }

    public static int getMaxY() {
        return maxY; 
    }

    public void addThing(PhysicalThing item) {
        location[item.getX()][item.getY()].add(item); 
    }

    public void updateLocation() {
        for(int i = 0; i < maxX; i++) {
            for(int k = 0; k < maxY; k++) {
                for(int j = 0; j < location[i][k].size(); j++) {
                    int currentX = location[i][k].get(j).getX(); 
                    int currentY = location[i][k].get(j).getY(); 
                    if(currentX != i || currentY != k) {
                        location[currentX][currentY].add(location[i][k].get(j)); 
                        location[i][k].remove(location[i][k].get(j)); 
                        System.out.println("Location updated!");
                    }
                    else {
                        System.out.println("Location updated: No changes needed!");
                    }
                }
            }
        }
    }

    public void updateLocation(int x, int y) {
        for(int i = 0; i < location[x][y].size(); i++) {
            int currentX = location[x][y].get(i).getX(); 
            int currentY = location[x][y].get(i).getY(); 
            if(currentX != x || currentY != y) {
                location[currentX][currentY].add(location[x][y].get(i)); 
                location[x][y].remove(location[x][y]);
                System.out.println("LOCATION UPDATED!");
            }
            else {
                System.out.println("Location updated: No changes needed!");
            }
        }
    }

    public String thingsInLocation(int x, int y) {
        String items = "Things: "; 
        for(int i = 0; i < location[x][y].size(); i++) {
            items = items + location[x][y].get(i); 
        }
        return items; 
    }



    public static void main(String[] args) {
        System.out.println(getMaxX()); 
        System.out.println(getMaxY()); 
    }
}
