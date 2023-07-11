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

            <form class="checkout-form" method="post" action="">
                <div class="form-group row">
                    <label class="col-md-4 label-md">Số điện thoại*</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" placeholder="phone" name="phone">
                    </div>
                </div>
                <div class="col-md-10">
                    <input type="hidden" value=""class="form-control" placeholder="Name" name="userID">
                </div>
                <div class="form-group row">
                    <label class="col-md-4 label-md">Họ tên</label>
                    <div class="col-md-8">
                        <input type="text" value=""class="form-control" placeholder="Name" name="username">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-md-4 label-md">Email</label>
                    <div class="col-md-8">
                        <input type="email" class="form-control" placeholder="Email" name="email">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-md-4 label-md">Địa chỉ nhận hàng</label>
                    <div class="col-md-8">
                        <textarea class="form-control" placeholder="Adress" name="adress"></textarea>
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
                        <input type="submit" class="btn btn-info form-control" value="Trở lại">
                    </div>
                    <div class="col-md-6">
                        <input type="submit" class="btn btn-success form-control" value="Thanh toán">
                    </div>
                </div>

            </form>
        </div><!-- /form-section-box -->


        <script>
            $(document).on("click", ".del-order", (function () {
                var idOrder = $(this).attr("idOrder");
                //lấy dữ liêu
                swal.fire({
                    title: 'Bạn Có Chắc Chắn?',
                    text: "Sản phẩm sẽ bị xóa khỏi giỏ hàng.!",
                    icon: 'warning',
                    padding: '3em',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Đồng Ý, Xóa!',
                    cancelButtonText: 'Hủy bỏ',
                    reverseButtons: true,
                    customClass: null
                }).then((result) => {
                    if (result.value) {
                        $.ajax({
                            async: false,
                            type: "post",
                            url: "<%=request.getContextPath()%>/addtocart",
                            data: {idOrder: idOrder},
                            success: function (data) {
                                if (data == false) {
                                    Swal.fire(
                                            'Thông Báo!',
                                            'Bạn không thể xóa sản phẩm này này.',
                                            'danger'
                                            ).then(function () {
                                        location.reload();
                                    })
                                } else {
                                    Swal.fire(
                                            'Thành công!',
                                            'Bạn đã xóa thành công một sản phẩm.',
                                            'success'
                                            ).then(function () {
                                        location.reload();
                                    })
                                }
                            },
                            error: function (xhr, ajaxOptions, thrownError) {
                                Swal.fire(
                                        'Thông Báo!',
                                        'Thao tác không thể thực hiện.',
                                        'danger'
                                        ).then(function () {
                                    location.reload();
                                })
                            }
                        });
                    } else if (result.dismiss === Swal.DismissReason.cancel) {
                        swal.fire(
                                'Thất bại',
                                'Bạn Chưa thực hiện xóa',
                                'error'
                                )
                    }
                })
            }))
        </script>
    </body>
</html>