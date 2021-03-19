package comp3350.srsys.application;

import comp3350.overfeed.persistence.IDatabase;
import comp3350.overfeed.persistence.TimePersistence;
import comp3350.overfeed.persistence.MealPersistence;
import comp3350.overfeed.persistence.Database;
import comp3350.overfeed.presentation.MainActivity;

public class Services
{
	private static MealPersistence mealPersistence = null;
	private static TimePersistence timePersistence = null;
	private static IDatabase iDatabase = null;

	public static synchronized MealPersistence getMealPersistence()
    {
		if (mealPersistence == null)
		{
		    //mealPersistence = new MealPersistenceStub();
            mealPersistence = new MealPersistence();
        }

        return mealPersistence;
	}

    public static synchronized TimePersistence getTimePersistence()
    {
        if (timePersistence == null)
        {
            // timePersistence = new TimePersistenceStub();
            timePersistence = new TimePersistence();
        }

        return timePersistence;
    }

	public static synchronized IDatabase getIDatabase() {
        if (iDatabase == null) {
            // IDatabase = new IDatabaseStub();
            iDatabase = new Database(MainActivity.getDBPathName());
        }

        return iDatabase;
    }
}
