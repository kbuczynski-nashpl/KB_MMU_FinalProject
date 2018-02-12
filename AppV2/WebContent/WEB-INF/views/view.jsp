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
	<%@include file="nav.html"%>
	<div class="page-header container-fluid">
		<h1>${crmCompany.getCompany_name()}</h1>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-3">
				<div class="nav flex-column nav-pills" id="v-pills-tab"
					role="tablist" aria-orientation="vertical">
					<a class="nav-link active" id="v-pills-home-tab" data-toggle="pill"
						href="#v-pills-home" role="tab" aria-controls="v-pills-home"
						aria-selected="true">Main</a> <a class="nav-link"
						id="v-pills-profile-tab" data-toggle="pill"
						href="#v-pills-profile" role="tab" aria-controls="v-pills-profile"
						aria-selected="false">Users</a> <a class="nav-link"
						id="v-pills-messages-tab" data-toggle="pill"
						href="#v-pills-messages" role="tab"
						aria-controls="v-pills-messages" aria-selected="false">Emails</a>
					<a class="nav-link" id="v-pills-settings-tab" data-toggle="pill"
						href="#v-pills-settings" role="tab"
						aria-controls="v-pills-settings" aria-selected="false">Notes</a>
				</div>
			</div>
			<div class="col-9">
				<div class="col-12">
					<div class="tab-content" id="v-pills-tabContent">
						<div class="tab-pane fade show active" id="v-pills-home"
							role="tabpanel" aria-labelledby="v-pills-home-tab">
							<div class="form-group row">
								<label for="company_name_label" class="col-2 col-form-label">Company
									Name: </label>
								<div class="col-9">
									<input class="form-control" type="text"
										value="<c:out value="${crmCompany.getCompany_name()}" />"
										id="company_name" readonly>
								</div>
							</div>
							<div class="form-group row">
								<label for="company_name_label" class="col-2 col-form-label">Company
									Active Email: </label>
								<div class="col-9">
									<input class="form-control" type="text"
										value="<c:forEach items="${crmCompanyEmailAddresses}" var="crmEmail"><c:if test="${crmEmail.getCompany_email_active() == true}">${crmEmail.getCompany_email_address()}</c:if></c:forEach>"
										id="company_name" readonly>
								</div>
							</div>
						</div>
						<div class="tab-pane fade" id="v-pills-profile" role="tabpanel"
							aria-labelledby="v-pills-profile-tab">
							<div class="form-group row">
								<table class="table">
									<thead class="thead-inverse">
										<tr>
											<th>ID</th>
											<th>Forname</th>
											<th>Surnname</th>
											<th>Email</th>
											<th>Phone No</th>
											<th>Phone No Prefix</th>
											<th>Company Postion</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<c:forEach items="${crmCompanyPersonnel}" var="crmPersonnel">
											<td>${crmPersonnel.getId()}</td>
											<td>${crmPersonnel.getCompany_personnel_forname()}</td>
											<td>${crmPersonnel.getCompany_personnel_surname()}</td>
											<td>${crmPersonnel.getCompany_personnel_email()}</td>
											<td>${crmPersonnel.getCompany_personnel_phoneNo()}</td>
											<td>${crmPersonnel.getCompany_personnel_phoneNo_prefix()}</td>
											<td>${crmPersonnel.getCompany_personnel_position()}</td>
											</c:forEach>										
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="tab-pane fade" id="v-pills-messages" role="tabpanel"
							aria-labelledby="v-pills-messages-tab">...</div>
						<div class="tab-pane fade" id="v-pills-settings" role="tabpanel"
							aria-labelledby="v-pills-settings-tab">...</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>