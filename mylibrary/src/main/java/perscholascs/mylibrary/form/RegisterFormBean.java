package perscholascs.mylibrary.form;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;
import perscholascs.mylibrary.validation.EmailUnique;
import perscholascs.mylibrary.validation.TwoFieldsAreEqual;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@TwoFieldsAreEqual(fieldOneName = "confirmPassword", fieldTwoName = "password", message = "Password and Conform Password must be the same.")
public class RegisterFormBean {
    public Integer id;
    @NotEmpty(message = "Email is required")
    @Pattern(regexp = "^.+@.+$", message="Please provide a valid E-mail format")
    @EmailUnique(message = "Email must be Unique")
    public String email;

    @NotEmpty(message = "FirstName is required")
    //@Length(min = 1, max = 50, message = "First Name must be between 1 and 45 character in length.")
    public String firstName;

    @NotEmpty(message = "LastName is required")
    public String lastName;

    @NotEmpty(message = "UserName is required")
    private String userName;

    public String password;
    public String confirmPassword;

    @NotEmpty(message = "PhoneNumber is required")
    public String phoneNo;

    @NotEmpty(message = "Address is required")
    private String address;

    @NotEmpty(message = "DateOfBirth is required")
    private String dob;

    private List<String> errorMessages = new ArrayList<>();

    @Override
    public String toString() {

        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
