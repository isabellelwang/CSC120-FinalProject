import java.util.Scanner;
public class GamePlay {

    public static void main(String[] args) {
        String name; 
        boolean found = false; 
        boolean lose = false; 
        Ocean map = new Ocean(6, 6); 

        //Making the eels, fish, and necklace and assigning to random positions 
        Necklace pearls = new Necklace((int)(Math.random() * 2) + 4,(int)(Math.random() * 2) + 4);
        Eel eel1 = new Eel((int)(Math.random() * 2),(int)(Math.random() * 2) + 2);
        Eel eel2 = new Eel((int)(Math.random() * 2) + 2,(int)(Math.random() * 2) + 1);
        Fish fish1 = new Fish((int)(Math.random() * 2) + 1,(int)(Math.random() * 2) + 4); 
        Fish fish2 = new Fish((int)(Math.random() * 2) + 4,(int)(Math.random() * 2) + 1);

        /* 
        System.out.println("Necklace: (" + pearls.getX() + ", " + pearls.getY() + "). "); 
        System.out.println("EEl1: (" + eel1.getX() + ", " + eel1.getY() + "). "); 
        System.out.println("EEl2: (" + eel2.getX() + ", " + eel2.getY() + "). "); 
        System.out.println("FIsh1: (" + fish1.getX() + ", " + fish1.getY() + "). "); 
        System.out.println("Fish2: (" + fish2.getX() + ", " + fish2.getY() + "). "); 
        */

        Ocean.addThing(pearls); 
        Ocean.addThing(eel1); 
        Ocean.addThing(fish1); 
        Ocean.addThing(fish2); 

        System.out.println("FISHERMAN FINDS");
        System.out.println("---------------------");

        Scanner in = new Scanner(System.in); //Creating a Scanner variable
        System.out.println("Welcome dear Fisherman...we are glad you finally came!");
        System.out.println("What is your name?"); //Asks for name
        name = in.nextLine(); //User inputs name


        System.out.println("Thank you. Creating player.... \n PRESS ENTER TO CONTINUE");
        in.nextLine(); //Clear input


        Boat boat = new Boat(name);  //Creating a Boat
        Fishingpole pole = new Fishingpole(name); //Creating a Fishing pole
        User player = new User(name, boat, pole); //creating a User

        System.out.println("------------------");
        System.out.println("Dear Fisherman..."); 
        System.out.println("There is a lost necklace somewhere out in the ocean...");
        in.nextLine(); 
        System.out.println("But beware...if you catch an eel, you die");
        System.out.println("But! If you catch a fish...you get a hint");

        System.out.println("PRESS ENTER TO CONTINUE...");
        in.nextLine(); 
        System.out.println(player); 

        int response; 
        int moveXUnits = 0; 
        int moveYUnits = 0; 

        System.out.println("------------------------------");
        System.out.println("You are boarding the boat...");
        while(!found && !lose) {
            in.nextLine(); 
            //Ocean.updateLocations(); 
            //Ocean.printLocations();
            System.out.println("What would you like to do?"); 
            System.out.println(player.printCoordinates());
            System.out.println(player.getPole().printCoordinates());
            player.showOptions();
            System.out.println("Please type in the corresponding number: ");
            response = in.nextInt(); 

            if(response == 1) {
                in.nextLine(); 
                System.out.println(player.printCoordinates()); 
                response = Boat.getSize() + 1; 

                while(response > Boat.getSize()) {
                    System.out.println("You can only move " + Boat.getSize() + " units vertically and/or horizontally");
                    System.out.println("Rowing Boat: How many units would you like to move right or left? Select 0 if you would only like to move up and down.");
                    response = in.nextInt(); 
                }

                moveXUnits = Math.abs(response); 
                in.nextLine(); 

                if(moveXUnits != 0) {
                    System.out.println("Would you like to move: \n 1. right \n 2. left");
                    response = in.nextInt(); 
                    if(response == 2) {
                         moveXUnits *= -1; 
                    }
                }
                
                in.nextLine(); 
                
                response = Boat.getSize() + 1; 
                while(response > Boat.getSize()) {
                    System.out.println("How many units would you like to move up or down? Select 0 if you would not like to move vertically"); 
                    System.out.println("You can only move " + Boat.getSize() + " units"); 
                    response = in.nextInt(); 
                }
    
                moveYUnits = Math.abs(response); 
                in.nextLine(); 
                
                if(moveYUnits != 0) {
                    System.out.println("Would you like to move: \n 1. up \n 2. down");
                    response = in.nextInt(); 
                    if(response == 2) {
                        moveYUnits *= -1; 
                    }
                }

                player.rowBoat(moveXUnits, moveYUnits); 
                System.out.println(player.printCoordinates());
                in.nextLine(); 
            }
            else if(response == 2) {
                in.nextLine(); 
                player.getOnBoat(); 
            }
            else if(response == 3) {
                in.nextLine(); 
                player.jumpOffBoat(); 
            }
            else if(response == 4) {
                in.nextLine(); 
                player.swim(); 
            }
            else if (response == 5) {
                in.nextLine(); 

                response = Fishingpole.getLength() + 1; 
                while(response > Fishingpole.getLength()) {
                    System.out.println("You can only extend " + Fishingpole.getLength() + " units vertically and/or horizontally");
                    System.out.println("How many units would you like to extend horizontally? (right/left), select 0 if you would not like to extend horizontally:");
                    response = in.nextInt();
                }
                
                moveXUnits = Math.abs(response);  


                if(moveXUnits != 0) {
                    System.out.println("Would you like to move: \n 1. right \n 2. left ");
                    response = in.nextInt(); 
                    if(response == 2) {
                    moveXUnits *= -1; 
                    }
                }

                response = Fishingpole.getLength() + 1; 
                while(response > Fishingpole.getLength()) {
                    System.out.println("How many units would you like to extend vertically? (up/down), select 0 if you would not like to extend vertically.");
                    response = in.nextInt(); 
                }

                moveYUnits = Math.abs(response); 
                in.nextLine(); 

                if(moveYUnits != 0) {
                    System.out.println("Would you like to move \n 1. Up \n 2. Down");
                    response = in.nextInt(); 
                    if(response == 2){
                        moveYUnits *= -1; 
                    }
                }

                in.nextLine(); 

                player.extendFishingPole(moveXUnits, moveYUnits);
                //Ocean.updateLocations(); 

        
            
                if((player.getPole().getX() == pearls.getX()) && (player.getPole().getY() == pearls.getY())) {
                    System.out.println("Could this be the... necklace???!!!");
                    in.nextLine(); 
                    System.out.println("Press enter to catch the item to confirm your finding!");
                    in.nextLine(); 
                    player.catchItem(pearls);
                    found = true;  
                }
                else if((player.getPole().getX() == eel1.getX()) && (player.getPole().getY() == eel1.getY())) {
                    System.out.println("Something is tugging!!");
                    System.out.println("It's pulling quite hard... press enter to catch!");
                    in.nextLine(); 
                    player.catchItem(eel1); 
                    System.out.println("The eel cralwed up on you and ate your hand... You can no longer fish, so you return home defeated.");
                    lose = true; 
                }  
                else if((player.getPole().getX() == eel2.getX()) && (player.getPole().getY() == eel2.getY())) {
                    System.out.println("Something is tugging!!");
                    System.out.println("It's pulling quite aggressively...press enter to catch!");
                    in.nextLine(); 
                    player.catchItem(eel2); 
                    System.out.println("The eel broke your fishing pole...You return home defeated");
                    lose = true; 
                }    
                else if((player.getPole().getX() == fish1.getX()) && (player.getPole().getY() == fish1.getY())) {
                    System.out.println("Something is tugging!!");
                    System.out.println("Press enter to catch...");
                    in.nextLine(); 
                    player.catchItem(fish1); 
                    System.out.println("A fish! It's telling you a hint....");
                    System.out.println(("Hello Fair Fisherman:\n Here is a hint, the X-coordinate of the necklace is " + pearls.getX()));
                }
                else if((player.getPole().getX() == fish1.getX()) && (player.getPole().getY() == fish1.getY())) {
                    System.out.println("Something is tugging!!");
                    System.out.println("Press enter to catch...");
                    in.nextLine(); 
                    player.catchItem(fish1); 
                    System.out.println("A fish! It's telling you a hint....");
                    System.out.println(("Fish's hint: The X-coordinate of the necklace is " + pearls.getX()));
                }
                else if((player.getPole().getX() == fish2.getX()) && (player.getPole().getY() == fish2.getY())) {
                    System.out.println(player.getPole().getX());
                    System.out.println("Something is tugging!!");
                    System.out.println("Press enter to catch...");
                    in.nextLine(); 
                    player.catchItem(fish2); 
                    System.out.println("A fish! It's telling you a hint....");
                    System.out.println(("Fish's hint: The Y-coordinate of the necklace is " + pearls.getY()));
                }
                else {
                    System.out.println("You did not catch anything...");
                }
                in.nextLine(); 
            }
            else if(response == 6) {
                in.nextLine(); 
                System.out.println("Please extend the fishing pole first!");
            }
            else if( response == 7) {
                in.nextLine(); 
                System.out.println(player.printCoordinates());
            }
            else {
                System.out.println("Invalid input, try again.");
            }
        }

        System.out.println("-----------------------------------");
        if(found && !lose) {
            System.out.println("You are the best! You found the necklace!");
            }
        else if(!found && lose) {
            System.out.println("bummers...You lose...");
        }

        in.close(); 
    }
}
