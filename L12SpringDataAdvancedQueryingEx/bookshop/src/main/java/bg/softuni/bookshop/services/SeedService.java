package bg.softuni.bookshop.services;

import java.io.IOException;

public interface SeedService {
    void seedAuthors() throws IOException;

    void seedBooks() throws IOException;

    void seedCategories() throws IOException;

    default void seedAllDate() throws IOException {
        seedAuthors();
        seedBooks();
        seedCategories();
    }

}
