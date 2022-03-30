package myProject;

import javax.persistence.*;
import java.util.Set;

@Entity
class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Person_Info_id",referencedColumnName = "id")
	PersonInfo personInfo;


	@Column
	Integer accountType;

	@Column
	String username;

	@Column
	String password;

	@Column
	String securityQuestion;

	@Column
	String securityAnswer;


	@OneToMany(mappedBy = "person")
	Set<BookRating> ratings;

//	@OneToMany(mappedBy = "person")
//	private Set<BookRating> ratings;


//	@OneToMany
//	@JoinColumn(name = "bk_book_id")
/*

	public Books getBk() {
		return bk;
	}
	@ManyToOne
	@JoinColumn(name = "friends_id")
	Person friends;

	public Person getFriends() {
		return friends;
	}
	@Column
	Books library;
	@Column
	CREDIT CARD INFO

	@Column
	Friends JSON
*/


	public Integer getId() { return id; }
	public void setId(Integer id){ this.id = id; }

	public Integer getAccountType() { return accountType; }
    public void setAccountType(Integer accountType) { this.accountType = accountType;}

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getSecurityQuestion() { return securityQuestion; }
    public void setSecurityQuestion(String securityQuestion) { this.securityQuestion = securityQuestion; }

    public String getSecurityAnswer() { return securityAnswer; }
    public void setSecurityAnswer(String securityAnswer) { this.securityAnswer = securityAnswer; }


}