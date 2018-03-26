<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar fixed-top navbar-light bg-light container-fluid">
	<button class="navbar-toggler float-right" type="button"
		data-toggle="collapse" data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon" style="padding: 1%;"></span>
	</button>
	<a class="navbar-brand" href="${pageContext.request.contextPath}/index" style="margin: 1%;">WebKB
		CRM</a>
	<div class="container col-8" style="padding: 1%">
		<input class="form-control container" type="text" placeholder="Search"
			id="search_navBar">
	</div>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/index"><i class="fas fa-home"></i> Home <span
					class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item">
				<a class="nav-link" href="${pageContext.request.contextPath}/usersettings"><i class="fas fa-cogs"></i> User Settings <span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item">
			 <a class="nav-link" href="${pageContext.request.contextPath}/about"><i class="fas fa-question-circle"></i> Information <span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="${pageContext.request.contextPath}/logout"><i class="fas fa-sign-out-alt"></i> Logout <span class="sr-only">(current)</span></a>
			</li>
		</ul>
	</div>
</nav>

<!-- Modal Search Box -->
<div class="modal fade" id="searchModal" tabindex="-1" role="dialog"
	aria-labelledby="searchModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content" id="modalContentSearchBox"
			style="padding: 3%">
			<div class="modal-body" id="modalSearchBody"
				style="margin-top: 2%; margin-bottom: 5%"></div>
		</div>
	</div>
</div>

<!-- Modal Add Box -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
	aria-labelledby="addModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content" id="modalContentAddNewBox"
			style="padding: 3%">
			<div class="modal-header container" id="addModalHeader"></div>
			<div class="modal-body container" id="modalAddBody"
				style="margin-top: 2%; margin-bottom: 5%;"></div>
		</div>
	</div>
</div>

<div id="Add">
	<a id="add_new_btn" href="#"> Add New Company </a>
</div>
<style>
body {
	padding-top: 1%;
}

@media all and (max-width: 1024px) {
	body {
		padding-top: 11%;
	}
}

#Add {
	height: 0px;
	width: 105px;
	position: fixed;
	left: 2%;
	top: 95%;
	z-index: 1000;
	border-radius: 25px;
	transform: rotate(-90deg);
	-webkit-transform: rotate(0deg);
	-moz-transform: rotate(0deg);
	-o-transform: rotate(0deg);
}

#Add a {
	display: block;
	background: #000;
	height: 52px;
	padding-top: 10px;
	width: 170px;
	text-align: center;
	border-radius: 25px 25px 0px 0px;
	color: #fff;
	font-family: Arial, sans-serif;
	font-size: 17px;
	font-weight: bold;
	text-decoration: none;
}

#Add a:hover {
	background: #00495d;
}
</style>
