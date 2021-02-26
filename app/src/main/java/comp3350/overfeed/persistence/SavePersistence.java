package comp3350.overfeed.persistence;

import comp3350.overfeed.persistence.MealPersistence;
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
    public void save() {
        try {
            Writer myWriter = new FileWriter("sessionSaveFile.txt", false);
            myWriter.write(MealPersistence.getMeals());
        } catch(Exception e) {
            System.out.println("Failed to save the file.");
        }
    }
}
