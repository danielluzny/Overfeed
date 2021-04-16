package comp3350.overfeed.Tests.LogicTests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import comp3350.overfeed.domainObjects.Upgrade;
import comp3350.overfeed.logic.MealLogic;
import comp3350.overfeed.persistence.MealPersistence;

public class MealLogicTest {

    private MealLogic mealLogic;
    private Upgrade up;

    @Before
    public void setUp()
    {
        mealLogic = new MealLogic();
        mealLogic.initializeData();
        up = null;
    }

    @Test
    public void test1()
    {
        //tests for
        System.out.println("Starting Meal Logic Test One");

        assertEquals("Starting number of meals should be 0",
                mealLogic.getMeals(), 0);

        mealLogic.increaseMeals();
        assertEquals("After incrementing meals once, current number of meals should be 1",
                mealLogic.getMeals(), 1);

        assertNotEquals("The toString should not be empty",
                mealLogic.mealsToString(), "");

        int clicks = mealLogic.getClicks();
        assertEquals("The starting number of clicks should be zero",
                clicks, 0);

        mealLogic.incrementClicks();
        clicks = mealLogic.getClicks();
        assertEquals("There should be one click", clicks, 1);

        System.out.println("Finished Meal Logic Test One");
    }

    @Test
    public void test2(){
        //tests for formatting text and ensuring that data isn't null
        System.out.println("Starting Meal Logic Test Two");

        assertNotEquals("The PlateValueText should not be empty ",
                mealLogic.getPlateValueText(), "");

        assertNotEquals("The WorkerValueText should not be empty ",
                mealLogic.getWorkerValueText(), "");

        assertNotEquals("The FoodTruckValueText should not be empty ",
                mealLogic.getFoodTruckValueText(), "");

        assertNotEquals("The RestaurantValueText should not be empty ",
                mealLogic.getRestaurantValueText(), "");

        assertNotEquals("The LambSauceValueText should not be empty ",
                mealLogic.getLambSauceValueText(), "");


        mealLogic.createUpgrade("PLATE", 2, 15, 3);
        assertTrue("Should have plate upgrade", mealLogic.checkUpgradeExists("PLATE"));
        assertNotEquals("The PlateValueText should not be empty ",
                mealLogic.getPlateValueText(), "");

        mealLogic.createUpgrade("WORKER", 5, 100,3);
        assertTrue("Should have worker upgrade", mealLogic.checkUpgradeExists("WORKER"));
        assertNotEquals("The WorkerValueText should not be empty ",
                mealLogic.getWorkerValueText(), "");

        mealLogic.createUpgrade("FOODTRUCK", 30, 350, 2);
        assertTrue("Should have food truck upgrade", mealLogic.checkUpgradeExists("FOODTRUCK"));
        assertNotEquals("The FoodTruckValueText should not be empty ",
                mealLogic.getFoodTruckValueText(), "");

        mealLogic.createUpgrade("RESTAURANT", 100, 1500, 2);
        assertTrue("Should have restaurant upgrade", mealLogic.checkUpgradeExists("RESTAURANT"));
        assertNotEquals("The RestaurantValueText should not be empty ",
                mealLogic.getRestaurantValueText(), "");

        mealLogic.createUpgrade("LAMBSAUCE", 999, 7000, 2);
        assertTrue("Should have lamb sauce upgrade", mealLogic.checkUpgradeExists("LAMBSAUCE"));
        assertNotEquals("The LambSauceValueText should not be empty ",
                mealLogic.getLambSauceValueText(), "");


        assertNotEquals("The MealsToString should not be empty ",
                mealLogic.mealsToString(), "");

        assertNotEquals("The TotalMealsToString should not be empty ",
                mealLogic.totalMealsToString(), "");

        assertNotEquals("The clicksToString should not be empty ",
                mealLogic.clicksToString(), "");


        int[] testCostArr = mealLogic.getBaseCostArray();
        assertNotNull("The BaseCostArray should not be null", testCostArr);

        int[] testValueArr = mealLogic.getBaseValueArray();
        assertNotNull("The BaseValueArray should not be null", testValueArr);

        String[] testIDArr = mealLogic.getUpgradeIDs();
        assertNotEquals("The UpgradeIDsArray should not be empty",
                testIDArr, "");

        ArrayList<Upgrade> up = mealLogic.getUpgradeList();
        assertNotNull("Upgrade list should not be null", up);

        MealPersistence pers = mealLogic.getPersistence();
        assertNotNull("MealPersistence object should not be null", pers);

        int[] costMult = mealLogic.getCostMultArray();
        assertNotNull("Cost Mult Array should not be null", costMult);
        assertTrue("The first item in the cost mult array should be 3.", costMult[0] == 3);


        System.out.println("Finished Meal Logic Test Two");
    }

    @Test
    public void test3(){
        //test adding, subtracting, etc upgrades logic
        System.out.println("Starting Meal Logic Test Three");

        int meals = mealLogic.getMeals();
        assertEquals("Starting number of meals should be zero",
                meals, 0);

        //test increasing meals without a plate upgrade
        mealLogic.increaseMeals();
        meals = mealLogic.getMeals();
        assertEquals("The number of meals after one increment without upgrades should be one",
                meals, 1);

        //test decreasing amount of meals by one
        mealLogic.decreaseMeals(1);
        meals = mealLogic.getMeals();
        assertEquals("After subtracting one meal from the total of 1," +
                "the number of meals should return to 0", meals, 0);

        //test "have enough" without having an upgrade
        assertFalse("There should not be enough meals to purchase an upgrade",
                mealLogic.haveEnoughMeals(50));

        //add enough meals to purchase one upgrade
        for(int i = 0; i < 15; i++){ mealLogic.increaseMeals(); }
        meals = mealLogic.getMeals();
        assertEquals("There should now be 15 meals total", meals, 15);

        assertTrue("There should be enough meals to purchase an upgrade",
                mealLogic.haveEnoughMeals(15));

        //create the worker upgrade
        mealLogic.createUpgrade("Worker", 5, 10,3);
        //add enough meals to purchase one
        for(int i = 0; i < 15; i++){ mealLogic.increaseMeals(); }
        meals = mealLogic.getMeals();

        //check if have enough for worker upgrade
        assertTrue("Should have enough meals to purchase worker upgrade",
                mealLogic.haveEnoughMeals("Worker"));

        //subtract the amount for a worker upgrade
        mealLogic.decreaseMeals("Worker");
        meals = mealLogic.getMeals();

        assertEquals("After decreasing the amount of meals by the price of " +
                "worker (15), we should be back at 0 meals.", meals, 0);

        mealLogic.autoIncreaseMeals();
        int mealsAfter = mealLogic.getMeals();
        assertTrue("Meals after autoincrementing should be greater than meals before",
                meals < mealsAfter);

        up = mealLogic.getUpgrade("Worker");
        assertNotNull("The upgrade should not be null", up);

        int amtBefore = up.getUpgradeNum();
        mealLogic.increaseUpgrade("Worker");
        up = mealLogic.getUpgrade("Worker");

        assertTrue("Current amount of worker upgrade should be more than previous",
                amtBefore < up.getUpgradeNum());

        //test the increaseMeals with a plate
        mealLogic.createUpgrade("PLATE", 2, 15, 3);

        meals = mealLogic.getMeals();
        mealLogic.increaseMeals();
        mealsAfter = mealLogic.getMeals();
        assertTrue("Meals after incrementing with a plate upgrade should be two more " +
                "than before incrementing", (mealsAfter - meals) == 2);


        System.out.println("Finished Meal Logic Test Three");
    }

}

