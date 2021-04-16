package comp3350.overfeed.logic;

import android.util.Log;

import comp3350.overfeed.domainObjects.Upgrade;
import comp3350.overfeed.persistence.MealData;
import comp3350.overfeed.persistence.MealPersistence;

import java.io.Serializable;
import java.util.ArrayList;

public class MealLogic implements Serializable
{
    // Parallel arrays with regards to the upgrades and their attributes
    private final int[] UPGRADE_BASE_COSTS = {15, 100, 350, 1500, 7000}; // cost in meals
    private final String[] UPGRADE_IDS = {"PLATE", "WORKER", "FOODTRUCK", "RESTAURANT", "LAMBSAUCE"};
    private final int[] UPGRADE_BASE_VALUES = {2, 5, 30, 100, 999}; // meals per second
    private final int[] UPGRADE_COST_MULTIPLIERS = {3, 3, 2, 2, 2};

    private final int BASE_AMOUNT_ZERO = 0; // We need a default/base value for upgrades that we haven't unlocked yet.
    private final int BASE_PER_SECOND_ZERO = 0;

    private final int BASE_CLICK_PLATE = 1; // This is strictly for use in a base case situation. By default and without upgrades, the user generates 1 meal per click.

    private MealPersistence mealPersistence;
    private ArrayList<Upgrade> upgradeList;

    public MealLogic() { }

    public void initializeData()
    {
        mealPersistence = new MealData();
        upgradeList = mealPersistence.getUpgradeList();
    }

    // Handles meal increase when clicking on the Plate
    public void increaseMeals()
    {
        boolean found = false; // boolean variable used to determine if we've found the target upgrade or not.
        int pos = -1; // position of our Plate upgrade in the arrayList.

        if(upgradeList.size() != 0) // If we have purchased any upgrades
        {
            for(int i=0; i<upgradeList.size() && !found; i++)
            {
                if(upgradeList.get(i).getId().equals("PLATE")) // Look for an upgrade related to clicking on the plate (id=Plate)
                {

                    found = true;
                    pos = i;
                }
            }
        }

        if(found) // increase our meals per click based on the amount upgraded
        {
            mealPersistence.addCurrMeals(upgradeList.get(pos).getCurrValue());
            mealPersistence.addTotalMeals(upgradeList.get(pos).getCurrValue());
        }
        else // default to 1 meal/click
        {
            mealPersistence.addCurrMeals(1);
            mealPersistence.addTotalMeals(1);
        }

    }

    // Handles meal increase automatically through our upgrades. Called by the Thread in MainActivity every second (since upgrades are in meal-per-second).
    public void autoIncreaseMeals()
    {
        if(upgradeList.size() != 0) // only process if we have any upgrades
        {
            for(int i=0; i<upgradeList.size(); i++)
            {
                if(!(upgradeList.get(i).getId().equals("PLATE"))) // Process every upgrade except the one related to clicking on the plate
                {
                    mealPersistence.addCurrMeals(upgradeList.get(i).getCurrValue());
                    mealPersistence.addTotalMeals(upgradeList.get(i).getCurrValue());
                }
            }
        }
    }


    public void decreaseMeals(String id)
    {
        Upgrade up;

        up = getUpgrade(id);

        mealPersistence.decreaseCurrMeals(up.getCost());
    }

    public String getPlateValueText()
    {
        String result;
        Upgrade up;

        if(checkUpgradeExists(UPGRADE_IDS[0]))
        {
            up = getUpgrade(UPGRADE_IDS[0]);
            result = String.format("Cost for Next:%d Total Amount:%d Current Per Click:%d",up.getCost(),up.getUpgradeNum(),up.getCurrValue());
        }
        else
        {
            result = String.format("Cost for Next:%d Total Amount:%d Current Per Click:%d",UPGRADE_BASE_COSTS[0],BASE_AMOUNT_ZERO,BASE_CLICK_PLATE);
        }

        return result;
    }

    public String getWorkerValueText()
    {
        String result;
        Upgrade up;

        if(checkUpgradeExists(UPGRADE_IDS[1]))
        {
            up = getUpgrade(UPGRADE_IDS[1]);
            result = String.format("Cost for Next:%d Total Amount:%d Current Per Second:%d",up.getCost(),up.getUpgradeNum(),up.getCurrValue());
        }
        else
        {
            result = String.format("Cost for Next:%d Total Amount:%d Current Per Second:%d",UPGRADE_BASE_COSTS[1],BASE_AMOUNT_ZERO,BASE_PER_SECOND_ZERO);
        }

        return result;
    }

