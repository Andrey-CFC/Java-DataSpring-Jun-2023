package bg.softuni.SpringDataIntro.services;

import bg.softuni.SpringDataIntro.entities.Student;

public interface StudentService {
    Student register(String name);
    Student searchByName(String name);
}

