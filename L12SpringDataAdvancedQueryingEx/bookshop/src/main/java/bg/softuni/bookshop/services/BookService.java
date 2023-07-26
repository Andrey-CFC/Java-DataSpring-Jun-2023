package bg.softuni.bookshop.services;

import bg.softuni.bookshop.entities.Book;
import bg.softuni.bookshop.model.BookPrintInformation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    boolean isDataSeeded();

    void seedBooks(List<Book> books);

    List<Book> getAllBooksAfterGivenYear(LocalDate date);

    List<Book> getAllBooksBeforeGivenYear(LocalDate date);

    List<Book> getAllBooksBeforeGivenDate(LocalDate date);

    List<Book> getAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);

    List<Book> getAllByAgeRestriction(String ageRestriction);

    List<Book> getAllByEditionTypeAndCopiesOver(String editionType, Integer copiesToCompare);

    List<Book> getAllByPriceNotBetween(BigDecimal lowerBoundary, BigDecimal upperBoundary);

    List<Book> getAllBooksNotReleasedInYear(Integer year);

    List<Book> getAllByTitleContaining(String contains);

    List<Book> getAllByAuthorLastNameStartsWith(String prefix);

    Integer getAllByTitleLengthGreaterThan(Integer length);

    List<BookPrintInformation> getAllByTitle(String title);

    void increaseCopiesForBookReleasedAfter(Integer addedCopies, LocalDate dateAfter);

    Integer deleteAllCopiesLessThan(Integer copies);

    Integer getBooksCountByAuthorsFirstNameAndAuthorLastName(String fullName);
//
//    @Transactional
//    int deleteBooks(int copies);
//
//    int storedProcedureCall(String firstName, String lastName);
}