    public String getFoodTruckValueText()
    {
        String result;
        Upgrade up;

        if(checkUpgradeExists(UPGRADE_IDS[2]))
        {
            up = getUpgrade(UPGRADE_IDS[2]);
            result = String.format("Cost for Next:%d Total Amount:%d Current Per Second:%d",up.getCost(),up.getUpgradeNum(),up.getCurrValue());
        }
        else
        {
            result = String.format("Cost for Next:%d Total Amount:%d Current Per Second:%d",UPGRADE_BASE_COSTS[2],BASE_AMOUNT_ZERO,BASE_PER_SECOND_ZERO);
        }

        return result;
    }

    public String getRestaurantValueText()
    {
        String result;
        Upgrade up;

        if(checkUpgradeExists(UPGRADE_IDS[3]))
        {
            up = getUpgrade(UPGRADE_IDS[3]);
            result = String.format("Cost for Next:%d Total Amount:%d Current Per Second:%d",up.getCost(),up.getUpgradeNum(),up.getCurrValue());
        }
        else
        {
            result = String.format("Cost for Next:%d Total Amount:%d Current Per Second:%d",UPGRADE_BASE_COSTS[3],BASE_AMOUNT_ZERO,BASE_PER_SECOND_ZERO);
        }

        return result;
    }

    public String getLambSauceValueText()
    {
        String result;
        Upgrade up;

        if(checkUpgradeExists(UPGRADE_IDS[4]))
        {
            up = getUpgrade(UPGRADE_IDS[4]);
            result = String.format("Cost for Next:%d Total Amount:%d Current Per Second:%d",up.getCost(),up.getUpgradeNum(),up.getCurrValue());
        }
        else
        {
            result = String.format("Cost for Next:%d Total Amount:%d Current Per Second:%d",UPGRADE_BASE_COSTS[4],BASE_AMOUNT_ZERO,BASE_PER_SECOND_ZERO);
        }

        return result;
    }

    public void decreaseMeals(int cost)
    {
        mealPersistence.decreaseCurrMeals(cost);
    }

    public void incrementClicks() { mealPersistence.incrementClicks();}

    // Get meal data and associated toStrings
    public int getMeals()
    {
        return mealPersistence.getCurrMeals();
    }

    public int getTotalMeals()
    {
        return mealPersistence.getTotalMeals();
    }

    public int getClicks() { return mealPersistence.getClicks(); }

    public ArrayList<Upgrade> getUpgradeList() { return mealPersistence.getUpgradeList(); }

    public MealPersistence getPersistence() { return this.mealPersistence; }

    public String mealsToString()
    {
        return this.getMeals()+"";
    }

    public String totalMealsToString()
    {
        return this.getTotalMeals()+"";
    }

    public String clicksToString()
    {
        return this.getClicks()+"";
    }
    ///////

    // Return parallel arrays
    public int[] getBaseCostArray()
    {
        return this.UPGRADE_BASE_COSTS;
    }

    public int[] getBaseValueArray()
    {
        return this.UPGRADE_BASE_VALUES;
    }

    public String[] getUpgradeIDs()
    {
        return this.UPGRADE_IDS;
    }

    public int[] getCostMultArray() { return this.UPGRADE_COST_MULTIPLIERS; }
    // ////////

    public boolean checkUpgradeExists(String id)
    {
        boolean result = false;

        if(upgradeList.size()>0)
        {
            for(int i = 0; i < upgradeList.size(); i++)
            {
                if(upgradeList.get(i).getId().equals(id))
                {
                    result = true;
                }
            }
        }

        return result;

    }

    public Upgrade getUpgrade(String id)
    {
        Upgrade result = null;

        if(upgradeList.size()>0)
        {
            for(int i = 0; i < upgradeList.size(); i++)
            {
                if(upgradeList.get(i).getId().equals(id))
                {
                    result = upgradeList.get(i);
                }
            }
        }

        return result;
    }

    public void increaseUpgrade(String id) // Increases the upgrade count by 1
    {
        for(int i=0; i<upgradeList.size(); i++)
        {
            if(upgradeList.get(i).getId().equals(id))
            {
                upgradeList.get(i).addUpgrade();
            }
        }
    }

    public void createUpgrade(String id, int baseValue, int cost, int costMultiplier)
    {
        Upgrade up = new Upgrade(id, baseValue, cost, costMultiplier);
        up.updateCost();
        mealPersistence.addUpgrade(up);
    }

    public boolean haveEnoughMeals(String id) // Find the upgrade with associated ID and check to see if we have enough meals created to purchase it
    {
        boolean result = false;
        Upgrade up = getUpgrade(id);

        if(getMeals()>=up.getCost())
        {
            result = true;
        }

        return result;
    }

    public boolean haveEnoughMeals(int num) // base case situation where we have no upgrades and are passed the BASE_COST
    {
        boolean result = false;

        if(getMeals()>=num)
        {
            result = true;
        }

        return result;
    }
}
