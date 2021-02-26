package comp3350.overfeed.Tests.LogicTests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import comp3350.overfeed.logic.TimeLogic;

public class TimeLogicTest {

    private TimeLogic timeLogic;

    @Before
    public void setUp()
    {
        timeLogic = new TimeLogic();

    }

    @Test
    public void test1()
    {
        System.out.println("Starting Time Logic Tests");

        assertEquals("Current time should be zero (as timer is not running in test)",
                timeLogic.getCurrTime(), 0);

        timeLogic.calculateTime(); //re-set currTime
        assertEquals("Current time should be zero, even after recalculating time",
                timeLogic.getCurrTime(), 0);

        System.out.println("Finished Time Logic Tests");
    }

}
