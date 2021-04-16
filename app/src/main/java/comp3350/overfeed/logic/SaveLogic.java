package comp3350.overfeed.logic;

import comp3350.overfeed.persistence.Save;
import comp3350.overfeed.persistence.SaveHSQL;
import comp3350.overfeed.application.Main;

public class SaveLogic
{
    private Save saver;

    private MealLogic mealLogic;
    private TimeLogic timeLogic;
    private AchievementsLogic achievLogic;

    public SaveLogic(){}

    public SaveLogic(final Save savePersistence) {
        this.saver = savePersistence;
    }

    public void initializeSaver(MealLogic m, TimeLogic t, AchievementsLogic a)
    {
        mealLogic = m;
        timeLogic = t;
        achievLogic = a;

        saver = new SaveHSQL(Main.getDBPathName(), mealLogic.getPersistence(), timeLogic.getPersistence(), achievLogic.getPersistence());
    }

    public void saveAll()
    {
        saver.saveAll();
    }

}
