<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <Title>Troy Library</Title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   <%-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>--%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

   <style type = "text/css">
           <!--    google family in a class-->
           .gf{
         font-family: "Trirong", serif;
       }
       </style>
</head>

<body style="background-color: lightblue;">
<h1 align="center" style="color :black"> TROY LIBRARY</h1><br>

    <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
               <a class="nav-link" href="/">Home<span class="sr-only">(current)</span></a>
            </li>
            <sec:authorize access="!isAuthenticated()">
              <li class="nav-item active">
                <a class="nav-link" href="/login/login">LogIn/Register<span class="sr-only">(current)</span></a>
              </li>
              </sec:authorize>
           <%--   <li class="nav-item active">
                <a class="nav-link "  href="/communityPrograms">CommunityPrograms</a>
              </li>--%>
              <li class="nav-item active">
                <a class="nav-link" href="/locations&hours">Location&Hours</a>
              </li>
           <%--   <li class="nav-item active">
                <a class="nav-link" href="./views/Services.html" title="All inperson services are cancelled due to Covid-19" >Services</a>
              </li>
               <li class="nav-item active">
                <a class="nav-link" href="./views/About.html">About<span class="sr-only">(current)</span></a>
              </li>--%>
       <%--      <sec:authorize access="hasAuthority('ADMIN')">
                <li class="nav-item dropdown active">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                     Admin Home
                     <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/login/logout">Logout</a>
                     </div>
                </li>
                 </sec:authorize>--%>
                <sec:authorize access="hasAnyAuthority('ADMIN')">
                   <li class="nav-item dropdown active">
                       <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          <sec:authentication property="principal.username" />  Admin Home </a>
                             <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="/register">UserRegistration</a>
                                <a class="dropdown-item" href="/userListAll">EditUser</a>
                                <a class="dropdown-item" href="/addBook">AddABook</a>
                                <a class="dropdown-item" href="/bookListAll">Edit/Delete Book</a>

                             </div>
                   </li>
                </sec:authorize>

              <sec:authorize access="hasAnyAuthority('ADMIN', 'USER')">
              <li class="nav-item dropdown active">
                      <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                       <sec:authentication property="principal.username" />  Profile </a>
                      <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Action</a>
                       <%-- <a class="dropdown-item" href="#">Another action</a>--%>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/login/logout">Logout</a>
                      </div>
              </li>
               <li class="nav-item active">
                    <a class="nav-link" href="/cartReady">Cart<span class="sr-only">(current)</span></a>
               </li>
              </sec:authorize>

            </ul>
            <form class="form-inline mt-2 mt-md-0" method="GET" action="/bookSearch">
              <input class="form-control mr-sm-2" type="text" name="search" placeholder="SearchByBookName" aria-label="Search">
              <button class="btn btn-outline-success my-2 my-sm-0" type="submit" >Search</button>
            </form>
          </div>
        </nav>
   <%--    <div class="album py-5 ">
              <div class="container-fluid">
                  <div class="row">
               <c:forEach items = "${bookKey}" var="book">
                  <div class="col-md-3 d-inline" style="width:500px">
                    <div class="card mb-4 box-shadow">
                    <div >
                      <img   class="img-fluid d-flex justify-content-between align-items-center"
                              style="max-height: 300px; width:100%; display: block; object-fit:contain"
                      src="${book.url}"></div>
                      <div class="card-body">
                        <h2 class="card-text">Title:${book.bookName}</h2>
                                   <h4 class="card-text">Author:${book.author}<br>
                                   Publisher:${book.publisher}<br>
                                   BookType:${book.bookType}</h4>
                        <div class="d-flex justify-content-between align-items-center">
                          <button href="/cartReady" class="card-btn">Add To Cart</button>
                        </div>
                      </div>
                    </div>
                  </div>
                   </c:forEach>
               </div>
              </div>
       </div>--%>

       <div class="album py-5 ">

                     <div class="container-fluid">
                         <div class="row">
                      <c:forEach items = "${bookKey}" var="book">
                         <div class="col-md-3 d-inline" style="width:500px">
                           <div class="card mb-4 box-shadow">
                           <div >
                             <a href="/bookDetails?id=${book.id}"><img   class="img-fluid d-flex justify-content-between align-items-center"
                                     style="max-height: 300px; width:100%; display: block; object-fit:contain"
                             src="${book.url}"></a></div>
                             <div class="card-body">
                               <h2 class="card-text">Title:${book.bookName}</h2>
                                          <h4 class="card-text">Author:${book.author}<br>
                                          Publisher:${book.publisher}<br>
                                          BookType:${book.bookType}</h4>
                               <sec:authorize access="hasAnyAuthority('ADMIN', 'USER')">

                               <div class="d-flex justify-content-between align-items-center">
                               <%--  <button class="card-btn  btn-link" href="/cartReady">Add To Cart</button>btn btn-primary btn-lg--%>
                                 <a href="${book.id}/addToCart" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Add To Cart</a>

                               </div>
                                </sec:authorize>

                             </div>
                           </div>
                         </div>
                          </c:forEach>
                      </div>
                     </div>
              </div>





