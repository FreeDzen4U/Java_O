package Labs_O.Lab_5.task2.model;

import java.io.Serializable;

public class Books implements Comparable<Books>, Serializable {
    private String title;
    private String author;
    private String publisher;
    private int yearOfPublication;
    private int numberOfPages;
    private int price;

    public Books(String title, String author, String publisher, int yearOfPublication, int numberOfPages, int price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearOfPublication = yearOfPublication;
        this.numberOfPages = numberOfPages;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "\n" +
                "\u001B[1m Книжка \u001B[0m" +
                "\nНазва - \"" + title + '\"' +
                "\nАвтор - \"" + author + '\"' +
                "\nВидавництво - \"" + publisher + '\"' +
                "\nРік публікації - " + yearOfPublication +
                "\nКількість сторінок - " + numberOfPages +
                "\nЦіна - " + price;
    }

    @Override
    public int compareTo(Books obj) {
        return this.publisher.compareTo(obj.publisher);
    }
}
