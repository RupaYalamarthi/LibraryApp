<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="../include/header1.jsp" />

<div class="container">
<table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">FirstName</th>
      <th scope="col">LastName</th>
      <th scope="col">Email</th>
      <th scope="col">PhoneNumber</th>
      <th scope="col">DateOfBirth</th>
      <th scope="col">Address</th>
      <th scope="col">Username</th>
      <th scope="col">Edit</th>
    <%--  <th scope="col">Delete</th>--%>
    </tr>
  </thead>
  <tbody>
   <c:forEach items = "${userKey}" var="user">
    <tr>
      <td>${user.firstName}</td>
      <td>${user.lastName}</b></td>
      <td>${user.email}</b></td>
      <td>${user.phoneNo}</b></td>
      <td>${user.dob}</td>
      <td><b>${user.address}</td>
      <td><b>${user.userName}</td>
    <%--  <td><a href = "/register?id=${user.id}">Edit</td>
      <td><a href = "/deleteUser?id=${user.id}">Delete</td>--%>
            <td><a href = "/editUser?id=${user.id}">Edit</td>

    </tr>
  </c:forEach>
 </tbody>
</table>
</div>
<jsp:include page="../include/footer.jsp" />
