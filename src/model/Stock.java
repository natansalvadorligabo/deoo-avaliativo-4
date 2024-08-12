package model;

import java.util.LinkedList;
import java.util.List;

public class Stock implements StockInterface {
    private List<Product> products;
    private Integer totalItems;

    public Stock() {
        products = new LinkedList<>();
        this.totalItems = 0;
    }

    @Override
    public synchronized boolean addProduct(Product product) {
        if (product == null || findProductByName(product.getName()) != null) {
            return false;
        }
        products.add(product);
        totalItems += product.getQuantity();
        return true;
    }

    @Override
    public synchronized boolean removeProduct(String productName) {
        Product product = findProductByName(productName);
        if (product == null) {
            return false;
        }
        products.remove(product);
        totalItems -= product.getQuantity();
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

    public Integer getTotalItems() {
        return totalItems;
    }
}
