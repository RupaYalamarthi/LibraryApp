<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
<script
      src="https://code.jquery.com/jquery-3.6.0.js"
      integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
      crossorigin="anonymous"></script>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossorigin="anonymous">

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
   <style type = "text/css">
    <!--    google family in a class-->
    .gf{
  font-family: "Trirong", serif;
}
    <meta charset="UTF-8">
    <style>
  * {
    padding: 0;
    margin: 0;
  }

  nav {
    background: #009000;
    height: 50px;
  }

  nav ul {
    height: 50px;
    width: 300px margin:0 auto;
    align-items: center;
    display: flex;
    justify-content: center;
    padding: 0 1rem;

  }

  nav ul li {
   text-decoration: none;
    font-size: 35px;
    margin: 500;
    boarder: 10px;
    padding: 10px 17px 10px 12px;
    text-align: center;
    display: flex;
    height: 100%;
    overflow: hidden;
  }

  li a {
    text-decoration: none;
    line-height: 50px;
    display: block;
  }

  li a:hover {
    background-color: orange;
    color: black;
  }

.card {
  /* Add shadows to create the "card" effect */
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
}

/* On mouse-over, add a deeper shadow */
.card:hover {
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}

/* Add some padding inside the card container */
.container {
  padding: 2px 16px;
}
</style>
</head>

<body style="background-color:lightblue">
<h1 align="center" style="color :black"> TROY LIBRARY</h1><br>
<form method="GET" action="/bookSearch" >
<input type="text" name="search"  placeholder="SearchByBookName">
    <button type="submit">Search</button>
</form><br>
<nav>
    <ul>
         <li><a href="./views/location&Hours.html">Location&Hours</a></li>
           <li><a href="./views/CommunityPrograms.html">CommunityPrograms</a></li>
           <li><a href="./views/Services.html" title="All inperson services are cancelled due to Covid-19" >Services</a></li>
           <!--<li><a href="/register">MyAccount</a></li>-->
               <li><a href="/login/login">MyAccount</a></li>
           <li><a href="./views/About.html">About</a></li>

    </ul>
</nav><br>

