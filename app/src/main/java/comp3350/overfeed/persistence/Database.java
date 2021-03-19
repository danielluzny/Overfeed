package comp3350.overfeed.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import static comp3350.srsys.application.Services.getIDatabase;
import static comp3350.srsys.application.Services.getMealPersistence;
import static comp3350.srsys.application.Services.getTimePersistence;

public class Database implements IDatabase {

    private final String dbPath;
    private static int NUMSTATEVAR = 3;
    private HashMap<String, Long> savedData;

    public Database(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    @Override
    public boolean saveAll() {
        boolean result = false;
        try (final Connection c = connection()){
            //save(c, persistence, value);
            //repeat save calls

            result = true;
        }
        catch (final SQLException e){
            System.out.println("Save failed");
        }
        return result;
    }

    private void save(Connection con, String tag, Long value) throws SQLException {
        final PreparedStatement st = con.prepareStatement("INSERT INTO savefile VALUES(?, ?)");
        st.setString(1, tag);
        st.setLong(2, value);
        st.executeUpdate();
    }

    @Override
    public boolean loadAll() {
        boolean result = false;
        final HashMap<String, Long> saveFile = new HashMap<String, Long>();
        try (final Connection c = connection()){
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM savefile");
            while (rs.next()) {
                savedData.put(rs.getString("componentID"), rs.getLong("componentValue"));
            }
            if(savedData.isEmpty()) {
                getMealPersistence();
                getTimePersistence();
                getIDatabase();
            } else {
                //call each setter method for state variables, passing arguments from savedData.
            }
            rs.close();
            st.close();

            result = true;
        }
        catch (final SQLException e){
            System.out.println("Load failed");
        }
        return result;
    }
}
