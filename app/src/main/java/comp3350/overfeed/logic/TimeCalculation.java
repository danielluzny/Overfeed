package comp3350.overfeed.logic;

import android.os.Handler;

public class TimeCalculation
{
    final private long startTime;

    public TimeCalculation()
    {
        startTime = System.currentTimeMillis();
    }

    public int[] getTime()
    {
        int[] result = new int[2];
        int seconds = (int)((System.currentTimeMillis() - startTime)/1000); // divide by 1000 here because 1000ms == 1s
        int minutes = seconds / 60; // similarly for seconds to minutes

        result[0] = seconds%60;
        result[1] = minutes;

        return result;
    }
}
