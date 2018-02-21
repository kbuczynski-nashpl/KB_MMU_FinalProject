<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="container col-12">
	<table class="table">
		<tbody>
			<tr>
				<th>Company Name</th>
				<td><input id="companyName" class="form-control col-9"
					value="${postVariables.companyName}" readonly required /></td>
			</tr>
			<tr>
				<th>Address Line 1</th>
				<td><input id="companyAddressLine1" class="form-control col-9"
					value="${postVariables.companyAddressLine1}" readonly required /></td>
			</tr>
			<tr>
				<th>Address Line 2</th>
				<td><input id="companyAddressLine2" class="form-control col-9"
					value="${postVariables.companyAddressLine2}" readonly required /></td>
			</tr>
			<tr>
				<th>Address Post Code</th>
				<td><input id="companyAddressPostcode"
					class="form-control col-9"
					value="${postVariables.companyAddressPostcode}" readonly required /></td>
			</tr>
			<tr>
				<th>Address City</th>
				<td><input id="companyAddressCity" class="form-control col-9"
					value="${postVariables.companyAddressCity}" readonly required /></td>
			</tr>
			<tr>
				<th>Address Country</th>
				<td><input id="companyAddressCountry"
					class="form-control col-9"
					value="${postVariables.companyAddressCountry}" readonly required /></td>
			</tr>
			<tr>
				<th>Email Address</th>
				<td><input id="companyEmailAddress" class="form-control col-9"
					value="${postVariables.companyEmailAddress}" readonly required /></td>
			</tr>
			<tr>
				<th>Active Email</th>
				<td><input id="companyEmailActive"
					class="form-control-checkbox col-9" type="checkbox" readonly
					required
					<c:if test="${postVariables.companyEmailActive == 'on'}">checked</c:if> /></td>
			</tr>
			<tr>
				<th>Phone Number</th>
				<td><input id="companyPhoneNumber" class="form-control col-9"
					value="${postVariables.companyPhoneNumber}" readonly required /></td>
			</tr>
			<tr>
				<th>Phone Number Prefix</th>
				<td><input id="companyPhonePrefix" class="form-control col-9"
					value="${postVariables.companyPhoneNoPrefix}" readonly required /></td>
			</tr>
		</tbody>
	</table>
	<div class="container right" id="divSubmitConfirm">
		<button class="btn btn-primary" id="btnSubtmiConfirm">Submit</button>
	</div>
</div>

<script>
	$(document).ready(function() {
		$("#btnSubtmiConfirm").on("click", function() {
			submit();
		});

		function submit() {
			data = {};
			data.isModal = false;
			data.responseRequired = true;
			let response = ajaxCall("add/confirm", data);
			if (response === "200") {
				alert("success");
			}

		}
	});
</script>