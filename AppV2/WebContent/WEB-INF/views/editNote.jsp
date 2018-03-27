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
		<h1 class="page-header">${CCN.getCompany_note_title()}</h1>
	</div>
	<div class="container">
		<%
			String error_msg = (String) request.getAttribute("error");
			String success_msg = (String) request.getAttribute("success");
			if (error_msg != null) {
				out.println(
						"<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\"><strong>Error: </strong>"
								+ error_msg
								+ "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button></div>");
			}
			if (success_msg != null) {
				out.println(
						"<div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\"><strong>Success: </strong>"
								+ success_msg
								+ "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button></div>");
			}
			request.getSession().removeAttribute("EDIT_RESPONSE");
		%>
	</div>
	<form
		action="${pageContext.request.contextPath}/edit/note/${CCN.getId()}"
		method="post">
		<div class="container form-control" style="padding: 2%;">
			<div class="form-group row container col-12">
				<div class="col-4">
					<label class="col-form-label">User Id: </label>
				</div>
				<div class="col-8">
					<input class="form-control" name="noteUserId"
						value="${USER.getId()}" readonly />
				</div>
			</div>
			<div class="form-group row container col-12">
				<div class="col-4">
					<label class="col-form-label">Note Title: </label>
				</div>
				<div class="col-8">
					<input class="form-control" name="noteTitle"
						value="${CCN.getCompany_note_title()}" required />
				</div>
			</div>
			<div class="form-group row container col-12">
				<div class="col-4">
					<label class="col-form-label"> Status: </label>
				</div>
				<div class="col-8">
					<select class="form-control" name="noteStatus">
						<c:forEach items="${NOTE_STATUS}" var="status">
							<c:choose>
								<c:when test="${CCN.getCompany_note_status() eq status}">
									<option value="${status}" selected>${status}</option>
								</c:when>
								<c:when test="${CCN.getCompany_note_status() != status}">
									<option value="${status}">${status}</option>
								</c:when>
							</c:choose>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group row container col-12">
				<div class="col-4">
					<label class="col-form-label">Assigned To: </label>
				</div>
				<div class="col-8">
					<select class="form-control" name="noteAssigne">
						<c:forEach items="${USER_INFO}" var="assigne">
							<c:choose>
								<c:when
									test="${CCN.getCompany_note_assignedToName().getFullName() eq assigne}">
									<option value="${assigne.getId()}" selected>${assigne.getUser_surname()}
										${assigne.getUser_forname()}</option>
								</c:when>
								<c:when
									test="${CCN.getCompany_note_assignedToName().getFullName() != assigne}">
									<option value="${assigne.getId()}">${assigne.getUser_surname()}
										${assigne.getUser_forname()}</option>
								</c:when>
							</c:choose>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group row container col-12">
				<div class="col-4">
					<label class="col-form-label">Due In: </label>
				</div>
				<div class="col-8">
					<input class="form-control" name="noteDuein"
						value="${CCN.getCompany_note_dueinToStringToFrom()}"
						type="datetime-local" required />
				</div>
			</div>
			<div class="form-group row container col-12">
				<div class="col-4">
					<label class="col-form-label">Note: </label>
				</div>
				<div class="col-8">
					<textarea class="form-control" name="note">${CCN.getCompany_note(0)}</textarea>
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
				<a href="${pageContext.request.contextPath}/view/${CC.getId()}"
					class="btn btn-primary">Return</a>
			</div>
		</div>
	</form>
</body>
</html>