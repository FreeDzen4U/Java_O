package Labs_O.Lab_5.task2.controller;

import Labs_O.Lab_5.task2.data.Data;
import Labs_O.Lab_5.task2.model.Books;

import java.util.ArrayList;
import java.util.List;

public class BooksController {
    private final Data data;

    public BooksController(Data data) {
        this.data = data;
    }

    public List<Books> ProcessData(String booksData, Commands command){
        switch (command) {
            case GET_AUTHOR: return data.getBooksAuthor(booksData);
            case GET_PUBLISHER: return data.getBooksPublisher(booksData);
            case GET_YEAR: return data.getBooksYear(Integer.parseInt(booksData));
            case GET_PUBLISHING: return data.getBooksPublishing();
            case GET_SAVE: return data.getSaveBooks();
            default: return new ArrayList<>();
        }
    }
}
