import controller.StockController;

public class Main {
    public static void main(String[] args) {
        StockController controller = StockController.getInstance();
        controller.run();
    }
}
