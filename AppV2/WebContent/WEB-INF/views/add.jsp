<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />
<div class="container-fluid">
	<div class="container" id="add-new-page-1">
		<div class="container">
			<h4 class="page-header">Company Information</h4>
		</div>
		<div class="form-group row">
			<label class="col-3 col-form-label">Company Name: </label>
			<div class="col-9">
				<input class="form-control" type="text" placeholder="Company Name"
					id="company-name-input" required>
			</div>
		</div>
	</div>
	<div class="container" id="add-new-page-2" style="display: none">
		<div class="container">
			<h4 class="page-header">Address Information:</h4>
		</div>
		<div class="container" id="company-address-info">
			<div class="form-group row">
				<label class="col-3 col-form-label">Address Line 1: </label>
				<div class="col-9">
					<input class="form-control" type="text"
						placeholder="Address Line 1" id="company-address-line1-input"
						required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-3 col-form-label">Address Line 2: </label>
				<div class="col-9">
					<input class="form-control" type="text"
						placeholder="Address Line 2" id="company-address-line2-input">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-3 col-form-label">Post Code: </label>
				<div class="col-9">
					<input class="form-control" type="text" placeholder="Post Code"
						id="company-address-postcode-input" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-3 col-form-label">Company City: </label>
				<div class="col-9">
					<input class="form-control" type="text" placeholder="City"
						id="company-address-city-input" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-3 col-form-label">Country: </label>
				<div class="col-9">
					<input class="form-control" type="text" placeholder="Country"
						id="company-address-country-input" required>
				</div>
			</div>
		</div>
	</div>
	<div class="container" id="add-new-page-3" style="display: none">
		<div class="container">
			<div class="container" id="company-email-info">
				<h4 class="page-header">Company Email:</h4>
				<div class="form-group row">
					<label class="col-3 col-form-label">Email Address: </label>
					<div class="col-9">
						<input class="form-control" type="email"
							placeholder="Email Address" id="company-email-address-input"
							required>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-3 col-form-label">Email Type: </label>
					<div class="col-9">
						<input class="form-control" type="text" placeholder="Email Type"
							id="company-email-type-input" required>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-3 form-check-label">Active: </label>
					<div class="col-9">
						<input class="form-check-input form-control" type="checkbox"
							checked id="company-email-active-input" required>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container" id="add-new-page-4" style="display: none">
		<div class="container" id="company-phone-info">
			<div class="container">
				<h5 class="page-header">Company Phone Number:</h5>
			</div>
			<div class="form-group row">
				<label class="col-3 col-form-label">Phone Number: </label>
				<div class="col-9">
					<input class="form-control" type="number" placeholder="Phone Number"
						id="company-phone-number-input" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-3 col-form-label">Phone Prefix: </label>
				<div class="col-9">
					<input class="form-control" type="text" placeholder="Phone Prefix"
						id="company-phone-prefix-input" required>
				</div>
			</div>
		</div>
			<button class="btn btn-primary container" id="submitNew">Submit</button>
	</div>
</div>
<div class="container fixed-bottom">
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
			<li id="pagination-previous" class="page-item"><a class="page-link"
				id="pagination-page-previous" href="#" tabindex="-1">Previous</a></li>
			<li id="pagination-1" class="page-item"><a class="page-link"
				id="pagination-page-1" href="#">1</a></li>
			<li id="pagination-2" class="page-item"><a class="page-link"
				id="pagination-page-2" href="#">2</a></li>
			<li id="pagination-3"class="page-item"><a class="page-link"
				id="pagination-page-3" href="#">3</a></li>
			<li id="pagination-4"class="page-item"><a class="page-link"
				id="pagination-page-4" href="#">4</a></li>
			<li class="page-item"><a class="page-link"
				id="pagination-page-next" href="#">Next</a></li>
		</ul>
	</nav>
