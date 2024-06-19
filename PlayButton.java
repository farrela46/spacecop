import greenfoot.*;  

public class PlayButton extends Actor
{
    public PlayButton()
    {
        setImage("Play.png");
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new SpaceWorld1(0)); 
        }
    }
}
