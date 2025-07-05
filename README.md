# Fawry Quantum Internship Challenge – E-Commerce System (Java)

This project is a Java-based console application that simulates an e-commerce system for the Fawry Rise Journey Full Stack Development Internship.

## Features

- Define products (expirable, shippable, or both)
- Add items to cart with quantity validation
- Prevent checkout if:
  - Product is expired
  - Product is out of stock
  - Cart is empty
  - Customer balance is insufficient
- Ship shippable items (implements `Shippable` interface)
- Calculate and print:
  - Subtotal
  - Shipping fee
  - Total amount
  - Remaining customer balance
- Clean, readable console output in required format

---

## Project Structure

```
FawryECommerceChallenge/
├── src/
│   ├── Main.java
│   ├── model/
│   │   ├── Product.java
│   │   ├── ExpirableProduct.java
│   │   ├── ShippableProduct.java
│   │   ├── ExpirableShippableProduct.java
│   │   ├── Shippable.java
│   │   ├── Customer.java
│   ├── cart/
│   │   ├── Cart.java
│   │   ├── CartItem.java
│   ├── service/
│   │   ├── ShippingService.java
│   │   ├── ECommerceSystem.java
```

---

## How to Run

### Using an IDE (IntelliJ / Eclipse)

1. Clone or download the project.
2. Open in your IDE as a Java project.
3. Run the `Main` class.

### Using Command Line

```bash
javac -d out src/**/*.java
java -cp out Main
```

---

## Example Use Case

From `Main.java`:

```java
cart.add(product1, quantity1);
cart.add(product2, quantity2);
checkout(customer, cart);
```

Expected console output:

```
** Shipment notice **
[Quantity]x [ProductName]     [Weight]g
[...]
Total package weight [X]kg

** Checkout receipt **
[Quantity]x [ProductName]     [Price]
[...]
----------------------
Subtotal         [SubtotalAmount]
Shipping         [ShippingAmount]
Amount           [TotalAmount]
Balance          [CustomerBalance]
```

---

## Assumptions

- Expiry date is checked against the current system date.
- Shipping fee is flat (30 units) if at least one item requires shipping.
- Shipping weight is calculated cumulatively for all units.

---

## Notes

- No external libraries are used.
- All requirements from the challenge PDF are implemented.
- Code is clean and modular for scalability and testing.
