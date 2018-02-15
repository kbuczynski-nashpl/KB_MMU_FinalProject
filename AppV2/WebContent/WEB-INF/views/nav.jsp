<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar fixed-top navbar-light bg-light"
	style="position: fixed;">
	<a class="navbar-brand" href="index">WebKB CRM</a>
	<div class="container">
		<input class="form-control mr-sm-2" type="text" placeholder="Search"
			id="search_navBar">
	</div>
	<i id="toggleNav" class="fa fa-bars fa-2x" onclick="toggleNav()"
		style="left: 2%;"></i>

</nav>
<div class="panel-main" style="display: none;" id="panel-main">
	<div class="panel-content">

		<div class="row">
			<div class="col-md-6">
				<i data-aria="hidden" class="fa fa-home fa-3x"></i>
			</div>

			<div class="col-md-6">
				<p>Home</p>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6">
				<i data-aria="hidden" class="fa fa-info fa-3x"></i>
			</div>

			<div class="col-md-6">
				<p>About</p>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6">
				<i data-aria="hidden" class="fa fa-address-book fa-3x"></i>
			</div>

			<div class="col-md-6">
				<p>Contact</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<i data-aria="hidden" class="fa fa-sign-out-alt fa-3x"></i>
			</div>

			<div class="col-md-6">
				<a href="${pageContext.request.contextPath}/logout"><p>Sign
						Out</p></a>
			</div>
		</div>

	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="searchModal" tabindex="-1" role="dialog"
	aria-labelledby="searchModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content" id="modalContent"
			style="padding: 3%">
			<div class="modal-body" id="modalBody"></div>
		</div>
	</div>
</div>
<script>
	
</script>
<style>
#toggleNav {
	cursor: pointer;
}

.panel-main {
	background-color: white;
	max-width: 800px;
	max-height: auto;
	min-width: 180px;
	min-height: auto;
	box-shadow: 1px 1px 2px 2px #ccc;
	z-index: 1000;
	position: fixed;
	top: auto;
	right: 1%;
}

.panel-content {
	text-align: center;
}

.panel-content i {
	color: #4B515D;
}

.panel-content p {
	margin-top: 12px;
	margin-left: -10px;
	font-size: 18px;
	text-align: left;
}

.panel-content .row {
	
}

.panel-content .row:hover {
	/* background-color: rgba(75, 81, 93, 0.4);*/
	cursor: pointer;
}

.panel-footer {
	text-align: center;
	padding: 0;
	margin-bottom: -10px;
}
</style>
