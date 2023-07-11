    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">


    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>SideBar Menu</title>
        <link rel="stylesheet" type="text/css" href="assets/css/styledetail.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <style>
            html, body {
                width: 100%;
                height: 100%;
                text-decoration: none;
            </style>
        </head>

        <body >
            <div>
                <%@include file="header.jsp" %>
            </div>
            <div class="container mt-5 mb-5" style="padding-top: 10%;
                 height: 56%;">
                <div class="card">
                    <div class="row g-0">
                        <div class="col-md-6 border-end">
                            <div class="d-flex flex-column justify-content-center">
                                <div class="main_image"> <img src="${requestScope.Prod.image}" id="main_product_image"
                                                              width="350"> </div>

                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="p-3 right-side">
                                <div class="d-flex justify-content-between align-items-center">
                                    <h3>${requestScope.Prod.name}</h3>
                                </div>
                                <div class="mt-2 pr-3 content">
                                    <p>${requestScope.Prod.info}</p>
                                </div>
                                <h3>$${requestScope.Prod.price}</h3>

                                <div class="mt-5">

                                </div>
                                <div class="buttons d-flex flex-row mt-5 gap-3"> <button class="btn btn-outline-dark">Buy
                                        Now</button> <a href="buy?id=${requestScope.Prod.getId()}" class="btn btn-dark">Add Cart</a> </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div style="margin-top: 14%;">                   
                <%@include file="footer.jsp" %>
            </div>
        </body>

    </html>