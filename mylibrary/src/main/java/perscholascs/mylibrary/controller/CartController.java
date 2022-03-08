package perscholascs.mylibrary.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import perscholascs.mylibrary.database.dao.BookDAO;
import perscholascs.mylibrary.database.dao.CheckOutDAO;
import perscholascs.mylibrary.database.dao.TransactionDAO;
import perscholascs.mylibrary.database.dao.UserDAO;
import perscholascs.mylibrary.database.entity.Book;
import perscholascs.mylibrary.database.entity.Checkout;
import perscholascs.mylibrary.database.entity.Transaction;
import perscholascs.mylibrary.database.entity.User;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CheckOutDAO checkOutDao;
    @Autowired
    private BookDAO bookDao;
    @Autowired
    private UserDAO userDao;
    @Autowired
    private TransactionDAO transactionDao;



    @RequestMapping(value = "{bookId}/addToCart", method = RequestMethod.GET)
    // @RequestMapping(value = "/addToCart?id=${book.id}", method = RequestMethod.GET)
    public ModelAndView addToCart(@PathVariable("bookId") Integer bookId) throws Exception {
        ModelAndView response = new ModelAndView();
        // System.out.println("bookid is"+bookId);
        Book book = bookDao.findById(bookId);
        // System.out.println("book is"+ book);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userDao.findByUserName(currentPrincipalName);
        Checkout checkout = checkOutDao.findByUserAndStatus(user, "cart");
       // Transaction transaction = transactionDao.findByBookIdAndCheckoutId(bookId,checkout.getId());
        if(checkout==null){
            checkout = new Checkout();
            checkout.setStatus("cart");
            checkout.setUser(user);
            checkOutDao.save(checkout);
            Transaction transaction1 = new Transaction();
            transaction1.setBook(book);
            book.setStatus("hold");
            transaction1.setCheckout(checkout);
            transactionDao.save(transaction1);
            response.setViewName("redirect:/index");

        }
        else {
        Transaction transaction = transactionDao.findByBookIdAndCheckoutId(bookId,checkout.getId());
            if(transaction==null){
                Transaction transaction1 = new Transaction();
                transaction1.setBook(book);
                book.setStatus("hold");

                transaction1.setCheckout(checkout);
                transactionDao.save(transaction1);
                response.setViewName("redirect:/index");

            }
            else{
            response.setViewName("/cart/bookPresentCart");}
        }


        return response;
    }
    //write a method name it cartReady , should receive userid as parameter or from authentication
    //check your checkout table if it has this user id with status cart
    //If it has a user id with status cart get the checkout id
    //Query the transaction table using your check-out id.
    //Should bring 1 or null or list
    //Send this list to Cart jsp page

    @RequestMapping(value = "/cartReady", method = RequestMethod.GET)
    public ModelAndView cartReady() throws Exception {
        ModelAndView response = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userDao.findByUserName(currentPrincipalName);
        if(user.getId()!=null) {
            Checkout checkout = checkOutDao.findByUserIdAndStatus(user.getId(), "cart");
            // System.out.println("checkout details" +checkout);
            if (checkout != null) {

                List<Transaction> transactions = transactionDao.findByCheckout(checkout);
                // System.out.println("Transactions"+ transactions);
                response.addObject("transactionKey", transactions);
                response.setViewName("/cart/cartReady");
            }
            // }
            else {
                System.out.println("Your Cart is empty");
                response.setViewName("/cart/cartEmpty");
            }
        }

        return response;
    }

    @RequestMapping(value = "/proceedToCheckOut", method = RequestMethod.GET)
    public ModelAndView proceedToCheckOut() throws Exception {
        ModelAndView response = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userDao.findByUserName(currentPrincipalName);
        Checkout checkout = checkOutDao.findByUserIdAndStatus(user.getId(),"cart");
        //System.out.println(checkout);
        if(checkout!=null){
        List<Transaction> transactions = transactionDao.findByCheckout(checkout);
//for loop go to each book change the status of the book to available.
      //  after the loop change the status of checkout and upadate the dates...

        for(Transaction transaction : transactions){
            Book book = transaction.getBook();
            System.out.println(book);
            book.setStatus("NotAvailable");
        }
            checkout.setStatus("complete");
            Date date = new Date();
            checkout.setCheckoutDate(date);
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, 10);
            Date returnDate = c.getTime();
            checkout.setDueDate(returnDate);
            checkOutDao.save(checkout);
        response.setViewName("/cart/transaction");}
    else {
        System.out.println("Your Cart is empty");
        response.setViewName("/cart/cartEmpty");
    }
        return response;

    }
    @RequestMapping(value = "{bookId}/deleteFromCart", method = RequestMethod.GET)
    public ModelAndView deleteFromCart(@PathVariable("bookId") Integer bookId) throws Exception {
        ModelAndView response = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Book book = bookDao.findById(bookId);
        User user = userDao.findByUserName(currentPrincipalName);
        Checkout checkout = checkOutDao.findByUserIdAndStatus(user.getId(),"cart");
      //  List<Transaction> transactions= transactionDao.findByCheckout(checkout);
        if(checkout!=null){
        Transaction transaction = transactionDao.findByBookIdAndCheckoutId(bookId,checkout.getId());
       // System.out.println(checkout);
       // System.out.println(transaction);
        book.setStatus("Available");
        transactionDao.delete(transaction);
        //checkOutDao.delete(checkout);
        }
        response.setViewName("redirect:/cartReady");

        return response;
    }
}
