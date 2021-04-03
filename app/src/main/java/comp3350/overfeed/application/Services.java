package comp3350.overfeed.application;

import comp3350.overfeed.persistence.AchievementPersistence;
import comp3350.overfeed.persistence.LoadHSQL;
import comp3350.overfeed.persistence.MealPersistence;
import comp3350.overfeed.persistence.TimePersistence;
import comp3350.overfeed.persistence.MealData;
import comp3350.overfeed.persistence.TimeData;
import comp3350.overfeed.persistence.AchievementData;

import comp3350.overfeed.persistence.SaveHSQL;

public class Services
{
    public static MealPersistence mealPersistence = null;
    public static TimePersistence timePersistence = null;
    public static AchievementPersistence achievementPersistence = null;
    public static SaveHSQL saveHSQL = null;
    public static LoadHSQL loadHSQL = null;


    public static synchronized MealPersistence getMealPersistence()
    {
        if(mealPersistence == null)
        {
            mealPersistence = new MealData();
        }

        return mealPersistence;
    }

    public static synchronized TimePersistence getTimePersistence()
    {
        if(timePersistence == null)
        {
            timePersistence = new TimeData();
        }

        return timePersistence;
    }

    public static synchronized AchievementPersistence getAchievementPersistence()
    {
        if(achievementPersistence == null)
        {
            achievementPersistence = new AchievementData();
        }

        return achievementPersistence;
    }

    public static synchronized void makeSaver()
    {
        saveHSQL = new SaveHSQL(Main.getDBPathName(), mealPersistence, timePersistence, achievementPersistence);
    }

    public static synchronized void makeLoader()
    {
        loadHSQL = new LoadHSQL(Main.getDBPathName(), mealPersistence, timePersistence, achievementPersistence);
    }

}
