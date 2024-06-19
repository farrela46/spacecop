import greenfoot.*;  

public class WaveCounter extends Actor
{
    private int wave = 1;

    public void act()
    {
        setImage(new GreenfootImage("Wave: " + wave, 24, Color.WHITE, new Color(0, 0, 0, 0)));
    }

    public void setWave(int wave)
    {
        this.wave = wave;
    }
}
