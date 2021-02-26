package comp3350.overfeed.Tests.LogicTests;

import org.junit.Before;
import org.junit.Test;
import java.io.File;
import comp3350.overfeed.logic.MealLogic;
import comp3350.overfeed.logic.SaveLogic;
import comp3350.overfeed.logic.TimeLogic;
import comp3350.overfeed.persistence.SavePersistence;

public class SaveLogicTest {

    private SaveLogic saveLogic;
    private MealLogic mealLogic;
    private TimeLogic timelogic;

    @Before
    public void setUp()
    {
        mealLogic = new MealLogic();
        timelogic = new TimeLogic();
        File saveFile = new File("sessionSaveFile.txt");
        if(saveFile.delete())
            System.out.println("File found and deleted.");
        saveLogic = new SaveLogic(mealLogic, timelogic);
    }

    @Test
    public void test1() {
        System.out.println("Starting Save Logic Tests");

        File saves = new File("sessionSaveFile.txt");
        if(saves.exists()) {
            System.out.println("File exists.");
        } else {
            System.out.println("File does not exist, save failed.");
        }

        saveLogic.setGame(10);
        saveLogic.saveGame();
        System.out.println("Should read in 10 from meals.");
        saveLogic.loadGame();
    }

}
