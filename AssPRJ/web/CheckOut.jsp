<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="width: 30%; margin: auto;">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body style="
          background-color: #f8f9fa;
          padding: 20px;
          ">
        <!-- /section-banner -->
        <h1 style="text-align: center;">Check Out</h1>
        <div class="form-section-box">

            <form class="checkout-form" method="POST" action="${pageContext.request.contextPath}/checkout">
                <div class="form-group row">
                    <label class="col-md-4 label-md">Số điện thoại*</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" placeholder="phone" name="phone">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-md-4 label-md">Họ tên</label>
                    <div class="col-md-8">
                        <input type="text" value=""class="form-control" placeholder="Name" name="name">
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-md-4 label-md">Địa chỉ nhận hàng</label>
                    <div class="col-md-8">
                        <textarea class="form-control" placeholder="Address" name="address"></textarea>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-md-4 label-md">Ghi chú cho đơn hàng</label>
                    <div class="col-md-8">
                        <textarea class="form-control" placeholder="Note" name="note"></textarea>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-md-6">
                        <input type="" class="btn btn-info form-control" value="Trở lại">
                    </div>
                    <div class="col-md-6">
                        <button type="submit" class="btn btn-success form-control">CheckOut</button>
                    </div>
                </div>

            </form>
        </div><!-- /form-section-box -->


       
    </body>
</html>