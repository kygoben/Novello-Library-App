package myProject;

import javax.persistence.*;
import java.util.Set;

@Entity
class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer bookID;

        @Column
        String isbn;

        @Column
        String title;

        @Column
        String author;

        @Column
        Integer publicationYear;

        @Column
        Integer rating;

        @Column
        Double msrp;

        @Column
        String genre;

        @OneToMany(mappedBy = "book")
        Set<BookRating> ratings;

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor(){ return author;}

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPublicationYear(){ return publicationYear;}

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getISBN() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getMSRP() {
        return msrp;
    }

    public void setMsrp(Double msrp) {
        this.msrp = msrp;
    }

    public Integer getRating(){return rating;}

    public void setRating(Integer rating) {
        this.rating = rating;
    }


}
