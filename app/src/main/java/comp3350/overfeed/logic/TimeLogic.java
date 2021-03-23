package comp3350.overfeed.logic;

import comp3350.overfeed.persistence.TimePersistence;
import comp3350.overfeed.persistence.TimePersistenceFake;

public class TimeLogic
{
    private long startTime;
    private TimePersistence timePersistence;

    public TimeLogic()
    {
        startTime = System.currentTimeMillis();
        timePersistence = new TimePersistenceFake();
    }

    public void calculateTime() // Time is in seconds
    {
        int seconds = (int) ((System.currentTimeMillis() - startTime) / 1000); // divide by 1000 here because 1000ms == 1s
        timePersistence.setCurrTime(seconds);
    }

    public int getCurrTime()
    {
        return timePersistence.getCurrTime();
    }

    public int[] formatTime()
    {
        int[] result = new int[2];
        int time = this.getCurrTime();

        result[0] = time % 60; // seconds going from 0-59
        result[1] = time / 60; // minutes going from 0-1-2-...

        return result;
    }
}
