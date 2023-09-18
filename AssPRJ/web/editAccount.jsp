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
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container" style="margin-top: 10px;">
            <div class="row"
                 style="border: 1px darkgrey solid; border-radius: 10px; width: 50%; margin: 0 auto; padding: 20px;">
                <div class="col-sm-12">

                    <h2 class="myclass">Update Account</h2>
                    <form action="${pageContext.request.contextPath}/editAcc" method="post">
                        <div class="form-group">
                            <input type="hidden" 
                                   class="form-control" value="${requestScope.Acc.getId()}" name="ID" placeholder="Enter ID"  >
                        </div>
                        <div class="form-group">
                            <label>UserName</label> 
                            <input type="text" 
                                   class="form-control" value="${requestScope.Acc.getUsername()}" name="username" placeholder="Enter name" >
                        </div>

                        <div class="form-group">
                            <label>Password</label> 
                            <input type="text" 
                                   class="form-control" value="${requestScope.Acc.getPassword()}" name="password" >
                        </div>

                        <div class="form-group">
                            <label>Email</label> 
                            <input type="email" 
                                   class="form-control" value="${requestScope.Acc.getEmail()}" name="email" >
                        </div>
                        <div class="form-group">
                            <label for="permission">Permission</label>
                            <select name="permission">
                                <c:set var="manager" value="manager"></c:set>
                                <c:choose>
                                    <c:when test="${requestScope.Acc.getPermission() eq manager}">
                                        <option value="manager">Manager</option>
                                        <option value="user">User</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="user">User</option>
                                        <option value="manager">Manager</option>
                                    </c:otherwise>
                                </c:choose>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary">Save</button>
                        <a href="<%=request.getContextPath()%>/account" class="btn btn-primary">Cancel</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>