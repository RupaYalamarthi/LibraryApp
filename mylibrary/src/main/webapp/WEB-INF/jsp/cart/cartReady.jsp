<jsp:include page="../include/header1.jsp" />
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<section class="h-100" >
  <div class="container h-100 py-5">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-10">

        <div class="d-flex justify-content-between align-items-center mb-4">
          <h3 class="fw-normal mb-0 text-black">Shopping Cart</h3>
        </div>
 <c:forEach items = "${transactionKey}" var="transaction">

        <div class="card rounded-3 mb-4">
          <div class="card-body p-4">
            <div class="row d-flex justify-content-between align-items-center">
              <div class="col-md-2 col-lg-2 col-xl-2">
                <img src="${transaction.book.url}"
                  class="img-fluid rounded-3" alt="Cotton T-shirt">
              </div>
              <div class="col-md-3 col-lg-3 col-xl-3">
                <p class="lead fw-normal mb-2"><b>${transaction.book.bookName}</b></p>
                <p><span class="text-muted">By:${transaction.book.author} </span><span class="text-muted"></span></p>
              </div>
              <div class="col-md-2 col-lg-2 col-xl-2 text-end">
                <a href="${transaction.book.id}/deleteFromCart" class="text-danger">Delete<i class="fas fa-trash fa-lg"></i></a>
              </div>
            </div>
          </div>
        </div>
 </c:forEach>

        <div class="card">
                    <div class="card-body">
                      <a href="/proceedToCheckOut"button type="button" class="btn btn-warning btn-block btn-lg">Proceed to CheckOut</button></a>
                    </div>
                  </div>
      </div>
    </div>
  </div>
</section>
