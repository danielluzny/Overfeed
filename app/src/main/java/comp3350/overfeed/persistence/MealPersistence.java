package comp3350.overfeed.persistence;

import java.io.Serializable;

public class MealPersistence implements Serializable
{
    private int numMeals;
    private int numClicks;

    public MealPersistence()
    {
        this.numMeals = 0;
        this.numClicks = 0;
    }

    public void incrementMeals()
    {
        this.numMeals++;
    }

    public int getMeals()
    {
        return this.numMeals;
    }

    public void incrementClicks()
    {
        this.numClicks++;
    }

    public int getClicks()
    {
        return this.numClicks;
    }

}
