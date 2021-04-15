package comp3350.overfeed.Tests.LogicTests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import comp3350.overfeed.domainObjects.Achievement;
import comp3350.overfeed.logic.AchievementsLogic;
import comp3350.overfeed.persistence.AchievementPersistence;

public class AchievementsLogicTest {

    private AchievementsLogic achieveLogic;
    private Achievement achieve;
    int pts; //test number of points

    @Before
    public void setUp() {
        achieveLogic = new AchievementsLogic();
        achieveLogic.initializeData();
        pts = 0;
        achieve = null;
    }

    @Test
    public void test1(){
        //testing the adding of achievements, percentage done, and fetching index
        System.out.println("Starting Achievements Logic Test One");

        assertEquals("The number of acquired achievements to begin should be zero",
                achieveLogic.getNumAchievementsDone(), 0);

        pts = 9;
        assertFalse("There should not be enough points to have an achievement yet",
                achieveLogic.checkClickAchievement(pts));
        assertEquals("There should not be enough points to have an achievement yet",
                achieveLogic.getNumAchievementsDone(), 0);

        pts++;
        assertTrue("There should only be one achievement acquired (the first)",
                achieveLogic.checkClickAchievement(pts));
        assertEquals("There should only be one achievement acquired (the first)",
                achieveLogic.getNumAchievementsDone(), 1);

        assertEquals("After completing only one achievement, the % should be 12%",
                achieveLogic.getPercentageDone(), 12);

        pts = 25;
        assertTrue("There should be two achievements acquired (the first two)",
                achieveLogic.checkClickAchievement(pts));
        assertEquals("There should be two achievements acquired (the first two)",
                achieveLogic.getNumAchievementsDone(), 2);

        assertEquals("After completing two achievements, the % should be 25%",
                achieveLogic.getPercentageDone(), 25);

        pts = 50;
        assertTrue("There should be three achievements acquired",
                achieveLogic.checkClickAchievement(pts));
        assertEquals("There should be three achievements acquired (the first two)",
                achieveLogic.getNumAchievementsDone(), 3);

        assertEquals("After completing three achievements, the % should be 37%",
                achieveLogic.getPercentageDone(), 37);

        pts = 100;
        assertTrue("There should be four achievements acquired",
                achieveLogic.checkClickAchievement(pts));
        assertEquals("There should be four achievements acquired",
                achieveLogic.getNumAchievementsDone(), 4);

        assertEquals("After completing four achievements, the % should be 50%",
                achieveLogic.getPercentageDone(), 50);

        pts = 200;
        assertTrue("There should be five achievements acquired",
                achieveLogic.checkClickAchievement(pts));
        assertEquals("There should be five achievements acquired",
                achieveLogic.getNumAchievementsDone(), 5);

        assertEquals("After completing five achievements, the % should be 62%",
                achieveLogic.getPercentageDone(), 62);

        pts = 500;
        assertTrue("There should be six achievements acquired",
                achieveLogic.checkClickAchievement(pts));
        assertEquals("There should be six achievements acquired",
                achieveLogic.getNumAchievementsDone(), 6);

        assertEquals("After completing six achievements, the % should be 75%",
                achieveLogic.getPercentageDone(), 75);

        pts = 1000;
        assertTrue("There should be seven achievements acquired",
                achieveLogic.checkClickAchievement(pts));
        assertEquals("There should be seven achievements acquired",
                achieveLogic.getNumAchievementsDone(), 7);

        assertEquals("After completing seven achievements, the % should be 87%",
                achieveLogic.getPercentageDone(), 87);

        pts = 2500;
        assertTrue("There should be eight achievements acquired",
                achieveLogic.checkClickAchievement(pts));
        assertEquals("There should be eight achievements acquired",
                achieveLogic.getNumAchievementsDone(), 8);

        assertEquals("After completing eight achievements, the % should be 100%",
                achieveLogic.getPercentageDone(), 100);

        achieve = achieveLogic.getContent(2);
        assertTrue("Achievement at index 2 should be the 'Whiz' achievement",
                achieve.getName().equals("You are a whiz!"));

        AchievementPersistence pers = achieveLogic.getPersistence();
        assertNotNull("Achievement Persistence should not be null", pers);


        System.out.println("Finished Achievements Logic Test One");
    }

    @Test
    public void test2(){
        //testing getting new achievements
        System.out.println("Starting Achievements Logic Test Two");

        assertFalse("There should be no achievements acquired yet.",
                achieveLogic.checkClickAchievement(pts));
        achieve = achieveLogic.getNewAchievement();
        assertNull("Given that there have been no achievements unlocked, the achieve" +
                        "object should be null.", achieve);

        pts = 10;
        assertTrue("There should be one achievement acquired.",
                achieveLogic.checkClickAchievement(pts));

        assertTrue("NumAchievementsDone should be greater than 0",
                achieveLogic.getNumAchievementsDone() > 0);

        achieve = achieveLogic.getNewAchievement();
        assertNotNull("Given that there has been one achievement unlocked, the achieve" +
                "object should be not null.", achieve);

        System.out.println("Finished Achievements Logic Test Two");
    }

}
