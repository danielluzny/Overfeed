package comp3350.overfeed.Tests.LogicTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;

import comp3350.overfeed.Tests.Utils.TestUtils;
import comp3350.overfeed.logic.AchievementsLogic;
import comp3350.overfeed.logic.LoadLogic;
import comp3350.overfeed.logic.MealLogic;
import comp3350.overfeed.logic.SaveLogic;
import comp3350.overfeed.logic.TimeLogic;
import comp3350.overfeed.persistence.Load;
import comp3350.overfeed.persistence.LoadHSQL;
import comp3350.overfeed.persistence.Save;
import comp3350.overfeed.persistence.SaveHSQL;

public class SaveAndLoadLogicIT {
    private SaveLogic saveLogic;
    private LoadLogic loadLogic;
    private File tempDB;

    TimeLogic timeLogic;
    MealLogic mealLogic;
    AchievementsLogic achievLogic;

    @Before
    public void setup() throws IOException{
        this.tempDB = TestUtils.copyDB();

        mealLogic = new MealLogic();
        timeLogic = new TimeLogic();
        achievLogic = new AchievementsLogic();
        mealLogic.initializeData();
        timeLogic.initializeData();
        achievLogic.initializeData();

        final Save savePers = new SaveHSQL(this.tempDB.getAbsolutePath().replace(".script",""), mealLogic.getPersistence(), timeLogic.getPersistence(), achievLogic.getPersistence());
        final Load loadPers = new LoadHSQL(this.tempDB.getAbsolutePath().replace(".script",""), mealLogic.getPersistence(), timeLogic.getPersistence(), achievLogic.getPersistence());
        this.saveLogic = new SaveLogic(savePers);
        this.loadLogic = new LoadLogic(loadPers);

    }

    @Test
    public void testinitialSaveAndLoad(){
        saveLogic.saveAll();
        loadLogic.loadAll();
        assertEquals("Loaded Meal value should be equal to 0", 0, mealLogic.getMeals());
        assertEquals("Loaded Time value should be equal to 0", 0, timeLogic.getCurrTime());
        assertEquals("Loaded value for number of Achievements done should be equal to 0", 0, achievLogic.getNumAchievementsDone());
        System.out.println("Finished Save Logic/Load Logic testInitialSaveAndLoad");
    }

    @Test
    public void testSave(){
        assertEquals("NUmber of clicks should be initially 0", 0, mealLogic.getClicks());
        mealLogic.incrementClicks();

        saveLogic.saveAll();
        loadLogic.loadAll();
        assertEquals("Loaded click value should be equal to 1", 1, mealLogic.getClicks());
    }

    @Test
    public void testLoad(){
        loadLogic.loadAll();
        assertEquals("Loaded click value should be equal to 0", 0, mealLogic.getClicks());
    }

    @Test
    public void testSaveAndLoadAfterIncrease(){
        mealLogic.increaseMeals();
        timeLogic.incrementTime();
        achievLogic.checkClickAchievement(0);

        saveLogic.saveAll();
        loadLogic.loadAll();

        assertEquals("Loaded Meal value should be equal to 1", 1, mealLogic.getMeals());
        assertEquals("Loaded Time value should be equal to 1", 1, timeLogic.getCurrTime());
        assertEquals("Loaded value for number of Achievements done should be equal to 0", 0, achievLogic.getNumAchievementsDone());
        System.out.println("Finished Save Logic/Load Logic testSaveAndLoadAfterIncrease");
    }

    @Test
    public void testSaveAndLoadMealDecrease(){
        mealLogic.increaseMeals();
        mealLogic.decreaseMeals(1);

        saveLogic.saveAll();
        loadLogic.loadAll();

        assertEquals("Loaded Meal value should be equal to 0", 0, mealLogic.getMeals());
        System.out.println("Finished Save Logic/Load Logic testSaveAndLoadMealDecrease");
    }

    @Test
    public void testSaveAndLoadTime(){
        loadLogic.loadAll();
        String currentTime = timeLogic.formatTimeString();
        assertEquals("0:00",currentTime);

        loadLogic.loadAll();
        currentTime = timeLogic.formatTimeString();
        assertEquals("0:00",currentTime);

        timeLogic.incrementTime();
        saveLogic.saveAll();
        loadLogic.loadAll();
        currentTime = timeLogic.formatTimeString();
        assertEquals("0:01",currentTime);

        System.out.println("Finished Save Logic/Load Logic testSaveAndLoadTime");
    }



    @After
    public void tearDown() {
        // reset DB
        this.tempDB.delete();
    }

}
