<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="header.jsp" />
</head>
<body>
	<%
		String login_msg = (String) request.getAttribute("response");
		if (login_msg != null)
			out.println("<font color=red size=4px>" + login_msg + "</font>");
	%>
	<%@include file="nav.jsp"%>
	<div class="container">
		<h1 class="page-header">New Address</h1>
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
			}%>
	</div>
	<form
		action="${pageContext.request.contextPath}/new/postaddress/${COMPANY_ID}"
		method="post">
		<div class="container form-control" style="padding: 2%;">
			<div class="form-group row container col-12">
				<div class="col-4">
					<label class="col-form-label">Address Line 1: </label>
				</div>
				<div class="col-8">
					<input class="form-control" name="addressLine1" value="" required />
				</div>
			</div>
			<div class="form-group row container col-12">
				<div class="col-4">
					<label class="col-form-label">Address Line 2: </label>
				</div>
				<div class="col-8">
					<input class="form-control" name="addressLine2" value="" />
				</div>
			</div>
			<div class="form-group row container col-12">
				<div class="col-4">
					<label class="col-form-label">Address Postcode: </label>
				</div>
				<div class="col-8">
					<input class="form-control" name="addressPostcode" maxlength="10"
						value="" required />
				</div>
			</div>
			<div class="form-group row container col-12">
				<div class="col-4">
					<label class="col-form-label">Address City: </label>
				</div>
				<div class="col-8">
					<input class="form-control" name="addressCity" value="" required />
				</div>
			</div>
			<div class="form-group row container col-12">
				<div class="col-4">
					<label class="col-form-label">Address Country: </label>
				</div>
				<div class="col-8">
					<input class="form-control" name="addressCountry" value="" required />
				</div>
			</div>
		</div>
		<div class="containercol-12" style="padding-top: 1%;">
			<div class="float-right">
				<input class="btn btn-danger" id="btnSubmit" type="submit"
					value="Submit" /> <input style="display: none;" value="true"
					name="type" readonly />
			</div>
			<div class="float-left">
				<a href="${pageContext.request.contextPath}/view/${COMPANY_ID}"
					class="btn btn-primary">Return</a>
			</div>
		</div>
	</form>
</body>
</html>