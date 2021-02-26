package comp3350.overfeed.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import comp3350.overfeed.R;

public class StatisticsActivity extends AppCompatActivity {

    TextView textTotalClicks;
    TextView textCurrentTime;
    TextView textTotalMeals;
//    TextView textTotalTime;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        Intent mainIntent = getIntent();
        Bundle extras = mainIntent.getExtras();

        String clicks_string = extras.getString("NUMBER_CLICKS");
        String minutes_string = extras.getString("TIME_MINUTES");
        String seconds_string = extras.getString("TIME_SECONDS");

        textTotalClicks = (TextView)findViewById(R.id.textTotalClicks);
        textCurrentTime = (TextView)findViewById(R.id.textCurrentTime);
        textTotalMeals = (TextView)findViewById(R.id.textTotalMeals);
        textTotalClicks.setText(clicks_string);
        textTotalMeals.setText(clicks_string);
        textCurrentTime.setText(minutes_string+":"+seconds_string);
    }

}

