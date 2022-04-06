package myProject;

import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Set;


@RestController
public class EvaluationController {

    @Autowired
    EvaluationInterface db;
    @Autowired
    BookInterface bdb;
    @Autowired
    UserInterface pdb;

    @PutMapping("/evaluation/{bid}/{pid}")
    Evaluation creatEvaluation(@PathVariable Integer bid, @PathVariable Integer pid, @RequestBody Evaluation br) {

        EvaluationKey brk = new EvaluationKey();
        brk.setBookId(bid);
        brk.setPersonId(pid);

        br.setId(brk);
        User p = pdb.findById(pid).orElseThrow(NoSuchElementException::new);
        Book b = bdb.findById(bid).orElseThrow(NoSuchElementException::new);
        br.setBook(b);
        br.setPerson(p);

        db.save(br);
        return br;
    }

    @GetMapping("/getEvaluation/{bid}/{pid}")
    Evaluation findAReview(@PathVariable Integer bid, @PathVariable Integer pid) {
        EvaluationKey brk = new EvaluationKey();
        brk.setBookId(bid);
        brk.setPersonId(pid);
        return db.findById(brk).orElseThrow(NoSuchElementException::new);
    }

//    @PutMapping("/changeEvaluation/{bid}/{pid}")
//    Evaluation creatReview(@PathVariable Integer bid, @PathVariable Integer pid, @RequestBody Evaluation br) {
//        EvaluationKey brk = new EvaluationKey();
//        brk.setBookId(bid);
//        brk.setPersonId(pid);
//        Evaluation newEval = db.findById(brk).orElseThrow(NoSuchElementException::new);
//
//        Evaluation oldRating = db.findById(brk).orElseThrow(NoSuchElementException::new);
//        if (oldRating.getRating() != 0) {
//            br.setRating(oldRating.getRating());
//        }
//
//
//        User p = pdb.findById(pid).orElseThrow(NoSuchElementException::new);
//        Book b = bdb.findById(bid).orElseThrow(NoSuchElementException::new);
//        br.setId(brk);
//        br.setBook(b);
//        br.setPerson(p);
//        db.save(br);
//
//        return br;
//    }

    @GetMapping("/getEvaluations/{bid}")
    Set<Evaluation> getRatings(@PathVariable Integer bid) {

        Book b = bdb.findById(bid).orElseThrow(NoSuchElementException::new);
        return b.getEvaluation();
    }

    @GetMapping("/getAllEvaluationsFromUser/{pid}")
    Set<Evaluation> getAllRatingsFromUser(@PathVariable Integer pid) {

        User p = pdb.findById(pid).orElseThrow(NoSuchElementException::new);
        return p.getEvaluation();
    }
}