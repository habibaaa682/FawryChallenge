import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        Product cheese = new Product("Cheese", 100, 5, true, LocalDate.of(2025, 7, 30), true, 0.2);
        Product biscuits = new Product("Biscuits", 150, 3, true, LocalDate.of(2025, 8, 15), true, 0.7);
        Product scratchCard = new Product("Scratch Card", 50, 10, false, null, false, 0);
        Customer customer = new Customer("sara", 6000);
        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);
        cart.checkout(customer);
    }
}
