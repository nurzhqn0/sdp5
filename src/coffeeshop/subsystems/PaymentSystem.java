package coffeeshop.subsystems;

import coffeeshop.enums.Payment;

public class PaymentSystem {
    private double totalRevenue = 0.0;

    public boolean processPayment(double amount, Payment paymentMethod) {
        if (amount <= 0) {
            return false;
        }

        System.out.println("Processing " + paymentMethod + " payment: $" +
                String.format("%.2f", amount));
        totalRevenue += amount;
        return true;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }
}