package comp3350.overfeed.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import comp3350.overfeed.R;
import comp3350.overfeed.logic.AchievementsLogic;
import comp3350.overfeed.logic.MealLogic;

public class AchievementsActivity extends AppCompatActivity {

    AchievementsLogic achLogic;
    int currentClicks;

    int textViewCount = 8;
    private int progress = 0;
    TextView textProgress;

    // TextViews for the Achievement names
    TextView[] textAchieve = new TextView[textViewCount];
    // TextViews for Achievement descriptions
    TextView[] descAchieve = new TextView[textViewCount];

    ProgressBar theProgBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
        achLogic = (AchievementsLogic)getIntent().getSerializableExtra("ACH_LOGIC");
        Bundle extra = getIntent().getExtras();

        currentClicks = (int) extra.getInt("NUM_CLICKS");

        achLogic.checkClickAchievement(currentClicks);
        progress = achLogic.getPercentageDone();
        // Set the text needed for the TextViews in this page
        setTextViews();
    }

    private void setTextViews(){
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

        descAchieve[0] = (TextView)findViewById(R.id.textAchDesc1);
        descAchieve[1] = (TextView)findViewById(R.id.textAchDesc2);
        descAchieve[2] = (TextView)findViewById(R.id.textAchDesc3);
        descAchieve[3] = (TextView)findViewById(R.id.textAchDesc4);
        descAchieve[4] = (TextView)findViewById(R.id.textAchDesc5);
        descAchieve[5] = (TextView)findViewById(R.id.textAchDesc6);
        descAchieve[6] = (TextView)findViewById(R.id.textAchDesc7);
        descAchieve[7] = (TextView)findViewById(R.id.textAchDesc8);

        if(achLogic.getNumAchievementsDone() == 0){
            textAchieve[0].setText("No achievements yet");
            descAchieve[0].setText(" Keep on playing! You got this!");
            // Or change this to having the full achievements list with greyed out achievements for those not done yet
        } else{
            for(int i = 0; i < achLogic.getNumAchievementsDone(); i++){
                textAchieve[i].setText(i+1+". "+achLogic.getContent(i).getName());
                descAchieve[i].setText(achLogic.getContent(i).getDesc());
            }
        }
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent();
        intent.putExtra("ACH_LOGIC", achLogic);
        setResult(RESULT_OK,intent);
        finish();
    }

}