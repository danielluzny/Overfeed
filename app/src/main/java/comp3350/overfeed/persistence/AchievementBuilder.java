package comp3350.overfeed.persistence;

import java.util.ArrayList;

import comp3350.overfeed.domainObjects.Achievement;

public interface AchievementBuilder {
    void buildList();
    ArrayList<Achievement> getAchievementsList();
}
