package bg.softuni.SpringDataIntro.repositories;

import bg.softuni.SpringDataIntro.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    Student findByName(String name);
}
