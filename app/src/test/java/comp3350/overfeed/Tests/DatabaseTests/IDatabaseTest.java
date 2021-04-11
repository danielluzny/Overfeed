package comp3350.overfeed.Tests.DatabaseTests;

import org.junit.Before;
import org.junit.Test;

public class IDatabaseTest {

    private Database database;

    @Before
    public void setUp()
    {
        String dbPath = "tempDB";
        database = new Database(dbPath);
    }

    @Test
    public void test1()
    {
        System.out.println("Beginning IDatabase test1");



        System.out.println("Finished IDatabase test1");
    }
}
