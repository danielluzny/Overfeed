package comp3350.overfeed.presentation;

import androidx.appcompat.app.AppCompatActivity;

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
}