package comp3350.overfeed.domainObjects;

import java.io.Serializable;

public class Upgrade implements Serializable
{
    private int costMultiplier; // Determines the cost of the next upgrade purchase
    private int baseValue; // Every upgrade has a base value associated with it to determine how much one of that upgrade is worth.

    final private String id; // Every upgrade has an identification based on the upgrade name (for example: the Plate upgrade would have id="Plate")

    private int upgradeNum; // Every upgrade will have a number associated with it to determine how many of that upgrade you have.
    private int currValue; // currValue is simply upgradeNum*baseValue, which gives us our meals to increment per second.
    private int cost; // cost to purchase the next upgrade

    public Upgrade(String id, int baseValue, int cost, int costMultiplier)
    {
        this.id = id;
        this.upgradeNum=1;
        this.baseValue=baseValue;
        this.currValue=baseValue;
        this.cost=cost;
        this.costMultiplier=costMultiplier;
    }

    public Upgrade(String id) {this.id = id; }

    public void addUpgrade() // Purchasing an upgrade will call this method
    {
        upgradeNum++;
        updateValue();
        updateCost();
    }

    public void updateValue()
    {
        currValue = baseValue*upgradeNum;
    }

    public void updateCost()
    {
        cost = cost*costMultiplier;
    }


    public String getId()
    {
        return id;
    }

    public int getUpgradeNum() { return upgradeNum; }

    public int getCurrValue()
    {
        return currValue;
    }

    public int getCost() { return cost; }

    public int getCostMultiplier() { return costMultiplier; }

    public int getBaseValue() { return baseValue; }


    public void setUpgradeNum(int upgradeNum) { this.upgradeNum = upgradeNum; }

    public void setCurrValue(int currValue) { this.currValue = currValue; }

    public void setCost(int cost) { this.cost = cost; }

    public void setCostMultiplier(int costMultiplier) { this.costMultiplier = costMultiplier; }

    public void setBaseValue(int baseValue) { this.baseValue = baseValue; }
}
