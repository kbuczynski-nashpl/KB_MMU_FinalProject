<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp" />
<%@include file="nav.jsp"%>
<body class="container">
	<div class="container">
		<div class="row mt-5">
			<div class="col-4">
				<div class="container">
					<c:forEach items="${LAST5CUST}" var="crmCompany">
						<div class="card text-center" style="width: 18rem; margin-top: 1%; height: 5rem">
							<div class="card-body" style="padding: 1%">
								<h5 class="card-title">${crmCompany.getCompany_name()}</h5>
								<a href="view/${crmCompany.getId()}" type="button" class="badge badge-primary form-control">Visit</a>
							</div>
						</div>
					</c:forEach>

				</div>
			</div>
			<div class="col-4">
				<div class="conatiner">
					<c:forEach items="${LAST5NOTES}" var="crmNotes">
					<div class="card text-center" style="width: 18rem; margin-top: 1%; height: 5rem">
							<div class="card-body" style="padding: 1%">
								<h5 class="card-title">${crmNotes.getCompany_note_title()}</h5>
								<div class="container">
									<labe class="badge badge-light">Assigned To: ${crmNotes.getCompany_note_assignedToName().getFullName()}</label>
								</div>
								<a href="view/${crmNotes.getCompany_id()}" type="button" class="badge badge-primary form-control">Visit</a>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="col-4">
				<div class="container">Actions due in for the user (IMPORT
					JSP)</div>
			</div>
		</div>
	</div>
</body>
</html>