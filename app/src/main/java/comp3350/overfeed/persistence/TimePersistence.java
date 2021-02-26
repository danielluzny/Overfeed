package comp3350.overfeed.persistence;

public class TimePersistence
{
    private int currTime;

    public TimePersistence()
    {
        this.currTime = 0;
    }

    public int getCurrTime()
    {
        return this.currTime;
    }

    public void setCurrTime(int t)
    {
        this.currTime = t;
    }
}
