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
	<div class="page-header container-fluid">
		<h1>${crmCompany.getCompany_name()} <a href="${pageContext.request.contextPath}/edit/main/${crmCompany.getId()}" class="btn btn-primary">Edit</a></h1> 
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
						aria-selected="false">Personnel</a> <a class="nav-link"
						id="v-pills-email-tab" data-toggle="pill" href="#v-pills-email"
						role="tab" aria-controls="v-pills-email" aria-selected="false">Emails</a>
					<a class="nav-link" id="v-pills-notes-tab" data-toggle="pill"
						href="#v-pills-notes" role="tab" aria-controls="v-pills-notes"
						aria-selected="false">Notes</a>
				</div>
			</div>
			<div class="col-9">
				<div class="tab-content" id="v-pills-tabContent">
					<div class="tab-pane fade show active" id="v-pills-home"
						role="tabpanel" aria-labelledby="v-pills-home-tab">
						<div class="container">
							<h3 class="page-header">Company Information:</h3>
						</div>
						<div class="form-group row container col-12">
							<label for="company_name_label" class="col-2 col-form-label">Company
								Name: </label>
							<div class="col-9">
								<input class="form-control" type="text"
									value="<c:out value="${crmCompany.getCompany_name()}" />"
									id="company_name" readonly>
							</div>
						</div>
						<div class="form-group row container col-12">
							<label for="company_name_label" class="col-2 col-form-label">Company
								Active Email: </label>
							<div class="col-9">
								<input class="form-control" type="text"
									value="<c:forEach items="${crmCompanyEmailAddresses}" var="crmEmail"><c:if test="${crmEmail.getCompany_email_active() == true}">${crmEmail.getCompany_email_address()}</c:if></c:forEach>"
									id="company_name" readonly>
							</div>
						</div>
						<div class="container">
							<h3 class="page-header">Active Address:</h3>
						</div>
						<c:forEach items="${crmCompanyAddresses}" var="crmAddress">
							<c:if test="${crmAddress.getCompany_address_active() == true}">
								<div class="container row form-group col-12">
									<label for="company_address1_label"
										class="col-2 col-form-label">Address Line 1</label>
									<div class="col-9">
										<input class="form-control" type="text"
											value="${crmAddress.getCompany_address_line1()}"
											id="company_active_address_line1" readonly></input>
									</div>
								</div>
								<div class="container row form-group col-12">
									<lable for="company_address2_label"
										class="col-2 col-form-label">Address Line 2</lable>
									<div class="col-9">
										<input class="form-control" type="text"
											value="${crmAddress.getCompany_address_line2()}"
											id="company_active_address_line2" readonly></input>
									</div>
								</div>
								<div class="container row form-group col-12">
									<lable for="company_postcode_label"
										class="col-2 col-form-label">Post Code</lable>
									<div class="col-9">
										<input class="form-control" type="text"
											value="${crmAddress.getCompany_address_postcode()}"
											id="company_active_address_postcode" readonly></input>
									</div>
								</div>
								<div class="container row form-group col-12">
									<lable for="company_city_label" class="col-2 col-form-label">City</lable>
									<div class="col-9">
										<input class="form-control" type="text"
											value="${crmAddress.getCompany_address_city()}"
											id="company_active_address_city" readonly></input>
									</div>
								</div>
								<div class="container row form-group col-12">
									<lable for="company_country_label" class="col-2 col-form-label">Country</lable>
									<div class="col-9">
										<input class="form-control" type="text"
											value="${crmAddress.getCompany_address_country()}"
											id="company_active_address_line2" readonly></input>
									</div>
								</div>
							</c:if>
						</c:forEach>
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

									<c:forEach items="${crmCompanyPersonnel}" var="crmPersonnel"
										varStatus="crmPersonnelInfo">
										<tr>
											<td><a id="edit_user_${crmPersonnel.getId()}"
												href="${pageContext.request.contextPath}/edit/personnel/${crmPersonnel.getId()}">${crmPersonnelInfo.count}</a></td>
											<td>${crmPersonnel.getCompany_personnel_forname()}</td>
											<td>${crmPersonnel.getCompany_personnel_surname()}</td>
											<td>${crmPersonnel.getCompany_personnel_email()}</td>
											<td>${crmPersonnel.getCompany_personnel_phoneNo()}</td>
											<td>${crmPersonnel.getCompany_personnel_phoneNo_prefix()}</td>
											<td>${crmPersonnel.getCompany_personnel_position()}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>

					<div class="tab-pane fade" id="v-pills-email" role="tabpanel"
						aria-labelledby="v-pills-email-tab">
						<div class="form-group row">
							<table class="table">
								<thead class="thead-inverse">
									<tr>
										<th>ID</th>
										<th>Email Address</th>
										<th>Active</th>
										<th>Email Type</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${crmCompanyEmailAddresses}"
										var="crmEmailAddress" varStatus="crmEmailInfo">
										<tr>
											<td><a id="edit_email_${crmEmailAddress.getId()}"
												href="${pageContext.request.contextPath}/edit/email/${crmEmailAddress.getId()}">${crmEmailInfo.count}</a></td>
											<td>${crmEmailAddress.getCompany_email_address()}</td>
											<td><c:if
													test="${crmEmailAddress.getCompany_email_active() == true}">
													<span class="badge badge-success">TRUE</span>
												</c:if></td>
											<td>${crmEmailAddress.getCompany_email_type()}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<div class="tab-pane fade" id="v-pills-notes" role="tabpanel"
						aria-labelledby="v-pills-notes-tab">
						<div class="form-group row">
							<table class="table">
								<thead class="thead-inverse">
									<tr>
										<th>Id</th>
										<th>Note Title</th>
										<th>Note</th>
										<th>Last Edited by</th>
										<th>Last Edited time</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${crmCompanyNotes}" var="crmNote"
										varStatus="crmNoteInfo">
										<tr>
											<td><a id="edit_note_${crmNote.getId()}"
												href="${pageContext.request.contextPath}/edit/note/${crmNote.getId()}">${crmNoteInfo.count}</a></td>
											<td>${crmNote.getCrm_company_note_title()}</td>
											<td>${crmNote.getCompany_note(25)}</td>
											<td>${crmNote.getCompany_note_by_id()}</td>
											<td>${crmNote.getCompany_note_by_dateToString()}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>