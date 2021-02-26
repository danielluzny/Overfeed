package comp3350.overfeed.persistence;

import comp3350.overfeed.logic.MealLogic;
import comp3350.overfeed.logic.TimeLogic;
import java.io.File;
import java.io.*;

public class SavePersistence {

    private File saveFile;

    //constructor
    public SavePersistence() {
        try {
            saveFile = new File("sessionSaveFile.txt");
            if(!saveFile.createNewFile()) {  //will load the save if it exists, otherwise it creates a new save file
                load();
            }
        } catch (Exception e) {
            System.out.println("Failed to create save file or load save file.");
        }
    }

    //loads user's last save
    public void load() {
        //will need to set the meals and total time in other classes when those methods are made.
    }

    //remove everything from file, add new data to file, send data to database
    public void save(MealLogic meals, TimeLogic time) {
        try {
            Writer myWriter = new FileWriter("sessionSaveFile.txt", false);
            myWriter.write(meals.getMeals() + " " + time.getCurrTime());
        } catch(Exception e) {
            System.out.println("Failed to save the file.");
        }
    }
}
