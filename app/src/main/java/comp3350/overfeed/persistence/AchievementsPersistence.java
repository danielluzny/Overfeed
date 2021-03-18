package comp3350.overfeed.persistence;

import java.util.ArrayList;

import comp3350.overfeed.domainObjects.Achievement;

public class AchievementsPersistence {

    private int numAchievements;
    private ArrayList<Achievement>  achievementsList;

    public AchievementsPersistence()
    {
        this.achievementsList = new ArrayList<Achievement>();
        this.numAchievements = achievementsList.size();
        this.initializeList();
    }

    public int getNumAchievements()
    {
        return this.numAchievements;
    }

    public void initializeList(){
        // Create initial list of achievements

        Achievement noviceAchieve = new Achievement("Novice Cook!", "Make food 10 times.");
        this.achievementsList.add(noviceAchieve);

        Achievement studentAchieve = new Achievement("A+ Cooking Student!", "Make food 25 times.");
        this.achievementsList.add(studentAchieve);

        Achievement whizAchieve = new Achievement("You are a whiz!", "Make food 50 times.");
        this.achievementsList.add(whizAchieve);

        Achievement gordonAchieve = new Achievement("Making Gordon Ramsay proud!", "Make food 100 times.");
        this.achievementsList.add(gordonAchieve);

        Achievement apprAchieve = new Achievement("Apprentice Chef!", "Make food 200 times.");
        this.achievementsList.add(apprAchieve);

        Achievement sousAchieve = new Achievement("Sous Chef!", "Make food 500 times.");
        this.achievementsList.add(sousAchieve);

        Achievement cuisineAchieve = new Achievement("A Chef de cuisine!", "Make food 1000 times.");
        this.achievementsList.add(cuisineAchieve);

        Achievement masterAchieve = new Achievement("A true Master chef!", "Make food 2500 times.");
        this.achievementsList.add(masterAchieve);
    }

    public ArrayList<Achievement> getList() { return this.achievementsList; }

    public Achievement getContent(int n){ return this.achievementsList.get(n);}


}


