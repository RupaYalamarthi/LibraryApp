<jsp:include page="../include/header1.jsp" />
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div class="container">
   <table class="table table-striped table-dark">
     <thead>
       <tr>
         <th scope="col">CheckOutdate</th>
         <th scope="col">DueDate</th>
         <th scope="col">BookName</th>
       </tr>
     </thead>
     <tbody>
     <c:forEach items = "${listOfBooksKey}" var="book">
       <tr>
          <td>${book.checkout_date}</td>
          <td>${book.due_date}</b></td>
          <td>${book.book_name}</b></td>
       </tr>
   </c:forEach>
    </tbody>
   </table>
</div>
<jsp:include page="../include/footer.jsp" />







