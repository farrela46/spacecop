import greenfoot.*;

public class EndWorld extends World {
    private BackgroundMusic backgroundMusic;

    public EndWorld(int finalScore) {    
        super(800, 600, 1);
        GreenfootImage bg = new GreenfootImage("End World.png");
        setBackground(bg);

        // Display the final score
        showText("Final Score: " + finalScore, getWidth() / 2, getHeight() / 2);

        // Play background music
        backgroundMusic = BackgroundMusic.getInstance();
        backgroundMusic.play();
    }

    public void act() {
        if (Greenfoot.mouseClicked(null)) {
            Greenfoot.setWorld(new StartWorld());
        }
    }
}
