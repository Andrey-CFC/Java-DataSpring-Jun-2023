package bg.softuni.bookshop.services;

import bg.softuni.bookshop.entities.Book;

import java.time.LocalDate;
import java.util.List;

public interface BookService {
    boolean isDataSeeded();

    void seedBooks(List<Book> books);

    List<Book> getAllBooksAfterGivenYear(LocalDate date);

    List<Book> getAllBooksBeforeGivenYear(LocalDate date);

    List<Book> getAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);

}
