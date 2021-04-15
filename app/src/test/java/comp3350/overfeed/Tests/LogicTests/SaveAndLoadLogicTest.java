package comp3350.overfeed.Tests.LogicTests;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import comp3350.overfeed.logic.AchievementsLogic;
import comp3350.overfeed.logic.LoadLogic;
import comp3350.overfeed.logic.MealLogic;
import comp3350.overfeed.logic.SaveLogic;
import comp3350.overfeed.logic.TimeLogic;

public class SaveAndLoadLogicTest {

    private SaveLogic saveLogic;
    private LoadLogic loadLogic;
    private MealLogic mealLogic;
    private TimeLogic timeLogic;
    private AchievementsLogic achieveLogic;

    @Before
    public void setUp()
    {
        //create mocks
        mealLogic = mock(MealLogic.class);
        timeLogic = mock(TimeLogic.class);
        achieveLogic = mock(AchievementsLogic.class);
        saveLogic = mock(SaveLogic.class);
        loadLogic = mock(LoadLogic.class);

        //initialize
        mealLogic.initializeData();
        timeLogic.initializeData();
        achieveLogic.initializeData();

//        Mockito.doCallRealMethod().when(saveLogic.initializeSaver(mealLogic, timeLogic, achieveLogic));

        saveLogic.initializeSaver(mealLogic, timeLogic, achieveLogic);
        loadLogic.initializeLoader(mealLogic, timeLogic, achieveLogic);
    }

    @Test
    public void test1()
    {
        System.out.println("Starting Save Logic Test One");

        mealLogic.increaseMeals();
        timeLogic.incrementTime();
        achieveLogic.checkClickAchievement(10);

        int ml = mealLogic.getMeals();
        int tl = timeLogic.getCurrTime();
        int al = achieveLogic.getNumAchievementsDone();

        loadLogic.loadAll();

        assertEquals("ml should  be the same as the loaded ones", ml, mealLogic.getMeals());
        assertEquals("tl should be the same as the loaded ones", tl, timeLogic.getCurrTime());
        assertEquals("al should be the same as the loaded ones", al, achieveLogic.getNumAchievementsDone());

        System.out.println("Finished Save Logic Test One");
    }
}
