<jsp:include page="../include/header1.jsp" />
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<form method="POST" action="/addBookSubmit">
<div align="center">
<input type="hidden" name="id" value="${editBookFormBeanKey.id}">
<table cellpadding="5">
<tr><td>BookName</td>
        <td><input type="text" name ="bookName" value="${editBookFormBeanKey.bookName}"></td></tr>
<tr><td>Description</td>
        <td><input type="text" name ="description" value="${editBookFormBeanKey.description}"></td></tr>
<tr><td>Author</td>
        <td><input type="text" name ="author" value="${editBookFormBeanKey.author}"></td></tr>
<tr><td>Publisher</td>
        <td> <input type="text" name ="publisher" value="${editBookFormBeanKey.publisher}"></td></tr>
<%--<tr><td>BookType</td>
        <td> <input type="text" name ="bookType" value="${editBookFormBeanKey.bookType}"></td></tr>--%>
<tr><td>Url</td>
        <td><input type="text" name ="url" value="${editBookFormBeanKey.url}"></td></tr>
</table>
<tr><td align="center"><button type="submit" class="btn btn-primary" role="button">Submit</button>

</div>
</form>
<div>
  <c:forEach items="${editBookFormBeanKey.errorMessages}" var="message">
        <span style="color:red">${message}</span><br>
    </c:forEach>
</div>