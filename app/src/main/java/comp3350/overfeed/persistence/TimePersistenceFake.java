package comp3350.overfeed.persistence;

public class TimePersistenceFake
{
    private int currTime;

    public TimePersistenceFake()
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
