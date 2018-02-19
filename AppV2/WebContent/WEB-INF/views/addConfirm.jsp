<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp" />
<div class="container col-12">
	<table class="table">
		<tbody>
			<tr>
				<th>Company Name</th>
				<td><input id="companyName" class="form-control col-6"
					value="${postVariables.companyName}" readonly required /></td>
				<td id="td-companyName"><a href="#" id="btn-companyName"
					class="editBtn"><i class="fas fa-pencil-alt"></i></a></td>
			</tr>
			<tr>
				<th>Address Line 1</th>
				<td><input id="companyAddressLine1" class="form-control col-6"
					value="${postVariables.companyAddressLine1}" readonly required /></td>
				<td id="td-companyAddressLine1"><a href="#"
					id="btn-companyAddressLine1" class="editBtn"><i
						class="fas fa-pencil-alt"></i></a></td>
			</tr>
			<tr>
				<th>Address Line 2</th>
				<td><input id="companyAddressLine2" class="form-control col-6"
					value="${postVariables.companyAddressLine2}" readonly required /></td>
				<td id="td-companyAddressLine2"><a href="#"
					id="btn-companyAddressLine2" class="editBtn"><i
						class="fas fa-pencil-alt"></i></a></td>
			</tr>
			<tr>
				<th>Address Post Code</th>
				<td><input id="companyAddressPostcode"
					class="form-control col-6"
					value="${postVariables.companyAddressPostcode}" readonly required /></td>
				<td id="td-companyAddressPostcode"><a href="#"
					id="btn-companyAddressPostcode" class="editBtn"><i
						class="fas fa-pencil-alt"></i></a></td>
			</tr>
			<tr>
				<th>Address City</th>
				<td><input id="companyAddressCity" class="form-control col-6"
					value="${postVariables.companyAddressCity}" readonly required /></td>
				<td id="td-companyAddressCity"><a href="#"
					id="btn-companyAddressCity" class="editBtn"><i
						class="fas fa-pencil-alt"></i></a></td>
			</tr>
			<tr>
				<th>Address Country</th>
				<td><input id="companyAddressCountry"
					class="form-control col-6"
					value="${postVariables.companyAddressCountry}" readonly required /></td>
				<td id="td-companyAddressCountry"><a href="#"
					id="btn-companyAddressCountry" class="editBtn"><i
						class="fas fa-pencil-alt"></i></a></td>
			</tr>
			<tr>
				<th>Email Address</th>
				<td><input id="companyEmailAddress" class="form-control col-6"
					value="${postVariables.companyEmailAddress}" readonly required /></td>
				<td id="td-companyEmailAddress"><a href="#"
					id="btn-companyEmailAddress" class="editBtn"><i
						class="fas fa-pencil-alt"></i></a></td>
			</tr>
			<tr>
				<th>Active Email</th>
				<td><input id="companyEmailActive"
					class="form-control-checkbox col-6" type="checkbox" readonly
					required
					<c:if test="${postVariables.companyEmailActive == 'on'}">checked</c:if> /></td>
			</tr>
			<tr>
				<th>Phone Number</th>
				<td><input id="companyPhoneNumber" class="form-control col-6"
					value="${postVariables.companyPhoneNumber}" readonly required /></td>
				<td id="td-companyPhoneNumber"><a href="#"
					id="btn-companyPhoneNumber" class="editBtn"><i
						class="fas fa-pencil-alt"></i></a></td>
			</tr>
			<tr>
				<th>Phone Number Prefix</th>
				<td><input id="companyPhonePrefix" class="form-control col-6"
					value="${postVariables.companyPhoneNoPrefix}" readonly required /></td>
				<td id="td-companyPhonePrefix"><a href="#"
					id="btn-companyPhonePrefix" class="editBtn"><i
						class="fas fa-pencil-alt"></i></a></td>
			</tr>
		</tbody>
	</table>
	<div class="container right" id="divSubmitConfirm">
		<button class="btn btn-primary" id="btnSubmitConfrim">Submit</button>
	</div>
</div>

<script>
	$(document).ready(
			function() {
				checkForValidated();
				$('.editBtn').on("click", function() {
					enableEdit(this.id);
				});
				
				if (this.validate == true) {
					$('#divSubmitConfirm').toggle();
				}
				
				function enableEdit(id) {
					let inputBoxId = null;
					let inputBox = null
					if (id.indexOf("-") != -1) {
						inputBoxId = id.slice(4);
						inputBox = $("#" + inputBoxId);
					} else {
						inputBoxId = id;
						inputBox = $("#" + inputBoxId);
					}
					inputBox.attr("readonly", false);
					$("#btn-" + inputBoxId).attr("style", "display: none");
					let saveBtn = $("<a/>");
					saveBtn.attr("href", "#'");
					saveBtn.on("click", function() {
						saveInput(inputBoxId);
					});
					saveBtn.attr("id", "save-" + inputBoxId);
					let saveGliphicon = $("<i/>").attr("class", "fas fa-save");
					saveGliphicon.appendTo(saveBtn);
					saveBtn.appendTo($("#td-" + inputBoxId));

				}

				function saveInput(id) {
					console.log(id);
					$("#save-" + id).remove();
					$("#btn-" + id).toggle();
					$("#" + id).attr("readonly", true).attr("class",
							"form-control col-6");
				}

				function checkForValidated() {
					$("input").each(function() {
						var element = $(this);
						var elementId = $(this).attr("id");
						let result = true;
						if (element.val() == "" || element.val() == undefined) {
							element.addClass("form-control-danger is-invalid");
							enableEdit(elementId);
							result = false;
						}
					});
				}
				function submit(data, result){
					if(result !== true){
						checkForValidated();
						alert("Please complete the form");
					} else {
						data.isModal = false;
						data.newCompanySubmit = true;
						data.responseRequired = true;
						let response = ajaxCall("add", data);
						if(response === "200"){
							alert("success");
						}
						
					}
				}
			});
</script>