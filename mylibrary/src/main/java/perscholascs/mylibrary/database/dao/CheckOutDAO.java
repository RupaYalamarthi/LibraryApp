package perscholascs.mylibrary.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import perscholascs.mylibrary.database.entity.Book;
import perscholascs.mylibrary.database.entity.Checkout;
import perscholascs.mylibrary.database.entity.Transaction;
import perscholascs.mylibrary.database.entity.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;

public interface CheckOutDAO extends JpaRepository<Checkout,Long> {

    public Checkout findByUserAndStatus(@Param("user_id") User user, @Param("status") String status) ;
    public Checkout findByUserIdAndStatus(@Param("user_id")Integer id, @Param("status") String status) ;


    public Checkout findById(Integer id);
    @Query(value = "Select checkout.* FROM checkout inner JOIN transactions on transactions.checkout_id = checkout.id  WHERE checkout.id=?1", nativeQuery=true)
    public List<Checkout> findTransactionsByCheckOutId(Integer id);
    //public List<Checkout> findByUserIdAndStatus(@Param("user_id")Integer id, @Param("status") String status);
  //  Select checkout.*, books.book_name  FROM checkout inner JOIN transactions on transactions.checkout_id = checkout.id inner join
    //books on books.id = transactions.book_id group by books.id having checkout.user_id=1
    @Query(value = " Select checkout.*, books.book_name  FROM checkout inner JOIN transactions on transactions.checkout_id = checkout.id inner join books on books.id = transactions.book_id group by books.id having checkout.user_id=:userId" , nativeQuery=true)
    List<Map<String,Object>> checkedOutBooksByUser(@Param("userId") Integer id);


}
