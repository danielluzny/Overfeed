package comp3350.overfeed.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.TimerTask;
import java.util.Timer;

import comp3350.overfeed.R;
import comp3350.overfeed.logic.AchievementsLogic;
import comp3350.overfeed.logic.MealLogic;
import comp3350.overfeed.logic.TimeLogic;
import comp3350.overfeed.persistence.Database;

public class MainActivity extends AppCompatActivity {

    // Meal logic set up
    MealLogic mealLogic = new MealLogic();

    // Achievements logic set up
    AchievementsLogic achLogic = new AchievementsLogic();

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

    //Database set up
    private static String dbName="SF";
    Database database = new Database(dbName);
    TimerTask saveNow = new TimerTask()
    {
        public void run() {
            database.saveAll();
        }
    };

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

        // start the thread managing the database
        database.loadAll();//load saved data if it exists
        Timer timer = new Timer("dbTimer", true);
        long delay = 10000; //10 second delay
        timer.scheduleAtFixedRate(saveNow, delay, delay);//wait 10sec, run, repeat
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
        extras.putString("NUMBER_CLICKS", mealLogic.clicksToString());
        extras.putString("NUMBER_MEALS", mealLogic.totalMealsToString());
        statisticsIntent.putExtras(extras);

        MainActivity.this.startActivity(statisticsIntent);
    }

    public static String getDBPathName() {
        return dbName;
    }

    public void upgradeViewOnClick(View v)
    {
        Intent upgradesIntent = new Intent(MainActivity.this, UpgradesActivity.class);

        upgradesIntent.putExtra("MEAL_LOGIC", mealLogic);
        automationFlag = false;

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

    public void saveAllOnClick(View v)
    {
        database.saveAll();
    }

    public static void setDBPathName(final String name)
    {
        try {
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        dbName = name;
    }
}