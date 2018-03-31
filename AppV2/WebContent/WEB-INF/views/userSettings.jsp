<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="header.jsp" />
</head>
<%@include file="nav.jsp"%>
<body>
	<div class="container">
		<h3 class="page-header">Settings</h3>
	</div>
		<div class="container">
	<%
		String error_msg = (String) request.getAttribute("error");
		String success_msg = (String) request.getAttribute("success");
		if (error_msg != null) {
			out.println("<script>window.onload = function() { createNewAlert('ERROR','" + error_msg +"',true); };</script>");
		}
		if (success_msg != null) {
					out.println("<script>window.onload = function() { createNewAlert('SUCCESS','" + success_msg +"',true); };</script>");
		}
		
		request.getSession().removeAttribute("EDIT_RESPONSE");
	%>	
	</div>
	<div class="form-control" style="margin-top: 1%; margin-bottom:1%;">
	<div class="container">
		<h5 class="page-header">User Information</h5>
		<div class="form-group row col-12 container">
			<div class="col-3">
				<label class="col-form-label">Company Name: </label>
			</div>
			<div class="col-9">
				<input class="form-control" name="" type="text"
					value="${CUM.getUser_company_name()}" readonly required />
			</div>
		</div>
		<div class="form-group row col-12 container">
			<div class="col-3">
				<label class="col-form-label">Username: </label>
			</div>
			<div class="col-9">
				<input class="form-control" name="" type="text"
					value="${CU.getUser_username()}" readonly required />
			</div>
		</div>
	</div>
</div>

	<form action="${pageContext.request.contextPath}/settings/post"
		method="post" class="form-control" style="margin-top: 1%; margin-bottom:1%;">
		<div class="container">
			<h5 class="page-header">User Details</h5>
			<div class="form-group row col-12 container">
				<div class="col-3">
					<label class="col-form-label">Surname: </label>
				</div>
				<div class="col-9">
					<input class="form-control" name="userSurname" type="text" value="${CUI.getUser_surname()}"
						required />
				</div>
			</div>
			<div class="form-group row col-12 container">
				<div class="col-3">
					<label class="col-form-label">Forname: </label>
				</div>
				<div class="col-9">
					<input class="form-control" name="userForname" type="text" value="${CUI.getUser_forname() }"
						required />
				</div>
			</div>
			<div class="form-group row col-12 container">
				<div class="col-3">
					<label class="col-form-label">Date Of Birth: </label>
				</div>
				<div class="col-9">
					<input class="form-control" name="userDOB" type="date" value="${CUI.getUser_dobFromString()}"
						required />
				</div>
			</div>
		</div>
		<div class="container col-12  text-center" style="padding-top: 1%;">
			<input style="display: none;" value="true" name="usersettingstype"
				readonly /> <input class="btn btn-danger col-8  form-control"
				id="btnSubmit" type="submit" value="Submit User Details" />
		</div>
	</form>
	<form action="${pageContext.request.contextPath}/settings/post"
		method="post" class="form-control" style="margin-top: 1%; margin-bottom:1%;">
		<div class="container">
			<h5 class="page-header">User Security</h5>
			<div class="form-group row col-12 container">
				<div class="col-3">
					<label class="col-form-label">New Password: </label>
				</div>
				<div class="col-9">
					<input class="form-control" name="userPsw" type="password" value=""
						required />
				</div>
			</div>
			<div class="form-group row col-12 container">
				<div class="col-3">
					<label class="col-form-label">Confirm New Password: </label>
				</div>
				<div class="col-9">
					<input class="form-control" name="userConfPsw" type="password"
						value="" required />
				</div>
			</div>
		</div>
		<div class="container col-12  text-center" style="padding-top: 1%;">
			<input style="display: none;" value="true" name="usersettingspswtype"
				readonly /> <input class="btn btn-danger col-8  form-control"
				id="btnSubmit" type="submit" value="Change Password" />
		</div>
	</form>
	<form action="${pageContext.request.contextPath}/settings/post"
		method="post" class="form-control" style="margin-top: 1%; margin-bottom:1%;">
		<div class="container">
			<h5 class="page-header">User Contact</h5>
			<div class="form-group row col-12 container">
				<div class="col-3">
					<label class="col-form-label">Email: </label>
				</div>
				<div class="col-9">
					<input class="form-control" name="userEmail" type="email"
						value="${CU.getUser_email()}" required />
				</div>
			</div>
		</div>
		<div class="container col-12  text-center" style="padding-top: 1%;">
			<input style="display: none;" value="true"
				name="usersettingsemailtype" readonly /> <input
				class="btn btn-danger col-8  form-control" id="btnSubmit"
				type="submit" value="Submit User Email" />
		</div>
	</form>
</body>
</html>