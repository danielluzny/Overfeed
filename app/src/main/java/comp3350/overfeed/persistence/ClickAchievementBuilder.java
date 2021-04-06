package comp3350.overfeed.persistence;

import java.util.ArrayList;

import comp3350.overfeed.domainObjects.Achievement;

public class ClickAchievementBuilder implements AchievementBuilder {

    private ArrayList<Achievement> achievementsList;

    public ClickAchievementBuilder(){
        this.achievementsList = new ArrayList<Achievement>();
    }

    @Override
    public void buildList() {
        // Create initial list of achievements related to the number of clicks
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

//            this.updateSize();
//            this.setNumDone(0);

    }

    @Override
    public ArrayList<Achievement> getAchievementsList() {
        return this.achievementsList;
    }
}
