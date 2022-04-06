package myProject;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
class Book {

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
    Double overallRating;

    @Column
    Double msrp;

    @Column
    String genre;

    @Column
    String description;

    @Column
    String readingUrl;

    @Column
    String imageUrl;

    @OneToMany(mappedBy = "book")
    Set<Evaluation> evaluation;

    @OneToMany(mappedBy = "book")
    @JsonIgnore
    Set<Library> library;

    

    public String getDescription() {
        return description;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public String getReadingUrl() {
        return readingUrl;
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

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getISBN() {
        return isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setMsrp(Double msrp) {
        this.msrp = msrp;
    }

    public Double getMSRP() {
        return msrp;
    }

    public double getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(double rating) {
        this.overallRating = rating;
    }

    public Set<Evaluation> getEvaluation() {
        return evaluation;
    }

    public Set<Library> getLibrary() {
        return library;
    }




}
