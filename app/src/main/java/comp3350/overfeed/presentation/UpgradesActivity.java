package comp3350.overfeed.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.util.Log;

import comp3350.overfeed.R;
import comp3350.overfeed.logic.MealLogic;

public class UpgradesActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrades);
    }

    //TODO find out how to pass data between main/upgrades activity and make it persist with Back button press
    public void plateUpgradeViewOnClick(View v)
    {
        // mealLogic.increaseUpgrade("Plate", 2);
    }

}
