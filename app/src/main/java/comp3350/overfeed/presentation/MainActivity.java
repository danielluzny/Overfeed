package comp3350.overfeed.presentation;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import comp3350.overfeed.R;
import comp3350.overfeed.logic.TimeCalculation;

public class MainActivity extends AppCompatActivity {

    // Timer set up
    TimeCalculation tc = new TimeCalculation();
    TextView timerTextView;
    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable()
    {
        @Override
        public void run()
        {
            int[] time = tc.getTime();
            timerTextView.setText(String.format("%d:%02d", time[1], time[0]));
            timerHandler.post(this);
        }
    };
    // End timer set up

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Start the timer on app start up
        timerTextView = (TextView)findViewById(R.id.timerTextView);
        timerHandler.post(timerRunnable);

    }
}