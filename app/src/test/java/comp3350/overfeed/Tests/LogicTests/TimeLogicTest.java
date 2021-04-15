package comp3350.overfeed.Tests.LogicTests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import comp3350.overfeed.logic.TimeLogic;
import comp3350.overfeed.persistence.TimePersistence;

public class TimeLogicTest {

    private TimeLogic timeLogic;

    @Before
    public void setUp()
    {
        timeLogic = new TimeLogic();
        timeLogic.initializeData();

    }

    @Test
    public void test1()
    {
        System.out.println("Starting Time Logic Tests");

        assertEquals("Current time should be zero (as timer is not running in test)",
                timeLogic.getCurrTime(), 0);

        timeLogic.incrementTime();
        assertEquals("Time should be incremented from 0 to 1",
                1, timeLogic.getCurrTime());

        TimePersistence pers = timeLogic.getPersistence();
        assertNotNull("Time Persistence object should not be null", pers);

        String formatTime = timeLogic.formatTimeString();
        assertNotNull("formatTime string should not be null", formatTime);
        assertFalse("formatTime string should not be empty", formatTime.equals(""));

        System.out.println("Finished Time Logic Tests");
    }

}
