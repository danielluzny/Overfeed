package comp3350.overfeed.persistence;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import comp3350.overfeed.domainObjects.Upgrade;

public class MealPersistenceHSQL implements MealPersistence, Serializable
{
    private final String dbPath;
    private final int dbId = 1; // There will only be one entry into the MEALS table (which contains id, currMeals, totalMeals, numClicks). This id is the one and only primary key for that entry and table.

    private ArrayList<Upgrade> upgradeList;

    public MealPersistenceHSQL(final String dbPath)
    {
        this.dbPath = dbPath;

        upgradeList = new ArrayList<>();
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    public void addCurrMeals(int numMeals)
    {
        try(final Connection c = connection())
        {
            int result;
            final PreparedStatement st = c.prepareStatement("SELECT currmeals FROM meals WHERE mealid = ?");
            st.setInt(1,dbId);
            final ResultSet rs = st.executeQuery();

            rs.next();
            result = rs.getInt("currMeals");
            result+=numMeals;

            final PreparedStatement st2 = c.prepareStatement("UPDATE meals SET currmeals = ? WHERE mealid = ?");
            st2.setInt(1,result);
            st2.setInt(2, dbId);

            st2.executeUpdate();
        }
        catch(SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    public void decreaseCurrMeals(int numMeals)
    {
        try(final Connection c = connection())
        {
            int result;
            final PreparedStatement st = c.prepareStatement("SELECT currmeals FROM meals WHERE mealid = ?");
            st.setInt(1,dbId);
            final ResultSet rs = st.executeQuery();

            rs.next();
            result = rs.getInt("currMeals");
            result-=numMeals;

            final PreparedStatement st2 = c.prepareStatement("UPDATE meals SET currmeals = ? WHERE mealid = ?");
            st2.setInt(1,result);
            st2.setInt(2, dbId);

            st2.executeUpdate();
        }
        catch(SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    public void addTotalMeals(int numMeals)
    {
        try(final Connection c = connection())
        {
            int result;
            final PreparedStatement st = c.prepareStatement("SELECT totalmeals FROM meals WHERE mealid = ?");
            st.setInt(1,dbId);
            final ResultSet rs = st.executeQuery();

            rs.next();
            result = rs.getInt("totalmeals");
            result+=numMeals;

            final PreparedStatement st2 = c.prepareStatement("UPDATE meals SET totalmeals = ? WHERE mealid = ?");
            st2.setInt(1,result);
            st2.setInt(2, dbId);

            st2.executeUpdate();
        }
        catch(SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    public void incrementClicks()
    {
        try(final Connection c = connection())
        {
            int result;
            final PreparedStatement st = c.prepareStatement("SELECT numclicks FROM meals WHERE mealid = ?");
            st.setInt(1,dbId);
            final ResultSet rs = st.executeQuery();

            rs.next();
            result = rs.getInt("numclicks");
            result++;

            final PreparedStatement st2 = c.prepareStatement("UPDATE meals SET numclicks = ? WHERE mealid = ?");
            st2.setInt(1,result);
            st2.setInt(2, dbId);

            st2.executeUpdate();
        }
        catch(SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    public void addUpgrade(Upgrade up)
    {
        upgradeList.add(up);
    }

    public int getCurrMeals()
    {
        int result;

        try(final Connection c = connection())
        {
            final PreparedStatement st = c.prepareStatement("SELECT currmeals FROM meals WHERE mealid = ?");
            st.setInt(1,dbId);
            final ResultSet rs = st.executeQuery();

            rs.next();
            result = rs.getInt("currMeals");

            return result;
        }
        catch(SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    public int getTotalMeals()
    {
        int result;

        try(final Connection c = connection())
        {
            final PreparedStatement st = c.prepareStatement("SELECT totalmeals FROM meals WHERE mealid = ?");
            st.setInt(1,dbId);
            final ResultSet rs = st.executeQuery();

            rs.next();
            result = rs.getInt("totalmeals");

            return result;
        }
        catch(SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    public int getClicks()
    {
        int result;

        try(final Connection c = connection())
        {
            final PreparedStatement st = c.prepareStatement("SELECT numclicks FROM meals WHERE mealid = ?");
            st.setInt(1,dbId);
            final ResultSet rs = st.executeQuery();

            rs.next();
            result = rs.getInt("numclicks");

            return result;
        }
        catch(SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    public ArrayList<Upgrade> getUpgradeList()
    {
        return this.upgradeList;
    }
}
