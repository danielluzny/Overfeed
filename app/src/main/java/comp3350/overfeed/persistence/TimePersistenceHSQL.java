package comp3350.overfeed.persistence;

import java.io.Serializable;

public class TimePersistenceHSQL implements TimePersistence, Serializable
{
    private int currTime;

    public TimePersistenceHSQL()
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
