package comp3350.overfeed.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import comp3350.overfeed.R;

public class AchievementsActivity extends AppCompatActivity {

    // Needs access to DSO Achievement
    int textViewCount = 8;
    private int progress = 0;
    TextView textProgress;

    TextView[] textAchieve = new TextView[textViewCount];
    ProgressBar theProgBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
        theProgBar = (ProgressBar)findViewById(R.id.progressBar);
        theProgBar.setProgress(progress);
        textProgress = (TextView)findViewById(R.id.percentProgress);
        textProgress.setText(progress+"%");

        textAchieve [0] = (TextView)findViewById(R.id.textAchieve1);
        textAchieve[0].setText("");
//        textAchieve [1] = (TextView)findViewById(R.id.textAchieve2);
//        textAchieve[1].setText();
//        textAchieve [2] = (TextView)findViewById(R.id.textAchieve3);
//        textAchieve[2].setText();
//        textAchieve [3] = (TextView)findViewById(R.id.textAchieve4);
//        textAchieve[3].setText();
//        textAchieve [4] = (TextView)findViewById(R.id.textAchieve5);
//        textAchieve[4].setText();
//        textAchieve [5] = (TextView)findViewById(R.id.textAchieve6);
//        textAchieve[5].setText();
//        textAchieve [6] = (TextView)findViewById(R.id.textAchieve7);
//        textAchieve[6].setText();
//        textAchieve [7] = (TextView)findViewById(R.id.textAchieve8);
//        textAchieve[7].setText();

    }

    private void updateProgressBar(){
        // Update this later to reflect achievements in the DSO
        theProgBar.setProgress(progress);
    }
}