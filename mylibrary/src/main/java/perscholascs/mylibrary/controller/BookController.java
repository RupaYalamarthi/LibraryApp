package perscholascs.mylibrary.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import perscholascs.mylibrary.database.dao.BookDAO;
import perscholascs.mylibrary.database.entity.Book;

import perscholascs.mylibrary.database.entity.User;
import perscholascs.mylibrary.database.entity.UserRole;
import perscholascs.mylibrary.form.EditBooksFormBean;
import perscholascs.mylibrary.form.RegisterFormBean;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookDAO bookDao;
    @RequestMapping(value = "/bookSearch", method = RequestMethod.GET)
    public ModelAndView bookSearch(@RequestParam(required = false) String search) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("book/bookSearch");
        if (!StringUtils.isEmpty(search)) {
            List<Book> books = bookDao.findByBookNameContainingIgnoreCase(search);
            response.addObject("bookKey", books);
            response.addObject("searchInput", search);
//            System.out.println(books);
        }
        else{
            List<Book> books = bookDao.findAll();
        response.addObject("bookKey", books);
        }
        return response;
    }
    @RequestMapping(value = {"/","/bookList","/index"}, method = RequestMethod.GET)
    public ModelAndView bookList(@RequestParam(required = false) Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        List<Book> books = bookDao.displayAvailablebooks();
        response.addObject("bookKey", books);
        response.setViewName("book/bookList");
        return response;
    }
    @RequestMapping(value = "/addBook", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView addBook(@RequestParam(required = false) Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("book/addBook");
        EditBooksFormBean form1 = new EditBooksFormBean();
        response.addObject("editBookFormBeanKey", form1);
        return response;
    }
    @RequestMapping(value = "/addBookSubmit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView addBookSubmit(@Valid EditBooksFormBean form1, BindingResult errors) throws Exception {
        ModelAndView response = new ModelAndView();
        //        System.out.println(form);
       if (errors.hasErrors()) {
            for (FieldError error : errors.getFieldErrors()) {
                form1.getErrorMessages().add(error.getDefaultMessage());
                System.out.println("error field = " + error.getField() + " message = " + error.getDefaultMessage());
            }
            response.addObject("editBookFormBeanKey", form1);
            response.setViewName("book/addBook");
        }
      else {
            Book book;
            if (form1.getId() == null) {
                book = new Book();
            }
            else {
                book = bookDao.findById(form1.getId());
            }
        book.setBookName(form1.getBookName());
        book.setDescription(form1.getDescription());
        book.setAuthor(form1.getAuthor());
        book.setPublisher(form1.getPublisher());
        book.setBookType(form1.getBookType());
        book.setUrl(form1.getUrl());
        book = bookDao.save(book);}
        response.setViewName("book/addBook");
        return response;
    }

    @RequestMapping(value = "/editBook", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView editBook(@RequestParam(required = false) Integer id ) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("/book/editBook");
        if (id != null) {
            // id has been passed to this form so it is an edit
            Book book = bookDao.findById(id);

            // populate the form bean with the data loaded from the database
            EditBooksFormBean form1 = new EditBooksFormBean();
            form1.setBookName(book.getBookName());
            form1.setDescription(book.getDescription());
            form1.setAuthor(book.getAuthor());
            form1.setPublisher(book.getPublisher());
            form1.setBookType(book.getBookType());
            form1.setId(book.getId());
            form1.setUrl(book.getUrl());
            response.addObject("editBookFormBeanKey", form1);
        }
        // response.setViewName("book/editBook");
        return response;
    }
    @RequestMapping(value = "/bookListAll", method = RequestMethod.GET)
    public ModelAndView bookListAll(@RequestParam(required = false) String search) throws Exception {
        ModelAndView response = new ModelAndView();
       response.setViewName("/book/bookListAll");
        if (StringUtils.isEmpty(search)) {
        List<Book> books = bookDao.findAll();
        response.addObject("editBookFormBeanKey", books);
        }
        return response;

    }
    @RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam(required = false) Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/bookListAll");

        Book delete = bookDao.findById(id);
        if( delete!=null){
            bookDao.delete(delete);
        }
        return response;
    }
    @RequestMapping(value = "/bookDetails", method = RequestMethod.GET)
    public ModelAndView bookDetails(@RequestParam(required = false) Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("/book/bookDetails");


        if (id != null) {
            // id has been passed to this form so it is an edit
            Book book = bookDao.findById(id);

            // populate the form bean with the data loaded from the database
            EditBooksFormBean form1 = new EditBooksFormBean();
            form1.setBookName(book.getBookName());
            form1.setDescription(book.getDescription());
            form1.setAuthor(book.getAuthor());
            form1.setPublisher(book.getPublisher());
            form1.setBookType(book.getBookType());
            form1.setId(book.getId());
            form1.setUrl(book.getUrl());
            response.addObject("editBookFormBeanKey", form1);
        }
        return response;
    }


}
