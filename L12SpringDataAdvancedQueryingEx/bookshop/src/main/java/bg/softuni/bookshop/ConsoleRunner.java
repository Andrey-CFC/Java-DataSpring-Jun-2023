package bg.softuni.bookshop;

import bg.softuni.bookshop.services.AuthorService;
import bg.softuni.bookshop.services.BookService;
import bg.softuni.bookshop.services.CategoryService;
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
    private final CategoryService categoryService;
    private final Scanner scanner;

    @Autowired
    public ConsoleRunner(SeedService seedService, BookService bookService, AuthorService authorService, CategoryService categoryService) {
        this.seedService = seedService;
        this.bookService = bookService;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedService.seedAllDate();
//        final String[] input = this.scanner.nextLine().split("-");
//        final String firstInput = input[0];
//        final String secondInput = input[1];
//        final String thirdInput = input[2];

//        final String prefix = scanner.nextLine();
//        this.bookService.getAllBooksAfterGivenYear(LocalDate.of(2000, 1, 1));
//        this.authorService.getAllAuthorsWithBooksBeforeGivenYear(LocalDate.of(1991, 1, 1));
//        this.authorService.getAllAuthorsOrderByBooksDescending();
//        this.bookService.getAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(firstName,lastName);
// 1
//        this.bookService.getAllByAgeRestriction(firstInput);
// 2
//       this.bookService.getAllByEditionTypeAndCopiesOver("GOLD",5000);
// 3
//        this.bookService.getAllByPriceNotBetween(BigDecimal.valueOf(5), BigDecimal.valueOf(40));
// 4
//        this.bookService.getAllBooksNotReleasedInYear(2000);
// 5
//        this.bookService.getAllBooksBeforeGivenDate(LocalDate.of(Integer.parseInt(thirdInput), Integer.parseInt(secondInput), Integer.parseInt(firstInput)));
// 6
//                this.authorService.getAllByFirstNameEndingWith(suffix);
// 7
//        this.bookService.getAllByTitleContaining(suffix);
// 8
//        this.bookService.getAllByAuthorLastNameStartsWith(prefix);
// 9
//        this.bookService.getAllByTitleLengthGreaterThan(12);
// 10
//        this.authorService.getTotalBookCopies();
// 11
//        this.bookService.getAllByTitle("Things Fall Apart");
// 12
//        this.bookService.increaseCopiesForBookReleasedAfter(100,LocalDate.of(2005,10,12));
// 13
//        this.bookService.deleteAllCopiesLessThan(10000);
// 14
//        this.bookService.getBooksCountByAuthorsFirstNameAndAuthorLastName("Amanda Rice");
    }
}
