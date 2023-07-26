package bg.softuni.bookshop.services;

import bg.softuni.bookshop.entities.Author;
import bg.softuni.bookshop.entities.Book;
import bg.softuni.bookshop.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;
    private BookService bookService;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, BookService bookService) {
        this.authorRepository = authorRepository;
        this.bookService = bookService;
    }

    @Override
    public boolean isDataSeeded() {
        return this.authorRepository.count() > 0;
    }

    @Override
    public void seedAuthors(List<Author> authors) {
        this.authorRepository.saveAllAndFlush(authors);
    }

    @Override
    public Author getRandomAuthor() {
        long count = this.authorRepository.count();
        if (count != 0) {
            long randomId = new Random().nextLong(1, count) + 1;
            return this.authorRepository.findById(randomId).orElseThrow(NoSuchElementException::new);
        }
        throw new RuntimeException();
    }

    @Override
    public List<Author> getAllAuthorsWithBooksBeforeGivenYear(LocalDate date) {
        List<Author> authors = this.bookService.getAllBooksBeforeGivenYear(date)
                .stream()
                .map(Book::getAuthor)
                .toList();

        System.out.println(authors.stream().map(Author::getAuthorFullName).collect(Collectors.joining("%n")));
        return authors;
    }

    @Override
    public List<Author> getAllAuthorsOrderByBooksDescending() {
        List<Author> authors = this.authorRepository.findAllDistinctOrderByBooks();

        System.out.println(authors.stream().map(Author::getAuthorFullNameAndCountOfBooks).collect(Collectors.joining("%n")));
        return authors;
    }

    @Override
    public List<Author> getAllByFirstNameEndingWith(String suffix) {
        final List<Author> authors = this.authorRepository.findAllByFirstNameEndingWith(suffix);
        authors.forEach(a -> System.out.println(a.getAuthorFullName()));
        return authors;
    }

    @Override
    public List<String> getTotalBookCopies() {
        List<String> authors = this.authorRepository.findBooksCopiesByAuthor().stream()
                .map(author -> {
                    String[] authorInput = author.split(",");
                    String result = authorInput[0] + " " + authorInput[1] + " - " + authorInput[2];
                    return result;
                }).toList();
        authors.forEach(System.out::println);
        return authors;
    }
}
