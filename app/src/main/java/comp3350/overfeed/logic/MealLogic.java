package comp3350.overfeed.logic;

import comp3350.overfeed.domainObjects.Upgrades;
import comp3350.overfeed.persistence.MealPersistence;

import java.util.ArrayList;
import android.util.Log;

public class MealLogic
{
    private MealPersistence mealPersistence;
    private ArrayList<Upgrades> upgradeList;

    public MealLogic()
    {
        mealPersistence = new MealPersistence();
        upgradeList = mealPersistence.getUpgradeList();
    }

    // Handles meal increase when clicking on the Plate (a special case of meal increasing)
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
            Log.i("dsf","Inside increaseMeals and found Plate upgrade");
            mealPersistence.incrementMeals(upgradeList.get(pos).getCurrValue());
        }
        else // default to 1 meal/click
        {
            Log.i("dsf","Inside increaseMeals and not found Plate upgrade");
            mealPersistence.incrementMeals(1);
        }
    }

    public int getMeals()
    {
        return mealPersistence.getMeals();
    }

    public String mealsToString()
    {
        return this.getMeals()+"";
    }

    public String clicksToString()
    {
        return this.getClicks()+"";
    }

    public void incrementClicks() { mealPersistence.incrementClicks();}

    public int getClicks() { return mealPersistence.getClicks(); }

    public void increaseUpgrade(String id, int baseValue)
    {
        boolean found = false;

        for(int i=0; i<upgradeList.size(); i++) // look for the appropriate upgrade to increase
        {
            if(upgradeList.get(i).getId().equals(id))
            {
                Log.i("fsd","Inside upgradeList loop");
                upgradeList.get(i).addUpgrade();
                found = true;
                Log.i("...",""+upgradeList.get(0).getCurrValue());
            }
        }

        if(!found) // if the upgrade isn't in the list then it hasn't been created yet
        {
            Log.i("fsd","Inside !found before object made");
            createUpgrade(id, baseValue);
            Log.i("..",""+upgradeList.get(0).getCurrValue());
        }
    }

    public void createUpgrade(String id, int baseValue)
    {
        Upgrades up = new Upgrades(id, baseValue);
        mealPersistence.createUpgrade(up);
    }
}
