import greenfoot.*;
import java.util.List;

public class SpaceWorld2 extends World {
    private Character crosshair;
    private int wave;
    private int enemyCount;
    private ScoreCounter scoreCounter;
    private WaveCounter waveCounter;

    public SpaceWorld2(int initialWave, int initialScore) {    
        super(800, 600, 1);
        GreenfootImage bg = new GreenfootImage("Ruang Angkasa 2.png");
        setBackground(bg);

        crosshair = new Character();
        addObject(crosshair, getWidth()/2, getHeight()/2);

        wave = initialWave;
        enemyCount = wave * 5;

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

        // Spawn 3 hostages per wave
        for (int i = 0; i < 3; i++) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new Hostage(), x, y);
        }
    }

    private void spawnHostages() {
        // Adding 3 hostages each time for example
        for (int i = 0; i < 3; i++) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new Hostage(), x, y);
        }
    }

    public void act() {
        List<Enemy> enemies = getObjects(Enemy.class);
        if (enemies.isEmpty() && wave < 10) {
            wave++;
            waveCounter.setWave(wave);
            enemyCount += 5;
            spawnEnemies();
        } else if (enemies.isEmpty() && wave == 10) {
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
