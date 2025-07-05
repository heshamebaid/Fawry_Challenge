# 📦 Fawry Quantum Internship Challenge – E-Commerce System (Java)

This project is a Java-based console application that simulates an **e-commerce system** for the Fawry Rise Journey Full Stack Development Internship.

## ✅ Features

- 📦 Define products (expirable, shippable, or both)
- 🛒 Add items to cart with quantity validation
- ❌ Prevent checkout if:
  - Product is expired
  - Product is out of stock
  - Cart is empty
  - Customer balance is insufficient
- 🚚 Ship shippable items (implements `Shippable` interface)
- 💳 Calculate and print:
  - Subtotal
  - Shipping fee
  - Total amount
  - Remaining customer balance
- 📄 Clean, readable console output in required format

---

## 🗂 Project Structure

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

## 🚀 How to Run

### ✅ Using an IDE (IntelliJ / Eclipse)

1. Clone or download the project.
2. Open in your IDE as a Java project.
3. Run the `Main` class.

### ✅ Using Command Line

```bash
javac -d out src/**/*.java
java -cp out Main
```

---

## 🧪 Example Use Case (from `Main.java`)

```java
cart.add(cheese, 2);
cart.add(biscuits, 1);
cart.add(scratchCard, 1);
checkout(customer, cart);
```

### ✅ Console Output

```
** Shipment notice **
2x Cheese     400g
1x Biscuits   700g
Total package weight 1.1kg

** Checkout receipt **
2x Cheese     200
1x Biscuits   150
1x ScratchCard 50
----------------------
Subtotal         400
Shipping         30
Amount           430
Balance          570
```

---

## 📌 Assumptions

- Expiry date is checked against the current system date.
- Shipping fee is flat (30 units) if at least one item requires shipping.
- Shipping weight is calculated cumulatively for all units.

---

## 🔒 Notes

- No external libraries are used.
- All requirements from the challenge PDF are implemented.
- Code is clean and modular for scalability and testing.
