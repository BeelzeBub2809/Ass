<%-- 
    Document   : signup
    Created on : Jun 20, 2023, 8:33:35 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Slide Navbar</title>
        <link rel="stylesheet" type="text/css" href="assets/css/stylesignup.css">
        <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="stylesheet">


    </head>
    <body>
        <input type="hidden" id="status" value="<%=request.getAttribute("status")%>">
        <div class="main">  	

            <div class="signup">
                <form action="signup" method="POST">
                    <label for="chk" aria-hidden="true">Sign up</label>
                    <input type="text" name="username" placeholder="User name" required="">
                    <input type="email" name="email" placeholder="Email" required="">
                    <input type="password" name="pswd" placeholder="Password" required="">
                    <input type="password" name="re-pswd" placeholder="Re-enter password" required="">
                    <button type="submit">Sign up</button>
                    <a href="login">Sign in</a>
                </form>
            </div>
        </div>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script type="text/javascript">
            var status = document.getElementById("status").value;
            if(status === "success"){
                swal("Congrats", "Account Create Successfully Please Click to Sign In", "success");
            }
            if(status === "Invalid"){
                swal("Sorry", "Username or password contain white space", "failed");
            }
            if(status === "Unmatch"){
                swal("Sorry", "Password and Re-password does not match", "failed");
            }
            if(status === "fail"){
                swal("Sorry", "Username has already exist", "failed");
            }
        </script>
    </body>
</html>
