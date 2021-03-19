package comp3350.overfeed.logic;

import java.io.Serializable;

import comp3350.overfeed.domainObjects.Achievement;
import comp3350.overfeed.persistence.AchievementsPersistence;

public class AchievementsLogic implements Serializable {
    private AchievementsPersistence achievementsPersistence;

    public AchievementsLogic()
        {
            achievementsPersistence = new AchievementsPersistence();
        }

    public int getNumAchievementsDone(){ return achievementsPersistence.getNumAchievementsDone();}

    public boolean checkClickAchievement(int points){
        boolean ShowSnackbar = false;
        // Check if point is reached
        if (points >= 10 && !achievementsPersistence.getContent(0).getValue()){
            achievementsPersistence.getContent(0).setValue();
            ShowSnackbar = true;
        }
        if (points >= 25 && !achievementsPersistence.getContent(1).getValue()){
            achievementsPersistence.getContent(1).setValue();
            ShowSnackbar = true;
        }
        if (points >= 50 && !achievementsPersistence.getContent(2).getValue()){
            achievementsPersistence.getContent(2).setValue();
            ShowSnackbar = true;
        }
        if (points >= 100 && !achievementsPersistence.getContent(3).getValue()){
            achievementsPersistence.getContent(3).setValue();
            ShowSnackbar = true;
        }
        if (points >= 200 && !achievementsPersistence.getContent(4).getValue()){
            achievementsPersistence.getContent(4).setValue();
            ShowSnackbar = true;
        }
        if (points >= 500 && !achievementsPersistence.getContent(5).getValue()){
            achievementsPersistence.getContent(5).setValue();
            ShowSnackbar = true;
        }
        if (points >= 1000&& !achievementsPersistence.getContent(6).getValue()){
            achievementsPersistence.getContent(6).setValue();
            ShowSnackbar = true;
        }
        if (points >= 2500 && !achievementsPersistence.getContent(7).getValue()){
            achievementsPersistence.getContent(7).setValue();
            ShowSnackbar = true;
        }
        achievementsPersistence.updateSize();
        return ShowSnackbar;
    }

    public Achievement getNewAchievement(){
        // Returns the last achievement from the list which has a value of true
        Achievement thisAch = null;

        if(achievementsPersistence.getNumAchievementsDone()>0){
            thisAch = achievementsPersistence.getContent(achievementsPersistence.getNumAchievementsDone()-1);
        }

        return thisAch;
    }

    public int getPercentageDone(){
        int percentageDone = 0;
        if(achievementsPersistence.getNumAchievementsDone()>0){
            percentageDone =  (int)(((float)achievementsPersistence.getNumAchievementsDone()/(float)achievementsPersistence.getNumAchievementsTotal())*100);
        }
        return percentageDone;
    }

    public Achievement getContent(int index){
        return achievementsPersistence.getContent(index);
    }

}
