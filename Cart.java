import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();
    public void add(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            System.out.println("Not enough stock for " + product.getName());
            return;
        }
        items.add(new CartItem(product, quantity));
    }
    public void checkout(Customer customer) {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        double subtotal = 0;
        List<ShippableItem> shippableItems = new ArrayList<>();
        for (CartItem item : items) {
            Product p = item.getProduct();
            if (p.isExpired()) {
                System.out.println("Product " + p.getName() + " is expired.");
                return;
            }
            if (item.getQuantity() > p.getQuantity()) {
                System.out.println("Not enough stock for " + p.getName());
                return;
            }
            subtotal += p.getPrice() * item.getQuantity();
            if (p.isShippable()) {
                shippableItems.add(p);
            }
        }
        double shippingFees = shippableItems.isEmpty() ? 0 : 30;
        double total = subtotal + shippingFees;
        if (customer.getBalance() < total) {
            System.out.println("Insufficient balance");
            return;
        }
        for (CartItem item : items) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }
        customer.reduceBalance(total);
        if (!shippableItems.isEmpty()) {
            ShippingService.ship(shippableItems);
        }
        System.out.println("** Checkout receipt **");
        for (CartItem item : items) {
            System.out.printf("%dx %s\t%.0f\n", item.getQuantity(), item.getProduct().getName(), item.getProduct().getPrice() * item.getQuantity());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal\t%.0f\n", subtotal);
        System.out.printf("Shipping\t%.0f\n", shippingFees);
        System.out.printf("Amount\t\t%.0f\n", total);
        System.out.printf("Customer Balance After Payment: %.0f\n", customer.getBalance());
        System.out.println();
    }
}
