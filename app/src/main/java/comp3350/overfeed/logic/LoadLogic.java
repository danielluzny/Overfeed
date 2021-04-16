package comp3350.overfeed.logic;

import comp3350.overfeed.application.Main;
import comp3350.overfeed.persistence.Load;
import comp3350.overfeed.persistence.LoadHSQL;
import comp3350.overfeed.persistence.Save;


public class LoadLogic
{
    private Load loader;

    private MealLogic mealLogic;
    private TimeLogic timeLogic;
    private AchievementsLogic achievLogic;

    public LoadLogic() {

    }

    public LoadLogic(final Load loadPersistence) {
        this.loader = loadPersistence;
    }
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
