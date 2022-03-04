package perscholascs.mylibrary.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import perscholascs.mylibrary.database.entity.Book;
import perscholascs.mylibrary.database.entity.User;

import java.util.List;

public interface BookDAO extends JpaRepository<Book, Long> {
    public List<Book> findByBookNameContainingIgnoreCase(@Param("bookName") String bookName) ;
    public Book findById(@Param("id") Integer id);
    @Query(value="Select * from books where status <> 'checkedout'",nativeQuery = true)
    List<Book>  displayAvailablebooks();
    public Book findByBookName(String bname);

}
