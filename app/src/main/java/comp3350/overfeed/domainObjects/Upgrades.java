package comp3350.overfeed.domainObjects;

public class Upgrades
{
    final private String id; // Every upgrade has an identification based on the upgrade name (for example: the Plate upgrade would have id="Plate")
    final private int baseValue; // Every upgrade has a base value associated with it to determine how much one of that upgrade is worth.

    private int upgradeNum; // Every upgrade will have a number associated with it to determine how many of that upgrade you have.
    private int currValue; // currValue is simply upgradeNum*baseValue, which gives us our meals to increment per second.


    public Upgrades(String id, int baseValue)
    {
        this.id = id;
        this.upgradeNum=1;
        this.baseValue=baseValue;
        this.currValue=baseValue;
    }

    public void addUpgrade() // Purchasing an upgrade will call this method
    {
        upgradeNum++;
        updateValue();
    }

    public void updateValue()
    {
        currValue = baseValue*upgradeNum;
    }

    public String getId()
    {
        return this.id;
    }

    public int getCurrValue()
    {
        return this.currValue;
    }
}
