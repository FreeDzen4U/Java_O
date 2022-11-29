package Labs_O.Lab_3.DataAccessObject;

import Labs_O.Lab_3.model.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Data {

    public final List<Book> books = new ArrayList<>();

    public void addBooks(Collection<Book> books) {
        this.books.addAll(books);
    }
}
