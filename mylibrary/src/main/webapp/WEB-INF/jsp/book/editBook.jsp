<jsp:include page="../include/header1.jsp" />
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<form method="POST" action="/addBookSubmit">
<div class="container">
<input type="hidden" name="id" value="${editBookFormBeanKey.id}">
<div class="form-row">
    <div class="col-md-4 mb-3">
      <label>BookName</label>
      <input type="text" class="form-control" name ="bookName"  placeholder="BookName" value="${editBookFormBeanKey.bookName}">
    </div>
    <div class="col-md-4 mb-3">
      <label>Description</label>
      <input type="text" class="form-control" name ="description"  placeholder="Description" value="${editBookFormBeanKey.author}" >
    </div>

    <div class="col-md-4 mb-3">
      <label>Author</label>
          <input type="text" class="form-control" name ="author" placeholder="Author" value="${editBookFormBeanKey.author}" >
    </div>
  </div>
  <div class="form-row">
    <div class="col-md-3 mb-3">
       <label>Publisher</label>
           <input type="text" class="form-control" name ="publisher" placeholder="Publisher" value="${editBookFormBeanKey.publisher}" >
    </div>
  <div class="col-md-3 mb-3">
           <label>BookType</label>
               <input type="text" class="form-control" name ="bookType" placeholder="BookType" value="${editBookFormBeanKey.bookType}" >
    </div>
    <div class="col-md-6 mb-3">
      <label>Url</label>
      <input type="text" class="form-control" name ="url" placeholder="Url" value="${editBookFormBeanKey.url}">
    </div>
  </div>
  <button class="btn btn-primary" type="submit">Submit</button>
 </div>
</form>
<div>
  <c:forEach items="${editBookFormBeanKey.errorMessages}" var="message">
        <span style="color:red">${message}</span><br>
    </c:forEach>
</div>
