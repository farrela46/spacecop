import greenfoot.*;

public class BackgroundMusic {
    private static BackgroundMusic instance;
    private GreenfootSound backgroundMusic;
    private boolean isPlaying;

    private BackgroundMusic() {
        backgroundMusic = new GreenfootSound("bkg.mp3"); // Your background music file
    }

    public static BackgroundMusic getInstance() {
        if (instance == null) {
            instance = new BackgroundMusic();
        }
        return instance;
    }

    public void play() {
        if (!isPlaying) {
            backgroundMusic.playLoop();
            isPlaying = true;
        }
    }

    public void stop() {
        backgroundMusic.stop();
        isPlaying = false;
    }

    public void pause() {
        backgroundMusic.pause();
        isPlaying = false;
    }

    public void resume() {
        if (!isPlaying) {
            backgroundMusic.playLoop();
            isPlaying = true;
        }
    }
}
