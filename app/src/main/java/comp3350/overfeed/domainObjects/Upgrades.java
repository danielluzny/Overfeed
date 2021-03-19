package comp3350.overfeed.domainObjects;

import java.io.Serializable;

public class Upgrades implements Serializable
{
    final private int COST_MULTIPLIER = 3; // Determines the cost of the next upgrade purchase

    final private String id; // Every upgrade has an identification based on the upgrade name (for example: the Plate upgrade would have id="Plate")
    final private int baseValue; // Every upgrade has a base value associated with it to determine how much one of that upgrade is worth.

    private int upgradeNum; // Every upgrade will have a number associated with it to determine how many of that upgrade you have.
    private int currValue; // currValue is simply upgradeNum*baseValue, which gives us our meals to increment per second.
    private int cost; // cost to purchase the next upgrade

    public Upgrades(String id, int baseValue, int cost)
    {
        this.id = id;
        this.upgradeNum=1;
        this.baseValue=baseValue;
        this.currValue=baseValue;
        this.cost=cost;
    }

    public void addUpgrade() // Purchasing an upgrade will call this method
    {
        upgradeNum++;
        updateValue();
        updateCost();
    }

    public void updateValue()
    {
        this.currValue = baseValue*upgradeNum;
    }

    public void updateCost()
    {
        this.cost = this.cost*COST_MULTIPLIER;
    }

    public String getId()
    {
        return this.id;
    }

    public int getUpgradeNum() { return this.upgradeNum; }

    public int getCurrValue()
    {
        return this.currValue;
    }

    public int getCost() { return this.cost; }
}
