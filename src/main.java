import model.*;
import cart.Cart;
import service.ECommerceSystem;

import java.util.Calendar;

public class main {

    public static void main(String[] args) {
        runAllTests();
    }

    public static void runAllTests() {
        testValidCheckout(); // TC1
        testEmptyCart(); // TC2
        testExpiredProduct(); // TC3
        testOutOfStock(); // TC4
        testInsufficientBalance(); // TC5
        testNonShippableOnly(); // TC6
        testShippableOnly(); // TC7
        testZeroWeight(); // TC8
    }

    public static void testValidCheckout() {
        System.out.println("\n--- Test Case: Valid Checkout ---");
        try {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, 5); // not expired

            Product cheese = new ExpirableShippableProduct("Cheese", 100, 5, cal.getTime(), 0.2);
            Product scratch = new Product("ScratchCard", 50, 5) {};

            Customer customer = new Customer("User", 500);
            Cart cart = new Cart();
            cart.add(cheese, 2);
            cart.add(scratch, 1);

            ECommerceSystem.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static void testEmptyCart() {
        System.out.println("\n--- Test Case: Empty Cart ---");
        try {
            Customer customer = new Customer("User", 100);
            Cart cart = new Cart();
            ECommerceSystem.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("EXPECTED: " + e.getMessage());
        }
    }

    public static void testExpiredProduct() {
        System.out.println("\n--- Test Case: Expired Product ---");
        try {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -5); // expired

            Product expired = new ExpirableShippableProduct("Milk", 80, 3, cal.getTime(), 0.5);
            Customer customer = new Customer("User", 300);
            Cart cart = new Cart();
            cart.add(expired, 1);

            ECommerceSystem.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("EXPECTED: " + e.getMessage());
        }
    }

    public static void testOutOfStock() {
        System.out.println("\n--- Test Case: Out of Stock ---");
        try {
            Product tv = new ShippableProduct("TV", 1000, 1, 5.0);
            Customer customer = new Customer("User", 2000);
            Cart cart = new Cart();
            cart.add(tv, 2); // requesting more than available
            ECommerceSystem.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("EXPECTED: " + e.getMessage());
        }
    }

    public static void testInsufficientBalance() {
        System.out.println("\n--- Test Case: Insufficient Balance ---");
        try {
            Product phone = new Product("Phone", 999, 10) {};
            Customer customer = new Customer("User", 500);
            Cart cart = new Cart();
            cart.add(phone, 1);
            ECommerceSystem.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("EXPECTED: " + e.getMessage());
        }
    }

    public static void testNonShippableOnly() {
        System.out.println("\n--- Test Case: Non-Shippable Only ---");
        try {
            Product scratch = new Product("ScratchCard", 50, 5) {};
            Customer customer = new Customer("User", 100);
            Cart cart = new Cart();
            cart.add(scratch, 2);
            ECommerceSystem.checkout(customer, cart); // no shipment section
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static void testShippableOnly() {
        System.out.println("\n--- Test Case: Shippable Only ---");
        try {
            Product box = new ShippableProduct("Gadget", 120, 5, 1.5);
            Customer customer = new Customer("User", 500);
            Cart cart = new Cart();
            cart.add(box, 2);
            ECommerceSystem.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static void testZeroWeight() {
        System.out.println("\n--- Test Case: Zero Weight Product ---");
        try {
            Product lightBox = new ShippableProduct("LightBox", 50, 10, 0.0);
            Customer customer = new Customer("User", 300);
            Cart cart = new Cart();
            cart.add(lightBox, 2);
            ECommerceSystem.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
