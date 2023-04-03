<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

<link href="assets/css/list.css" rel="stylesheet"/>
<body>
	<!-- Responsive navbar-->

	<!-- Page header with logo and tagline-->
	<header class="py-5 bg-light border-bottom mb-4">
		<div class="container">
			<div class="text-center my-5">
				<h1 class="fw-bolder">Tất cả các bản tin mới nhất</h1>
				<p class="lead mb-0">Chính xác - Đáng tin cậy</p>
			</div>
		</div>
	</header>
	<!-- Page content-->
	<div class="container">
		<div class="row">
			<!-- Blog entries-->
			<div class="col-lg-8">
				<!-- Featured blog post-->
				<!-- Nested row for non-featured blog posts-->
				<div class="row">
					<c:forEach var="news" items="${ bannews }">
						<div class="col-lg-6">
							<!-- Blog post-->
							<div class="card mb-4">
								<a href="#!"><img class="card-img-top"
									src="${news.thumbnail }" alt="..." /></a>
								<div class="card-body">
									<div class="small text-muted">January 1, 2022</div>
									<a  class="format-a" href="./newsdetail?title=${news.title }">
										<h2 class="card-title h4">${ news.title }</h2>
									</a>
									<p class="card-text">${ news.content }</p>
									<a class="btn btn-primary"
										href="./newsdetail?title=${news.title }">Read more →</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>


				<!-- Pagination-->
				<nav aria-label="Pagination">
					<hr class="my-0" />
					<ul class="pagination justify-content-center my-4">
						<li class="page-item disabled"><a class="page-link" href="#"
							tabindex="-1" aria-disabled="true">Newer</a></li>
						<li class="page-item active" aria-current="page"><a
							class="page-link" href="#!">1</a></li>
						<li class="page-item"><a class="page-link" href="#!">2</a></li>
						<li class="page-item"><a class="page-link" href="#!">3</a></li>
						<li class="page-item disabled"><a class="page-link" href="#!">...</a></li>
						<li class="page-item"><a class="page-link" href="#!">15</a></li>
						<li class="page-item"><a class="page-link" href="#!">Older</a></li>
					</ul>
				</nav>
			</div>
			<!-- Side widgets-->
			<div class="col-lg-4">
				<!-- Search widget-->
				<!-- Categories widget-->
				<%@include file="/common/client/category.jsp" %>
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
