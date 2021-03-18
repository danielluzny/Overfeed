package comp3350.overfeed.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import comp3350.overfeed.R;
import comp3350.overfeed.logic.AchievementsLogic;

public class AchievementsActivity extends AppCompatActivity {

    // Needs access to DSO Achievement
    // Temporary Achievement instance for now
//    AchievementsLogic achLogic = new AchievementsLogic();
    AchievementsLogic achLogic;

    int textViewCount = 8;
    private int progress = 0;
    TextView textProgress;

    TextView[] textAchieve = new TextView[textViewCount];
    ProgressBar theProgBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
        achLogic = (AchievementsLogic)getIntent().getSerializableExtra("ACH_LOGIC");
        setTextViews();
    }

    private void setTextViews(){
        progress = achLogic.getNumAchievementsDone()/achLogic.getNumAchievementsTotal();

        theProgBar = (ProgressBar)findViewById(R.id.progressBar);
        theProgBar.setProgress(progress);
        textProgress = (TextView)findViewById(R.id.percentProgress);
        textProgress.setText(progress+"%");

        textAchieve[0] = (TextView)findViewById(R.id.textAchieve1);
        textAchieve[1] = (TextView)findViewById(R.id.textAchieve2);
        textAchieve[2] = (TextView)findViewById(R.id.textAchieve3);
        textAchieve[3] = (TextView)findViewById(R.id.textAchieve4);
        textAchieve[4] = (TextView)findViewById(R.id.textAchieve5);
        textAchieve[5] = (TextView)findViewById(R.id.textAchieve6);
        textAchieve[6] = (TextView)findViewById(R.id.textAchieve7);
        textAchieve[7] = (TextView)findViewById(R.id.textAchieve8);

        if(achLogic.getNumAchievementsDone() == 0){
            textAchieve[0].setText("No achievements yet. Keep on playing! You got this!");
            // Or change this to having the full achievements list with greyed out achievements for those not done yet
        } else{
            for(int i = 0; i < achLogic.getNumAchievementsDone(); i++){
                textAchieve[i].setText(achLogic.getContent(i).getName());
            }
        }
    }


    private void updateProgressBar(){
        // Update this later to reflect achievements in the DSO
        theProgBar.setProgress(progress);
    }
}