package comp3350.overfeed.Tests.LogicTests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import comp3350.overfeed.domainObjects.Upgrades;
import comp3350.overfeed.logic.MealLogic;

public class MealLogicTest {

    private MealLogic mealLogic;
    private Upgrades up;

    @Before
    public void setUp()
    {
        mealLogic = new MealLogic();
        up = null;
    }

    @Test
    public void test1()
    {
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
        //test formatting text and ensuring that data isn't null
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


        mealLogic.createUpgrade("Plate", 2, 15);
        assertTrue("Should have plate upgrade", mealLogic.checkUpgradeExists("Plate"));
        assertNotEquals("The PlateValueText should not be empty ",
                mealLogic.getPlateValueText(), "");

        mealLogic.createUpgrade("Worker", 5, 100);
        assertTrue("Should have worker upgrade", mealLogic.checkUpgradeExists("Worker"));
        assertNotEquals("The WorkerValueText should not be empty ",
                mealLogic.getWorkerValueText(), "");

        mealLogic.createUpgrade("Food Truck", 30, 350);
        assertTrue("Should have food truck upgrade", mealLogic.checkUpgradeExists("Food Truck"));
        assertNotEquals("The FoodTruckValueText should not be empty ",
                mealLogic.getFoodTruckValueText(), "");

        mealLogic.createUpgrade("Restaurant", 100, 1500);
        assertTrue("Should have restaurant upgrade", mealLogic.checkUpgradeExists("Restaurant"));
        assertNotEquals("The RestaurantValueText should not be empty ",
                mealLogic.getRestaurantValueText(), "");

        mealLogic.createUpgrade("Lamb Sauce", 999, 7000);
        assertTrue("Should have lamb sauce upgrade", mealLogic.checkUpgradeExists("Lamb Sauce"));
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
        mealLogic.createUpgrade("Worker", 5, 10);
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

        //test the increasemeals with a plate
        mealLogic.createUpgrade("Plate", 2, 15);

        meals = mealLogic.getMeals();
        mealLogic.increaseMeals();
        mealsAfter = mealLogic.getMeals();
        assertTrue("Meals after incrementing with a plate upgrade should be two more " +
                "than before incrementing", (mealsAfter - meals) == 2);


        System.out.println("Finished Meal Logic Test Three");
    }

}

