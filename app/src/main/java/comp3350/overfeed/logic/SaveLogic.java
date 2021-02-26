package comp3350.overfeed.logic;

import comp3350.overfeed.persistence.SavePersistence;
import comp3350.overfeed.logic.MealLogic;
import comp3350.overfeed.logic.TimeLogic;

import java.util.*;

public class SaveLogic {

    private SavePersistence saveFile;
    private MealLogic meals;
    private TimeLogic time;

    //constructor, starts the autosave function using the Timer and TimerTask Utilities
    public SaveLogic(MealLogic meals, TimeLogic time) {
        this.meals = meals;
        this.time = time;
        saveFile = new SavePersistence(); //will load the last save if there is one
        Timer recurring = new Timer();
        recurring.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                saveGame();
            }
        }, 10000, 30000); //divide by 1,000 to get the number in seconds
    }

    public void saveGame() {saveFile.save(meals, time);}

}
