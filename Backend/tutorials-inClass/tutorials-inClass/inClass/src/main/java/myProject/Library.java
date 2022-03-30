package myProject;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Library")
public class Library {
    @Id
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Books book;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "rating")
    private  int rating;

    public Library(){
    }

    public Books getBook(){return book;}
    public void setBook(Books book){this.book = book;}
    public Person getPerson(){return person;}
    public void setPerson(Person person){this.person = person;}
    public void setRating(Integer rating){this.rating = rating;}
    public Integer getRating(){return rating;}

}
