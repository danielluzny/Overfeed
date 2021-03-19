package comp3350.srsys.application;

import comp3350.overfeed.persistence.TimePersistence;
import comp3350.overfeed.persistence.SCPersistence;
import comp3350.overfeed.persistence.MealPersistence;
import comp3350.overfeed.persistence.hsqldb.TimePersistenceHSQLDB;
import comp3350.overfeed.persistence.hsqldb.SCPersistenceHSQLDB;
import comp3350.overfeed.persistence.hsqldb.MealPersistenceHSQLDB;

public class Services
{
	private static MealPersistence mealPersistence = null;
	private static TimePersistence timePersistence = null;
	private static SCPersistence scPersistence = null;

	public static synchronized MealPersistence getMealPersistence()
    {
		if (mealPersistence == null)
		{
		    //mealPersistence = new MealPersistenceStub();
            mealPersistence = new MealPersistenceHSQLDB(Main.getDBPathName());
        }

        return mealPersistence;
	}

    public static synchronized TimePersistence getTimePersistence()
    {
        if (timePersistence == null)
        {
            // timePersistence = new TimePersistenceStub();
            timePersistence = new TimePersistenceHSQLDB(Main.getDBPathName());
        }

        return timePersistence;
    }

	public static synchronized SCPersistence getScPersistence() {
        if (scPersistence == null) {
            // scPersistence = new SCPersistenceStub();
            scPersistence = new SCPersistenceHSQLDB(Main.getDBPathName());
        }

        return scPersistence;
    }
}
