<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<c:if test="${STATUS eq 'ERROR'}">
	<div class="alert alert-danger">
		<p>Upps! We could not create new company. We are missing some information. Please try again !</p>
		<div class="container">
			<label>Missing Inforamtion</label><input class="form-control" id="wrongInput" value="${MSG}" readonly/>
		</div>
	</div>
	</c:if>
	<c:if test="${STATUS eq 'OK'}">
	<div class="alert alert-success">
		<p>New Company has been created</p>
		<div class="container">
			<a href="view/${ID}" class="btn btn-primary form-control">Visit new company page</a>
		</div>
	</div>
	</c:if>
</div>