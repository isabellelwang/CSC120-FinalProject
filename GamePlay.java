import java.util.Scanner;
public class GamePlay {

    public static void main(String[] args) {
        //name: String name of user
        //the game objective is dependent on boolean found (necklace is found) and lose (caught an eel)
        String name; 
        boolean found = false; 
        boolean lose = false; 
        Ocean map = new Ocean(6, 6); //constructs an ocean

        //Making the eels, fish, and necklace and assigning to random positions 
        PhysicalThing[] items = new PhysicalThing[5]; 

        //Assigning random x and y coordinates
        Necklace pearls = new Necklace((int)(Math.random() * 6) ,(int)(Math.random() * 6));
        Eel eel1 = new Eel((int)(Math.random() * 6),(int)(Math.random() * 6));
        Eel eel2 = new Eel((int)(Math.random() * 6),(int)(Math.random() * 6));
        Fish fish1 = new Fish((int)(Math.random() * 6),(int)(Math.random() * 6)); 
        Fish fish2 = new Fish((int)(Math.random() * 6),(int)(Math.random() * 6));

        //adding into an array
        items[0] = pearls; 
        items[1] = eel1; 
        items[2] = eel2; 
        items[3] = fish1; 
        items[4] = fish2; 

        int randX = 0; //setting random x and y coordinates
        int randY = 0; 
        //checking for double coordinates. Changes the coordinate if there is duplicate
        for(int i = 0; i < items.length - 1; i++) {
            for(int k = i + 1; k < items.length; k++) {
                while(items[i].getX() == items[k].getX() && items[i].getY() == items[k].getY()) {
                    randX = (int)(Math.random() * 6); 
                    randY = (int)(Math.random()* 6); 
                    items[i].changeCoordinates(randX, randY);
                }

            }
        }

        Ocean.addThing(pearls); //adds necklace into ocean map
        Ocean.addThing(eel1);  //adds eel1 to the ocean map
        Ocean.addThing(eel2); //adds eel2 to the ocean map
        Ocean.addThing(fish1); //adds fish 1
        Ocean.addThing(fish2); //adds fish2 to the ocean map

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
        System.out.println("But! If you catch a fish...you get a hint"); //explaining game

        System.out.print("PRESS ENTER TO CONTINUE...");
        in.nextLine(); 
        System.out.println(player); //prints out name and welcomes player to the game

        String response; //stores string response of user
        int steps; //stores input of user for moving units
        int moveXUnits = 0; //moving x units
        int moveYUnits = 0;  //moving y units

        System.out.println("------------------------------");
        System.out.print("You are boarding the boat... \nPRESS ENTER TO CONTINUE ");
        in.nextLine(); 
        //game begins--engds when necklace is found and lose is true
        while(!found && !lose) {
            System.out.println("What would you like to do?");
            player.showOptions(); //shows user options
            System.out.println("Please type in the choices");
            System.out.println(player.printCoordinates()); //prints coordinate of user
            response = in.nextLine(); //takes in input

            //based on user response, it will run a case
            switch(response) {
                case("row boat") : 
                    System.out.println("----------------------");
                    System.out.println(player.printCoordinates()); //prints out the coordinate
                    steps = Boat.getSize() + 1; //steps start as a number greater than boat size to begin the while loop

                    while(steps > Boat.getSize()) {
                        System.out.println("You can only move " + Boat.getSize() + " units vertically and/or horizontally"); //Boat size is number of units user can row boat
                        System.out.print("ROWING HORIZONTALLY: How many units would you like to move? Select 0 if not. \nInput: ");
                        steps = in.nextInt(); //user input of how man units they would like to move
                    }

                    moveXUnits = Math.abs(steps); //sets the units to absolute value
                    in.nextLine(); 

                    if(moveXUnits != 0) {
                        //if user is at coordinate (0, 0), then user can only move right (map is positive x, positive y)
                        if(player.getX() == 0 && player.getY() == 0) {
                        System.out.println("Since your coordinates are (0, 0), you may only move right.");
                        }
                        else { //otherwise ask user if they would like to move left or right
                            System.out.print("Would you like to move: \n- right \n- left \ninput: ");
                            response = in.nextLine(); 
                            //if user chooses to move left, the x coordinate becomes negative
                            if(response.equals("left")) {
                                moveXUnits *= -1; 
                            }
                        }
                    }
                    
                    System.out.print("PRESS ENTER TO CONTINUE...");
                    in.nextLine(); 
                    
                    //repeats the process again for the y coordinate
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
                    
                    //rows the boat and prints coordinate
                    player.rowBoat(moveXUnits, moveYUnits); 
                    System.out.println(player.printCoordinates());
                    break; 
                
                case("get on boat") : //user inputs get on boat
                    System.out.println("--------------");
                    player.getOnBoat(); 
                    break;
        
                case ("jump off boat") :  //user inputs jump off boat--ends the game
                    System.out.println("--------------");
                    player.jumpOffBoat(); 
                    lose = true; 
                    break; 
            
                case ("swim") : // user inputs swim
                    System.out.println("--------------");
                    player.swim(); 
                    break; 
            
                case("extend fishing pole") : // user inputs extend fishing pole
                    System.out.println("--------------");
                    
                    //steps is fishing pole length + 1 to enter into while loop 
                    steps = Fishingpole.getLength() + 1; 
                    while(steps > Fishingpole.getLength()) {
                        System.out.println("You can only extend " + Fishingpole.getLength() + " units vertically and/or horizontally");
                        System.out.print("EXTENDING HORIZONTALLY: How many units would you like to extend? select 0 if not. \nInput: ");
                        steps = in.nextInt(); // receives user input
                    }
                    
                    in.nextLine(); 
                    moveXUnits = Math.abs(steps);  //move x units is absolute value

                    // if user chooses to move >0 units, will see what direction they want to move
                    if(moveXUnits != 0) {
                        //user can only move positive x and y if they are at coordinate (0,0)
                        if(player.getPole().getX() == 0 && player.getPole().getY() == 0) {
                            System.out.println("Since you are at position (0, 0), you can only move right.");
                        } else { //ask user if they would like to move right or left
                            System.out.println("------------------");
                            System.out.println("Would you like to move: \n- right \n- left \nInput: ");
                            response = in.nextLine(); 
                            //sets units negative if user would like to move left
                            if(response.equals("left")) {
                            moveXUnits *= -1; 
                            }
                        }
                    }
                    in.nextLine(); 

                    //repeats same process for y coordinate
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
                    
                    //extends fishing pole
                    player.extendFishingPole(moveXUnits, moveYUnits);
                    
                    //checks to see if fishing pole unit is equal to necklace, eel, and fish and then prints out the results
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

                case ("catch item") : //user inputs catch item
                    System.out.println("Please extend the fishing pole first!");
                    break;
            
                case ("print my coordinates") : //user inputs print my coordinate
                    System.out.println(player.printCoordinates());
                    break; 

                case("how to play"): //user inputs how to play
                    System.out.println("---------------------------");
                    player.printRules(); 
                    break;

                default : //default statement
                    System.out.println("Invalid input, try again.");
                    break; 
                }
            System.out.println("PRESS ENTER TO CONTINUE...");
            in.nextLine(); 
        }
        //end of game, diffeent statements depending on whether user won or loss. 
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

