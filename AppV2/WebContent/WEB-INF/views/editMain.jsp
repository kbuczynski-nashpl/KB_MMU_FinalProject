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
		<h1 class="page-header">${CC.getCompany_name()}</h1>
	</div>
	<div class="container form-control" style="padding: 2%;">
		<div class="container" style="padding: 1%">
			<label class="label">Company Active Email:</label>
			<div class="col">
				<select id="selAddress" name="emailAddress" class="form-control">
					<c:forEach items="${CCEA}" var="email">
						<c:if test="${email.getCompany_email_active() == true }">
							<option value="${email.getId()}" selected>${email.getCompany_email_address()}</option>
						</c:if>
						<c:if test="${email.getCompany_email_active() == false }">
							<option value="${email.getId()}">${email.getCompany_email_address()}</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="container" style="padding: 1%">
			<label class="label">Company Active Email:</label>
			<div class="col">
				<select id="selEmailAddress" name="address" class="form-control">
					<c:forEach items="${CCA}" var="address">
						<c:if test="${address.getCompany_address_active() == true }">
							<option value="${address.getId()}" selected>${address.toString()}</option>
						</c:if>
						<c:if test="${address.getCompany_address_active() == false }">
							<option value="${address.getId()}" selected>${address.toString()}</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
		</div>
	</div>
	<div class="containercol-12" style="padding-top: 1%;">
		<div class="float-right">
		<button class="btn btn-danger" id="btnSubmit" type="button">Submit</button>
		</div>
		<div class="float-left">
			<a href="${pageContext.request.contextPath}/view/${CC.getId()}" class="btn btn-primary">Return</a>
		</div>
	</div>
</body>
</html>

<script>
$(document).ready(function() {
	$("#btnSubmit").on("click", function(){
		submitMainEdit();
	});
})

function submitMainEdit(){
	let data = [];
	data.companyId = ${CC.getId()};
	data.emailAddress = $("#selEmailAddress").val();
	data.address = $("#selselAddress").val();
	data.type = "TRUE";
	//TODO: SEND TO /edit/main/1 url
}
</script>