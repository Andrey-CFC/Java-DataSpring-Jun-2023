package bg.softuni.SpringDataIntro;

import bg.softuni.SpringDataIntro.entities.Student;
import bg.softuni.SpringDataIntro.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String studentName = scanner.nextLine();
        Student register = studentService.register(studentName);
        Student student = studentService.searchByName(studentName);
        System.out.println(student.getId());
    }
}
