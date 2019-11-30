
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>FoodyBag SignUp</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="assets/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="assets/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="assets/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/css/util.css">
	<link rel="stylesheet" type="text/css" href="assets/css/main.css">
<!--===============================================================================================-->
</head>
<body style="background-color: #9b59b6;">
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form" method="POST" enctype='multipart/form-data'>
					<span class="login100-form-title p-b-43">
						Signup to FoodyBag
					</span>
                     <c:set var="errmsg" scope="page" value="${errorMsg}"></c:set>
                    <c:if test="${errmsg != null}">
                        <div>
                            <span style="font-size: 15px;">${errmsg}</span>
                        </div>
                    </c:if>
                    
					
                    <div class="wrap-input100 validate-input" >
                        <input class="input100" type="text" name="first_name">
						<span class="focus-input100"></span>
						<span class="label-input100">First Name</span>
					</div>

					<div class="wrap-input100 validate-input" >
						<input class="input100" type="text" name="last_name">
						<span class="focus-input100"></span>
						<span class="label-input100">Last Name</span>
					</div>
                                        <div class="wrap-input100 validate-input" >
						<input class="input100" type="text" name="address">
						<span class="focus-input100"></span>
						<span class="label-input100">Address</span>
					</div>
                                        <div class="wrap-input100 validate-input" >
						<input class="input100" type="text" name="contact">
						<span class="focus-input100"></span>
						<span class="label-input100">Contact</span>
					</div>


					<div class="wrap-input100 validate-input" >
						<input class="input100" type="email" name="email">
						<span class="focus-input100"></span>
						<span class="label-input100">Email</span>
					</div>
					
					
					<div class="wrap-input100 validate-input" data-validate="Password is required">
						<input class="input100" type="password" name="pass">
						<span class="focus-input100"></span>
						<span class="label-input100">Password</span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Password is required">
						<input class="input100" type="password" >
						<span class="focus-input100"></span>
						<span class="label-input100">Re-Type Password</span>
					</div>
					<div class="wrap-input100 validate-input" data-validate="Photo is required">
						<input class="input100" type="file" name="file" >
						<span class="focus-input100"></span>
						<span class="label-input100">Select your photo</span>
					</div>
					
					<div class="container-signup100-form-btn">
						<button type="submit" class="login100-form-btn">
							Sign up
						</button>
					</div>

					
				</form>

				<div class="login100-more" style="background-image: url('assets/images/bglg.jpg');">
				</div>
			</div>
		</div>
	</div>
	
	

	

	
	
<!--===============================================================================================-->
	<script src="assets/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="assets/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="assets/vendor/bootstrap/js/popper.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="assets/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="assets/vendor/daterangepicker/moment.min.js"></script>
	<script src="assets/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="assets/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="assets/js/main.js"></script>

</body>
</html>