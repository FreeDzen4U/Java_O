package Labs_O.Lab_3.model;

public class Book implements Comparable<Book>{

    private String name;
    private String author;
    private String publishedBy;
    private int publicYear;
    private int pages;
    private double price;

    public Book(String name, String author, String publishedBy, int publicYear, int pages, double price) {
        this.name = name;
        this.author = author;
        this.publishedBy = publishedBy;
        this.publicYear = publicYear;
        this.pages = pages;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishedBy() {
        return publishedBy;
    }

    public void setPublishedBy(String publishedBy) {
        this.publishedBy = publishedBy;
    }

    public int getPublicYear() {
        return publicYear;
    }

    public void setPublicYear(int publicYear) {
        this.publicYear = publicYear;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static final String colorReset = "\u001B[0m";
    public static final String colorTextBlue = "\033[0;34m";
    public static final String colorTextWhite = "\033[0;97m";


    @Override
    public String toString() {
        return  colorTextWhite +
                "\nBook name: " + colorTextBlue + "'" + name + "'" +colorTextWhite +
                "\nAuthor: " + colorTextBlue + author + colorTextWhite +
                "\nPublished by: " + colorTextBlue + publishedBy + colorTextWhite +
                "\nYear of publication: " + colorTextBlue + publicYear + colorTextWhite +
                "\nQuality of pages: " + colorTextBlue + pages + colorTextWhite +
                "\nPrice: " + colorTextBlue + price + colorReset;
    }

    @Override
    public int compareTo(Book o) {
        return this.publishedBy.compareTo(o.publishedBy);
    }
}
