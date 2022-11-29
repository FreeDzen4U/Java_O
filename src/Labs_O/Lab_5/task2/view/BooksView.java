package Labs_O.Lab_5.task2.view;

public class BooksView implements View {
    @Override
    public void consoleDisplay() {
        System.out.println("1 - Отримати список книг зазначеного автора" +
                "\n" + "2 - Отримати список книг, які видані зазначеним видавництвом" +
                "\n" + "3 - Отримати список книг, виданих пізніше вказаного року" +
                "\n" + "4 - Відсортувати книги за видавництвами" +
                "\n" + "5 - Зберегти дані у файл" +
                "\n" + "6 - Імпортувати дані з файлу" +
                "\n" + "7 - Вийти з консолі");
    }

    @Override
    public void consoleDisplayError(String error) {
        System.out.println(error);
    }
}
