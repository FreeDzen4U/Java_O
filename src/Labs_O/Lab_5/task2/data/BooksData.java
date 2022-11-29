package Labs_O.Lab_5.task2.data;

import Labs_O.Lab_5.task2.model.Books;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BooksData implements Data {
    private final Database database;

    public BooksData(Database database) {
        this.database = database;
    }

    @Override
    public List<Books> getBooksAuthor(String author) {
        return database.books.stream()
                .filter(i -> author.equals(i.getAuthor()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Books> getBooksPublisher(String publisher) {
        return database.books.stream()
                .filter(i -> publisher.equals(i.getPublisher()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Books> getBooksYear(int year) {
        return database.books.stream()
                .filter(i -> i.getYearOfPublication() >= year)
                .collect(Collectors.toList());
    }

    @Override
    public List<Books> getBooksPublishing() {
        return database.books.stream().sorted()
                .collect(Collectors.toList());
    }

    @Override
    public List<Books> getSaveBooks() {
        return new ArrayList<>(database.books);
    }
}
