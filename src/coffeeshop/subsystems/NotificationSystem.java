package coffeeshop.subsystems;

public class NotificationSystem {
    public void sendOrderConfirmation(String customerName, String orderDetails) {
        System.out.println("Message sent to " + customerName);
        System.out.println("Order confirmed: " + orderDetails);
    }

    public void notifyBarista(String orderDetails) {
        System.out.println("Barista: New order - " + orderDetails);
    }
}