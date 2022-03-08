<jsp:include page="../include/header1.jsp" />
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<%--<div class="card" style="width: 18rem;">
  <img class="card-img-top" src="${editBookFormBeanKey.url}" alt="Card image cap">
  <div class="card-body">
  <h5 class="card-title">BookName:${editBookFormBeanKey.bookName}</h5>

  Description: ${editBookFormBeanKey.description}<br/>
  Author:${editBookFormBeanKey.author}<br/>
  Publisher:${editBookFormBeanKey.publisher}<br/>
  BookType:${editBookFormBeanKey.bookType}<br/>

    <sec:authorize access="isAuthenticated()">
    <a href="${editBookFormBeanKey.id}/addToCart" class="btn btn-primary">Add To Cart</a>

         </sec:authorize>
         <sec:authorize access="!isAuthenticated()">
    <a href="/login/login" class="btn btn-primary">Add To Cart</a>

         </sec:authorize>
  </div>
</div>

</div>
</form>--%>





<div class="container  px-4 py-5">
<div style="background-color:white; border-radius:10%" >
    <div class="row flex-lg-row align-items-center g-5 py-5">
    <div class = "col-1 "></div>
      <div class="col-10 col-sm-8 col-lg-6 ">
        <img src="${editBookFormBeanKey.url}"  style="max-height:500px;object-fit:contain;box-shadow:0 3px 1em black" class="d-block mx-lg-auto img-fluid" alt="Bootstrap Themes"  loading="lazy">
      </div>
      <div class="col-lg-4">
      <h5 class="card-title">BookName:${editBookFormBeanKey.bookName}</h5>

        Description: ${editBookFormBeanKey.description}<br/>
        Author:${editBookFormBeanKey.author}<br/>
        Publisher:${editBookFormBeanKey.publisher}<br/>
        BookType:${editBookFormBeanKey.bookType}<br/>
       <%-- <h1 class="display-5 fw-bold lh-1 mb-3">Responsive left-aligned hero with image</h1>
        <p class="lead">Quickly design and customize responsive mobile-first sites with Bootstrap, the world’s most popular front-end open source toolkit, featuring Sass variables and mixins, responsive grid system, extensive prebuilt components, and powerful JavaScript plugins.</p>
        <div class="d-grid gap-2 d-md-flex justify-content-md-start">
         <button type="button" class="btn btn-primary btn-lg px-4 me-md-2">Primary</button>--%>
             <sec:authorize access="isAuthenticated()">
                <a href="${editBookFormBeanKey.id}/addToCart" class="btn btn-primary">Add To Cart</a>

                     </sec:authorize>
                     <sec:authorize access="!isAuthenticated()">
                <a href="/login/login" class="btn btn-primary">Add To Cart</a>

                     </sec:authorize>

        </div>
      </div>
    </div>
  </div>
</div>
</form>


<jsp:include page="../include/footer.jsp" />



