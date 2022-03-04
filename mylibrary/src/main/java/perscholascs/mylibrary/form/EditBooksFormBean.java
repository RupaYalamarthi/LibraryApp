package perscholascs.mylibrary.form;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import perscholascs.mylibrary.validation.EmailUnique;
import perscholascs.mylibrary.validation.TwoFieldsAreEqual;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class EditBooksFormBean {
    public Integer id;
    @NotEmpty(message = "BookName is required")
    public String bookName;

    @NotEmpty(message = "Description is required")
    public String description;

    @NotEmpty(message = "AuthorName is required")
    public String author;

    private String publisher;

    public String bookType;

    @NotEmpty(message = "URL is required")
    public String url;

    private List<String> errorMessages = new ArrayList<>();

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}


