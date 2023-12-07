import java.util.Scanner;

public class GamePlay {
    String name; 
    int age; 

    System.out.println("Welcome dear Fisherman...we are glad you finally came!");
    System.out.println("What is your name?");
    Scanner input = new Scanner(System.in); 
    name = input.nextLine(); 

    input.nextLine(); 
    
    //Asks user for their age
    System.out.println("What is your age?");
    age = input.nextInt(); 

    User player = new User(name, age);



    System.out.println("Dear Fisherman..."); 
    System.out.println("You lost your precious necklace yesterday while fishing. Today you will go out and find it!");
    System.out.println(player); 

    int numRounds = 5; 
    int rounds = 0; 

    while(rounds > 5) {
        System.out.println()





    }
}








}
