<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../static/head.jsp"%>

<html>
<head>
    <title>信息建设工程欢迎您</title>
</head>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>信息化平台建设</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="${ctx}/statics/plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- icheck bootstrap -->
    <link rel="stylesheet" href="${ctx}/statics/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${ctx}/statics/dist/css/adminlte.min.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
    <style type="text/css">
        .login-page {
            background: url(${ctx}/statics/dist/img/login/loginBackground.png) no-repeat center center fixed;
            background-size: cover;
        }
    </style>
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="../../index2.html"><b>T</b>B</a>
    </div>
    <!-- /.login-logo -->
    <div class="card">
        <div class="card-body login-card-body">
            <p class="login-box-msg">欢迎登录信息化平台建设</p>

            <form action="${ctx}/sys/login/login" method="post">
                <div class="input-group mb-3">
                    <input type="username" class="form-control" name="username" placeholder="用户名">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-envelope"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="password" class="form-control" name="password" placeholder="密码">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-lock"></span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-8">
                        <div class="icheck-primary">
                            <input type="checkbox" id="remember">
                            <label for="remember">
                                记住密码
                            </label>
                        </div>
                    </div>
                    <!-- /.col -->
                    <div class="col-4">
                        <button type="submit" class="btn btn-primary btn-block">登录</button>
                    </div>
                    <!-- /.col -->
                </div>
            </form>

            <div class="social-auth-links text-center mb-3">
                <p>- 第三方系统登录 -</p>
                <a href="#" class="btn btn-block btn-primary">
                    <i class="fab fa-facebook mr-2"></i> 使用QQ登录
                </a>
                <a href="#" class="btn btn-block btn-danger">
                    <i class="fab fa-google-plus mr-2"></i> 使用微信登录
                </a>
            </div>
            <!-- /.social-auth-links -->

            <p class="mb-1">
                <a href="forgot-password.html">忘记密码？</a>
            </p>
            <p class="mb-0">
                <a href="${ctx}/sys/login/register" class="text-center">注册账号？</a>
            </p>
        </div>
        <!-- /.login-card-body -->
    </div>
</div>
<!-- /.login-box -->

<!-- jQuery -->
<script src="${ctx}/statics/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${ctx}/statics/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="${ctx}/statics/dist/js/adminlte.min.js"></script>

</body>
</html>
