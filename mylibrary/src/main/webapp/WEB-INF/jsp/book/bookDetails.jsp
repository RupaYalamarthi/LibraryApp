<jsp:include page="../include/header1.jsp" />
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


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



