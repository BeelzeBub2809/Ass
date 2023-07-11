<%-- 
    Document   : header
    Created on : Jun 19, 2023, 3:21:55 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Complete Responsive Pet Food Website Design Tutorial</title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-dpZg5/mFHqPHn1e4D6eHVv3yATewEsSo1hz5ebR3/ZehYQp+1I47/+3rBUoED+Lb0slJ4TetZjGwrcbYMw58tA==" crossorigin="anonymous" referrerpolicy="no-referrer" />


        <!-- font awesome cdn link  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

        <!-- custom css file link  -->
        <link rel="stylesheet" href="assets/css/styleheader.css">

    </head>
    <body>

        <!-- header section starts  -->

        <header class="header">

            <a href="${pageContext.request.contextPath}/login" class="logo"> <i class="fas fa-paw"></i> shop </a>

            <nav class="navbar">
                <a href="${pageContext.request.contextPath}/login">home</a>
                <a href="${pageContext.request.contextPath}/loadProd">shop</a>
                <a href="#services">services</a>
                <a href="plan.jsp">plan</a>
                <a href="#contact">contact</a>
            </nav>

            <div class="user-info">
                <div class="user-profile" >
                    <div class="dropdown-btn">
                        <img  src="assets/image/OIP.jpg" alt="User Picture" class="user-picture">
                        <span class="username">${sessionScope.AccSes.username}</span>
                    </div>
                    <a href="cart" class="fas fa-shopping-cart cart-icon"></a>
                </div>

                <!-- User Dropdown Menu -->
                <div class="user-dropdown" id="user-dropdown">
                    <ul class="dropdown-list">
                        <li><a href="#">Profile</a></li>
                        <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                    </ul>
                </div>
            </div>
        </header>
        
        
        
        

        <script>
            let dropdownList = document.querySelector(".dropdown-list");
            let btn = document.querySelector(".dropdown-btn");

            const toggleDropdown = () => {
                dropdownList.classList.toggle("active");
            };

            btn.addEventListener("click", toggleDropdown);
        </script>
        <script src="assets/js/scriptheader.js"></script>
    </body>
</html>
