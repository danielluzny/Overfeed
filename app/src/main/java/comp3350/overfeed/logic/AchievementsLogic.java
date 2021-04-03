package comp3350.overfeed.logic;

import java.io.Serializable;

import comp3350.overfeed.application.Services;
import comp3350.overfeed.domainObjects.Achievement;
import comp3350.overfeed.persistence.AchievementPersistence;

public class AchievementsLogic implements Serializable {
    public AchievementPersistence achievementPersistence;

    public AchievementsLogic()
        {
            achievementPersistence = Services.getAchievementPersistence();
        }

    public int getNumAchievementsDone(){ return achievementPersistence.getNumAchievementsDone();}

    public boolean checkClickAchievement(int points){
        boolean ShowSnackbar = false;
        // Check if point is reached
        if (points >= 10 && !achievementPersistence.getContent(0).getValue()){
            achievementPersistence.getContent(0).setValue();
            ShowSnackbar = true;
        }
        if (points >= 25 && !achievementPersistence.getContent(1).getValue()){
            achievementPersistence.getContent(1).setValue();
            ShowSnackbar = true;
        }
        if (points >= 50 && !achievementPersistence.getContent(2).getValue()){
            achievementPersistence.getContent(2).setValue();
            ShowSnackbar = true;
        }
        if (points >= 100 && !achievementPersistence.getContent(3).getValue()){
            achievementPersistence.getContent(3).setValue();
            ShowSnackbar = true;
        }
        if (points >= 200 && !achievementPersistence.getContent(4).getValue()){
            achievementPersistence.getContent(4).setValue();
            ShowSnackbar = true;
        }
        if (points >= 500 && !achievementPersistence.getContent(5).getValue()){
            achievementPersistence.getContent(5).setValue();
            ShowSnackbar = true;
        }
        if (points >= 1000&& !achievementPersistence.getContent(6).getValue()){
            achievementPersistence.getContent(6).setValue();
            ShowSnackbar = true;
        }
        if (points >= 2500 && !achievementPersistence.getContent(7).getValue()){
            achievementPersistence.getContent(7).setValue();
            ShowSnackbar = true;
        }
        achievementPersistence.updateSize();
        updateNumDone();
        return ShowSnackbar;
    }

    public Achievement getNewAchievement(){
        // Returns the last achievement from the list which has a value of true
        Achievement thisAch = null;

        if(achievementPersistence.getNumAchievementsDone()>0){
            thisAch = achievementPersistence.getContent(achievementPersistence.getNumAchievementsDone()-1);
        }

        return thisAch;
    }

    public void updateNumDone(){
        int numberDone = 0;
        for(int i = 0; i< achievementPersistence.getNumAchievementsTotal(); i++) {
            if (achievementPersistence.getContent(i).getValue()) {
                numberDone++; // Increment numDone for each that returns a getValue of true
            }
        }
        achievementPersistence.setNumDone(numberDone);
    }

    public int getPercentageDone(){
        int percentageDone = 0;
        if(achievementPersistence.getNumAchievementsDone()>0){
            percentageDone =  (int)(((float) achievementPersistence.getNumAchievementsDone()/(float) achievementPersistence.getNumAchievementsTotal())*100);
        }
        return percentageDone;
    }

    public Achievement getContent(int index){
        return achievementPersistence.getContent(index);
    }

}
