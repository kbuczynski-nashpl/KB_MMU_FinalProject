<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp" />
<body>
	<div class="container">
		<%@include file="nav.jsp"%>
	</div>
	<div class="container" style="margin-top: 65px">
		<div class="row mt-5">
			<div class="col-4">
				<div class="container">
					<c:forEach items="${LAST5CUST}" var="crmCompany">
						<div class="card text-center" style="width: 18rem;">
							<div class="card-body">
								<h5 class="card-title">${crmCompany.getCompany_name()}</h5>
								<a href="view/${crmCompany.getId()}" class="btn btn-primary">Visit</a>
							</div>
						</div>
					</c:forEach>

				</div>
			</div>
			<div class="col-4">
				<div class="conatiner">10 Most recent recent Companies Notes
					(IMPORT JSP)</div>
			</div>
			<div class="col-4">
				<div class="container">Actions due in for the user (IMPORT
					JSP)</div>
			</div>
		</div>
	</div>
</body>
</html>