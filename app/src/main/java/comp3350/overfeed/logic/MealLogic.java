package comp3350.overfeed.logic;

import comp3350.overfeed.domainObjects.Upgrades;
import comp3350.overfeed.persistence.MealPersistence;

import java.io.Serializable;
import java.util.ArrayList;
import android.util.Log;

public class MealLogic implements Serializable
{
    // Parallel arrays with regards to the upgrades and their attributes
    private final int[] UPGRADE_BASE_COSTS = {15, 100, 350, 1500, 7000}; // cost in meals
    private final String[] UPGRADE_IDS = {"Plate", "Worker", "Food Truck", "Restaurant", "Lamb Sauce"};
    private final int[] UPGRADE_BASE_VALUES = {2, 5, 30, 100, 999}; // meals per second

    private MealPersistence mealPersistence;
    private ArrayList<Upgrades> upgradeList;

    public MealLogic()
    {
        mealPersistence = new MealPersistence();
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
                if(upgradeList.get(i).getId().equals("Plate")) // Look for an upgrade related to clicking on the plate (id=Plate)
                {

                    found = true;
                    pos = i;
                }
            }
        }

        if(found) // increase our meals per click based on the amount upgraded
        {
            mealPersistence.incrementMeals(upgradeList.get(pos).getCurrValue());
        }
        else // default to 1 meal/click
        {
            mealPersistence.incrementMeals(1);
        }
    }

    // Handles meal increase automatically through our upgrades. Called by the Thread in MainActivity every second (since upgrades are in meal-per-second).
    public void autoIncreaseMeals()
    {
        if(upgradeList.size() != 0) // only process if we have any upgrades
        {
            for(int i=0; i<upgradeList.size(); i++)
            {
                if(!(upgradeList.get(i).getId().equals("Plate"))) // Process every upgrade except the one related to clicking on the plate
                {
                    mealPersistence.incrementMeals(upgradeList.get(i).getCurrValue());
                }
            }
        }
    }


    public void decreaseMeals(String id)
    {
        Upgrades up;

        up = getUpgrade(id);

        mealPersistence.decrementMeals(up.getCost());
    }

    public String getPlateValueText()
    {
        String result = "";
        Upgrades up = null;

        if(checkUpgradeExists(UPGRADE_IDS[0]))
        {
            up = getUpgrade(UPGRADE_IDS[0]);
            result = String.format("Cost for Next:%d Total Amount:%d Current Per Click:%d",up.getCost(),up.getUpgradeNum(),up.getCurrValue());
        }
        else
        {
            result = String.format("Cost for Next:%d Total Amount:%d Current Per Click:%d",UPGRADE_BASE_COSTS[0],0,1);
        }

        return result;
    }

    public String getWorkerValueText()
    {
        String result = "";
        Upgrades up = null;

        if(checkUpgradeExists(UPGRADE_IDS[1]))
        {
            up = getUpgrade(UPGRADE_IDS[1]);
            result = String.format("Cost for Next:%d Total Amount:%d Current Per Second:%d",up.getCost(),up.getUpgradeNum(),up.getCurrValue());
        }
        else
        {
            result = String.format("Cost for Next:%d Total Amount:%d Current Per Second:%d",UPGRADE_BASE_COSTS[1],0,0);
        }

        return result;
    }

    public String getFoodTruckValueText()
    {
        String result = "";
        Upgrades up = null;

        if(checkUpgradeExists(UPGRADE_IDS[2]))
        {
            up = getUpgrade(UPGRADE_IDS[2]);
            result = String.format("Cost for Next:%d Total Amount:%d Current Per Second:%d",up.getCost(),up.getUpgradeNum(),up.getCurrValue());
        }
        else
        {
            result = String.format("Cost for Next:%d Total Amount:%d Current Per Second:%d",UPGRADE_BASE_COSTS[2],0,0);
        }

        return result;
    }

    public String getRestaurantValueText()
    {
        String result = "";
        Upgrades up = null;

        if(checkUpgradeExists(UPGRADE_IDS[3]))
        {
            up = getUpgrade(UPGRADE_IDS[3]);
            result = String.format("Cost for Next:%d Total Amount:%d Current Per Second:%d",up.getCost(),up.getUpgradeNum(),up.getCurrValue());
        }
        else
        {
            result = String.format("Cost for Next:%d Total Amount:%d Current Per Second:%d",UPGRADE_BASE_COSTS[3],0,0);
        }

        return result;
    }

    public String getLambSauceValueText()
    {
        String result = "";
        Upgrades up = null;

        if(checkUpgradeExists(UPGRADE_IDS[4]))
        {
            up = getUpgrade(UPGRADE_IDS[4]);
            result = String.format("Cost for Next:%d Total Amount:%d Current Per Second:%d",up.getCost(),up.getUpgradeNum(),up.getCurrValue());
        }
        else
        {
            result = String.format("Cost for Next:%d Total Amount:%d Current Per Second:%d",UPGRADE_BASE_COSTS[4],0,0);
        }

        return result;
    }

    public void decreaseMeals(int cost)
    {
        mealPersistence.decrementMeals(cost);
    }

    public int getMeals()
    {
        return mealPersistence.getMeals();
    }

    public int getTotalMeals()
    {
        return mealPersistence.getTotalMeals();
    }

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

    public void incrementClicks() { mealPersistence.incrementClicks();}

    public int getClicks() { return mealPersistence.getClicks(); }

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

    public Upgrades getUpgrade(String id)
    {
        Upgrades result = null;

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

    public void createUpgrade(String id, int baseValue, int cost)
    {
        Upgrades up = new Upgrades(id, baseValue, cost);
        up.updateCost();
        mealPersistence.createUpgrade(up);
    }

    public boolean haveEnoughMeals(String id) // Find the upgrade with associated ID and check to see if we have enough meals created to purchase it
    {
        boolean result = false;
        Upgrades up = getUpgrade(id);

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
