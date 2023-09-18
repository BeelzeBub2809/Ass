
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

                    <h2 class="myclass">Add Order</h2>
                    <form action="addOrders" method="post" >
                        <div class="form-group">
                            <label>Name</label> 
                            <input type="text" 
                                   class="form-control" name="Name" placeholder="Enter name">
                        </div>

                        <div class="form-group">
                            <label>Address</label> 
                            <input type="text" 
                                   class="form-control" name="Address" placeholder="Enter address">
                        </div>

                        <div class="form-group">
                            <label>Phone</label> 
                            <input type="text" 
                                   class="form-control" name="Phone" placeholder="Enter phone">
                        </div>

                        <div class="form-group">
                            <label>Note</label> 
                            <input type="text" 
                                   class="form-control" name="Note" placeholder="Enter note">
                        </div>

                        <div class="form-group">
                            <label>Product Id</label> 
                            <input type="number" 
                                   class="form-control" name="Product_id" placeholder="Enter Product id">
                        </div>

                        <div class="form-group">
                            <label>Quantity</label> 
                            <input type="number" 
                                   class="form-control" name="Quantity" placeholder="Enter Quantity">
                        </div>

                        <button type="submit" class="btn btn-primary">Save</button>
                        <button type="reset" class="btn btn-primary">Cancel</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>