package comp3350.overfeed.logic;

import java.io.Serializable;

import comp3350.overfeed.persistence.MealPersistence;

public class MealLogic implements Serializable
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

    public void incrementClicks() { mealPersistence.incrementClicks();}

    public int getClicks() { return mealPersistence.getClicks(); }
}
