import java.time.LocalDate;

public class Product implements ShippableItem {
    private String name;
    private double price;
    private int quantity;
    private boolean hasExpirationDate;
    private LocalDate expirationDate;
    private boolean shippable;
    private double weight;

    public Product(String name, double price, int quantity, boolean hasExpirationDate, LocalDate expirationDate, boolean shippable, double weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.hasExpirationDate = hasExpirationDate;
        this.expirationDate = expirationDate;
        this.shippable = shippable;
        this.weight = weight;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public boolean hasExpirationDate() { return hasExpirationDate; }
    public LocalDate getExpirationDate() { return expirationDate; }
    public boolean isShippable() { return shippable; }
    public double getWeight() { return weight; }

    public void reduceQuantity(int qty) {
        this.quantity -= qty;
    }

    public boolean isExpired() {
        return hasExpirationDate && expirationDate.isBefore(LocalDate.now());
    }
}
