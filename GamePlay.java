import java.util.Scanner;
public class GamePlay {

    public static void main(String[] args) {
        String name; 
        boolean found = false; 
        boolean lose = false; 
        Ocean map = new Ocean(6, 6); 

        //Making the eels, fish, and necklace and assigning to random positions 
        PhysicalThing[] items = new PhysicalThing[5]; 
        Necklace pearls = new Necklace((int)(Math.random() * 6) ,(int)(Math.random() * 6));
        Eel eel1 = new Eel((int)(Math.random() * 6),(int)(Math.random() * 6));
        Eel eel2 = new Eel((int)(Math.random() * 6),(int)(Math.random() * 6));
        Fish fish1 = new Fish((int)(Math.random() * 6),(int)(Math.random() * 6)); 
        Fish fish2 = new Fish((int)(Math.random() * 6),(int)(Math.random() * 6));

        items[0] = pearls; 
        items[1] = eel1; 
        items[2] = eel2; 
        items[3] = fish1; 
        items[4] = fish2; 

        int randX = 0; 
        int randY = 0; 
        for(int i = 0; i < items.length - 1; i++) {
            for(int k = i + 1; k < items.length; k++) {
                while(items[i].getX() == items[k].getX() && items[i].getY() == items[k].getY()) {
                    randX = (int)(Math.random() * 6); 
                    randY = (int)(Math.random()* 6); 
                    items[i].changeCoordinates(randX, randY);
                }

            }
        }

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


        System.out.print("Thank you. Creating player.... \nPRESS ENTER TO CONTINUE");
        in.nextLine(); //Clear input


        Boat boat = new Boat(name);  //Creating a Boat
        Fishingpole pole = new Fishingpole(name); //Creating a Fishing pole
        User player = new User(name, boat, pole); //creating a User

        System.out.println("----------------------");
        System.out.println("Dear Fisherman..."); 
        System.out.print("There is a lost necklace somewhere out in the ocean... \nPRESS ENTER TO CONTINUE ");
        in.nextLine(); 
        System.out.println("\nBeware...if you catch an eel, you die");
        System.out.println("But! If you catch a fish...you get a hint");

        System.out.print("PRESS ENTER TO CONTINUE...");
        in.nextLine(); 
        System.out.println(player); 

        String response; 
        int steps;
        int moveXUnits = 0; 
        int moveYUnits = 0; 

        System.out.println("------------------------------");
        System.out.print("You are boarding the boat... \nPRESS ENTER TO CONTINUE ");
        in.nextLine(); 
        while(!found && !lose) {
            System.out.println("What would you like to do?");
            player.showOptions();
            System.out.println("Please type in the choices");
            System.out.println(player.printCoordinates());
            response = in.nextLine(); 

            switch(response) {
                case("row boat") :
                    System.out.println("----------------------");
                    System.out.println(player.printCoordinates()); 
                    steps = Boat.getSize() + 1; 

                    while(steps > Boat.getSize()) {
                        System.out.println("You can only move " + Boat.getSize() + " units vertically and/or horizontally");
                        System.out.print("ROWING HORIZONTALLY: How many units would you like to move? Select 0 if not. \nInput: ");
                        steps = in.nextInt(); 
                    }

                    moveXUnits = Math.abs(steps); 
                    in.nextLine(); 

                    if(moveXUnits != 0) {
                        if(player.getX() == 0 && player.getY() == 0) {
                        System.out.println("Since your coordinates are (0, 0), you may only move right.");
                        }
                        else {
                            System.out.print("Would you like to move: \n- right \n- left \ninput: ");
                            response = in.nextLine(); 
                            if(response.equals("left")) {
                                moveXUnits *= -1; 
                            }
                        }
                    }
                    
                    System.out.print("PRESS ENTER TO CONTINUE...");
                    in.nextLine(); 
                
                    steps = Boat.getSize() + 1; 
                    while(steps > Boat.getSize()) {
                        System.out.println("ROWING VERTICALLY: How many units would you like to move up or down? Select 0 if not."); 
                        System.out.print("You can only move " + Boat.getSize() + " units. \ninput: "); 
                        steps = in.nextInt(); 
                    }
    
                    moveYUnits = Math.abs(steps); 
                    in.nextLine(); 
                
                    if(moveYUnits != 0) {
                        if(player.getX() == 0 && player.getY() == 0) {
                            System.out.println("Since you are at (0, 0), you can only move up");
                        }
                        else {
                            System.out.print("Would you like to move: \nup \ndown \nInput: ");
                            response = in.nextLine(); 
                            if(response.equals("down")) {
                                moveYUnits *= -1; 
                            }
                        }
                    }
        
                    player.rowBoat(moveXUnits, moveYUnits); 
                    System.out.println(player.printCoordinates());
                    break; 
            
                case("get on boat") :
                    System.out.println("--------------");
                    player.getOnBoat(); 
                    break;
        
                case ("jump off boat") : 
                    System.out.println("--------------");
                    player.jumpOffBoat(); 
                    lose = true; 
                    break; 
            
                case ("swim") :
                    System.out.println("--------------");
                    player.swim(); 
                    break; 
            
                case("extend fishing pole") : 
                    System.out.println("--------------");

                    steps = Fishingpole.getLength() + 1; 
                    while(steps > Fishingpole.getLength()) {
                        System.out.println("You can only extend " + Fishingpole.getLength() + " units vertically and/or horizontally");
                        System.out.print("EXTENDING HORIZONTALLY: How many units would you like to extend? select 0 if not. \nInput: ");
                        steps = in.nextInt();
                    }
                    
                    in.nextLine(); 
                    moveXUnits = Math.abs(steps);  


                    if(moveXUnits != 0) {
                        if(player.getPole().getX() == 0 && player.getPole().getY() == 0) {
                            System.out.println("Since you are at position (0, 0), you can only move right.");
                        } else {
                            System.out.println("------------------");
                            System.out.println("Would you like to move: \n- right \n- left \nInput: ");
                            response = in.nextLine(); 
                            if(response.equals("left")) {
                            moveXUnits *= -1; 
                            }
                        }
                    }
                    in.nextLine(); 

                    steps = Fishingpole.getLength() + 1; 
                    while(steps > Fishingpole.getLength()) {
                        System.out.print("EXTENDING VERTICALLY: How many units would you like to extend vertically? select 0 if not. \nInput: ");
                        steps = in.nextInt(); 
                    }

                    moveYUnits = Math.abs(steps); 
                    in.nextLine(); 

                    if(moveYUnits != 0) {
                        if(player.getPole().getX() == 0 && player.getPole().getY() == 0) {
                            System.out.println("Since you are at (0, 0), you can only extend up.");
                        } else {
                            System.out.print("Would you like to move \n- up \n- down \nInput: ");
                            response = in.nextLine(); 
                            if(response.equals("down")){
                                moveYUnits *= -1; 
                            }
                        } 
                    }

                    in.nextLine(); 

                    player.extendFishingPole(moveXUnits, moveYUnits);
            
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
                    break; 

                case ("catch item") : 
                    System.out.println("Please extend the fishing pole first!");
                    break;
            
                case ("print my coordinates") :
                    System.out.println(player.printCoordinates());
                    break; 
                default : 
                    System.out.println("Invalid input, try again.");
                    break; 
                }
            System.out.println("PRESS ENTER TO CONTINUE...");
            in.nextLine(); 
        }

        System.out.println("-----------------------------------");
        if(found && !lose) {
            System.out.println("You are the best! You found the necklace!");
        }
        else if(!found && lose) {
            System.out.println("Bummers...You lose...");
        }

        in.close(); 
    }
}

