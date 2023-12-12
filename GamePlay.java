import java.util.Scanner;
import java.util.ArrayList; 

public class GamePlay {

    public static void main(String[] args) {
        String name; 
        int age; 
        ArrayList<PhysicalThing> things; 
        Ocean gameMap = new Ocean(5, 5); 
        PhysicalThing[][] thingHere = new PhysicalThing[5][5];

        boolean found = false; 

        Scanner in = new Scanner(System.in); 
        System.out.println("Welcome dear Fisherman...we are glad you finally came!");
        System.out.println("What is your name?");
        name = in.nextLine(); 

        in.nextLine(); 
    
        //Asks user for their age
        System.out.println("What is your age?");
        age = in.nextInt(); 

        User player = new User(name, age);
        Boat boat = new Boat(player); 
        Fishingpole pole = new Fishingpole(player); 

        System.out.println("Dear Fisherman..."); 
        System.out.println("You lost your precious necklace yesterday while fishing. Today you will go out and find it!");
        System.out.println(player); 

        in.nextLine(); 

        int numRounds = 5; 
        int rounds = 0; 
        int score = 0; 

        String response; 

        while(rounds < 5 && !found) {
            System.out.println("Welcome! Type A to go on the boat"); 
            response = in.nextLine(); 
            if(response.equals("A") || response.equals("a")) {
            }
        }
    }
}
