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
	<%@include file="nav.jsp"%>
	<div class="container">
		<h1 class="page-header">Email: ${CCEA.getCompany_email_address()}</h1>
	</div>
	<form
		action="${pageContext.request.contextPath}/edit/email/${CCEA.getId()}"
		method="post">
		<div class="container form-control" style="padding: 2%;">
			<div class="form-group row container col-12">
				<div class="col-4">
					<label class="col-form-label">Email Address: </label>
				</div>
				<div class="col-8">
					<input class="form-control" name="emailAddress"
						value="${CCEA.getCompany_email_address()}" required/>
				</div>
			</div>
			<div class="form-group row container col-12">
				<div class="col-4">
					<label class="col-form-label">Email Address Type: </label>
				</div>
				<div class="col-8">
					<input class="form-control" name="emailType"
						value="${CCEA.getCompany_email_type()}" required/>
				</div>
			</div>
		</div>
		<div class="containercol-12" style="padding-top: 1%;">
			<div class="float-right">
				<input  class="btn btn-danger" id="btnSubmit" type="submit" value="Submit"/>
				<input style="display:none;" value="true" name="type" readonly/>
			</div>
			<div class="float-left">
				<a href="${pageContext.request.contextPath}/view/${CC.getId()}"
					class="btn btn-primary">Return</a>
			</div>
		</div>
	</form>
</body>
</html>