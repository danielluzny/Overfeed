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

    // Meal logic set up
    MealLogic mealLogic = new MealLogic();
    // Achievements logic set up
    AchievementsLogic achLogic = new AchievementsLogic();
    TextView counterTextView;

    // Timer set up
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
        timerTextView = (TextView)findViewById(R.id.timerTextView);
        timerHandler.post(timerRunnable);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void plateViewOnClick(View v)
    {
        mealLogic.increaseMeals();
        counterTextView = (TextView)findViewById(R.id.counterView);
        counterTextView.setText(mealLogic.mealsToString());

        if(achLogic.checkClickAchievement(mealLogic.getMeals())){
            String newAchievement = achLogic.getNewAchievement().getName();
            Snackbar mySnackbar = Snackbar.make(findViewById(R.id.myCoordinatorLayout), "Achievement Unlocked! "+ newAchievement, Snackbar.LENGTH_SHORT);
            mySnackbar.show();
        }
    }

    //     OnClick methods for Tab Items (Statistics, Achievements)
    public void tabStatisticsOnClick(View v)
    {
        Intent statisticsIntent = new Intent(MainActivity.this, StatisticsActivity.class);
        Bundle extras = new Bundle();

        int[] currTime = timeLogic.formatTime();
        extras.putString("TIME_MINUTES", Integer.toString(currTime[1]));
        extras.putString("TIME_SECONDS", String.format("%02d", currTime[0]));
        extras.putString("NUMBER_CLICKS", mealLogic.mealsToString());
        statisticsIntent.putExtras(extras);

        MainActivity.this.startActivity(statisticsIntent);
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

    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2)
        {
            if(resultCode == RESULT_OK)
            {
                achLogic = (AchievementsLogic)data.getExtras().getSerializable("ACH_LOGIC");
            }
        }
    }



}