</div>
<script>
	$(document).ready(function() {
		$("#add-new-page-1").attr("class", "active");
		$("#pagination-1").addClass("active");
		$('#pagination-page-previous').on("click", function() {
			displayPage("PREVIOUS");
		});
		$('#pagination-page-1').on("click", function() {
			displayPage("1");
		});
		$('#pagination-page-2').on("click", function() {
			displayPage("2");
		});
		$('#pagination-page-3').on("click", function() {
			displayPage("3");
		});
		$('#pagination-page-4').on("click", function() {
			displayPage("4");
		});
		$('#pagination-page-next').on("click", function() {
			displayPage("NEXT");
		});
		$('#submitNew').on("click", function(){
			dataBuildUp();
		});
		
	});
	function displayPage(pageValue) {
		let activeDiv = $(".active");
		let currentPageNo = activeDiv.attr('id').split("-")[3];
		switch (pageValue) {
		case "PREVIOUS":
			if (currentPageNo != 1) {
				$("#add-new-page-" + currentPageNo).toggle().removeClass(
						"active");
				$("#pagination-" + currentPageNo).removeClass("active");
				currentPageNo--;
				$("#add-new-page-" + currentPageNo).fadeIn(1000).attr("class",
						"active");
				$("#pagination-" + currentPageNo).addClass("active");
			}
			break;
		case "NEXT":
			if (currentPageNo != 4) {
				$("#add-new-page-" + currentPageNo).toggle().removeClass(
						"active");
				$("#pagination-" + currentPageNo).removeClass("active");
				currentPageNo++;
				$("#add-new-page-" + currentPageNo).fadeIn(1000).attr("class",
						"active");
				$("#pagination-" + currentPageNo).addClass("active");
			}
			break;
		case "1":
			$("#add-new-page-" + currentPageNo).toggle().removeClass("active");
			$("#pagination-" + currentPageNo).removeClass("active");
			$("#pagination-1").addClass("active");
			$("#add-new-page-1").fadeIn(1000).attr("class", "active");
			break;
		case "2":
			$("#add-new-page-" + currentPageNo).toggle().removeClass("active");
			$("#pagination-" + currentPageNo).removeClass("active");
			$("#pagination-2").addClass("active");
			$("#add-new-page-2").fadeIn(1000).attr("class", "active");
			break;
		case "3":
			$("#add-new-page-" + currentPageNo).toggle().removeClass("active");
			$("#pagination-" + currentPageNo).removeClass("active");
			$("#pagination-3").addClass("active");
			$("#add-new-page-3").fadeIn(1000).attr("class", "active");
			break;
		case "4":
			$("#add-new-page-" + currentPageNo).toggle().removeClass("active");
			$("#pagination-" + currentPageNo).removeClass("active");
			$("#pagination-4").addClass("active");
			$("#add-new-page-4").fadeIn(1000).attr("class", "active");
			break;
		default:
			break;
		}
	}

	function dataBuildUp() {
			let data = {};
			let url = window.location.origin + "/AppV2/add";
			data.companyName = $("#company-name-input").val();
			data.addressline1 = $("#company-address-line1-input").val();
			data.addressline2 = $("#company-address-line2-input").val();
			data.addresspostcode = $("#company-address-postcode-input").val();
			data.addresscity = $("#company-address-city-input").val();
			data.addresscountry = $("#company-address-country-input").val();
			data.emailaddress = $("#company-email-address-input").val();
			data.emailtype = $("#company-email-type-input").val();
			data.emailactive = $("#company-email-active-input").val();
			data.phoneNonumber = $("#company-phone-number-input").val();
			data.phoneNoprefix = $("#company-phone-prefix-input").val();
			redirectPost(url, data);
	}
	
	function redirectPost(url, data) {
		data.isModal = true;
		data.modalId = "#modalAddBody";
		$("#modalAddBody").html("");
		console.log(data);
		ajaxCall("add", data);
	}
</script>


