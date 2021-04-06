package comp3350.overfeed.persistence;

import comp3350.overfeed.domainObjects.*;

import java.sql.ResultSet;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoadHSQL implements Load
{
    private final String dbPath;

    TimePersistence timePers;
    MealPersistence mealPers;
    AchievementPersistence achievPers;

    public LoadHSQL(String dbPath, MealPersistence m, TimePersistence t, AchievementPersistence a)
    {
        this.dbPath = dbPath;
        timePers = t;
        mealPers = m;
        achievPers = a;
    }

    public void loadAll()
    {
       loadCurrMeals();
       loadTotalMeals();
       loadNumClicks();
       loadUpgrades();
       loadTime();
       loadNumAchiev();
       loadAchievDone();

     //  loadAchiev();
    }

   public void loadCurrMeals()
   {
       int currMeals;

       try(final Connection c = connection())
       {
           final PreparedStatement st = c.prepareStatement("SELECT currmeals FROM meals");
           final ResultSet rs = st.executeQuery();
           rs.next();
           currMeals = rs.getInt(1);
           mealPers.setCurrMeals(currMeals);
       }
       catch(SQLException e)
       {
           throw new PersistenceException(e);
       }
   }

    public void loadTotalMeals()
    {
        int totalMeals;

        try(final Connection c = connection())
        {
            final PreparedStatement st = c.prepareStatement("SELECT totalmeals FROM meals");
            final ResultSet rs = st.executeQuery();
            rs.next();
            totalMeals = rs.getInt(1);
            mealPers.setTotalMeals(totalMeals);
        }
        catch(SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    public void loadNumClicks()
    {
        int numClicks;

        try(final Connection c = connection())
        {
            final PreparedStatement st = c.prepareStatement("SELECT numclicks FROM meals");
            final ResultSet rs = st.executeQuery();
            rs.next();
            numClicks = rs.getInt(1);
            mealPers.setNumClicks(numClicks);
        }
        catch(SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    public void loadUpgrades()
    {
        ArrayList<Upgrade> upgrades = mealPers.getUpgradeList();
        Upgrade up;

        try (final Connection c = connection())
        {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM upgrades");
            final ResultSet rs = st.executeQuery();

            while(rs.next())
            {
                int upgradeNum = rs.getInt(4);
                if((upgradeNum)>0)
                {
                    up = new Upgrade(rs.getString(1));
                    up.setCostMultiplier(rs.getInt(2));
                    up.setBaseValue(rs.getInt(3));
                    up.setUpgradeNum(rs.getInt(4));
                    up.setCurrValue(rs.getInt(5));
                    up.setCost(rs.getInt(6));

                    upgrades.add(up);
                }
            }
        }
        catch(SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    public void loadTime()
    {
        int currTime;

        try(final Connection c = connection())
        {
            final PreparedStatement st = c.prepareStatement("SELECT currtime FROM time");
            final ResultSet rs = st.executeQuery();
            rs.next();
            currTime = rs.getInt(1);
            timePers.setCurrTime(currTime);
        }
        catch(SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    public void loadNumAchiev()
    {
        int numAchiev;

        try(final Connection c = connection())
        {
            final PreparedStatement st = c.prepareStatement("SELECT numachieve FROM achievementnums");
            final ResultSet rs = st.executeQuery();
            rs.next();
            numAchiev = rs.getInt(1);
            achievPers.setNumAchiev(numAchiev);
        }
        catch(SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    public void loadAchievDone()
    {
        int numDone;

        try(final Connection c = connection())
        {
            final PreparedStatement st = c.prepareStatement("SELECT numdone FROM achievementnums");
            final ResultSet rs = st.executeQuery();
            rs.next();
            numDone = rs.getInt(1);
            achievPers.setNumDone(numDone);
        }
        catch(SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    public void loadAchiev()
    {

    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }
}
