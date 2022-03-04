//package perscholascs.mylibrary.database.dao;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Rollback;
//import perscholascs.mylibrary.database.entity.Book;
//import perscholascs.mylibrary.database.entity.User;
//
//import java.util.Date;
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//
//public class bookDAOTest  {
//    @Autowired
//    private BookDAO bookDAO;
//    @Test
//    @Rollback(false)
//    public void testCreateBook()
//    {
//
//        Book book = new Book();
//       book.setBookName("TesBook");
//       book.setDescription("TestDescription");
//       book.setAuthor("Rupa");
//       book.setUrl("/pub/images/test.img");
//       bookDAO.save(book);
//        Book book1 = bookDAO.findByBookName("TesBook");
//        Assertions.assertEquals("TestDescription", book1.getBookName());
//        Assertions.assertEquals("Erik@gmail.com", book1.getDescription());
//        Assertions.assertEquals("Rupa", book1.getAuthor());
//        Assertions.assertEquals("/pub/images/test.img", book1.getUrl());
//    }
//    @Test
//    @Rollback(false)
//    public void testDeleteUser()
//    {
//        User user = userDAO.findByUserName("Erik");
//        userDAO.delete(user);
//        Assertions.assertEquals(null,userDAO.findByUserName("Erik"));
//    }
//    @Test
//    //  @Rollback(false)
//    public void testEditUser()
//    {
//        User user = userDAO.findByUserName("qwe");
//        user.setFirstName("ErikV");
//        Assertions.assertEquals("ErikV",userDAO.findByUserName("qwe").getFirstName());
//    }
//
//    @Test
//    public void testFindById()
//    {
//        User user = userDAO.findById(1);
//        Assertions.assertEquals("Rupa", user.getFirstName());
//        Assertions.assertEquals("yalamarthyrupa@gmail.com", user.getEmail());
//        Assertions.assertEquals("9717247327", user.getPhoneNo());
//        Assertions.assertEquals("qeqeq", user.getAddress());
//        Assertions.assertEquals("Yalamarthi", user.getLastName());
//        Assertions.assertEquals("Rupa", user.getUserName());
//
//    }
//
//}
//}
