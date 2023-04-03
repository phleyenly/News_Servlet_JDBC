<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="layoutSidenav_nav">
	<nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
		<div class="sb-sidenav-menu">
			<div class="nav">
				<div class="sb-sidenav-menu-heading">Core</div>
				<a class="nav-link" href="index.html">
					<div class="sb-nav-link-icon">
						<i class="fas fa-tachometer-alt"></i>
					</div> Dashboard
				</a>
				<div class="sb-sidenav-menu-heading">Interface</div>
				<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
					data-bs-target="#collapseLayouts" aria-expanded="false"
					aria-controls="collapseLayouts">
					<div class="sb-nav-link-icon">
						<i class="fas fa-columns"></i>
					</div> Quản Lý Người Dùng
					<div class="sb-sidenav-collapse-arrow">
						<i class="fas fa-angle-down"></i>
					</div>
				</a>
				<div class="collapse" id="collapseLayouts"
					aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
					<nav class="sb-sidenav-menu-nested nav">
						<a class="nav-link" href="./account">Tất Cả Tài Khoản</a>
						<a class="nav-link" href="./createuser">Thêm Tài Khoản</a>
						<c:forEach var="roles" items="${role }">
							<a class="nav-link" href="./account?rolecode=${roles.code }">${roles.name }</a>
						</c:forEach>
					</nav>
				</div>
				<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
					data-bs-target="#collapsePages" aria-expanded="false"
					aria-controls="collapsePages">
					<div class="sb-nav-link-icon">
						<i class="fas fa-book-open"></i>
					</div> Quản Lý Bài Viết
					<div class="sb-sidenav-collapse-arrow">
						<i class="fas fa-angle-down"></i>
					</div>
				</a>
				<div class="collapse" id="collapsePages"
					aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
					<nav class="sb-sidenav-menu-nested nav accordion"
						id="sidenavAccordionPages">

						<a class="nav-link" href="./totalnews">Tất Cả Bài Viết</a> <a
							class="nav-link" href="./createnews">Thêm Bài Viết</a>
						<c:forEach var="item" items="${bantheloai }">
							<a class="nav-link" href="./totalnews?category-code=${item.code}">${item.name}
							</a>
						</c:forEach>
					</nav>
				</div>
				<div class="sb-sidenav-menu-heading">Addons</div>
				<a class="nav-link" href="charts.html">
					<div class="sb-nav-link-icon">
						<i class="fas fa-chart-area"></i>
					</div> Charts
				</a> <a class="nav-link" href="tables.html">
					<div class="sb-nav-link-icon">
						<i class="fas fa-table"></i>
					</div> Tables
				</a>
			</div>
		</div>
		<div class="sb-sidenav-footer">
			<div class="small">Logged in as:</div>
			Start Bootstrap
		</div>
	</nav>
</div>