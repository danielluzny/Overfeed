package comp3350.overfeed.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import comp3350.overfeed.R;
import comp3350.overfeed.logic.MealLogic;
import comp3350.overfeed.domainObjects.Upgrades;

public class UpgradesActivity extends AppCompatActivity
{
    MealLogic mealLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrades);

        mealLogic= (MealLogic)getIntent().getSerializableExtra("MEAL_LOGIC");

        // Text views used to create a dynamic description of the upgrades's values such as current amount, cost for next upgrade, and amount produced per second.
        TextView plateTextView = findViewById(R.id.plateUpgradeValues);
        TextView workerTextView = findViewById(R.id.workerUpgradeValues);
        TextView foodTruckTextView = findViewById(R.id.foodTruckUpgradeValues);
        TextView restaurantTextView = findViewById(R.id.restaurantUpgradeValues);
        TextView lambSauceTextView = findViewById(R.id.lambSauceUpgradeValues);

        plateTextView.setText(mealLogic.getPlateValueText());
        workerTextView.setText(mealLogic.getWorkerValueText());
        foodTruckTextView.setText(mealLogic.getFoodTruckValueText());
        restaurantTextView.setText(mealLogic.getRestaurantValueText());
        lambSauceTextView.setText(mealLogic.getLambSauceValueText());
    }

    public void plateUpgradeViewOnClick(View v)
    {
        String id = mealLogic.getUpgradeIDs()[0];
        TextView plateTextView = findViewById(R.id.plateUpgradeValues);

        if(mealLogic.checkUpgradeExists(id))
        {
            if(mealLogic.haveEnoughMeals(id))
            {
                mealLogic.decreaseMeals(id);
                mealLogic.increaseUpgrade(id);
            }
        }
        else
        {
            if(mealLogic.haveEnoughMeals(mealLogic.getBaseCostArray()[0]))
            {
                mealLogic.decreaseMeals(mealLogic.getBaseCostArray()[0]);
                mealLogic.createUpgrade(id, mealLogic.getBaseValueArray()[0], mealLogic.getBaseCostArray()[0]);
            }
        }

        plateTextView.setText(mealLogic.getPlateValueText());
    }

    public void workerUpgradeOnClick(View v)
    {
        String id = mealLogic.getUpgradeIDs()[1];
        TextView workerTextView = findViewById(R.id.workerUpgradeValues);

        if(mealLogic.checkUpgradeExists(id))
        {
            if(mealLogic.haveEnoughMeals(id))
            {
                mealLogic.decreaseMeals(id);
                mealLogic.increaseUpgrade(id);
            }
        }
        else
        {
            if(mealLogic.haveEnoughMeals(mealLogic.getBaseCostArray()[1]))
            {
                mealLogic.decreaseMeals(mealLogic.getBaseCostArray()[1]);
                mealLogic.createUpgrade(id, mealLogic.getBaseValueArray()[1], mealLogic.getBaseCostArray()[1]);
            }
        }

        workerTextView.setText(mealLogic.getWorkerValueText());
    }

    public void foodTruckUpgradeOnClick(View v)
    {
        String id = mealLogic.getUpgradeIDs()[2];
        TextView foodTruckTextView = findViewById(R.id.foodTruckUpgradeValues);

        if(mealLogic.checkUpgradeExists(id))
        {
            if(mealLogic.haveEnoughMeals(id))
            {
                mealLogic.decreaseMeals(id);
                mealLogic.increaseUpgrade(id);
            }
        }
        else
        {
            if(mealLogic.haveEnoughMeals(mealLogic.getBaseCostArray()[2]))
            {
                mealLogic.decreaseMeals(mealLogic.getBaseCostArray()[2]);
                mealLogic.createUpgrade(id, mealLogic.getBaseValueArray()[2], mealLogic.getBaseCostArray()[2]);
            }
        }

        foodTruckTextView.setText(mealLogic.getFoodTruckValueText());
    }

    public void restaurantUpgradeOnClick(View v)
    {
        String id = mealLogic.getUpgradeIDs()[3];
        TextView restaurantTextView = findViewById(R.id.restaurantUpgradeValues);

        if(mealLogic.checkUpgradeExists(id))
        {
            if(mealLogic.haveEnoughMeals(id))
            {
                mealLogic.decreaseMeals(id);
                mealLogic.increaseUpgrade(id);
            }
        }
        else
        {
            if(mealLogic.haveEnoughMeals(mealLogic.getBaseCostArray()[3]))
            {
                mealLogic.decreaseMeals(mealLogic.getBaseCostArray()[3]);
                mealLogic.createUpgrade(id, mealLogic.getBaseValueArray()[3], mealLogic.getBaseCostArray()[3]);
            }
        }

        restaurantTextView.setText(mealLogic.getRestaurantValueText());
    }

    public void lambSauceUpgradeOnClick(View v)
    {
        String id = mealLogic.getUpgradeIDs()[4];
        TextView lambSauceTextView = findViewById(R.id.lambSauceUpgradeValues);

        if(mealLogic.checkUpgradeExists(id))
        {
            if(mealLogic.haveEnoughMeals(id))
            {
                mealLogic.decreaseMeals(id);
                mealLogic.increaseUpgrade(id);
            }
        }
        else
        {
            if(mealLogic.haveEnoughMeals(mealLogic.getBaseCostArray()[4]))
            {
                mealLogic.decreaseMeals(mealLogic.getBaseCostArray()[4]);
                mealLogic.createUpgrade(id, mealLogic.getBaseValueArray()[4], mealLogic.getBaseCostArray()[4]);
            }
        }

        lambSauceTextView.setText(mealLogic.getLambSauceValueText());
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent();
        intent.putExtra("MEAL_LOGIC", mealLogic);
        setResult(RESULT_OK,intent);
        finish();
    }

}
