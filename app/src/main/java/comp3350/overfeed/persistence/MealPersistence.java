package comp3350.overfeed.persistence;

public class MealPersistence
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
