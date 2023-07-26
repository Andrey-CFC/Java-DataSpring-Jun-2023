package bg.softuni.bookshop.repositories;

import bg.softuni.bookshop.entities.Book;
import bg.softuni.bookshop.enums.AgeRestriction;
import bg.softuni.bookshop.enums.EditionType;
import bg.softuni.bookshop.model.BookPrintInformation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<List<Book>> findAllByReleaseDateAfter(LocalDate date);

    Optional<List<Book>> findAllByReleaseDateBefore(LocalDate date);

    List<Book> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copiesToCompare);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lowerBoundary, BigDecimal upperBoundary);

    @Query("SELECT b FROM Book AS b WHERE EXTRACT(YEAR FROM b.releaseDate) != :year")
    List<Book> findAllByReleaseDateYearNot(@Param("year") Integer year);

    List<Book> findAllByTitleContaining(String contains);

    List<Book> findAllByAuthor_LastNameStartsWith(String prefix);

    @Query("Select count(b) from Book b where length(b.title) > :length")
    Integer findAllByTitleLengthGreaterThan(Integer length);

    @Query("SELECT new bg.softuni.bookshop.model.BookPrintInformation(b.title, b.editionType, b.ageRestriction, b.price) FROM Book b WHERE b.title=:title")
    List<BookPrintInformation> findAllByTile(String title);

    @Transactional
    Integer deleteAllByCopiesLessThan(Integer copies);

    @Procedure("usp_get_book_written_by")
    Integer getBooksCountByAuthorsFullName(String fullName);

    @Procedure("total_number_of_books")
    int callProcedure(@Param(value = "first_name") String firstName, @Param(value = "last_name") String lastName);

    @Query(value = "CALL total_number_of_books (:first_name, :last_name);", nativeQuery = true)
    int storedProcedureCall(@Param(value = "first_name") String firstName, @Param(value = "last_name") String lastName);

}
