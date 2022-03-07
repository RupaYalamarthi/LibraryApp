<jsp:include page="../include/header1.jsp" />
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div class="container" >
<table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">BookName</th>
      <th scope="col">Description</th>
      <th scope="col">Author</th>
      <th scope="col">Publisher</th>
    <th scope="col">BookType</th>
      <th scope="col">URL</th>
      <th scope="col">Edit</th>
      <th scope="col">Delete</th>

    </tr>
  </thead>
  <tbody>
  <c:forEach items = "${editBookFormBeanKey}" var="book">
    <tr>
       <td>${book.bookName}</td>
       <td>${book.description}</b></td>
       <td>${book.author}</b></td>
       <td>${book.publisher}</b></td>
       <td>${book.bookType}</td>
       <td><b>${book.url}</td>
       <td><a href = "/editBook?id=${book.id}" button class="btn btn-primary " >Edit</button></td>
       <td><a href = "/deleteBook?id=${book.id}" button class="btn btn-danger" type="submit">Delete</button></td>
    </tr>
</c:forEach>
 </tbody>
</table>
</div>
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