package comp3350.overfeed.Tests.DatabaseTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import comp3350.overfeed.persistence.Database;
import comp3350.overfeed.persistence.IDatabase;

public class IDatabaseTest {

    private Database database;

    @Before
    public void setUp() { database = new Database(); }

    @Test
    public void test1() {
        System.out.println("Beginning IDatabase test1");

        assertEquals("Saving should return true",
                database.saveAll(), true);

        assertEquals("Loading should return true",
                database.loadAll(), true);

        System.out.println("Finished IDatabase test1");
    }
}
