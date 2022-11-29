package Labs_O.Lab_5.task2.data;

import Labs_O.Lab_5.task2.model.*;

import java.util.List;

public interface Data {
    List<Books> getBooksAuthor(String author);
    List<Books> getBooksPublisher(String publisher);
    List<Books> getBooksYear(int year);
    List<Books> getBooksPublishing();
    List<Books> getSaveBooks();
}
