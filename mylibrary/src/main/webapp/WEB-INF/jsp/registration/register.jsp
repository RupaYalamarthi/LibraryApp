<jsp:include page="../include/header1.jsp" />
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<p align="center">Please fill the fields on this form and click submit to register. Your online registration will be forwarded to the Library.</p>
<br>
<br>
<form method="POST" action="/registerSubmit">
<div align="center">
<input type="hidden" name="id" value="${formBeanKey.id}">
<table cellpadding="5">
<tr><td>FirstName</td>
        <td><input type="text" name ="firstName" value="${formBeanKey.firstName}"></td></tr>
<tr><td>LastName</td>
        <td><input type="text" name ="lastName" value="${formBeanKey.lastName}"></td></tr>
<tr><td>Email</td>
        <td><input type="text" name ="email" value="${formBeanKey.email}"></td></tr>
<tr><td>PhoneNumber</td>
        <td> <input type="text" name ="phoneNo" value="${formBeanKey.phoneNo}"></td></tr>
<tr><td>DateOfBirth</td>
        <td> <input type="date" name ="dob" value="${formBeanKey.dob}"></td></tr>
<tr><td>Address</td>
        <td> <input type="text" name ="address" value="${formBeanKey.address}"></td></tr>
<tr><td>Username</td>
        <td><input type="text" name ="userName" value="${formBeanKey.userName}"></td></tr>
<tr><td>Password</td>
         <td><input type="password" name ="password" value="${formBeanKey.password}"></td></tr>
<tr><td>ConfirmPassword</td>
         <td> <input type="password" name ="confirmPassword" value="${formBeanKey.confirmPassword}"></td></tr>
<%--<tr><td><button type="submit" >Submit </button></td></tr>--%>
</table>
<tr><td align="center"><button type="submit" class="btn btn-primary" role="button">Submit</button>
</div>
</form>
<div>
    <c:forEach items="${errorMessages}" var="message">
        <span style="color:red">${message}</span><br>
    </c:forEach>
</div>


