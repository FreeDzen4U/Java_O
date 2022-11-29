package Labs_O.Lab_3.controller;

import Labs_O.Lab_3.DataAccessObject.BookDAO;
import Labs_O.Lab_3.model.Book;

import java.util.ArrayList;
import java.util.List;


public class MainController {
    private final BookDAO bookdao;

    public MainController(BookDAO bookdao) {
        this.bookdao = bookdao;
    }

    public List<Book> ProcessData(String data, CommandsForController command){
        switch (command) {
            case GET_AUTHOR: return bookdao.getByAuthor(data);
            case GET_PUBLISHER: return bookdao.getByPublisher(data);
            case GET_YEAR_OF_PUBL: return bookdao.getSinceYear(Integer.parseInt(data));
            case SORT_BY_PUBLISHERS: return bookdao.getAllSortedByPublisher();
            default: return new ArrayList<>();
        }
    }


}
