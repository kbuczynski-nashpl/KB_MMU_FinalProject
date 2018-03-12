<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="row">
		<c:forEach items="${SEARCHRESULT}" var="searchItem"
			varStatus="searchItemInfo">
			<div class="col-sm-4" style="padding: 1%;">
				<div class="card text-center" style="height: 120px">
						<div class="card-header" style="height: 45%; padding: 3%;">
						<p class="card-title">${searchItem.value.getCompany_name()}</p>
					</div>
					<div class="car-body" style="padding: 2%; margin: 1%">
						<a href="${pageContext.request.contextPath}/view/${searchItem.key}" class="btn btn-primary">Visit</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>