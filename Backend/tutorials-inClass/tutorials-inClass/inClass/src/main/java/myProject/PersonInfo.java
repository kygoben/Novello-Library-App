package myProject;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Person_Info")
class PersonInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;

	@OneToOne(mappedBy = "personInfo")
	private Person person;

	@Column
	String name;

	@Column
	String email;

	@Column
	Integer age;

	public PersonInfo(){

	}

//	public Person getId() { return p; }
//	public void setId(Person p){ this.p = p; }

	public String getName() { return name; }
    public void setName(String name){ this.name = name; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}