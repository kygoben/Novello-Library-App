package myProject;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonDB extends JpaRepository<Person, Integer> {

}