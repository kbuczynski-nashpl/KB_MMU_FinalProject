<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="row">
		<c:forEach items="${SEARCHRESULT}" var="searchItem"
			varStatus="searchItemInfo">
			<div class="col-sm-4">
				<div class="card text-center">
					<div class="card-block">
						<h3 class="card-title">${searchItem.value.getCompany_name()}</h3>
						<div class="container ">
							<a
								href="${pageContext.request.contextPath}/view/${searchItem.key}"
								class="btn btn-primary form-group col-12">Visit</a>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>