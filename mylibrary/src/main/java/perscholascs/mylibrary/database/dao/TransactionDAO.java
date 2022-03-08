package perscholascs.mylibrary.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import perscholascs.mylibrary.database.entity.Book;
import perscholascs.mylibrary.database.entity.Checkout;
import perscholascs.mylibrary.database.entity.Transaction;
import perscholascs.mylibrary.database.entity.User;

import java.util.List;

public interface TransactionDAO extends JpaRepository<Transaction,Long> {
    public Transaction  findByBookIdAndCheckoutId(@Param("book_id") Integer bookId, @Param("chekout_id") Integer checkOutId) ;
    public List<Transaction> findByCheckout(@Param("chekout_id") Checkout checkout) ;

    public Transaction  findByBookId(@Param("book_id") Integer bookId);
//    @Query(value = "Select transactions.* FROM checkout inner JOIN transactions on transactions.checkout_id = checkout.id inner join books on books.id = transactions.book_id group by books.id having checkout.user_id=:userId" , nativeQuery=true)
//    public List<Transaction> findBYUserTrans(Integer id);

}
