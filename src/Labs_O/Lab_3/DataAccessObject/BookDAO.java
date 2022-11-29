package Labs_O.Lab_3.DataAccessObject;

import Labs_O.Lab_3.model.*;

import java.util.List;

public interface BookDAO {

    List<Book> getByAuthor(String author);
    List<Book> getByPublisher(String publisher);
    List<Book> getSinceYear(int year);
    List<Book> getAllSortedByPublisher();
}
