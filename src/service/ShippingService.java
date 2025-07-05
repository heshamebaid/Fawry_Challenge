package service;

import model.Shippable;

import java.util.*;

public class ShippingService {
    public static void ship(List<Shippable> items) {
        if (items.isEmpty()) return;

        System.out.println("** Shipment notice **");

        Map<String, Integer> itemCount = new LinkedHashMap<>();
        double totalWeight = 0;

        for (Shippable item : items) {
            itemCount.put(item.getName(), itemCount.getOrDefault(item.getName(), 0) + 1);
            totalWeight += item.getWeight();
        }

        for (Map.Entry<String, Integer> entry : itemCount.entrySet()) {
            System.out.printf("%dx %-10s %.0fg%n", entry.getValue(), entry.getKey(), totalWeight * 1000 / items.size());
        }

        System.out.printf("Total package weight %.1fkg%n%n", totalWeight);
    }
}
