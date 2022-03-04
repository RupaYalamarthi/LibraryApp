package perscholascs.mylibrary.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import perscholascs.mylibrary.database.dao.UserDAO;
import perscholascs.mylibrary.database.dao.UserRoleDAO;
import perscholascs.mylibrary.database.entity.Book;
import perscholascs.mylibrary.database.entity.User;
import perscholascs.mylibrary.database.entity.UserRole;
import perscholascs.mylibrary.form.RegisterFormBean;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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


    @RequestMapping(value = "/user/profile", method = RequestMethod.GET)
    public ModelAndView profile() throws Exception {
        ModelAndView response = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        response.addObject("username", currentPrincipalName);
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
       response.setViewName("/user/userListAll");
       if (id != null) {
            // id has been passed to this form so it is an edit
            User user = userDao.findById(id);
            // populate the form bean with the data loaded from the database
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
            form.setConfirmPassword(user.getPassword());
            // since we loaded this from the database we know the id field
            form.setId(user.getId());
            form.setAddress(user.getAddress());
            form.setPhoneNo(user.getPhoneNo());

            response.addObject("formBeanKey", form);

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
