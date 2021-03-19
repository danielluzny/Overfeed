package comp3350.overfeed.persistence;

public interface IDatabase {

    public void saveAll();

    //Will load all game data and return true if successful, false if not
    public void loadAll();

}
