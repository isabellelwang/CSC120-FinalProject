public class PhysicalThing {
    private int x; 
    private int y; 


    public PhysicalThing() {
        this.x = 0; 
        this.y = 0; 
    }
    
    public PhysicalThing(int x, int y) {
        this.x = x; 
        this.y = y; 
    }

    public PhysicalThing(int x) {
        this.y = 0; 
        this.x = x; 
    }

    public int getX() {
        return this.x; 
    }

    public int getY() {
        return this.y; 
    }


    public String moveX(int x) {
        if((this.x + x) > Ocean.getMaxX() || (this.x + x) < 0) {
                throw new RuntimeException("Error. You cannot move this far.");
        }
        this.x += x; 
        if(x > 0) {
            return (this + " moved" + x + " units to the right."); 
        }
        else if(x < 0) {
            return (this + " moved" + -x + " units to the left."); 
        }
        else {
            return ("You did not move...");
        }
    }

    public String moveY(int y) {
        if((this.y + y) > Ocean.getMaxY() || (this.y + y) < 0) {
                throw new RuntimeException("Error. You cannot move this far.");
        }

        this.y += y; 

        if(y > 0) {
            return (this + " moved " + y + " units up"); 
        }
        else if(y < 0) {
            return (this + " moved " + -y + " units down"); 
        }
        else {
            return ("You did not move...");
        }
    }

    public String printCoordinates() {
        return ("The coordinate of " + this + " is (" + this.x + ", " + this.y + "). ");
    }
    
    /*
    public String moveRight(int x) {
        if((this.x + x) > Ocean.getMaxX()) {
            throw new RuntimeException("Error. You cannot move this far"); 
        }
        this.x += x; 
        return (this + " moved" + this.x + " units to the right."); 
    }

    public String moveLeft(int x) {
        if((this.x - x) < 0 ) {
            throw new RuntimeException("You cannot move this far."); 
        }
        this.x -= x; 
        return (this + " moved" + this.x + " units to the right."); 
    }

    public String move(int y) {
        if((this.y + y) > Ocean.getMaxY()) {
            throw new RuntimeException("Error. You cannot move this far"); 
        }
        this.y += y; 
        return (this + " moved" + this.y + " units forward"); 
    }
    
    public String moveBackward(int y) {
        if((this.y + y) < 0) {
            throw new RuntimeException("Error. You cannot move this far"); 
        }
        this.y -= y; 
        return (this + " moved" + this.y + " units forward");
    }
    */
}
