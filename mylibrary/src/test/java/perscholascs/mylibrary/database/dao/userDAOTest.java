package perscholascs.mylibrary.database.dao;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import perscholascs.mylibrary.database.entity.User;

import java.time.LocalDate;
import java.util.Date;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@SpringBootTest

public class userDAOTest {
//    @Autowired
//    private TestEntityManager entityManager;

    @Autowired
    private UserDAO userDAO;
    @Test
   @Rollback(false)
    public void testCreateUser()
    {
       // entityManager.persist(new User());
       User user1 = new User();
       user1.setFirstName("Erik");
       user1.setLastName("V");
       user1.setEmail("Erik@gmail.com");
       user1.setPhoneNo("3245235357");
       user1.setUserName("Erik");
       Date date = new Date( );
       user1.setDob(date);

       user1.setPassword("erik");
        user1.setConfirmPassword("erik");
        user1.setAddress("abcd");
        userDAO.save(user1);
        User user = userDAO.findByUserName("Erik");
        Assertions.assertEquals("Erik", user.getFirstName());
        Assertions.assertEquals("Erik@gmail.com", user.getEmail());
        Assertions.assertEquals("3245235357", user.getPhoneNo());
        Assertions.assertEquals("abcd", user.getAddress());
        Assertions.assertEquals("V", user.getLastName());
        Assertions.assertEquals("Erik", user.getUserName());
    }
    @Test
    @Rollback(false)
    public void testDeleteUser()
    {
        User user = userDAO.findByUserName("Erik");
        userDAO.delete(user);
        Assertions.assertEquals(null,userDAO.findByUserName("Erik"));
    }
    @Test
  //  @Rollback(false)
    public void testEditUser()
    {
        User user = userDAO.findByUserName("qwe");
        user.setFirstName("ErikV");
        Assertions.assertEquals("ErikV",userDAO.findByUserName("qwe").getFirstName());
    }

    @Test
    public void testFindById()
    {
        User user = userDAO.findById(1);
        Assertions.assertEquals("Rupa", user.getFirstName());
        Assertions.assertEquals("yalamarthyrupa@gmail.com", user.getEmail());
        Assertions.assertEquals("9717247327", user.getPhoneNo());
        Assertions.assertEquals("qeqeq", user.getAddress());
        Assertions.assertEquals("Yalamarthi", user.getLastName());
        Assertions.assertEquals("Rupa", user.getUserName());

    }

}
