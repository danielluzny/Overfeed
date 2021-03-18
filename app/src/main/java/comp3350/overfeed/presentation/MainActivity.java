package comp3350.overfeed.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import comp3350.overfeed.R;
import comp3350.overfeed.logic.MealLogic;
import comp3350.overfeed.logic.TimeLogic;

public class MainActivity extends AppCompatActivity {

    MealLogic mealLogic = new MealLogic();
    TextView counterTextView;
    Handler mealHandler = new Handler();
    boolean automationFlag = true;
    Runnable mealRunnable = new Runnable()
    {
        @Override
        public void run()
        {
            if(automationFlag)
            {
                mealLogic.autoIncreaseMeals();
                counterTextView.setText(mealLogic.mealsToString());
            }
            mealHandler.postDelayed(this, 1000); // 1000 here because we want the counter to update every second(1000ms). Upgrades are on a per-second timer.
        }
    };
    // End meal set up

    TimeLogic timeLogic = new TimeLogic();
    TextView timerTextView;
    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable()
    {
        @Override
        public void run()
        {
            timeLogic.calculateTime();

            int[] time = timeLogic.formatTime();

            timerTextView.setText(String.format("%d:%02d", time[1], time[0]));
            timerHandler.post(this);
        }
    };
    // End timer set up

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Start the timer on app start up
        timerTextView = findViewById(R.id.timerTextView);
        timerHandler.post(timerRunnable);

        // Start the thread managing meals/upgrades
        counterTextView = findViewById(R.id.counterView);
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
                automationFlag = true;
                mealLogic = (MealLogic)data.getExtras().getSerializable("MEAL_LOGIC");
            }
        }
    }

    public void plateViewOnClick(View v)
    {
        mealLogic.incrementClicks();
        mealLogic.increaseMeals();
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
        automationFlag = false;

        MainActivity.this.startActivityForResult(upgradesIntent,1);
    }

}