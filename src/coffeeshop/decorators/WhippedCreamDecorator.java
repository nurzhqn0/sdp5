package coffeeshop.decorators;

import coffeeshop.decorators.base.BeverageDecorator;
import coffeeshop.models.interfaces.Beverage;

public class WhippedCreamDecorator extends BeverageDecorator {
    private final double additionalCost = 0.70;
    private final int additionalCalories = 80;

    public WhippedCreamDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whipped Cream";
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
