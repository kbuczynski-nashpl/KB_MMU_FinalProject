<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="header.jsp" />
</head>
<body class="bg">
	<div class="error">
		<div class="error-code m-b-10 m-t-20">
			404 <i class="fas fa-exclamation"></i>
		</div>
		<h3 class="font-bold">We couldn't find the page..</h3>

		<div class="error-desc">
			Sorry, but the page you are looking for was either not found or does
			not exist. <br /> Try refreshing the page or click the button below
			to go back to the Homepage.
			<div>
				<a class=" login-detail-panel-button btn" href="index"> <i
					class="fas fa-home"></i> Go back to Homepage
				</a> <a href="mailto:someone@example.com?Subject=Feedback:%20"
					target="_top" class="login-detail-panel-button btn"><i
					class="fas fa-envelope"></i> Send Feedback</a>
			</div>
		</div>
	</div>
</body>
<style>
.bg {
	background: #d2c9dd;
}

.error {
	background: #ffffff;
	margin: 0 auto;
	text-align: center;
	box-shadow: 5px 10px 8px 10px #888888;
}

.error-code {
	padding-top: 2%;
	bottom: 65%;
	color: #2d353c;
	font-size: 102px;
	line-height: 102px;
}

.error-desc {
	font-size: 14px;
	color: #647788;
}

.m-b-10 {
	margin-bottom: 15px !important;
}

.m-b-20 {
	margin-bottom: 25px !important;
}

.m-t-20 {
	margin-top: 25px !important;
}
</style>
</html>