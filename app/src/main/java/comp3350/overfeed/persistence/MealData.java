package comp3350.overfeed.persistence;

import java.io.Serializable;
import java.util.ArrayList;

import comp3350.overfeed.domainObjects.Upgrade;

public class MealData implements MealPersistence, Serializable
{
    private int currMeals;
    private int totalMeals;
    private int numClicks;

    public ArrayList<Upgrade> upgradeList;

    public MealData()
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
        numClicks++;
    }

    public void addUpgrade(Upgrade up)
    {
        upgradeList.add(up);
    }

    public int getCurrMeals()
    {
        return this.currMeals;
    }

    public int getTotalMeals()
    {
        return this.totalMeals;
    }

    public int getClicks()
    {
        return this.numClicks;
    }

    public void setCurrMeals(int currMeals)
    {
        this.currMeals = currMeals;
    }

    public void setTotalMeals(int totalMeals)
    {
        this.totalMeals = totalMeals;
    }

    public void setNumClicks(int numClicks)
    {
        this.numClicks = numClicks;
    }

    public ArrayList<Upgrade> getUpgradeList()
    {
        return this.upgradeList;
    }
}
