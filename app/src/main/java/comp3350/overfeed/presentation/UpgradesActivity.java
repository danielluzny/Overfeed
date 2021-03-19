package comp3350.overfeed.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
        Context context = getApplicationContext();
        String toastText = "Whoops! You don't have enough clicks yet to get this upgrade!";
        int duration = Toast.LENGTH_SHORT;

        if(mealLogic.checkUpgradeExists(id))
        {
            if(mealLogic.haveEnoughMeals(id)) {
                mealLogic.decreaseMeals(id);
                mealLogic.increaseUpgrade(id);
                toastText = id+ " Upgrade increased!";
            }
        }
        else
        {
            if(mealLogic.haveEnoughMeals(mealLogic.getBaseCostArray()[0]))
            {
                mealLogic.decreaseMeals(mealLogic.getBaseCostArray()[0]);
                mealLogic.createUpgrade(id, mealLogic.getBaseValueArray()[0], mealLogic.getBaseCostArray()[0]);
                toastText = id+ " Upgrade unlocked!";
            }

        }
        Toast toast = Toast.makeText(context, toastText, duration);
        toast.show();

        plateTextView.setText(mealLogic.getPlateValueText());
    }

    public void workerUpgradeOnClick(View v)
    {
        String id = mealLogic.getUpgradeIDs()[1];
        TextView workerTextView = findViewById(R.id.workerUpgradeValues);
        Context context = getApplicationContext();
        String toastText = "Whoops! You don't have enough clicks yet to get this upgrade!";
        int duration = Toast.LENGTH_SHORT;

        if(mealLogic.checkUpgradeExists(id))
        {
            if(mealLogic.haveEnoughMeals(id))
            {
                mealLogic.decreaseMeals(id);
                mealLogic.increaseUpgrade(id);
                toastText = id+ " Upgrade increased!";
            }
        }
        else
        {
            if(mealLogic.haveEnoughMeals(mealLogic.getBaseCostArray()[1]))
            {
                mealLogic.decreaseMeals(mealLogic.getBaseCostArray()[1]);
                mealLogic.createUpgrade(id, mealLogic.getBaseValueArray()[1], mealLogic.getBaseCostArray()[1]);
                toastText = id+ " Upgrade unlocked!";
            }
        }
        Toast toast = Toast.makeText(context, toastText, duration);
        toast.show();

        workerTextView.setText(mealLogic.getWorkerValueText());
    }

    public void foodTruckUpgradeOnClick(View v)
    {
        String id = mealLogic.getUpgradeIDs()[2];
        TextView foodTruckTextView = findViewById(R.id.foodTruckUpgradeValues);
        Context context = getApplicationContext();
        String toastText = "Whoops! You don't have enough clicks yet to get this upgrade!";
        int duration = Toast.LENGTH_SHORT;

        if(mealLogic.checkUpgradeExists(id))
        {
            if(mealLogic.haveEnoughMeals(id))
            {
                mealLogic.decreaseMeals(id);
                mealLogic.increaseUpgrade(id);
                toastText = id+ " Upgrade increased!";
            }
        }
        else
        {
            if(mealLogic.haveEnoughMeals(mealLogic.getBaseCostArray()[2]))
            {
                mealLogic.decreaseMeals(mealLogic.getBaseCostArray()[2]);
                mealLogic.createUpgrade(id, mealLogic.getBaseValueArray()[2], mealLogic.getBaseCostArray()[2]);
                toastText = id+ " Upgrade unlocked!";
            }
        }
        Toast toast = Toast.makeText(context, toastText, duration);
        toast.show();

        foodTruckTextView.setText(mealLogic.getFoodTruckValueText());
    }

    public void restaurantUpgradeOnClick(View v)
    {
        String id = mealLogic.getUpgradeIDs()[3];
        TextView restaurantTextView = findViewById(R.id.restaurantUpgradeValues);
        Context context = getApplicationContext();
        String toastText = "Whoops! You don't have enough clicks yet to get this upgrade!";
        int duration = Toast.LENGTH_SHORT;


        if(mealLogic.checkUpgradeExists(id))
        {
            if(mealLogic.haveEnoughMeals(id))
            {
                mealLogic.decreaseMeals(id);
                mealLogic.increaseUpgrade(id);
                toastText = id+ " Upgrade increased!";
            }
        }
        else
        {
            if(mealLogic.haveEnoughMeals(mealLogic.getBaseCostArray()[3]))
            {
                mealLogic.decreaseMeals(mealLogic.getBaseCostArray()[3]);
                mealLogic.createUpgrade(id, mealLogic.getBaseValueArray()[3], mealLogic.getBaseCostArray()[3]);
                toastText = id+ " Upgrade unlocked!";
            }
        }
        Toast toast = Toast.makeText(context, toastText, duration);
        toast.show();

        restaurantTextView.setText(mealLogic.getRestaurantValueText());
    }

    public void lambSauceUpgradeOnClick(View v)
    {
        String id = mealLogic.getUpgradeIDs()[4];
        TextView lambSauceTextView = findViewById(R.id.lambSauceUpgradeValues);
        Context context = getApplicationContext();
        String toastText = "Whoops! You don't have enough clicks yet to get this upgrade!";
        int duration = Toast.LENGTH_SHORT;


        if(mealLogic.checkUpgradeExists(id))
        {
            if(mealLogic.haveEnoughMeals(id))
            {
                mealLogic.decreaseMeals(id);
                mealLogic.increaseUpgrade(id);
                toastText = id+ " Upgrade increased!";
            }
        }
        else
        {
            if(mealLogic.haveEnoughMeals(mealLogic.getBaseCostArray()[4]))
            {
                mealLogic.decreaseMeals(mealLogic.getBaseCostArray()[4]);
                mealLogic.createUpgrade(id, mealLogic.getBaseValueArray()[4], mealLogic.getBaseCostArray()[4]);
                toastText = id+ " Upgrade unlocked!";
            }
        }
        Toast toast = Toast.makeText(context, toastText, duration);
        toast.show();

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
