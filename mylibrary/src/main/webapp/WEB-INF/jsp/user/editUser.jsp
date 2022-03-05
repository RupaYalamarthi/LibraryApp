


<jsp:include page="../include/header1.jsp" />
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<p align="center"><b>Please fill the fields on this form and click submit to register. Your online registration will be forwarded to the Library.</b></p>
<br>
<br>
<form method="POST" action="/registerSubmit">
<div class="container">
<input type="hidden" name="id" value="${formBeanKey.id}">
  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label >FirstName</label>
      <input type="text" class="form-control" name ="firstName"  placeholder="First name" value="${formBeanKey.firstName}">
    </div>
    <div class="col-md-4 mb-3">
      <label >LastName</label>
      <input type="text" class="form-control" name ="lastName"  placeholder="Last name" value="${formBeanKey.lastName}" >
    </div>

    <div class="col-md-4 mb-3">
      <label>Email</label>
          <input type="text" class="form-control" name ="email" placeholder="Email" value="${formBeanKey.email}" readonly="true" >
    </div>
  </div>
  <div class="form-row">
    <div class="col-md-3 mb-3">
       <label>PhoneNumber</label>
           <input type="text" class="form-control" name ="phoneNo" placeholder="PhoneNumber" value="${formBeanKey.phoneNo}" >
    </div>
    <div class="col-md-3 mb-3">
           <label>DateOfBirth</label>
               <input type="date" class="form-control" name ="dob" placeholder="DateOfBirth" value="${formBeanKey.dob}" >
    </div>
    <div class="col-md-6 mb-3">
      <label>Address</label>
      <input type="text" class="form-control" name ="address" placeholder="Address" value="${formBeanKey.address}">
    </div>
  </div>
  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label>Username</label>
      <input type="text" class="form-control" name ="userName" placeholder="Username" value="${formBeanKey.userName}">
    </div>
  <div class="col-md-4 mb-3">
      <label >Password</label>
      <input type="password" class="form-control" name ="password" placeholder="Password" value="${formBeanKey.password}" readonly="true">
    </div>
    <div class="col-md-4 mb-3">
          <label >ConfirmPassword</label>
          <input type="password" class="form-control" name ="confirmPassword" placeholder="ConfirmPassword" readonly="true"value="${formBeanKey.confirmPassword}">
    </div>
  </div>
  <button class="btn btn-primary" type="submit">Submit</button>
</div>
</form>
<div>
    <c:forEach items="${errorMessages}" var="message">
        <span style="color:red">${message}</span><br>
    </c:forEach>
</div>




