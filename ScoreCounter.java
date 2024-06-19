import greenfoot.*;  

public class ScoreCounter extends Actor
{
    private int score = 0;

    public void act()
    {
        setImage(new GreenfootImage("Score: " + score, 24, Color.WHITE, new Color(0, 0, 0, 0)));
    }

    public void addScore(int value)
    {
        score += value;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }
}
