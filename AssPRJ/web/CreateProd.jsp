
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

                    <h2 class="myclass">AddProd</h2>
                    <form action="createProd" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <label>Name</label> 
                            <input type="text" 
                                   class="form-control" name="NameProd" placeholder="Enter name">
                        </div>

                        <div class="form-group">
                            <label>Info</label> 
                            <input type="text" 
                                   class="form-control" name="InfoProd" placeholder="Enter info product">
                        </div>

                        <div class="form-group">
                            <label>Price</label> 
                            <input type="text" 
                                   class="form-control" name="PriceProd" placeholder="Price">
                        </div>

                        <div class="form-group">
                            <label for="cate">Choose a category</label>

                            <select name="cate">
                                <c:forEach items="${requestScope.listC}" var="l">
                                <option value="${l.getId()}">${l.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Quantity</label> 
                            <input type="number" 
                                   class="form-control" name="QuantityProd" placeholder="Price">
                        </div>

                        <div class="form-group">
                            <label>Photo</label> <br/>

                            <input type="file" 
                                   class="form-control" name="image" placeholder="Enter photo">
                        </div>
                        <button type="submit" class="btn btn-primary">Save</button>
                        <button type="reset" class="btn btn-primary">Cancel</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>