<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp" />
<body>
	<%
		String login_msg = (String) request.getAttribute("error");
		if (login_msg != null)
			out.println("<font color=red size=4px>" + login_msg + "</font>");
	%>
	<div class="container">
		<div class="row">
			<form class="form-horizontal" action='login' method="POST">
				<fieldset>
					<div id="legend">
						<legend>Login</legend>
					</div>
					<div class="control-group container">
						<!-- Username -->
						<label class="control-label" for="username">Username</label>
						<div class="controls">
							<input type="text" id="loginUsername" name="username"
								placeholder="" class="input-xlarge form-control">
						</div>
					</div>
					<div class="control-group container">
						<!-- Password-->
						<label class="control-label" for="password">Password</label>
						<div class="controls">
							<input type="password" id="loginPassword" name="password"
								placeholder="" class="input-xlarge form-control">
						</div>
					</div>
					<div class="control-group container col-md-12">
						<!-- Button -->
						<div class="controls">
							<input type="submit" value="Submit"
								class="btn btn-success form-control">
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>