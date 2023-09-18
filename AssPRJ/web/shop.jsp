<%-- 
    Document   : shop
    Created on : Jun 25, 2023, 12:03:11 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Complete Responsive Pet Food Website Design Tutorial</title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
              integrity="sha512-dpZg5/mFHqPHn1e4D6eHVv3yATewEsSo1hz5ebR3/ZehYQp+1I47/+3rBUoED+Lb0slJ4TetZjGwrcbYMw58tA=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />


        <!-- font awesome cdn link  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

        <!-- custom css file link  -->
        <link rel="stylesheet" href="assets/css/styleshop.css">


    </head>

    <body>

        <!-- header section starts  -->
        <%@include file="header.jsp" %>
        <!-- header section ends -->
        <!-- <div class="prod"> -->
        <div class="sidenav">
            <a href="loadProd">All Product</a>
            <c:forEach items="${listC}" var="l">
                <a href="category?CID=${l.getId()}" >${l.getName()}</a>
            </c:forEach>
        </div>
        <section class="shop" id="shop" style="padding: 7rem 9%">

            <h1 class="heading"> our <span> products </span> </h1>

            <div class="box-container">
                <c:forEach items="${listP}" var="p">
                    <div class="box">
                        <div class="icons">
                            <c:if test="${p.getQuantity() > 0}">
                            <a href="buy?id=${p.getId()}" class="fas fa-shopping-cart"></a>
                            </c:if>
                            <a href="detail?pid=${p.getId()}" class="fas fa-eye"></a>
                        </div>
                        <div class="image">
                            <img style="width:100%; border-style: inset;" src="${p.getImage()}" alt="">
                        </div>
                        <div class="content">
                            <h3>${p.getName()}</h3>
                            <div class="amount"> ${p.getPrice()} </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </section>
        <!-- </div> -->
        <div>
        <%@include file="footer.jsp" %>
        </div>
        <!-- custom js file link  -->

    </body>

</html>