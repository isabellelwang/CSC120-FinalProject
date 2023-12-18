import java.lang.Math; 

public class Eel extends PhysicalThing {

    /**
     * Constructs eel with x and y coordinates
     * @param x int x coordinate of eel
     * @param y int y coordinate of eel
     */
    public Eel(int x, int y) {
        super(x, y); 
    }

    public static void main(String[] args) {
        
        int x = (int) (Math.random() * 6);
        int y = (int)(Math.random() * 6);
        Eel eel1 = new Eel(x, y); 
        System.out.println(eel1.getX());
        System.out.println(eel1.getY());
    }
}
