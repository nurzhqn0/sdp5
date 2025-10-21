import coffeeshop.decorators.*;
import coffeeshop.enums.Payment;
import coffeeshop.facade.*;
import coffeeshop.models.*;
import coffeeshop.enums.Size;
import coffeeshop.models.interfaces.Beverage;

public class Main {
    public static void main(String[] args) {
        CoffeeShopFacade coffeeShop = new CoffeeShopFacade();

        System.out.println("COFFEE SHOP ORDER SYSTEM");

        // espresso
        Beverage order1 = new Espresso(Size.MEDIUM);
        coffeeShop.placeOrder("Alice Johnson", order1, Payment.APPLE_PAY);

        // latte with milk and sugar
        Beverage order2 = new Latte(Size.LARGE);
        order2 = new MilkDecorator(order2);
        order2 = new SugarDecorator(order2);
        coffeeShop.placeOrder("Bob Smith", order2, Payment.KASPI_QR);

        // cappuccino with servings
        Beverage order3 = new Cappuccino(Size.MEDIUM);
        order3 = new WhippedCreamDecorator(order3);
        order3 = new CaramelDecorator(order3);
        order3 = new SugarDecorator(order3);
        coffeeShop.placeOrder("Charlie Brown", order3, Payment.HALYK_QR);

        // fully served espresso
        Beverage order4 = new Espresso(Size.SMALL);
        order4 = new MilkDecorator(order4);
        order4 = new SugarDecorator(order4);
        order4 = new WhippedCreamDecorator(order4);
        order4 = new CaramelDecorator(order4);
        coffeeShop.placeOrder("Diana Prince", order4, Payment.CREDIT_CARD);

        coffeeShop.displayDailySummary();
    }
}