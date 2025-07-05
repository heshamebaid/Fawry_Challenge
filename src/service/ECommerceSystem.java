package service;

import cart.Cart;
import cart.CartItem;
import model.Customer;
import model.Product;
import model.Shippable;

import java.util.List;

public class ECommerceSystem {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty.");
        }

        for (CartItem item : cart.getItems()) {
            if (item.product.isExpired()) {
                throw new IllegalStateException(item.product.getName() + " is expired.");
            }
            if (item.quantity > item.product.getQuantity()) {
                throw new IllegalStateException(item.product.getName() + " is out of stock.");
            }
        }

        double subtotal = cart.getSubtotal();
        List<Shippable> shippables = cart.getShippables();
        double shipping = shippables.isEmpty() ? 0 : 30;
        double total = subtotal + shipping;

        if (!customer.canAfford(total)) {
            throw new IllegalStateException("Insufficient balance.");
        }

        // Deduct from stock
        for (CartItem item : cart.getItems()) {
            item.product.reduceQuantity(item.quantity);
        }

        // Ship
        ShippingService.ship(shippables);

        // Deduct from customer
        customer.deduct(total);

        // Print receipt
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %-10s %.0f%n", item.quantity, item.product.getName(), item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal         %.0f%n", subtotal);
        System.out.printf("Shipping         %.0f%n", shipping);
        System.out.printf("Amount           %.0f%n", total);
        System.out.printf("Balance          %.0f%n", customer.getBalance());
    }
}
