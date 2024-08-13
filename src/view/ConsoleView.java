package view;

public class ConsoleView implements StockView {
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
