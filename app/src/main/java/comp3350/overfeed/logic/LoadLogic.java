package comp3350.overfeed.logic;

import comp3350.overfeed.application.Main;
import comp3350.overfeed.persistence.Load;
import comp3350.overfeed.persistence.LoadHSQL;


public class LoadLogic
{
    private Load loader;

    private MealLogic mealLogic;
    private TimeLogic timeLogic;
    private AchievementsLogic achievLogic;

    public void LoadLogic(){}

    public void initializeLoader(MealLogic m, TimeLogic t, AchievementsLogic a)
    {
        mealLogic = m;
        timeLogic = t;
        achievLogic = a;

        loader = new LoadHSQL(Main.getDBPathName(), mealLogic.getPersistence(), timeLogic.getPersistence(), achievLogic.getPersistence());
    }

    public void loadAll()
    {
        loader.loadAll();
    }
}
