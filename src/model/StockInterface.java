package model;

public interface StockInterface {
    boolean addProduct(Product product);
    boolean removeProduct(String productName);
    Product findProductByName(String productName);
}
