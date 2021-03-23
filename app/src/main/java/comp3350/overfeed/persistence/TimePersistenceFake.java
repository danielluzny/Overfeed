package comp3350.overfeed.persistence;

import java.io.Serializable;

public class TimePersistenceFake implements TimePersistence, Serializable
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
