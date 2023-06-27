package bg.softuni.SpringDataIntro.services;

import bg.softuni.SpringDataIntro.entities.Student;
import bg.softuni.SpringDataIntro.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student register(String name) {
        Student student = new Student(name);
        return studentRepository.save(student);
    }

    @Override
    public Student searchByName(String name) {
        return studentRepository.findByName(name);
    }
}
