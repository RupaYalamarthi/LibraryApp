<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="../include/header1.jsp" />
<%--<form method="GET" action="/registration-url-path/userListAll">
<input type="text" name="search">
    <button type="submit">Search</button>
</form>--%>
   <table border="1">
     <tr>
          <td><b>FirstName</b></td>
          <td><b>LastName</b></td>
          <td><b>Email</b></td>
          <td><b>PhoneNumber</b></td>
          <td><b>DateOfBirth</b></td>
          <td><b>Address</b></td>
          <td><b>Username</b></td>
          <td><b>Edit</b></td>
       <%--   <td><b>Delete</b></td>--%>
     </tr>
    <c:forEach items = "${userKey}" var="user">
      <tr>
           <td>${user.firstName}</td>
           <td>${user.lastName}</b></td>
           <td>${user.email}</b></td>
           <td>${user.phoneNo}</b></td>
           <td>${user.dob}</td>
           <td><b>${user.address}</td>
           <td><b>${user.userName}</td>
           <td><a href = "/register?id=${user.id}">Edit</td>
        <%--   <td><a href = "/deleteUser?id=${user.id}">Delete</td>--%>
      </tr>
</c:forEach>
</table>
<jsp:include page="../include/footer.jsp" />
