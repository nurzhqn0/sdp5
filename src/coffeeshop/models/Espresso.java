package coffeeshop.models;

import coffeeshop.enums.Size;
import coffeeshop.models.interfaces.Beverage;

public class Espresso implements Beverage {
    private final Size size;
    private final double baseCost;
    private final int baseCalories;

    public Espresso(Size size) {
        this.size = size;
        this.baseCost = 2.50;
        this.baseCalories = 5;
    }

    @Override
    public String getDescription() {
        return size + " Espresso";
    }

    @Override
    public double getCost() {
        return baseCost * getSizeMultiplier();
    }

    @Override
    public int getCalories() {
        return (int)(baseCalories * getSizeMultiplier());
    }

    private double getSizeMultiplier() {
        switch(size) {
            case SMALL: return 0.8;
            case LARGE: return 1.2;
            case MEDIUM: return 1.0;
            default: throw new IllegalArgumentException("Invalid size");
        }
    }
}