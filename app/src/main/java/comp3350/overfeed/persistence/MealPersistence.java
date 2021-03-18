package comp3350.overfeed.persistence;

import java.io.Serializable;
import java.util.ArrayList;

import comp3350.overfeed.domainObjects.Upgrades;

public class MealPersistence implements Serializable
{
    private int totalMeals;
    private int numMeals;
    private int numClicks;

    private ArrayList<Upgrades> upgradeList;

    public MealPersistence()
    {
        this.numMeals = 0;
        this.numClicks = 0;
        this.totalMeals = 0;
        upgradeList = new ArrayList<>();
    }

    public void incrementMeals(int numMeals)
    {
        this.numMeals = this.numMeals+numMeals;
        this.totalMeals = this.totalMeals+numMeals;
    }

    public void decrementMeals(int numMeals) {this.numMeals = this.numMeals-numMeals; }

    public int getMeals()
    {
        return this.numMeals;
    }

    public int getTotalMeals(){ return this.totalMeals; }

    public ArrayList<Upgrades> getUpgradeList()
    {
        return this.upgradeList;
    }

    public void createUpgrade(Upgrades up)
    {
        upgradeList.add(up);
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
