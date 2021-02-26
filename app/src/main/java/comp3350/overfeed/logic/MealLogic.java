package comp3350.overfeed.logic;

import comp3350.overfeed.persistence.MealPersistence;

public class MealLogic
{
    private MealPersistence mealPersistence;

    public MealLogic()
    {
        mealPersistence = new MealPersistence();
    }

    public void increaseMeals()
    {
        mealPersistence.incrementMeals();
    }

    public int getMeals()
    {
        return mealPersistence.getMeals();
    }

    public String mealsToString()
    {
        return this.getMeals()+"";
    }
}
