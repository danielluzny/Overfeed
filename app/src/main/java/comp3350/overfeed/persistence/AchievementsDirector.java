package comp3350.overfeed.persistence;

import java.util.ArrayList;

import comp3350.overfeed.domainObjects.Achievement;

public class AchievementsDirector {
    // A class that controls what is needed for the final Achievements List output
    private AchievementBuilder achBuilder;
    public AchievementsDirector(AchievementBuilder achBuilder)
    {
        this.achBuilder = achBuilder;
    }

    public ArrayList<Achievement> getAchievementsList()
    {
        return this.achBuilder.getAchievementsList();
    }
    public void constructAchievementsList()
    {
        this.achBuilder.buildList();
    }
}
