<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SimplyKB</title>
</head>
<body>
	<%
		String login_msg = (String) request.getAttribute("error");
		if (login_msg != null)
			out.println("<font color=red size=4px>" + login_msg + "</font>");
	%>
	<form action="login" method="POST">
		<label>Username: </label> <input type="text" name="username"
			id="loginUsername"> <label>Password: </label> <input
			type="password" name="password" id="loginPassword"> <input
			type="submit" value="Submit">
	</form>
</body>
</html>