<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container" style="margin-top: 10px;">
            <div class="row"
                 style="border: 1px darkgrey solid; border-radius: 10px; width: 50%; margin: 0 auto; padding: 20px;">
                <div class="col-sm-12">
                    <h2 class="myclass">Register</h2>
                    <form action="${pageContext.request.contextPath}/editProd" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <input type="hidden" 
                                   class="form-control" value="${requestScope.Prod.getId()}" name="ID" placeholder="Enter ID"  >
                        </div>
                        <div class="form-group">
                            <label>Name</label> 
                            <input type="text" 
                                   class="form-control" value="${requestScope.Prod.getName()}" name="Name" placeholder="Enter name" >
                        </div>

                        <div class="form-group">
                            <label>Info</label> 
                            <input type="text" 
                                   class="form-control" value="${requestScope.Prod.getInfo()}" name="InfoProd" >
                        </div>

                        <div class="form-group">
                            <label>Price</label> 
                            <input type="number" 
                                   class="form-control" value="${requestScope.Prod.getPrice()}" name="PriceProd" >
                        </div>

                        <div class="form-group">
                            <label for="cate">Choose a category</label>

                            <select name="cate">
                                <c:forEach items="${requestScope.Prod.getCategory_id()}" var="l">
                                    <option value="${requestScope.Prod.getCategory_id()}">${requestScope.category.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Quantity</label> 
                            <input type="number" 
                                   class="form-control" name="QuantityProd" placeholder="Price" value="${requestScope.Prod.getQuantity()}">
                        </div>

                        <div class="form-group">
                            <label>Photo</label> <br/>
                            <img src="${requestScope.Prod.getImage()}" alt="alt"/>

                            <input type="file" 
                                   class="form-control" name="image" placeholder="Enter photo" ">
                        </div>
                        <button type="submit" class="btn btn-primary">Save</button>
                        <a href="<%=request.getContextPath()%>/admin" class="btn btn-primary">Cancel</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>