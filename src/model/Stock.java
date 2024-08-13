package model;

import java.util.LinkedList;
import java.util.List;

public class Stock implements StockInterface {
    private List<Product> products;
    public Stock() {
        products = new LinkedList<>();
    }

    @Override
    public synchronized boolean addProduct(Product product) {
        if (product == null || findProductByName(product.getName()) != null) {
            return false;
        }
        products.add(product);
        return true;
    }

    @Override
    public synchronized boolean removeProduct(String productName) {
        Product product = findProductByName(productName);
        if (product == null) {
            return false;
        }
        products.remove(product);
        return true;
    }

    @Override
    public synchronized Product findProductByName(String productName) {
        if (!productName.isBlank()) {
            for (Product product : products) {
                if (product.getName().equals(productName)) {
                    return product;
                }
            }
        }
        return null;
    }
}
