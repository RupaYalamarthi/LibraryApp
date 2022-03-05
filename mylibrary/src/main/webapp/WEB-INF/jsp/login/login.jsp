<%--<jsp:include page="../include/header1.jsp" />

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
</form>--%>
<jsp:include page="../include/header1.jsp" />

<form action="/login/loginSecurityPost" method="POST">
<div class="container">
<section class="vh-100" >
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card shadow-2-strong" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">

            <h3 class="mb-5">Sign in</h3>

            <div class="form-outline mb-4">
              <input type="text" name="username" id="typeEmailX-2" class="form-control form-control-lg" />
              <label class="form-label" for="typeEmailX-2">Username</label>
            </div>

            <div class="form-outline mb-4">
              <input type="password" name="password" id="typePasswordX-2" class="form-control form-control-lg" />
              <label class="form-label" for="typePasswordX-2">Password</label>
            </div>
       <button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>

            <hr class="my-4">
        <a href="/register">Click here to Register now</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</form>
</div>


