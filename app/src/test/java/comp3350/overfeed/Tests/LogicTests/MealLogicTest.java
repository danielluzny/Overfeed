package comp3350.overfeed.Tests.LogicTests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import comp3350.overfeed.logic.MealLogic;

public class MealLogicTest {

    private MealLogic mealLogic;

    @Before
    public void setUp()
    {
        mealLogic = new MealLogic();
    }

    @Test
    public void test1()
    {
        System.out.println("Starting Meal Logic Test One");

        assertEquals("Starting number of meals should be 0",
                mealLogic.getMeals(), 0);

        mealLogic.increaseMeals();
        assertEquals("After incrementing meals once, current number of meals should be 1",
                mealLogic.getMeals(), 1);

        assertNotEquals("The toString should not be empty",
                mealLogic.mealsToString(), "");

        int clicks = mealLogic.getClicks();
        assertEquals("The starting number of clicks should be zero",
                clicks, 0);

        mealLogic.incrementClicks();
        clicks = mealLogic.getClicks();
        assertEquals("There should be one click", clicks, 1);

        System.out.println("Finished Meal Logic Test One");
    }

}

