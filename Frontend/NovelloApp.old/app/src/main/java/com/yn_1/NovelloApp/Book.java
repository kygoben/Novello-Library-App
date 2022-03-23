package com.yn_1.NovelloApp;

public class Book {

    //book fields
    String title;
    String author;
    int publicationYear;
    String isbn;
    int rating;
    int bookID;

    /**
     * Constructor
     * @param title book title
     * @param author book author
     * @param publicationYear book publication year
     * @param isbn book isbn
     * @param rating book rating
     */
    public Book(int bookID, String title, String author, int publicationYear, String isbn, int rating) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.rating = rating;
    }

    /**
     * Constructor
     * @param title book title
     */
    public Book(String title) {
        this.title = title;
        this.author = "unknown author";
        this.publicationYear = -1;
        this.isbn = "unknown isbn";
        this.rating = -1;
    }

    /**
     * @return book title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return book author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @return book rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @return book isbn
     */
    public String getISBN() {
        return isbn;
    }

    /**
     * @return string representation of book
     */
    public String toString() {
        return title + " by " + author;
    }

    /**
     * @return book id
     */
    public int getBookID() {
        return bookID;
    }
}
