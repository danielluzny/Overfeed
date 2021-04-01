package comp3350.overfeed.application;

public class Main
{
    private static String dbName = "db";

    public static void main(String[] args)
    {
        System.out.println("Program finished");
    }

    public static void setDBPathName(final String name)
    {
        try {
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        dbName = name;
    }

    public static String getDBPathName() { return dbName; }
}
