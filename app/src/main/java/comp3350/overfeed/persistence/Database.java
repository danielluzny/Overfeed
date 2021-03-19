package comp3350.overfeed.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

public class Database implements IDatabase {

    private final String dbPath;
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
        final HashMap<String, Long> saveFile = new HashMap<String, Long>();
        try (final Connection c = connection()){
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM savefile");
            while (rs.next()) {
                savedData.put(rs.getString("componentID"), rs.getLong("componentValue"));
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
