<jsp:include page="../include/header1.jsp" />
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%--<form method="GET" action="/book/bookListAll" >
</form>--%>

   <table border="1">
     <tr>
          <td><b>BookName</b></td>
          <td><b>Description</b></td>
          <td><b>Author</b></td>
          <td><b>Publisher</b></td>
      <%--    <td><b>BookType</b></td>--%>
          <td><b>URL</b></td>
          <td><b>Edit</b></td>
          <td><b>Delete</b></td>
     </tr>
   <c:forEach items = "${editBookFormBeanKey}" var="book">
      <tr>
           <td>${book.bookName}</td>
           <td>${book.description}</td>
           <td>${book.author}</td>
           <td>${book.publisher}</td>
        <%--   <td>${book.bookType}</td>--%>
           <td>${book.url}</td>



       <td><a href = "/editBook?id=${book.id}">Edit</td>
           <td><a href = "/deleteBook?id=${book.id}">Delete</td>

      </tr>
</c:forEach>
</table>
<style>
td
{
 max-width: 300px;
 overflow: hidden;
 text-overflow: ellipsis;
 white-space: nowrap;
}
</style>
<jsp:include page="../include/footer.jsp" />