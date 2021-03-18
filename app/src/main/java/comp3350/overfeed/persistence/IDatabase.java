package comp3350.overfeed.persistence;

public interface IDatabase {

    //Will save all game data and return true if successful, false if not
    public boolean saveAll();

    //Will load all game data and return true if successful, false if not
    public boolean loadAll();

}
