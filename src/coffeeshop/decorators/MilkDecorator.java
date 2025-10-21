package coffeeshop.decorators;

import coffeeshop.decorators.base.BeverageDecorator;
import coffeeshop.models.interfaces.Beverage;

public class MilkDecorator extends BeverageDecorator {
    private final double additionalCost = 0.50;
    private final int additionalCalories = 40;

    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + additionalCost;
    }

    @Override
    public int getCalories() {
        return beverage.getCalories() + additionalCalories;
    }
}
