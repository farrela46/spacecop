import greenfoot.*;

public class StartWorld extends World {
    public StartWorld() {    
        super(800, 600, 1); 
        GreenfootImage bg = new GreenfootImage("StartWorld.png");
        setBackground(bg);

        addObject(new PlayButton(), getWidth()/2, getHeight()/2);

        MusicManager.startBackgroundMusic(); // Start background music
    }
}
