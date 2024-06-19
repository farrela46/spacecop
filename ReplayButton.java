import greenfoot.*;  

public class ReplayButton extends Actor
{
    public ReplayButton()
    {
        setImage("replay.png");
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new SpaceWorld1(0)); 
        }
    }
}
