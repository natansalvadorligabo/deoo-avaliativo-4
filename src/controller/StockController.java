package controller;

import model.Product;
import model.Stock;
import view.ConsoleView;
import view.StockView;

public class StockController {
    private static StockController instance = null;
    private final Stock stock;
    private final StockView view;

    private StockController() {
        this.stock = new Stock();
        view = new ConsoleView();
    }

    public static synchronized StockController getInstance() {
        if (instance == null) {
            instance = new StockController();
        }
        return instance;
    }

    public synchronized void sell(String productName, Integer quantity) {
        Product product = stock.findProductByName(productName);

        if (product == null) {
            view.displayMessage("Produto " + productName + " não existe.");
            return;
        }

        if (product.getQuantity() >= quantity) {
            product.setQuantity(product.getQuantity() - quantity);
            view.displayMessage(Thread.currentThread().getName() + ": Vendido(s) " + quantity + " unidade(s) de "
                    + productName + ". Estoque disponível: " + product.getQuantity());
        } else {
            view.displayMessage(Thread.currentThread().getName() + ": Não há estoque suficiente para " +
                    productName + ". Estoque disponível: " + product.getQuantity());
        }

        if (product.getQuantity() == 0) {
            view.displayMessage("Produto " + productName + " não possui estoque!");
        }
    }

    public void run() {
        Product notebook = new Product("Notebook", 10, 1979.99);
        stock.addProduct(notebook);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                getInstance().sell("Notebook", 5);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                getInstance().sell("Notebook", 3);
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                getInstance().sell("Notebook", 4);
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
