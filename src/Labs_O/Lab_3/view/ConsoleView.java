package Labs_O.Lab_3.view;

public class ConsoleView implements View {

    public static final String colorReset = "\u001B[0m";
    public static final String colorTextWhite = "\033[0;97m";
    @Override
    public void display() {
        System.out.println(colorTextWhite + "1 - See all books by author");
        System.out.println("2 - See all books published by");
        System.out.println("3 - See all books published after");
        System.out.println("4 - See all books sorted by publisher");
        System.out.println("5 - Exit\n" + colorReset);
    }

    @Override
    public void displayInfo(String message) {
        System.out.println(message);
    }
}
