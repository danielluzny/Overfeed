package comp3350.overfeed.persistence;

import comp3350.overfeed.logic.MealLogic;
import comp3350.overfeed.logic.SaveLogic;
import comp3350.overfeed.logic.TimeLogic;
import java.io.*;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class SavePersistence {

    private File saveFile;
    private SaveLogic saveLogic;

    //constructor
    public SavePersistence(SaveLogic saveLogic) {
        this.saveLogic = saveLogic;
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
        try {
            Scanner scanner = new Scanner(saveFile);
            saveLogic.setGame(scanner.nextInt());
            scanner.close();
        } catch(Exception e) {
            System.out.println("Could not read file.");
        }
    }

    //remove everything from file, add new data to file, send data to database
    public void save(MealLogic meals) {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(saveFile));
            dos.write(meals.getMeals());
            dos.close();
        } catch(Exception e) {
            System.out.println("Failed to save the file.");
        }
    }
}
