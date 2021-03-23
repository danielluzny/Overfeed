package comp3350.overfeed.persistence;

import java.io.Serializable;
import java.util.ArrayList;

import comp3350.overfeed.domainObjects.Upgrade;

public class MealPersistenceFake implements MealPersistence, Serializable
{
    private int currMeals;
    private int totalMeals;
    private int numClicks;

    private ArrayList<Upgrade> upgradeList;

    public MealPersistenceFake()
    {
        currMeals = 0;
        numClicks = 0;
        totalMeals = 0;
        upgradeList = new ArrayList<>();
    }

    public void addCurrMeals(int numMeals)
    {
        currMeals = currMeals+numMeals;
    }

    public void decreaseCurrMeals(int numMeals)
    {
        currMeals = currMeals-numMeals;
    }

    public void addTotalMeals(int numMeals)
    {
        totalMeals = totalMeals+numMeals;
    }

    public void incrementClicks()
    {
        this.numClicks++;
    }

    public void addUpgrade(Upgrade up)
    {
        upgradeList.add(up);
    }

    public int getCurrMeals()
    {
        return this.currMeals;
    }

    public int getTotalMeals(){ return this.totalMeals; }

    public int getClicks()
    {
        return this.numClicks;
    }

    public ArrayList<Upgrade> getUpgradeList()
    {
        return this.upgradeList;
    }

}
