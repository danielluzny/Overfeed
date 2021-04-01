package comp3350.overfeed.application;

import comp3350.overfeed.persistence.AchievementPersistence;
import comp3350.overfeed.persistence.AchievementPersistenceFake;
import comp3350.overfeed.persistence.MealPersistence;
import comp3350.overfeed.persistence.MealPersistenceFake;
import comp3350.overfeed.persistence.TimePersistence;
import comp3350.overfeed.persistence.TimePersistenceFake;
import comp3350.overfeed.persistence.MealPersistenceHSQL;
import comp3350.overfeed.persistence.TimePersistenceHSQL;
import comp3350.overfeed.persistence.AchievementPersistenceHSQL;

public class Services
{
    private static MealPersistence mealPersistence = null;
    private static TimePersistence timePersistence = null;
    private static AchievementPersistence achievementPersistence = null;

    public static synchronized MealPersistence getMealPersistence()
    {
        if(mealPersistence == null)
        {
            mealPersistence = new MealPersistenceFake();
            //mealPersistence = new MealPersistenceHSQL();
        }

        return mealPersistence;
    }

    public static synchronized TimePersistence getTimePersistence()
    {
        if(timePersistence == null)
        {
            timePersistence = new TimePersistenceFake();
            //timePersistence = new TimePersistenceHSQL();
        }

        return timePersistence;
    }

    public static synchronized AchievementPersistence getAchievementPersistence()
    {
        if(achievementPersistence == null)
        {
            achievementPersistence = new AchievementPersistenceFake();
            //achievementPersistence = new AchievementPersistenceHSQL();
        }

        return achievementPersistence;
    }
}
