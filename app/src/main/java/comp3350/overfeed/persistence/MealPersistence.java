package comp3350.overfeed.persistence;

public class MealPersistence
{
    private int numMeals;

    public MealPersistence()
    {
        this.numMeals = 0;
    }

    public void incrementMeals()
    {
        this.numMeals++;
    }

    public int getMeals()
    {
        return this.numMeals;
    }

}
