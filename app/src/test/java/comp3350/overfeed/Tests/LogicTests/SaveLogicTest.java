package comp3350.overfeed.Tests.LogicTests;

import org.junit.Before;
import org.junit.Test;

import comp3350.overfeed.logic.*;
import comp3350.overfeed.persistence.*;

import static org.junit.Assert.assertEquals;

public class SaveLogicTest {

    private SaveLogic saveLogic;
    private MealLogic mealLogic;
    private TimeLogic timeLogic;

    @Before
    public void setUp()
    {
        mealLogic = new MealLogic();
        timeLogic = new TimeLogic();
        saveLogic = new SaveLogic(mealLogic, timeLogic);
    }

    @Test
    public void test1() {
        System.out.println("Starting Save Logic Tests");
        assertEquals("Starting number of meals should be 0",
                mealLogic.getMeals(), 0);
        saveLogic.loadGame();
        saveLogic.saveGame();
        saveLogic.setGame(10);
        assertEquals("Number of meals should be 10",
                mealLogic.getMeals(), 10);
        System.out.println("Finished Save Logic Tests");
    }

}
