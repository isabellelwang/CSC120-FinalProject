public class User {
    private String name; 
    private int age; 
    private String occupation; 

    public User(String name, int age) {
        this.name = name; 
        this.age = age; 
        this.occupation = "Fisherman";
    }


    public User() {
        this.name = "user"; 
        this.age = 20; 
        this.occupation = "Fisherman"; 
    
    }

    public void getOnBoat() {
        System.out.println("You are on the boat...");
      
    }

    public void swim() { 
        System.out.println("Swimming, swimming, swimming.");
   
    }

    
    public String toString() {
        return ("Your name is " + this.name + " and your age is " + this.age);
    }

    

}