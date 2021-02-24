package comp3350.overfeed.presentation;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import comp3350.overfeed.R;

public class MainActivity extends AppCompatActivity {

    // Timer set up
    TextView timerTextView;
    long startTime = System.currentTimeMillis();

    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable()
    {
        @Override
        public void run()
        {
            int seconds = (int)((System.currentTimeMillis() - startTime)/1000); // divide by 1000 here because 1000ms == 1s
            int minutes = seconds / 60;

            timerTextView.setText(String.format("%d:%02d", minutes, seconds));

            timerHandler.post(this);
        }
    }; // End timer set up

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerTextView = (TextView)findViewById(R.id.timerTextView);
        timerHandler.postDelayed(timerRunnable, 0);

    }
}