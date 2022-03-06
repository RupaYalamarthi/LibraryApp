package perscholascs.mylibrary.database.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import perscholascs.mylibrary.database.entity.Book;
import perscholascs.mylibrary.database.entity.User;

import java.util.Date;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class bookDAOTest  {
    @Autowired
    private BookDAO bookDAO;
    @Test
    @Rollback(false)
    public void testCreateBook()
    {
        Book book = new Book();
        book.setBookName("TesBook1");
        book.setDescription("TestDescription");
        book.setAuthor("Rupa");
        book.setUrl("/pub/images/test.img");
        bookDAO.save(book);
        Book book1 = bookDAO.findByBookName("TesBook1");
       // Assertions.assertEquals("TesBook", book1.getBookName());
        Assertions.assertEquals("TestDescription", book1.getDescription());
        Assertions.assertEquals("Rupa", book1.getAuthor());
        Assertions.assertEquals("/pub/images/test.img", book1.getUrl());
    }




        @Test
      @Rollback(false)
    public void testDeleteBook()
    {
        Book book1 = bookDAO.findByAuthor("Rupa");
        bookDAO.delete(book1);
        Assertions.assertEquals(null,bookDAO.findByAuthor("Rupa"));
    }

    @Test
    // @Rollback(false)
    public void testEditBook()
    {
        Book book1 = bookDAO.findByAuthor("Anthony Falco");
        book1.setBookName("Pizza CzarS");
        Book book2=bookDAO.findByAuthor("Anthony Falco");
        Assertions.assertEquals("Pizza CzarS",book2.getBookName());
    }



    @Test
    public void testFindById()
    {
        Book book = bookDAO.findById(2);
        Assertions.assertEquals("The paper Palace", book.getBookName());
        Assertions.assertEquals("Fiction", book.getBookType());
        Assertions.assertEquals("/pub/images/PaperPalace.jfif", book.getUrl());
        Assertions.assertEquals("Miranda Cowley Heller", book.getAuthor());
        Assertions.assertEquals("Penguin Publishing Group", book.getPublisher());

    }

}
