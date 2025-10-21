package coffeeshop.subsystems;

public class OrderQueue {
    private int orderNumber = 1000;

    public int generateOrderNumber() {
        return orderNumber++;
    }

    public void addToQueue(int orderNum, String details) {
        System.out.println("Order #" + orderNum + " added to queue");
    }
}
