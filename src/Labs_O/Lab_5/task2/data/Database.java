package Labs_O.Lab_5.task2.data;

import Labs_O.Lab_5.task2.model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Database {
    public final List<Books> books = new ArrayList<>();

    public void addBooks(Collection<Books> books) {
        this.books.addAll(books);
    }
}
