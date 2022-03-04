<jsp:include page="header1.jsp" />

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>CommunityProgramsPage</title>
  <style>
  <%-- * {
    padding :0;
    margin :0;
     text-align:center;
    }
  nav {
        background:#009000;
        height:55px;

    }
    nav ul{
    height:50px;
   width:300px
    margin:0 auto;
    align-items:center;
    display:flex;

     justify-content:center;
        padding:0 1rem;
<!--        text-align:center;-->


    }
  nav ul li{

        text-decoration:none;
        font-size:35px;
        margin:500;
        boarder:10px;
        padding: 7x 17px 12px 12px;
        text-align:center;
        display:flex;
        height:100%;
        overflow :hidden;
        margin-left: 15px;


        }
li a{
text-decoration:none;
line-height:50px;
display:block;

}
li a:hover{
background-color:orange;
color:black;

}--%>
      #footer {
   position:flex;
   bottom:0;
   width:50%;
   height:60px;   /* Height of the footer */
   background:lightblue;
}
.dropbtn {
        background:#009000;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;

}

.dropbtn:hover, .dropbtn:focus {
  background-color: orange;
}

.dropdown1 {
  position: relative;
  display: inline-block;
  background-color: green;
  align="center"


}

.dropdown1-content {
  display: none;
  position: absolute;
  background-color: green;
  min-width: 160px;
  overflow: auto;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
  align="center"
}

.dropdown1-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown1 a:hover {background-color: #ddd;}

.show {display: block;}

</style>
</head>
<body style="background-color:lightblue">



<h2 align="center">Welcome to the community programs page</h2>
<br>
<br>
<p align="center">Click on the button to open the dropdown menu.</p>
<br>
<br>
<div class="dropdown1" text-align="center" >
  <button onclick="myFunction()" class="dropbtn">CommunityPrograms</button>
  <div id="myDropdown" class="dropdown1-content" text-align="center">
    <a href="#Event Calender">Event Calender  - 2022</a>
    <a href="#News and Views">News and Views January</a>
    <a href="#Press Releases">Press Releases - 2021</a>
  </div>
</div>
<br>


<script>
/* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
function myFunction() {
  document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {
    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
</script>

</body>
</html>