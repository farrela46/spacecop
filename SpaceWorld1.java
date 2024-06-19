import greenfoot.*;
import java.util.List;

public class SpaceWorld1 extends World {
    private Character crosshair;
    private int wave = 1;
    private int enemyCount = 5;
    private int hostageCount = 10; 
    private ScoreCounter scoreCounter;
    private WaveCounter waveCounter;

    public SpaceWorld1(int initialScore) {    
        super(800, 600, 1);
        GreenfootImage bg = new GreenfootImage("Ruang Angkasa 1.png");
        setBackground(bg);

        crosshair = new Character();
        addObject(crosshair, getWidth()/2, getHeight()/2);

        scoreCounter = new ScoreCounter();
        scoreCounter.setScore(initialScore);
        addObject(scoreCounter, 50, 30);

        waveCounter = new WaveCounter();
        waveCounter.setWave(wave);
        addObject(waveCounter, getWidth()/2, 30);

        spawnEnemies();
        spawnHostages();

        MusicManager.startBackgroundMusic(); // Start background music
    }

    private void spawnEnemies() {
        for (int i = 0; i < enemyCount; i++) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new Enemy(), x, y);
        }
    }

    private void spawnHostages() {
        for (int i = 0; i < hostageCount; i++) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new Hostage(), x, y);
        }
    }

    public void act() {
        List<Enemy> enemies = getObjects(Enemy.class);
        List<Hostage> hostages = getObjects(Hostage.class);
        
        if (enemies.isEmpty() && wave < 5) {
            wave++;
            waveCounter.setWave(wave);
            enemyCount += 5;
            hostageCount = 10; 
            spawnEnemies();
            spawnHostages();
        } else if (enemies.isEmpty() && wave == 5) {
            Greenfoot.setWorld(new SpaceWorld2(wave + 1, scoreCounter.getScore()));
        }
        
        if (hostages.isEmpty()) {
            Greenfoot.setWorld(new EndWorld(scoreCounter.getScore()));
        }
    }

    public void updateScore(int delta) {
        scoreCounter.addScore(delta);
        if (scoreCounter.getScore() < 0) {
            Greenfoot.setWorld(new EndWorld(scoreCounter.getScore()));
        }
    }
}
