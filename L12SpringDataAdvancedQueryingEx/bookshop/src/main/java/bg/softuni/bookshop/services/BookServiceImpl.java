package bg.softuni.bookshop.services;

import bg.softuni.bookshop.entities.Book;
import bg.softuni.bookshop.enums.AgeRestriction;
import bg.softuni.bookshop.enums.EditionType;
import bg.softuni.bookshop.model.BookPrintInformation;
import bg.softuni.bookshop.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean isDataSeeded() {
        return this.bookRepository.count() > 0;
    }

    @Override
    public void seedBooks(List<Book> books) {
        this.bookRepository.saveAllAndFlush(books);
    }

    @Override
    public List<Book> getAllBooksAfterGivenYear(LocalDate date) {
        List<Book> allByReleaseDateAfter = this.bookRepository.findAllByReleaseDateAfter(date).get();
        System.out.println(allByReleaseDateAfter.stream().map(Book::getTitle).collect(Collectors.joining("%n")));
        return allByReleaseDateAfter;
    }

    @Override
    public List<Book> getAllBooksBeforeGivenYear(LocalDate date) {
        List<Book> books = this.bookRepository.findAllByReleaseDateBefore(date)
                .orElseThrow(NoSuchFieldError::new);
        return books;
    }

    @Override
    public List<Book> getAllBooksBeforeGivenDate(LocalDate date) {
        List<Book> books = this.bookRepository.findAllByReleaseDateBefore(date)
                .orElseThrow(NoSuchFieldError::new);
        books.forEach(b-> System.out.println(b.getBookTitleEditionTypeAndPrice()));
        return books;
    }

    @Override
    public List<Book> getAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName) {
        final List<Book> allBooksByAuthor = this.bookRepository.findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(firstName, lastName);

        allBooksByAuthor.stream().map(Book::getBookTitleReleaseDateCopiesFormat)
                .forEach(System.out::println);

        return allBooksByAuthor;
    }

    @Override
    public List<Book> getAllByAgeRestriction(String ageRestriction) {
        final List<Book> allBooksByAgeRestriction = this.bookRepository.findAllByAgeRestriction(AgeRestriction.valueOf(ageRestriction.toUpperCase(Locale.ROOT)));
        allBooksByAgeRestriction.forEach(b -> System.out.println(b.getTitle()));
        return allBooksByAgeRestriction;
    }

    @Override
    public List<Book> getAllByEditionTypeAndCopiesOver(String editionType, Integer copiesToCompare) {
        final List<Book> books = this.bookRepository.findAllByEditionTypeAndCopiesLessThan(EditionType.valueOf(editionType.toUpperCase()), copiesToCompare);
        books.forEach(b -> System.out.println(b.getTitle()));
        return books;
    }

    @Override
    public List<Book> getAllByPriceNotBetween(BigDecimal lowerBoundary, BigDecimal upperBoundary) {
        final List<Book> books = this.bookRepository.findAllByPriceLessThanOrPriceGreaterThan(lowerBoundary, upperBoundary);
        books.forEach(b -> System.out.println(b.getBookTitleAndPriceFormat()));

        return books;
    }



    @Override
    public List<Book> getAllBooksNotReleasedInYear(Integer year) {
        final List<Book> allBooksReleasedNotInYear = this.bookRepository.findAllByReleaseDateYearNot(year);
        allBooksReleasedNotInYear.forEach(b -> System.out.println(b.getTitle()));

//       allBooksReleasedNotInYear.forEach(b-> System.out.println(b));
        return allBooksReleasedNotInYear;
    }

    @Override
    public List<Book> getAllByTitleContaining(String contains) {
        List<Book> books = this.bookRepository.findAllByTitleContaining(contains);
        books.forEach(b-> System.out.println(b.getTitle()));
        return books;
    }

    @Override
    public List<Book> getAllByAuthorLastNameStartsWith(String prefix) {
        final List<Book> books = this.bookRepository.findAllByAuthor_LastNameStartsWith(prefix);
        books.stream()
                .map(book -> String.format("%s (%s %S)",
                        book.getTitle(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName())).forEach(System.out::println);
        return books;
    }

    @Override
    public Integer getAllByTitleLengthGreaterThan(Integer length) {
        Integer count = this.bookRepository.findAllByTitleLengthGreaterThan(length);
        System.out.println(count);
        return count;
    }

    @Override
    public List<BookPrintInformation> getAllByTitle(String title) {
        final List<BookPrintInformation> allByTile = this.bookRepository.findAllByTile(title);
        allByTile.forEach(System.out::println);
        return allByTile;
    }

    @Override
    public void increaseCopiesForBookReleasedAfter(Integer addedCopies, LocalDate dateAfter) {

        List<Book> books = this.bookRepository.findAllByReleaseDateAfter(dateAfter).get();
        books.forEach(b->b.setCopies(b.getCopies()+addedCopies));
        this.bookRepository.saveAllAndFlush(books);

//        for (Book book : books) {
//            book.setCopies(book.getCopies() + addedCopies);
//            this.bookRepository.saveAndFlush(book);
//        }
//        List<Book> booksUpdated = this.bookRepository.findAllByReleaseDateAfter(dateAfter).get();
        System.out.println(books.stream().mapToInt(Book::getCopies).sum());

    }

    @Override
    public Integer deleteAllCopiesLessThan(Integer copies) {
        return this.bookRepository.deleteAllByCopiesLessThan(copies);
    }

    @Override
    public Integer getBooksCountByAuthorsFirstNameAndAuthorLastName(String fullName) {
        return this.getBooksCountByAuthorsFirstNameAndAuthorLastName(fullName);
    }
}
