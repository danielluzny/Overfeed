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

    // Meal logic set up
    MealLogic mealLogic = new MealLogic();
    TextView counterTextView;
    private static String dbName="SF";

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
    }

    //     OnClick methods for Tab Items
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

    public static void setDBPathName(final String name) {
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

    public static String getDBPathName() {
        return dbName;
    }
}