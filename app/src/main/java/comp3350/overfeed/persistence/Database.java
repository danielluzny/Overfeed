package comp3350.overfeed.persistence;

public class Database implements IDatabase {

    public Database() {

    }

    @Override
    public boolean saveAll() {
        boolean result = false;
        try {

            result = true;
        }
        catch (Exception e){
            System.out.println("Save failed");
        }
        return result;
    }

    @Override
    public boolean loadAll() {
        boolean result = false;
        try {

            result = true;
        }
        catch (Exception e){
            System.out.println("Load failed");
        }
        return result;
    }
}
