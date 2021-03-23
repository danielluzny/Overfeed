package comp3350.overfeed.persistence;

import java.util.ArrayList;

import comp3350.overfeed.domainObjects.Upgrade;

public interface MealPersistence
{
     void addCurrMeals(int numMeals);

     void decreaseCurrMeals(int numMeals);

     void addTotalMeals(int numMeals);

     void incrementClicks();

     void addUpgrade(Upgrade up);

     int getCurrMeals();

     int getTotalMeals();

     int getClicks();

     ArrayList<Upgrade> getUpgradeList();
}
