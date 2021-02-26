package comp3350.overfeed.logic;

import comp3350.overfeed.persistence.SavePersistence;
import java.util.*;

public class SaveLogic {

    private SavePersistence saveFile;

    //constructor, starts the autosave function using the Timer and TimerTask Utilities
    public SaveLogic() {
        saveFile = new SavePersistence();
        Timer recurring = new Timer();
        recurring.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                saveGame();
            }
        }, 10000, 30000); //divide by 1,000 to get the number in seconds
    }

    public void saveGame() {saveFile.save();}

}
