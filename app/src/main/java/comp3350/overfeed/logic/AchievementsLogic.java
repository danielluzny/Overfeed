package comp3350.overfeed.logic;

import comp3350.overfeed.domainObjects.Achievement;
import comp3350.overfeed.persistence.AchievementsPersistence;

public class AchievementsLogic {
    private AchievementsPersistence achievementsPersistence;

    public AchievementsLogic()
        {
            achievementsPersistence = new AchievementsPersistence();
        }

    public int getNumAchievementsTotal(){ return achievementsPersistence.getNumAchievementsTotal();}

    public int getNumAchievementsDone(){ return achievementsPersistence.getNumAchievementsDone();}

    public void checkPointAchievement(int points){
        // Check if point is reached and
        if (points >= 10 && !achievementsPersistence.getContent(0).getValue()){
            achievementsPersistence.getContent(0).setValue();
        } else if (points >= 25 && !achievementsPersistence.getContent(1).getValue()){
            achievementsPersistence.getContent(1).setValue();
        } else if (points >= 50 && !achievementsPersistence.getContent(2).getValue()){
            achievementsPersistence.getContent(2).setValue();
        } else if (points >= 100 && !achievementsPersistence.getContent(3).getValue()){
            achievementsPersistence.getContent(3).setValue();
        } else if (points >= 200 && !achievementsPersistence.getContent(4).getValue()){
            achievementsPersistence.getContent(4).setValue();
        } else if (points >= 500 && !achievementsPersistence.getContent(5).getValue()){
            achievementsPersistence.getContent(5).setValue();
        } else if (points >= 1000&& !achievementsPersistence.getContent(6).getValue()){
            achievementsPersistence.getContent(6).setValue();
        } else if (points >= 2500 && !achievementsPersistence.getContent(7).getValue()){
            achievementsPersistence.getContent(7).setValue();
        }
    }

    public Achievement getContent(int index){
        return achievementsPersistence.getContent(index);
    }

}
