package perscholascs.mylibrary.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import perscholascs.mylibrary.database.dao.*;
import perscholascs.mylibrary.database.entity.Book;
import perscholascs.mylibrary.database.entity.Transaction;
import perscholascs.mylibrary.database.entity.User;
import perscholascs.mylibrary.database.entity.UserRole;
import perscholascs.mylibrary.form.RegisterFormBean;
import perscholascs.mylibrary.form.UserEditFormBean;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
public class UserController {
    @Autowired
    private UserDAO userDao;
    @Autowired
    private UserRoleDAO userRoleDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TransactionDAO transactionDao;
    @Autowired
    private BookDAO bookDao;
    @Autowired
    private CheckOutDAO checkOutDAO;


    @RequestMapping(value = "/user/profile", method = RequestMethod.GET)
    public ModelAndView profile() throws Exception {
        ModelAndView response = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
       // response.addObject("username", currentPrincipalName);
        User user= userDao.findByUserName(currentPrincipalName);
        Integer id = user.getId();
        List<Map<String,Object>> listOfBooks = checkOutDAO.checkedOutBooksByUser(id);
        response.addObject("listOfBooksKey",listOfBooks);
        response.setViewName("/user/profile");

        return response;
    }
    @RequestMapping(value = "/userListAll", method ={ RequestMethod.GET, RequestMethod.GET})
    public ModelAndView userListAll(@RequestParam(required = false) String search) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("/user/userListAll");
        if (StringUtils.isEmpty(search)) {
            List<User> users = userDao.findAll();
            response.addObject("userKey", users);
        }
        return response;

    }
    @RequestMapping(value = "/editUser", method = { RequestMethod.GET,RequestMethod.POST})
    public ModelAndView registerEditPage(@RequestParam(required = false) Integer id ) throws ParseException {
        ModelAndView response = new ModelAndView();
     //  response.setViewName("registration/register");
       response.setViewName("/user/editUser");
       if (id != null) {
            // id has been passed to this form so it is an edit
            User user = userDao.findById(id);
           System.out.println(user);
            // populate the form bean with the data loaded from the database
            UserEditFormBean form = new UserEditFormBean();
           form.setEmail(user.getEmail());
            form.setFirstName(user.getFirstName());
            form.setLastName(user.getLastName());
            form.setUserName(user.getUserName());
          form.setPassword(user.getPassword());
            SimpleDateFormat formatte = new SimpleDateFormat("yyyy-MM-dd");
            // Date date = formatter.parse(user.getDob());
            String strDate = formatte.format(user.getDob());
            form.setDob(strDate);
           form.setConfirmPassword(user.getPassword());
            // since we loaded this from the database we know the id field
            form.setId(user.getId());
            form.setAddress(user.getAddress());
            form.setPhoneNo(user.getPhoneNo());
            response.addObject("formBeanKey", form);

        }
            return response;
        }

    @RequestMapping(value = "/userEditSubmit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView userEditSubmit(@Valid RegisterFormBean form, BindingResult errors) throws Exception {
        ModelAndView response = new ModelAndView();
//              System.out.println(form);
        if (errors.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors()) {
                errorMessages.add(error.getDefaultMessage());
                System.out.println("error field = " + error.getField() + " message = " + error.getDefaultMessage());
            }
            response.addObject("errorMessages", errorMessages);
            response.addObject("formBeanKey", form);
         //   response.setViewName("registration/register");
        } else {
//            User user;
//            if (form.getId() == null) {
//                user = new User();
//            }
//            else {
            User user = userDao.findById(form.getId());
//            }
            user.setFirstName(form.getFirstName());
            user.setLastName(form.getLastName());
            user.setUserName(form.getUserName());
            user.setEmail(user.getEmail());
            user.setPassword(user.getPassword());
            user.setConfirmPassword(user.getConfirmPassword());
            user.setPhoneNo(form.getPhoneNo());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(form.getDob());
            user.setDob(date);
            user.setAddress(form.getAddress());
            //Encrypting the user password entering from form
//            String encryptedPassword = passwordEncoder.encode(form.getPassword())  ;
//            user.setPassword(encryptedPassword);
            user = userDao.save(user);
//            if (form.getId() == null) {
//                UserRole ur = new UserRole();
//                ur.setUser(user);
//                ur.setUserRole("USER");
//                userRoleDao.save(ur);
//            }
//                response.setViewName("registration/register");
            response.setViewName("redirect:/userListAll");
        }
        return response;
    }




    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam(required = false) Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/userListAll");
        User delete = userDao.findById(id);
        UserRole delete1 = userRoleDao.findByUser(id);
        if( delete!=null){
            userRoleDao.delete(delete1);
            userDao.delete(delete);
        }
        return response;
    }


}
