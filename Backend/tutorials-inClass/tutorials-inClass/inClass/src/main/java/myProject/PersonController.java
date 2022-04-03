package myProject;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

	@Autowired
	PersonDB db;

	@GetMapping("/person/{id}")
	Person getPerson(@PathVariable Integer id) {
		return db.findById(id).
          orElseThrow(RuntimeException::new);
	}



	@PostMapping("/addAllPersons")
	void createAllPersons(@RequestBody Person[] p){
		for(int i = 0; i<p.length;i++){
			db.save(p[i]);
		}

	}
	@RequestMapping("/persons")
	List<Person> getPersons() {
		return db.findAll();
	}

	@PostMapping("/person")
	Person createPerson(@RequestBody Person p) {
		db.save(p);
		return p;
	}

	@PutMapping("/person/{id}")
	Person updatePerson(@RequestBody Person p, @PathVariable Integer id) {
		Person old_p = db.findById(id).orElseThrow(RuntimeException::new);
		if (p.name!= null)
			old_p.setName(p.name);
		if(p.accountType!= null)
			old_p.setAccountType(p.accountType);
		if (p.username!= null)
			old_p.setUsername(p.username);
		if (p.password!= null)
			old_p.setPassword(p.password);
		if (p.securityAnswer!= null)
			old_p.setSecurityAnswer(p.securityAnswer);
		if (p.securityQuestion!= null)
			old_p.setSecurityQuestion(p.securityQuestion);
		if (p.email!= null)
			old_p.setEmail(p.email);
		if (p.age!= null)
			old_p.setAge(p.age);
		db.save(old_p);
		return old_p;
	}
	@DeleteMapping("/person/{id}")
	String deletePerson(@PathVariable Integer id) {
		db.deleteById(id);
		return "deleted " + id;
	}

}
