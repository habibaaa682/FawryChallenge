import java.util.List;

public class ShippingService {
    public static void ship(List<ShippableItem> items) {
        double totalWeight = 0;
        System.out.println("** Shipment notice **");
        for (ShippableItem item : items) {
            System.out.printf("%-10s %6.1fg\n", item.getName(), item.getWeight() * 1000);
            totalWeight += item.getWeight();
        }
        System.out.printf("Total package weight: %.1fkg\n", totalWeight);
        System.out.println();
    }
}
