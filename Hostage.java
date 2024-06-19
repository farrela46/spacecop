import greenfoot.*;  

public class Hostage extends Actor
{
    private int moveSpeed = 1; 
    
    public Hostage()
    {
        setImage("AlienBaik.png");
    }
    
    public void act()
    {
        moveAround();
    }
    
    private void moveAround()
    {
      
        if (Greenfoot.getRandomNumber(100) < 2) {
            turn(Greenfoot.getRandomNumber(90) - 45);
        }
        move(moveSpeed);
        
        
        if (isAtEdge()) {
            turn(180);
        }
    }
}
