
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

                    <h2 class="myclass">Add Account</h2>
                    <h5 class="text-danger">${requestScope.mess}</h5>
                    <form action="addAcc" method="POST">
                        <div class="form-group">
                            <label>UserName</label> 
                            <input type="text" 
                                   class="form-control" name="username" placeholder="Enter Username">
                        </div>
                        <div class="form-group">
                            <label>Password</label> 
                            <input type="text" 
                                   class="form-control" name="password" placeholder="Enter Password">
                        </div>
                        <div class="form-group">
                            <label>Email</label> 
                            <input type="email" 
                                   class="form-control" name="email" placeholder="Enter Email">
                        </div>
                        <div class="form-group">
                            <label for="permission">Permission</label>
                            <select name="permission" id="permission">
                                <option value="manager">Manager</option>
                                <option value="user">User</option>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary">Save</button>
                        <button type="reset" class="btn btn-primary">Cancel</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>