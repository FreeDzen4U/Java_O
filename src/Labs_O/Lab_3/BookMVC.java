package Labs_O.Lab_3;

import Labs_O.Lab_3.controller.CommandsForController;
import Labs_O.Lab_3.controller.MainController;
import Labs_O.Lab_3.DataAccessObject.BookDAO;
import Labs_O.Lab_3.DataAccessObject.BookDAOImplementation;
import Labs_O.Lab_3.DataAccessObject.Data;
import Labs_O.Lab_3.model.Book;
import Labs_O.Lab_3.view.ConsoleView;
import Labs_O.Lab_3.view.View;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class BookMVC {

    private final static BookDAO bookDao;
    private final static View view = new ConsoleView();
    private final static Scanner input = new Scanner(System.in);
    public static final String colorReset = "\u001B[0m";
    public static final String colorTextYellow = "\033[0;93m";
    public static final String colorTextRed = "\033[0;91m";

    static {
        List<Book> books = List.of(
                new Book("Останнє бажання", "Анджей Сапковський", "Клуб Сімейного Дозвілля", 2016, 288, 175),
                new Book("Меч призначення", "Анджей Сапковський", "Клуб Сімейного Дозвілля", 2016, 368, 210),
                new Book("Хрещення вогнем", "Анджей Сапковський", "Клуб Сімейного Дозвілля", 2016, 384, 210),
                new Book("Метро 2033", "Дмитро Глуховський", "Навчальна книга - Богда", 2020, 616, 379),
                new Book("Метро 2034", "Дмитро Глуховський", "Навчальна книга - Богда", 2020, 332, 349),
                new Book("Метро 2035", "Дмитро Глуховський", "Навчальна книга - Богда", 2020, 536, 379),
                new Book("Секрети JavaScript ніндзя", "Джон Резіг", "Діалектика", 2016, 412, 350),
                new Book("Дві вежі", "Джон Рональд Руел Толкін", "Астролябія", 2020, 576, 338),
                new Book("Повернення короля", "Джон Рональд Руел Толкін", "Астролябія", 2020, 704, 363),
                new Book("Я, робот", "Айзек Азімов", "Gnome Press", 1950, 270, 469),
                new Book("Патерни проєктування", "Ерік Фрімен", "Фабула", 2022, 667, 726),
                new Book("Чиста архітектура", "Роберт Мартін", "Фабула", 2022, 335, 483));

        Data database = new Data();
        database.addBooks(books);

        bookDao = new BookDAOImplementation(database);
    }

    public static void main(String[] args) throws IOException {

        MainController maincontroller = new MainController(bookDao);

        User_Interface(maincontroller);

    }

    public static void User_Interface(MainController mc) throws IOException {
        String data = "";
        Scanner in = new Scanner(System.in);

        appLoop:
        while(true){
            view.display();
            switch (readNumb(in)) {
                case 1:
                    data = readData("author", in);
                    printResult(mc.ProcessData(data, CommandsForController.GET_AUTHOR));
                    break;
                case 2:
                    data = readData("publisher", in);
                    printResult(mc.ProcessData(data, CommandsForController.GET_PUBLISHER));
                    break;
                case 3:
                    data = readData("year", in);
                    printResult(mc.ProcessData(data, CommandsForController.GET_YEAR_OF_PUBL));
                    break;
                case 4:
                    printResult(mc.ProcessData(data, CommandsForController.SORT_BY_PUBLISHERS));
                    break;
                case 5:
                    break appLoop;
                default:
                    view.displayInfo(colorTextRed + "Invalid number" + colorReset);
            }
            System.out.println(" ");
        }
        input.close();
    }

    public static int readNumb(Scanner in) throws IOException {
        System.out.print(colorTextYellow + "Input a number: " + colorReset);
        return in.nextInt();
    }


    public static String readData(String data, Scanner in) throws IOException {
        System.out.print(colorTextYellow + "Input " + data + ": " + colorReset);
        in.nextLine();
        return in.nextLine();
    }

    public static void printResult(List<Book> books){
        if(books.isEmpty()){
            System.out.println(colorTextRed + "Nothing was found" + colorReset);
        }
        else{
            books.forEach(System.out::println);
        }
    }
}
