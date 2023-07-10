<%-- 
    Document   : admin
    Created on : Jun 23, 2023, 4:29:14 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>SideBar Menu</title>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="assets/css/styleadmin.css"/>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>

<body> <input type="checkbox" id="menu">
    <nav> <img style="width: 68px; border-radius:50%; margin-left: 92px " src="assets/image/logo.png" alt="alt"/><label>Admin</label>
        <ul>
            <li><a href="<%=request.getContextPath()%>/logout">Logout</a></li>
        </ul> <label for="menu" class="menu-bar"> <i class="fa fa-bars"></i> </label>
    </nav>
    <div class="side-menu">
        <center> <img src="assets/image/OIP.jpg"> <br><br>
            <h2>${sessionScope.AccSes.username}</h2>
        </center> <br> <a href="#"><i class="fa fa-user"></i><span>Customers</span></a>
        <a href="#"><i class="fa fa-envelope"></i><span>Message</span></a>
        <a href="#"><i class="fa fa-shopping-basket"></i><span>Products</span></a>
        <a href="#"><i class="fa fa-sellsy"></i><span>Statistices</span></a>
        <a href="#"><i class="fa fa-ban"></i><span>Ban Customers</span></a>
        <a href="#"><i class="fa fa-cog"></i><span>Setting</span></a>
        
    </div>
        <div class="data" style="height: 0vh"></div>
