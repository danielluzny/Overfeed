package comp3350.overfeed.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import comp3350.overfeed.R;
import comp3350.overfeed.logic.AchievementsLogic;
import comp3350.overfeed.logic.MealLogic;
import comp3350.overfeed.logic.TimeLogic;

public class MainActivity extends AppCompatActivity {

    MealLogic mealLogic = new MealLogic();
    AchievementsLogic achLogic = new AchievementsLogic();
    TimeLogic timeLogic = new TimeLogic();

    // Handler and TextViews are for running the thread and updating the timer/meals fields.
    Handler mealHandler = new Handler();

    TextView mealTextView;
    TextView timerTextView;

    Runnable mealRunnable = new Runnable() // Thread that executes every second. Updates timer and meals per second.
    {
        @Override
        public void run()
        {
            timeLogic.calculateTime();
            int[] time = timeLogic.formatTime();
            timerTextView.setText(String.format("%d:%02d", time[1], time[0]));

            mealLogic.autoIncreaseMeals();
            mealTextView.setText(mealLogic.mealsToString());


            if(achLogic.checkClickAchievement(mealLogic.getMeals())){
                String newAchievement = achLogic.getNewAchievement().getName();
                Snackbar mySnackbar = Snackbar.make(findViewById(R.id.myCoordinatorLayout), "Achievement Unlocked! "+ newAchievement, Snackbar.LENGTH_SHORT);
                mySnackbar.show();
            }

            mealHandler.postDelayed(this, 1000); // 1000 here because we want the counter to update every second(1000ms). Upgrades are on a per-second timer.
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerTextView = findViewById(R.id.timerTextView);
        mealTextView = findViewById(R.id.counterView);

        mealHandler.post(mealRunnable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==1)
        {
            if(resultCode == RESULT_OK)
            {
                mealLogic = (MealLogic)data.getExtras().getSerializable("MEAL_LOGIC");
            }
        }
        else if(requestCode==2)
        {
            if(resultCode == RESULT_OK)
            {
                achLogic = (AchievementsLogic)data.getExtras().getSerializable("ACH_LOGIC");
            }
        }
    }

    public void plateViewOnClick(View v)
    {
        mealLogic.incrementClicks();
        mealLogic.increaseMeals();
        mealTextView = (TextView)findViewById(R.id.counterView);
        mealTextView.setText(mealLogic.mealsToString());
    }

    public void tabStatisticsOnClick(View v)
    {
        Intent statisticsIntent = new Intent(MainActivity.this, StatisticsActivity.class);
        Bundle extras = new Bundle();

        int[] currTime = timeLogic.formatTime();
        extras.putString("TIME_MINUTES", Integer.toString(currTime[1]));
        extras.putString("TIME_SECONDS", String.format("%02d", currTime[0]));
        extras.putString("NUMBER_CLICKS", mealLogic.clicksToString());
        extras.putString("NUMBER_MEALS", mealLogic.totalMealsToString());
        statisticsIntent.putExtras(extras);

        MainActivity.this.startActivity(statisticsIntent);
    }

    public void upgradeViewOnClick(View v)
    {
        Intent upgradesIntent = new Intent(MainActivity.this, UpgradesActivity.class);

        upgradesIntent.putExtra("MEAL_LOGIC", mealLogic);

        MainActivity.this.startActivityForResult(upgradesIntent,1);
    }

    public void tabAchievementsOnClick(View v)
    {
        Bundle extra = new Bundle();
        Intent achievementsIntent = new Intent(MainActivity.this, AchievementsActivity.class);
        achievementsIntent.putExtra("ACH_LOGIC", achLogic);
        extra.putInt("NUM_CLICKS", mealLogic.getClicks());
        achievementsIntent.putExtras(extra);
        MainActivity.this.startActivityForResult(achievementsIntent, 2);
    }

}