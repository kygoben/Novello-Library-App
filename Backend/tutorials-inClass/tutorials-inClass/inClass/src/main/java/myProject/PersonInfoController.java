package myProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonInfoController {

	@Autowired
	PersonInfoDB db;

	@GetMapping("/personInfo/{id}")
	PersonInfo getPerson(@PathVariable Integer id) {
		return db.findById(id).
          orElseThrow(RuntimeException::new);
	}
	@RequestMapping("/personsInfo")
	List<PersonInfo> getPersons() {
		return db.findAll();
	}

	@PostMapping("/personInfo")
	PersonInfo createPerson(@RequestBody PersonInfo p) {
		db.save(p);
		return p;
	}
	@PutMapping("/personInfo/{id}")
	PersonInfo updatePerson(@RequestBody PersonInfo p, @PathVariable Integer id) {
		PersonInfo old_p = db.findById(id).orElseThrow(RuntimeException::new);
		if (p.name!= null)
			old_p.setName(p.name);
		if (p.email!= null)
			old_p.setEmail(p.email);
		if (p.age!= null)
			old_p.setAge(p.age);
		db.save(old_p);
		return old_p;
	}
	@DeleteMapping("/personInfo/{id}")
	String deletePerson(@PathVariable Integer id) {
		db.deleteById(id);
		return "deleted " + id;
	}

}
