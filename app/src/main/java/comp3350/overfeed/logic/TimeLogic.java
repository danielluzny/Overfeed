package comp3350.overfeed.logic;

import comp3350.overfeed.application.Services;
import comp3350.overfeed.persistence.TimePersistence;

public class TimeLogic
{
    private long startTime;
    private TimePersistence timePersistence;

    public TimeLogic()
    {
        startTime = System.currentTimeMillis();
        timePersistence = Services.getTimePersistence();
    }

    public void incrementTime()
    {
        timePersistence.setCurrTime(timePersistence.getCurrTime()+1);
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
