import model.*;
import cart.Cart;
import service.ECommerceSystem;

import java.util.Calendar;

public class main {
    public static void main(String[] args) {
        // Create expiry date in the future
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 5);

        // Create products
        Product cheese = new ExpirableShippableProduct("Cheese", 100, 5, cal.getTime(), 0.2);
        Product biscuits = new ExpirableShippableProduct("Biscuits", 150, 2, cal.getTime(), 0.7);
        Product tv = new ShippableProduct("TV", 1000, 10, 5.0);
        Product scratchCard = new Product("ScratchCard", 50, 100) {};

        // Customer
        Customer customer = new Customer("Hesham", 1000);

        // Cart
        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);

        // Checkout
        ECommerceSystem.checkout(customer, cart);
    }
}
