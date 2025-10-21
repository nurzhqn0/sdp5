package coffeeshop.decorators.base;

import coffeeshop.models.interfaces.Beverage;

public abstract class BeverageDecorator implements Beverage {
    protected Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription();
    }

    @Override
    public double getCost() {
        return beverage.getCost();
    }

    @Override
    public int getCalories() {
        return beverage.getCalories();
    }
}