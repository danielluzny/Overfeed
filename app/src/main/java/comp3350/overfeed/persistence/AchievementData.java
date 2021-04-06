package comp3350.overfeed.persistence;

import java.io.Serializable;
import java.util.ArrayList;

import comp3350.overfeed.domainObjects.Achievement;

public class AchievementData implements AchievementPersistence, Serializable
{
    private int numAchievements;
    private ArrayList<Achievement>  achievementsList;
    private int numDone;
    AchievementBuilder clickAchBuilder;
    AchievementsDirector director;

    public AchievementData()
    {
        clickAchBuilder = new ClickAchievementBuilder();
        director = new AchievementsDirector(clickAchBuilder);
        director.constructAchievementsList();
        this.achievementsList = director.getAchievementsList();
        this.numAchievements = achievementsList.size();
        this.numDone = 0;
    }

    public int getNumAchievementsTotal()
    {
        return this.numAchievements;
    }

    public int getNumAchievementsDone()
    {
        return this.numDone;
    }

    public ArrayList<Achievement> getList() { return this.achievementsList; }

    public void updateSize(){
        this.numAchievements = this.achievementsList.size();
    }

    public void setNumDone(int numDone) {
        this.numDone = numDone;
    }

    public void setNumAchiev(int numAchiev) { this.numAchievements = numAchiev; }

    public Achievement getContent(int n){ return this.achievementsList.get(n);}
}

