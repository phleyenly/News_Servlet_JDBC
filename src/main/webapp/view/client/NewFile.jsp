<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

<body>
	<!-- Responsive navbar-->

	<!-- Page header with logo and tagline-->
	<header class="py-5 bg-light border-bottom mb-4">
		<div class="container">
			<div class="text-center my-5">
				<h1 class="fw-bolder">Chào Mừng Bạn Ghé Thăm!!!</h1>
				<p class="lead mb-0"> Lina News - Người bạn của mọi nhà!</p>
			</div>
		</div>
	</header>
	<!-- Page content-->
	<div class="container">
		<div class="row">
			<!-- Blog entries-->
			<div class="col-lg-8">
				<!-- Featured blog post-->
				<div class="card mb-4">
					<a href="#!"><img class="card-img-top"
						src="${bannews[0].thumbnail}" alt="..." /></a>
					<div class="card-body">
						<div class="small text-muted">January 1, 2022</div>
						<h2 class="card-title">${bannews[0].title}</h2>
						<p class="card-text">${bannews[0].content}</p>
						<a class="btn btn-primary" href="./newsdetail?title=${bannews[0].title }">Read more →</a>
					</div>
				</div>
				<!-- Nested row for non-featured blog posts-->


				<!-- Pagination-->
				
			</div>
			<!-- Side widgets-->
			<div class="col-lg-4">
				<!-- Search widget-->
				
				<!-- Categories widget-->
				<%@include file="/common/client/category.jsp" %>
				</div>
				<!-- Side widget-->
				
			</div>
		</div>
	</div>
	<!-- Footer-->

	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="assets/js/scripts.js"></script>
</body>
</html>
