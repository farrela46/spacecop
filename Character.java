import greenfoot.*;
import java.util.List;

public class Character extends Actor {

    private static final int HITBOX_SIZE = 64; 
    private static final String HIT_SOUND_FILE = "hit.mp3"; // Hit sound file

    public Character() {
        setImage("crosshair.png");
    }

    public void act() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            setLocation(mouse.getX(), mouse.getY());
        }

        if (Greenfoot.mouseClicked(null)) {
            playHitSound(); // Play sound on every click
            checkShoot();
        }
    }

    private void checkShoot() {
        List<Enemy> enemies = getObjectsInRange(HITBOX_SIZE / 2, Enemy.class);
        for (Enemy enemy : enemies) {
            getWorld().removeObject(enemy);
            if (getWorld() instanceof SpaceWorld1) {
                ((SpaceWorld1)getWorld()).updateScore(4);
            } else if (getWorld() instanceof SpaceWorld2) {
                ((SpaceWorld2)getWorld()).updateScore(4);
            }
        }

        List<Hostage> hostages = getObjectsInRange(HITBOX_SIZE / 2, Hostage.class);
        for (Hostage hostage : hostages) {
            getWorld().removeObject(hostage);
            if (getWorld() instanceof SpaceWorld1) {
                ((SpaceWorld1)getWorld()).updateScore(-2);
            } else if (getWorld() instanceof SpaceWorld2) {
                ((SpaceWorld2)getWorld()).updateScore(-2);
            }
        }
    }

    private void playHitSound() {
        GreenfootSound hitSound = new GreenfootSound(HIT_SOUND_FILE);
        hitSound.setVolume(30); 
        hitSound.play();
    }
}
