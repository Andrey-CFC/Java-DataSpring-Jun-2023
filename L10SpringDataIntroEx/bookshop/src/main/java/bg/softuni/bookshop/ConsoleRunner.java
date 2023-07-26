package bg.softuni.bookshop;

import bg.softuni.bookshop.services.AuthorService;
import bg.softuni.bookshop.services.BookService;
import bg.softuni.bookshop.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final BookService bookService;
    private final AuthorService authorService;
    private final Scanner scanner;

    @Autowired
    public ConsoleRunner(SeedService seedService, BookService bookService, AuthorService authorService) {
        this.seedService = seedService;
        this.bookService = bookService;
        this.authorService = authorService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedService.seedAllDate();
        final String[] input = this.scanner.nextLine().split(" ");
        final String firstName = input[0];
        final String lastName = input[1];
//        this.bookService.getAllBooksAfterGivenYear(LocalDate.of(2000, 1, 1));
//        this.authorService.getAllAuthorsWithBooksBeforeGivenYear(LocalDate.of(1991, 1, 1));
//        this.authorService.getAllAuthorsOrderByBooksDescending();
        this.bookService.getAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(firstName,lastName);
    }
}
