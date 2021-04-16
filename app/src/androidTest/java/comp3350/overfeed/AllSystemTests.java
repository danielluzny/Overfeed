package comp3350.overfeed;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

        // Unfortunately we are unable to figure out why the HSQL DB gives us an error when trying to run consecutive test classes
        // The tests do however work individually
        // For our project please run each test class individually by right clicking on it and hitting "Run"

        /*
        IncreaseMealTest.class,
        StatisticsTest.class,
        UpgradesTest.class,
         */
})


public class AllSystemTests { }
