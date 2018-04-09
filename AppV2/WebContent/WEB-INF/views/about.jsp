<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="header.jsp" />
</head>
<%@include file="nav.jsp"%>
<body>
	<div class="container">
		<div class="container text-center">
			<h3>WebKB CRM Platform</h3>
			<br />
			<h3 class="text-muted">- The Future Built From The Past -</h3>
			<br />
			<h4>About</h4>
			<br />
			<p class="">In daily office life, each person has to deal with a
				customer. Sometimes it is hard to keep track of everyone using
				notepads, books, sticky notes. The revolution is to move away from
				paperwork and start working online where information can be safely
				shared across the whole company. The Customer Relationship
				Management system is a tool that allows adding and keep track of any
				customer store their essential information within the system. The
				WebKB CRM platform offers a simple solution to all everyday office
				needs within CRM system. The WebKB is a simple environment with a
				simple interface where everyone can use within minimal effort.</p>
			<br />
		</div>

		<div class="container text-center">
			<h4>Team:</h4>
			<br />
			<div class="container text-center">
				<div class="card text-center" style="width: 23%; left: 38%;">
					<img
						src="${pageContext.request.contextPath}/resource/img/kbuczynski-img.png"
						alt="kbuczynski-img" class="img-thumbnail">
					<div class="card-body">
						<h5 class="card-title">Krzysztof Buczynski</h5>
						<h6>Leading Developer</h6>
						<br />
						<div class="container col-12  text-center">
							<h6>Contact Information:</h6>
							<div class="container text-center">
								<a class="btn btn-info btn-social-media-about" type="button"
									href="mailto:13131612@stu.mmu.ac.uk"><i class="fas fa-at"></i>
									Email Me</a> <a class="btn btn-info btn-social-media-about"
									type="button" href="https://twitter.com/NashPL"><i
									class="fab fa-twitter"></i> Twitter</a> <a
									class="btn btn-info btn-social-media-about" type="button"
									href="https://www.linkedin.com/in/krzysztof-buczynski-59008b152/"><i
									class="fab fa-linkedin-in"></i> LinkedIn</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>