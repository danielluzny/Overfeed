package comp3350.overfeed.logic;

import comp3350.overfeed.persistence.TimeData;
import comp3350.overfeed.persistence.TimePersistence;

public class TimeLogic
{
    private TimePersistence timePersistence;

    public TimeLogic() { }

    public void initializeData() { timePersistence = new TimeData(); }

    public void incrementTime()
    {
        timePersistence.setCurrTime(timePersistence.getCurrTime()+1);
    }

    public int getCurrTime()
    {
        return timePersistence.getCurrTime();
    }

    public TimePersistence getPersistence() { return this.timePersistence; }

    public String formatTimeString()
    {
        int time = this.getCurrTime();
        int seconds;
        int minutes;

        seconds = time % 60; // seconds going from 0-59
        minutes = time / 60; // minutes going from 0-1-2-...
        String result = String.format("%d:%02d", minutes, seconds);

        return result;
    }

}
