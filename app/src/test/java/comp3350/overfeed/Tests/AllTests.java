package comp3350.overfeed.Tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.overfeed.Tests.LogicTests.MealLogicTest;
import comp3350.overfeed.Tests.LogicTests.TimeLogicTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TimeLogicTest.class,
        MealLogicTest.class
})

public class AllTests
{

}
