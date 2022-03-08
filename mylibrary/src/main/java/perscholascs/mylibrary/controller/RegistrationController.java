package perscholascs.mylibrary.controller;

import org.apache.commons.lang3.StringUtils;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import perscholascs.mylibrary.database.dao.UserDAO;
import perscholascs.mylibrary.database.dao.UserRoleDAO;
import perscholascs.mylibrary.database.entity.User;
import perscholascs.mylibrary.database.entity.UserRole;
import perscholascs.mylibrary.form.RegisterFormBean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Controller
public class RegistrationController {
    public static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDAO userRoleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(@RequestParam(required = false) Integer id) throws Exception {
//        ModelAndView response = new ModelAndView();
//        response.setViewName("registration/register");
//        RegisterFormBean form = new RegisterFormBean();
//        response.addObject("formBeanKey", form);
//        return response;
        ModelAndView response = new ModelAndView();
        response.setViewName("registration/register");
        if (id != null) {
            User user = userDao.findById(id);
            RegisterFormBean form = new RegisterFormBean();
            form.setEmail(user.getEmail());
            form.setFirstName(user.getFirstName());
            form.setLastName(user.getLastName());
            form.setUserName(user.getUserName());
            form.setPassword(user.getPassword());
            SimpleDateFormat formatte = new SimpleDateFormat("yyyy-MM-dd");
            // Date date = formatter.parse(user.getDob());
            String strDate = formatte.format(user.getDob());
            form.setDob(strDate);
            form.setConfirmPassword(user.getConfirmPassword());
            // since we loaded this from the database we know the id field
            form.setId(user.getId());
            form.setAddress(user.getAddress());
            form.setPhoneNo(user.getPhoneNo());
            response.addObject("formBeanKey", form);
        } else {
            //id has not been passed to this form so it is a create
            RegisterFormBean form = new RegisterFormBean();
            response.addObject("formBeanKey", form);
        }
        return response;
    }

    @RequestMapping(value = "/registerSubmit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult errors) throws Exception {
        ModelAndView response = new ModelAndView();
//              System.out.println(form);
        if (errors.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();
//            for (FieldError error : errors.getFieldErrors()) {
//                errorMessages.add(error.getDefaultMessage());
//                LOG.debug("error field = " + error.getField() + " message = " + error.getDefaultMessage());
//            }
            if(errors.hasErrors()){
                errors.getFieldErrors().forEach(error -> {
                    errorMessages.add(error.getDefaultMessage());
                LOG.debug("error field = " + error.getField() + " message = " + error.getDefaultMessage());
                });
            }
            response.addObject("errorMessages", errorMessages);
            response.addObject("formBeanKey", form);
            response.setViewName("registration/register");
        } else {
            User user;
            if (form.getId() == null) {
                user = new User();
            }
            else {
                user = userDao.findById(form.getId());
            }
                user.setFirstName(form.getFirstName());
                user.setLastName(form.getLastName());
                user.setUserName(form.getUserName());
                user.setEmail(form.getEmail());
                user.setPassword(form.getPassword());
                user.setConfirmPassword(form.getConfirmPassword());
                user.setPhoneNo(form.getPhoneNo());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(form.getDob());
            user.setDob(date);
            user.setAddress(form.getAddress());
            //Encrypting the user password entering from form
            String encryptedPassword = passwordEncoder.encode(form.getPassword())  ;
            user.setPassword(encryptedPassword);
            user = userDao.save(user);
                if (form.getId() == null) {
                    UserRole ur = new UserRole();
                    ur.setUser(user);
                    ur.setUserRole("USER");
                    userRoleDao.save(ur);
                }
//                response.setViewName("registration/register");
             response.setViewName("redirect:/index");
        }
        return response;
        }
 }



