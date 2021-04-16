package comp3350.overfeed.persistence;

import comp3350.overfeed.domainObjects.*;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveHSQL implements Save
{
    private final String dbPath;

    TimePersistence timePers;
    MealPersistence mealPers;
    AchievementPersistence achievPers;

    public SaveHSQL(String dbPath, MealPersistence m, TimePersistence t, AchievementPersistence a)
    {
        this.dbPath = dbPath;
        timePers = t;
        mealPers = m;
        achievPers = a;
    }

    public void saveAll()
    {
        saveUpgrades();
        saveCurrMeals();
        saveTotalMeals();
        saveNumClicks();
        saveTime();
        saveNumAchiev();
        saveAchievDone();
    }

    public void saveCurrMeals()
    {
        int currMeals = mealPers.getCurrMeals();

        try(final Connection c = connection())
        {
            final PreparedStatement st = c.prepareStatement("UPDATE meals SET currmeals = ?");
            st.setInt(1,currMeals);
            st.executeUpdate();
        }
        catch(SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    public void saveTotalMeals()
    {
        int totalMeals = mealPers.getTotalMeals();

        try(final Connection c = connection())
        {
            final PreparedStatement st = c.prepareStatement("UPDATE meals SET totalmeals = ?");
            st.setInt(1,totalMeals);
            st.executeUpdate();
        }
        catch(SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    public void saveNumClicks()
    {
        int numClicks = mealPers.getClicks();

        try(final Connection c = connection())
        {
            final PreparedStatement st = c.prepareStatement("UPDATE meals SET numclicks = ?");
            st.setInt(1,numClicks);
            st.executeUpdate();
        }
        catch(SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    public void saveUpgrades()
    {
        ArrayList<Upgrade> upgrades = mealPers.getUpgradeList();

        if(upgrades.size()>0)
        {
            try (final Connection c = connection())
            {
                int i = upgrades.size();
                while(i>0)
                {
                    int j = i-1;
                    final PreparedStatement st = c.prepareStatement("UPDATE upgrades SET costmult = ?, baseval = ?, upnum = ?, currval = ?, cost = ? WHERE upgradeid = ?");
                    st.setInt(1, upgrades.get(j).getCostMultiplier());
                    st.setInt(2, upgrades.get(j).getBaseValue());
                    st.setInt(3, upgrades.get(j).getUpgradeNum());
                    st.setInt(4, upgrades.get(j).getCurrValue());
                    st.setInt(5, upgrades.get(j).getCost());
                    st.setString(6, upgrades.get(j).getId());
                    st.executeUpdate();
                    st.close();
                    i--;
                }
            }
            catch (SQLException e)
            {
                throw new PersistenceException(e);
            }
        }
    }

    public void saveTime()
    {
        int time = timePers.getCurrTime();

        try(final Connection c = connection())
        {
            final PreparedStatement st = c.prepareStatement("UPDATE time SET currTime = ?");
            st.setInt(1,time);
            st.executeUpdate();
        }
        catch(SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    public void saveNumAchiev()
    {
        int numAchiev = achievPers.getNumAchievementsTotal();

        try(final Connection c = connection())
        {
            final PreparedStatement st = c.prepareStatement("UPDATE achievementnums SET numachieve = ?");
            st.setInt(1,numAchiev);
            st.executeUpdate();
        }
        catch(SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    public void saveAchievDone()
    {
        int achievDone = achievPers.getNumAchievementsDone();

        try(final Connection c = connection())
        {
            final PreparedStatement st = c.prepareStatement("UPDATE achievementnums SET numdone = ?");
            st.setInt(1,achievDone);
            st.executeUpdate();
        }
        catch(SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }
}
