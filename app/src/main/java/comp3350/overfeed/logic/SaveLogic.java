package comp3350.overfeed.logic;

import comp3350.overfeed.persistence.MealPersistence;
import comp3350.overfeed.persistence.SavePersistence;
import comp3350.overfeed.persistence.TimePersistence;

import java.util.*;

public class SaveLogic {

    private SavePersistence saveFile;
    private MealPersistence meals;
    private TimePersistence time;

    //constructor, starts the autosave function using the Timer and TimerTask Utilities
    public SaveLogic(MealPersistence meals, TimePersistence time) {
        this.meals = meals;
        this.time = time;
        saveFile = new SavePersistence();
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
