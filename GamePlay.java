import java.util.Scanner;

public class GamePlay {

    public static void main(String[] args) {
        String name; 
        int age; 
        boolean found = false; 
        Ocean map = new Ocean(5, 5); 

        //Making the eels, fish, and necklace and assigning to random positions 
        Necklace pearls = new Necklace((int)(Math.random() * Ocean.getMaxX() + 1),(int)(Math.random() * Ocean.getMaxY() + 1));
        Eel eel1 = new Eel((int)(Math.random() * Ocean.getMaxX() + 1),(int)(Math.random() * Ocean.getMaxY() + 1));
        Eel eel2 = new Eel((int)(Math.random() * Ocean.getMaxX() + 1),(int)(Math.random() * Ocean.getMaxY() + 1));
        Fish fish1 = new Fish((int)(Math.random() * Ocean.getMaxX() + 1),(int)(Math.random() * Ocean.getMaxY() + 1)); 
        Fish fish2 = new Fish((int)(Math.random() * Ocean.getMaxX() + 1),(int)(Math.random() * Ocean.getMaxY() + 1));


        Scanner in = new Scanner(System.in); //Creating a Scanner variable
        System.out.println("Welcome dear Fisherman...we are glad you finally came!");
        System.out.println("What is your name?"); //Asks for name
        name = in.nextLine(); //User inputs name

        in.nextLine(); //Clear input
    
        //Asks user for their age
        System.out.println("What is your age?");
        age = in.nextInt(); //User inputs age

        User player = new User(name, age); //creating a User
        map.addThing(player); 
        Boat boat = new Boat(player);  //Creating a Boat
        map.addThing(boat); 
        Fishingpole pole = new Fishingpole(player); //Creating a Fishing pole
        map.addThing(pole); 


        System.out.println("Dear Fisherman..."); 
        System.out.println("You lost your precious necklace yesterday while fishing. Today you will go out and find it!");
        System.out.println(player); 

        in.nextLine(); 

        int response; 
        int moveXUnits = 0; 
        int moveYUnits = 0; 

        while(!found) {
            /* public void showOptions() {
        System.out.println("Options: \n " + "1. rowBoat() \n 2. catchItem \n 3. extendPole() \n 4. swim() \n 5. jumpOffBoat() \n 6. getOnBoat() \n 7. pickUpItem()\n 7.");
    }*/
            System.out.println("Welcome! You are on the boat. What would you like to do?"); 
            System.out.println(player.printCoordinates());
            System.out.println("Please type in the corresponding number");
            response = in.nextInt(); 

            if(response == 1) {
                in.nextLine(); 
                System.out.println(player.printCoordinates()); 
                System.out.println("You can only move " + Boat.getSize() + " units vertically and/or horizontally");
                System.out.println("Rowing Boat: How many units would you like to move right or left? Select 0 if you would only like to move up and down.");
                moveXUnits = in.nextInt(); 
                in.nextLine(); 
                System.out.println("How many units would you like to move up or down?"); 
                moveYUnits = in.nextInt(); 
                in.nextLine(); 
                player.rowBoat(moveXUnits, moveYUnits); 
                System.out.println(player.printCoordinates());
            }
            else if (response ==2) {
                
            }
            


        }
        
        in.close(); 
    }
}
