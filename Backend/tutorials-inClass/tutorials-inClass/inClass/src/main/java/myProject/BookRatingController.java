package myProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BookRatingController {
    @Autowired
    RatingDB db;
    @Autowired
    BooksDB bdb;
    @Autowired
    PersonDB pdb;
    @PostMapping("/addRating/{bid}/{pid}")
    BookRating creatBookRating(@PathVariable Integer bid, @PathVariable Integer pid, @RequestBody BookRating br) {
//        br.setBook(bdb.findById(bid).orElseThrow());
//        br.setPerson(pdb.findById(pid).orElseThrow());

        BookRatingKey brk = new BookRatingKey();
        brk.setBookId(bid);
        brk.setPersonId(pid);

        br.setId(brk);
        db.save(br);
        return br;
    }
    @PutMapping("/addReview/{bid}/{pid}")
    BookRating creatReview(@PathVariable Integer bid, @PathVariable Integer pid, @RequestBody BookRating br) {

        BookRatingKey brk = new BookRatingKey();
        brk.setBookId(bid);
        brk.setPersonId(pid);


        br.setId(brk);
        db.save(br);
        return br;
    }

//    @GetMapping("/book/{bid}/person/{pid}")
//    Optional<BookRating> getBookRating(@PathVariable Integer bid, @PathVariable Integer pid) {
//        return db.findById(pid);
//
//    }
}
