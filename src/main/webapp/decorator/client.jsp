<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Lina News</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/image/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="assets/css/styles.css" rel="stylesheet"/>
<link href="assets/css/list.css" rel="stylesheet"/>
</head>
<body>
	<!-- phan header -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="./home"> Lina News Home</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<c:forEach var="item" items="${bantheloai}" begin="0" end="3" ><li class="nav-item"><a class="nav-link" href="./list?categoryCode=${item.code }">${item.name }</a></li>
					</c:forEach>
					<li class="nav-item"><a class="nav-link" href="./logout">Đăng Xuất</a></li>
				</ul>
			</div>
		</div>
	</nav>



	<decorator:body> </decorator:body>
	<!-- phan footer -->

	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Trụ sở: Thủ Đức - Hồ Chí Minh</p>
		</div>
	</footer>
</body>
</html>