<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<c:if test="${RESULT.STATUS === 'OK'}">
		<div class="alert alert-success">
			<strong>SUCCESS!</strong> You successfully created new CRM entry for
			${RESULT.cc-name}
		</div>
	</c:if>
	<c:if test="${RESULT.STATUS === 'ERROR'}">
		<div class="alert alert-danger">
			<strong>UPPS!</strong> You did not enter all needed information
			please try again.
		</div>
	</c:if>
</div>