<jsp:include page="../include/header1.jsp" />

<p align="center"> If you are not registered for library services,
    <a href="/register">Click here to register now</a>
</p><br>
<form action="/login/loginSecurityPost" method="POST">

    <p align="center" style="font-size: 22px">Please enter Username and Password to Log In<br>
        <br>
        Username: <input type="text" name="username" value="" id="USERNAME" placeholder="Enterusername" /><br><br>
        Password: <input type="password" name="password" value="" id="password" placeholder="Enterpassword" /><br><br>

        <input type="submit" value="Submit">
    </p>
</form>



