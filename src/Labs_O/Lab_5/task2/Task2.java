package Labs_O.Lab_5.task2;

import Labs_O.Lab_5.task2.controller.BooksController;
import Labs_O.Lab_5.task2.controller.Commands;
import Labs_O.Lab_5.task2.data.Data;
import Labs_O.Lab_5.task2.data.BooksData;
import Labs_O.Lab_5.task2.data.Database;
import Labs_O.Lab_5.task2.model.Books;
import Labs_O.Lab_5.task2.view.BooksView;
import Labs_O.Lab_5.task2.view.View;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    private final static Data DATA;
    private final static View view = new BooksView();
    private final static Scanner input = new Scanner(System.in);

    static {
        List<Books> books = List.of (
                new Books("Останнє бажання", "Анджей Сапковський", "Клуб Сімейного Дозвілля", 2016, 288, 175),
                new Books("Меч призначення", "Анджей Сапковський", "Клуб Сімейного Дозвілля", 2016, 368, 210),
                new Books("Хрещення вогнем", "Анджей Сапковський", "Клуб Сімейного Дозвілля", 2016, 384, 210),
                new Books("Метро 2033", "Дмитро Глуховський", "Навчальна книга - Богда", 2020, 616, 379),
                new Books("Метро 2034", "Дмитро Глуховський", "Навчальна книга - Богда", 2020, 332, 349),
                new Books("Метро 2035", "Дмитро Глуховський", "Навчальна книга - Богда", 2020, 536, 379),
                new Books("Секрети JavaScript ніндзя", "Джон Резіг", "Діалектика", 2016, 412, 350),
                new Books("Дві вежі", "Джон Рональд Руел Толкін", "Астролябія", 2020, 576, 338),
                new Books("Повернення короля", "Джон Рональд Руел Толкін", "Астролябія", 2020, 704, 363),
                new Books("Я, робот", "Айзек Азімов", "Gnome Press", 1950, 270, 469),
                new Books("Патерни проєктування", "Ерік Фрімен", "Фабула", 2022, 667, 726),
                new Books("Чиста архітектура", "Роберт Мартін", "Фабула", 2022, 335, 483)
        );

        Database database = new Database();
        database.addBooks(books);

        DATA = new BooksData(database);
    }

    public static void main(String[] args) throws IOException {
        BooksController controller = new BooksController(DATA);
        userInterface(controller);

    }

    public static void userInterface(BooksController controller) throws IOException {
        String data = "";
        Scanner scan = new Scanner(System.in);

        markProgram:
        while(true){
            view.consoleDisplay();
            switch (readNumber(scan)) {
                case 1:
                    data = readData("автора", scan);
                    printResult(controller.ProcessData(data, Commands.GET_AUTHOR));
                    break;
                case 2:
                    data = readData("видавництво", scan);
                    printResult(controller.ProcessData(data, Commands.GET_PUBLISHER));
                    break;
                case 3:
                    data = readData("число", scan);;
                    printResult(controller.ProcessData(data, Commands.GET_YEAR));
                    break;
                case 4:
                    printResult(controller.ProcessData(data, Commands.GET_PUBLISHING));
                    break;
                case 5:
                    scan.nextLine();
                    System.out.println("Введіть шлях для збереження:");
                    String filePath = scan.nextLine();
                    saveInFile(controller.ProcessData(data, Commands.GET_SAVE), filePath);
                    break;
                case 6:
                    scan.nextLine();
                    System.out.println("Введіть шлях для завантаження:");
                    String path = scan.nextLine();
                    System.out.println(loadFromFile(path));
                    break;
                case 7:
                    break markProgram;
                default:
                    view.consoleDisplayError("Помилка: неправильне введення!");
            }
            System.out.println(" ");
        }
        input.close();
    }

    public static int readNumber(Scanner in) {
        System.out.print("Введіть цифру: ");
        return in.nextInt();
    }


    public static String readData(String data, Scanner in) {
        System.out.print("Введіть " + data +": ");
        in.nextLine();
        return in.nextLine();
    }

    public static void printResult(List<Books> books){
        if(books.isEmpty()){
            System.out.println("Нічого не знайдено за даним запитом!");
        }
        else{
            books.forEach(System.out::println);
        }
    }

    public static void saveInFile(List<Books> books, String path) throws IOException {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
            output.writeObject(books);
        }
    }

    public static List<Books> loadFromFile(String path) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))) {
            return (List<Books>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
