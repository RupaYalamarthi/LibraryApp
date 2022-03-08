<jsp:include page="../include/header1.jsp" />
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%-- Delete button functionality --%>
<script>
    $(document).ready(function () {
        $('.btn-delete').click(function () {
            var id = $(this).parents('tr').children('td:first').html()
            var bookName = $(this).parents('tr').children('td:nth-child(2)').html()
            var delConfirm = confirm('Are you sure you want to delete the ' + bookName + '?')

            if (delConfirm == true) {
                window.location.href = '/deleteBook?id=' + id
            }
        })
    })
</script>
<div class="container"  >

<table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">BookName</th>
    <%--  <th scope="col">Description</th>--%>
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
      <td hidden>${book.id}</td>
       <td>${book.bookName}</td>
     <%--  <td>${book.description}</td>--%>
       <td>${book.author}</td>
       <td>${book.publisher}</td>
       <td>${book.bookType}</td>
       <td>${book.url}</td>
       <td><a href = "/editBook?id=${book.id}" button class="btn btn-primary " >Edit</button></td>
       <td><button   class="btn btn-danger btn-delete" type="button">Delete</button></td>
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

    }

</style>
<jsp:include page="../include/footer.jsp" />