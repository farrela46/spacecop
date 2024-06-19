import greenfoot.*;

public class Enemy extends Actor {
    
    private int moveSpeed; 
    
    public Enemy() {
        setImage("AlienJahat.png");
        moveSpeed = Greenfoot.getRandomNumber(3) + 1;
    }
    
    public void act() {
        moveAround();
    }
    
    private void moveAround() {
       
        if (Greenfoot.getRandomNumber(100) < 2) {
            turn(Greenfoot.getRandomNumber(90) - 45);
        }
        move(moveSpeed);
        
      
        if (isAtEdge()) {
            turn(180);
        }
    }
}
