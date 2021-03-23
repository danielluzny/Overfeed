package comp3350.overfeed.logic;

import java.io.Serializable;

import comp3350.overfeed.domainObjects.Achievement;
import comp3350.overfeed.persistence.AchievementPersistenceFake;

public class AchievementsLogic implements Serializable {
    private AchievementPersistenceFake achievementPersistenceFake;

    public AchievementsLogic()
        {
            achievementPersistenceFake = new AchievementPersistenceFake();
        }

    public int getNumAchievementsDone(){ return achievementPersistenceFake.getNumAchievementsDone();}

    public boolean checkClickAchievement(int points){
        boolean ShowSnackbar = false;
        // Check if point is reached
        if (points >= 10 && !achievementPersistenceFake.getContent(0).getValue()){
            achievementPersistenceFake.getContent(0).setValue();
            ShowSnackbar = true;
        }
        if (points >= 25 && !achievementPersistenceFake.getContent(1).getValue()){
            achievementPersistenceFake.getContent(1).setValue();
            ShowSnackbar = true;
        }
        if (points >= 50 && !achievementPersistenceFake.getContent(2).getValue()){
            achievementPersistenceFake.getContent(2).setValue();
            ShowSnackbar = true;
        }
        if (points >= 100 && !achievementPersistenceFake.getContent(3).getValue()){
            achievementPersistenceFake.getContent(3).setValue();
            ShowSnackbar = true;
        }
        if (points >= 200 && !achievementPersistenceFake.getContent(4).getValue()){
            achievementPersistenceFake.getContent(4).setValue();
            ShowSnackbar = true;
        }
        if (points >= 500 && !achievementPersistenceFake.getContent(5).getValue()){
            achievementPersistenceFake.getContent(5).setValue();
            ShowSnackbar = true;
        }
        if (points >= 1000&& !achievementPersistenceFake.getContent(6).getValue()){
            achievementPersistenceFake.getContent(6).setValue();
            ShowSnackbar = true;
        }
        if (points >= 2500 && !achievementPersistenceFake.getContent(7).getValue()){
            achievementPersistenceFake.getContent(7).setValue();
            ShowSnackbar = true;
        }
        achievementPersistenceFake.updateSize();
        updateNumDone();
        return ShowSnackbar;
    }

    public Achievement getNewAchievement(){
        // Returns the last achievement from the list which has a value of true
        Achievement thisAch = null;

        if(achievementPersistenceFake.getNumAchievementsDone()>0){
            thisAch = achievementPersistenceFake.getContent(achievementPersistenceFake.getNumAchievementsDone()-1);
        }

        return thisAch;
    }

    public void updateNumDone(){
        int numberDone = 0;
        for(int i = 0; i< achievementPersistenceFake.getNumAchievementsTotal(); i++) {
            if (achievementPersistenceFake.getContent(i).getValue()) {
                numberDone++; // Increment numDone for each that returns a getValue of true
            }
        }
        achievementPersistenceFake.setNumDone(numberDone);
    }

    public int getPercentageDone(){
        int percentageDone = 0;
        if(achievementPersistenceFake.getNumAchievementsDone()>0){
            percentageDone =  (int)(((float) achievementPersistenceFake.getNumAchievementsDone()/(float) achievementPersistenceFake.getNumAchievementsTotal())*100);
        }
        return percentageDone;
    }

    public Achievement getContent(int index){
        return achievementPersistenceFake.getContent(index);
    }

}
