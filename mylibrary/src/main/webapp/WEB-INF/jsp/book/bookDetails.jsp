<jsp:include page="../include/header1.jsp" />
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%--<form method="POST" action="/cart">
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
<tr><td>BookType</td>
        <td> <input type="text" name ="bookType" value="${editBookFormBeanKey.bookType}"></td></tr>
<tr><td>Url</td>
        <td><input type="text" name ="url" value="${editBookFormBeanKey.url}"></td></tr>
<tr><td><button type="submit" >Submit </button></td></tr>
<tr><td>Image</td>
        </tr>

</table>
<tr><td align="center"><button type="submit" class="btn btn-primary" role="button">Submit</button>--%>
<div class="card" style="width: 18rem;">
  <img class="card-img-top" src="${editBookFormBeanKey.url}" alt="Card image cap">
  <div class="card-body">
  <h5 class="card-title">BookName:${editBookFormBeanKey.bookName}</h5>

  Description: ${editBookFormBeanKey.description}<br/>
  Author:${editBookFormBeanKey.author}<br/>
  Publisher:${editBookFormBeanKey.publisher}<br/>
  BookType:${editBookFormBeanKey.bookType}<br/>
<%--  <sec:authorize access="hasAnyAuthority('ADMIN', 'USER')">
    <a href="/cart" class="btn btn-primary">Add To Cart</a>
    </sec:authorize>--%>
    <sec:authorize access="isAuthenticated()">
    <a href="${editBookFormBeanKey.id}/addToCart" class="btn btn-primary">Add To Cart</a>

         </sec:authorize>
         <sec:authorize access="!isAuthenticated()">
    <a href="/login/login" class="btn btn-primary">Add To Cart</a>

         </sec:authorize>
  </div>
</div>
</div>
</form>


<jsp:include page="../include/footer.jsp" />
