package comp3350.overfeed.persistence;

import java.util.ArrayList;

import comp3350.overfeed.domainObjects.Upgrade;

public interface MealPersistence
{
    public void addCurrMeals(int numMeals);

    public void decreaseCurrMeals(int numMeals);

    public void updateTotalMeals(int numMeals);

    public void incrementClicks();

    public void addUpgrade(Upgrade up);

    public int getCurrMeals();

    public int getTotalMeals();

    public int getClicks();

    public ArrayList<Upgrade> getUpgradeList();
}
