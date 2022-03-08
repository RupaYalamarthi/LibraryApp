package perscholascs.mylibrary.validation;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import perscholascs.mylibrary.database.dao.UserDAO;
import perscholascs.mylibrary.database.entity.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUniqueImpl implements ConstraintValidator<EmailUnique, String> {
    public static final Logger LOG = LoggerFactory.getLogger(EmailUniqueImpl.class);
    @Autowired
    private UserDAO userDao;
    @Override
    public void initialize(EmailUnique constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
//        if (StringUtils.isEmpty(value)) {
//            return false;
//        }
//        boolean passes = !StringUtils.equals(value, "a@b.com");
//        return (passes);
//    }
    if ( StringUtils.isEmpty(value) ) {
        return true;
    }

    //boolean passes = ! StringUtils.equals(value, "a@b.com");
    User user = userDao.findByEmail(value);

        return ( user == null );
}
}