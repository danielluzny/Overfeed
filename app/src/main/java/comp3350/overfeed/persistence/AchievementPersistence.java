package comp3350.overfeed.persistence;

import java.util.ArrayList;

import comp3350.overfeed.domainObjects.Achievement;

public interface AchievementPersistence
{
     int getNumAchievementsTotal();

     int getNumAchievementsDone();

     ArrayList<Achievement> getList();

     void updateSize();

     void setNumDone(int numDone);

     void setNumAchiev(int numAchiev);

     Achievement getContent(int n);
}
