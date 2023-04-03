<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="card mb-4">
					<div class="card-header">Thể Loại</div>
					<div class="card-body">
						<div class="row">
						<c:forEach var="item" items="${bantheloai}" >
							<div class="col-sm-6">
								<ul class="list-unstyled mb-0">
									
										<li><a href="./list?categoryCode=${item.code }">${item.name }</a></li>
									
								</ul>
							</div>
							</c:forEach>
						</div>
					</div>
				</div>