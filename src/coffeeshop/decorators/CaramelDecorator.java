package coffeeshop.decorators;

import coffeeshop.decorators.base.BeverageDecorator;
import coffeeshop.models.interfaces.Beverage;

public class CaramelDecorator extends BeverageDecorator {
    private final double additionalCost = 0.60;
    private final int additionalCalories = 50;

    public CaramelDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Caramel";
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