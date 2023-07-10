<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Complete Responsive Pet Food Website Design Tutorial</title>

        <!-- font awesome cdn link  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

        <!-- custom css file link  -->
        <link rel="stylesheet" href="assets/css/style.css">

        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.8/dist/sweetalert2.all.min.js"></script>

    </head>
    <body>

        <!-- header section starts  -->
        <c:choose>
            <c:when test="${sessionScope.AccSes == null}">
                <header class="header">

                    <a href="${pageContext.request.contextPath}/login" class="logo"> <i class="fas fa-paw"></i> shop </a>

                    <nav class="navbar">
                        <a href="#home">home</a>
                        <a href="#shop" id="showAlert">shop</a>
                        <a href="#services">services</a>
                        <a href="#plan">plan</a>
                        <a href="#contact">contact</a>
                    </nav>


                    <div class="icons">
                        <div class="fas fa-bars" id="menu-btn"></div>
                        <div class="fas fa-user" id="login-btn"></div>
                    </div>

                    <form action="login" class="login-form" method="POST">
                        <h3>sign in</h3>
                        <p style="color: red">${mess}</p>
                        <input type="text" name="username_in" placeholder="enter your username" id="" class="box" value="${uname}" required="required">
                        <input type="password" name="pswd_in" placeholder="enter your password" id="" class="box"  value="${pass}" required="required">
                        <div class="remember">
                            <input type="checkbox" name="remember" id="remember-me" value="1" ${rem.equals("1") ? 'checked' : ''} >
                            <label for="remember-me">remember me</label>
                        </div>
                        <input type="submit" value="sign in" class="btn">
                        <div class="links">
                            <a href="${pageContext.request.contextPath}/signup">sign up</a>
                        </div>
                    </form>



                </header>
            </c:when>

            <c:otherwise>
                <%@include file="header.jsp" %>
            </c:otherwise>
        </c:choose>
        <!-- header section ends -->

        <!-- home section starts  -->

 
        <!-- plan section starts  -->

        <section class="plan" id="plan">

            <h1 class="heading"> choose a <span>plan</span> </h1>

            <div class="box-container">

                <div class="box">
                    <h3 class="title">pet care</h3>
                    <h3 class="day"> 1 day </h3>
                    <i class="fas fa-bicycle icon"></i>
                    <div class="list">
                        <p> pet room <span class="fas fa-check"></span> </p>
                        <p> pet grooming <span class="fas fa-check"></span> </p>
                        <p> pet exercise <span class="fas fa-check"></span> </p>
                        <p> pet meals <span class="fas fa-check"></span> </p>
                    </div>
                    <div class="amount"><span>$</span>50</div>

                    <a href="#" class="btn" id="showAlert1"> choose plan </a>           
                    <c:if test="${sessionScope.AccSes == null}">
                        <script>
                            $("#showAlert1").click(function () {
                                Swal.fire(
                                        'Please login to choose plan',
                                        )
                            });
                        </script>
                    </c:if>
                </div>

                <div class="box">
                    <h3 class="title">pet care</h3>
                    <h3 class="day"> 10 days </h3>
                    <i class="fas fa-motorcycle icon"></i>
                    <div class="list">
                        <p> pet room <span class="fas fa-check"></span> </p>
                        <p> pet grooming <span class="fas fa-check"></span> </p>
                        <p> pet exercise <span class="fas fa-check"></span> </p>
                        <p> pet meals <span class="fas fa-check"></span> </p>
                    </div>
                    <div class="amount"><span>$</span>350</div>
                    <a href="#" class="btn" id="showAlert2"> choose plan </a>           
                    <c:if test="${sessionScope.AccSes == null}">
                        <script>
                            $("#showAlert2").click(function () {
                                Swal.fire(
                                        'Please login to choose plan',
                                        )
                            });
                        </script>
                    </c:if>
                </div>

                <div class="box">
                    <h3 class="title">pet care</h3>
                    <h3 class="day"> 30 days </h3>
                    <i class="fas fa-car-side icon"></i>
                    <div class="list">
                        <p> pet room <span class="fas fa-check"></span> </p>
                        <p> pet grooming <span class="fas fa-check"></span> </p>
                        <p> pet exercise <span class="fas fa-check"></span> </p>
                        <p> pet meals <span class="fas fa-check"></span> </p>
                    </div>
                    <div class="amount"><span>$</span>650</div>
                    <a href="#" class="btn" id="showAlert3"> choose plan </a>           
                    <c:if test="${sessionScope.AccSes == null}">
                        <script>
                            $("#showAlert3").click(function () {
                                Swal.fire(
                                        'Please login to choose plan',
                                        )
                            });
                        </script>
                    </c:if>
                </div>

            </div>

        </section>

        <!-- plan section ends -->

        <section class="contact" id="contact">

<!--            <div class="image">
                <img src="assets/image/contact_img.png" alt="">
            </div>-->

<!--            <form action="">
                <h3>contact us</h3>
                <input type="text" placeholder="your name" class="box">
                <input type="email" placeholder="your email" class="box">
                <input type="tumber" placeholder="your number" class="box">
                <textarea name="" placeholder="your message" id="" cols="30" rows="10"></textarea>
                <input type="submit" value="send message" class="btn">
            </form>-->

        </section>

        <section class="footer">

            <img src="assets/image/top_wave.png" alt="">

            <div class="credit"> created by <span> Tuancayda3 </span> | all rights reserved! </div>

        </section>




















        <!-- custom js file link  -->
        <script>
            $("#showAlert").click(function () {
                Swal.fire(
                        'Please login to shopping',
                        )
            });
        </script>
        <script src="assets/js/script.js"></script>

    </body>
</html>