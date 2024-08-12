import model.Product;
import model.Stock;

public class Main {
    public static void main(String[] args) {
        Stock stock = new Stock();

        Product laptop = new Product("Laptop", 10, 1979.99);
        Product smartphone = new Product("Smartphone", 20, 949.90);
        Product tablet = new Product("Tablet", 15, 899.90);
    }
}
