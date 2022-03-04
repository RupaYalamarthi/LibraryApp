package perscholascs.mylibrary.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
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

}
