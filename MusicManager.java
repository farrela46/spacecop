import greenfoot.*;

public class MusicManager {
    private static GreenfootSound backgroundMusic = new GreenfootSound("bkg.mp3");

    // Private constructor to prevent instantiation
    private MusicManager() {}

    // Start the music if it's not already playing
    public static void startBackgroundMusic() {
        if (!backgroundMusic.isPlaying()) {
            backgroundMusic.setVolume(100); // Set volume to 70%
            backgroundMusic.playLoop();
        }
    }

    // Stop the music
    public static void stopBackgroundMusic() {
        if (backgroundMusic.isPlaying()) {
            backgroundMusic.stop();
        }
    }
}
