package coffeeshop.decorators;

import coffeeshop.decorators.base.BeverageDecorator;
import coffeeshop.models.interfaces.Beverage;

public class SugarDecorator extends BeverageDecorator {
    private final double additionalCost = 0.20;
    private final int additionalCalories = 16;

    public SugarDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Sugar";
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