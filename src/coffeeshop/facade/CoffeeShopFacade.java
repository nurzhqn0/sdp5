package coffeeshop.facade;

import coffeeshop.enums.Payment;
import coffeeshop.models.interfaces.Beverage;
import coffeeshop.subsystems.*;

public class CoffeeShopFacade {
    private final PaymentSystem payment;
    private final NotificationSystem notification;
    private final OrderQueue orderQueue;

    public CoffeeShopFacade() {
        this.payment = new PaymentSystem();
        this.notification = new NotificationSystem();
        this.orderQueue = new OrderQueue();
    }

    public void placeOrder(String customerName, Beverage beverage,
                           Payment paymentMethod) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Processing order for: " + customerName);
        System.out.println("=".repeat(50));


        double cost = beverage.getCost();
        if (!payment.processPayment(cost, paymentMethod)) {
            System.out.println("Order failed: Payment declined");
            return;
        }

        int orderNum = orderQueue.generateOrderNumber();


        orderQueue.addToQueue(orderNum, beverage.getDescription());

        notification.notifyBarista(beverage.getDescription());
        notification.sendOrderConfirmation(customerName,
                String.format("Order #%d - %s - $%.2f",
                        orderNum, beverage.getDescription(), cost));

        printReceipt(orderNum, customerName, beverage);

        System.out.println("Order completed successfully!\n");
    }


    private void printReceipt(int orderNum, String customer, Beverage beverage) {
        System.out.println("\n" + "-".repeat(40));
        System.out.println("            COFFEE SHOP RECEIPT");
        System.out.println("-".repeat(40));
        System.out.println("Order #: " + orderNum);
        System.out.println("Customer: " + customer);
        System.out.println("Item: " + beverage.getDescription());
        System.out.println("Cost: KZT" + String.format("%.2f", beverage.getCost()));
        System.out.println("Calories: " + beverage.getCalories() + " kcal");
        System.out.println("-".repeat(40) + "\n");
    }

    public void displayDailySummary() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("              DAILY SUMMARY");
        System.out.println("=".repeat(50));
        System.out.println("Total Revenue: $" +
                String.format("%.2f", payment.getTotalRevenue())
        );
        System.out.println("=".repeat(50) + "\n");
    }
}
