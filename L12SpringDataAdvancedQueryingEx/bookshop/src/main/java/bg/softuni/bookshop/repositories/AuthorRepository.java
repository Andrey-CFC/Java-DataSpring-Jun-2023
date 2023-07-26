package bg.softuni.bookshop.repositories;

import bg.softuni.bookshop.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("Select a from Author a order by size(a.books) ")
    List<Author> findAllDistinctOrderByBooks();

    List<Author> findAllByFirstNameEndingWith(String suffix);

    @Query("SELECT a.firstName,a.lastName,sum (ab.copies) as book_copies FROM Author a JOIN a.books ab GROUP BY a.id  order by book_copies DESC")
    List<String> findBooksCopiesByAuthor();
}
