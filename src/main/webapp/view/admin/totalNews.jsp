<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

<div class="container-fluid px-4">
	<h1 class="mt-4 title"></h1>
	<ol class="breadcrumb mb-4">
		<li class="breadcrumb-item"><a href="./home">Trang chủ</a></li>
		<li class="breadcrumb-item active title"></li>
	</ol>



	<table class="table table-bordered">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Tiêu đề</th>
				<th scope="col">Hình ảnh</th>
				<th scope="col">Thể loại</th>
				<th scope="col">Nội dung</th>
				<th scope="col" style="width: 100px">Tác vụ</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${bannews }">
				<tr>
					<th scope="row">${item.id }</th>
					<td>${item.title}</td>
					<td><img class="image-of-news" alt="" src="${item.thumbnail }"></td>
					<td>${item.category.name }</td>
					<td>${item.content }</td>
					<c:set var="content" value="${ item.content }"></c:set>
					<td><span class="action-news" id="myBtn-${ item.id }"
						onclick="openModal('${item.title}', '${item.thumbnail}','${item.content}')"><i
							class="fa-solid fa-eye "></i> Xem</span><br /> <span
						class="action-news"><a href="./editnews?id=${item.id}"><i
								class="fa fa-pencil"></i> Sửa</a><br /> </span> <span class="action-news"
						onclick="deleteNews('${item.id}')"> <i class="fa fa-trash"></i>
							Xóa
					</span></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<ul class="pagination" id="pagination"></ul>
	<div style="height: 100vh"></div>

	<c:set var="category" value="${ bannews[0].category.name }"></c:set>
	<script type="text/javascript">
		const urlParams = new URLSearchParams(window.location.search)
		var a = 'Tất Cả Bài Viết'
		if (urlParams.get('category-code') != null) {
			a = "${category}"
		}
		var titleElements = document.getElementsByClassName("title")
		for (var i = 0; i < titleElements.length; i++) {
			titleElements[i].innerHTML = a;
		}
	</script>


	<!-- Phan lam cai modal -->

	<!-- Trigger/Open The Modal -->


	<!-- The Modal -->
	<div id="myModal_news" class="modal_news">

		<!-- Modal content -->
		<div class="modal-content_news">
			<span class="close_news">&times;</span>
			<div id="news-modal" class="d-flex">
				<div id="img_news"></div>
				<div>
					<div id="title_news"
						style="text-align: center; margin-bottom: 65px;"></div>
					<div id="content_news" style="margin-left: 35px; font-size: 22px;"></div>
				</div>
			</div>

		</div>

	</div>
</div>
<script>
// Get the modal
var modal = document.getElementById("myModal_news");

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close_news")[0];

// When the user clicks the button, open the modal 


// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
function openModal( title, thumbnail, content) {
	var modal = document.getElementById("myModal_news");
	var titleNews = document.getElementById("title_news"); 
	var contentNews = document.getElementById("content_news");
	var imgNews = document.getElementById("img_news");
	modal.style.display = "block";
	titleNews.innerHTML = "<h1>"+title+"</h1>";
	imgNews.innerHTML = "<img style=\"width: 650px;\" src='"+thumbnail+"'></img>";
	contentNews.innerHTML = "<p>"+content+"</p>";
}

function deleteNews(id){
	$.ajax({
		url: window.location.origin + '<c:url value="/admin/news"/>' +'?id=' +id,		
		type: 'DELETE',
		data: JSON.stringify(),
		success: function(data) {
			alert(data.message)
			window.location.reload()
		}
	})
	
	

}

</script>

<script type="text/javascript">
$('#pagination').twbsPagination({
	totalPages: ${totalPage},
	visiblePages: 5,
	startPage: ${Page},
	onPageClick: function(event, page){
		if(page != ${Page}){
		location.replace("http://localhost:8080/Web_Lesson1/admin/totalnews?page="+page+"&limit=2")
		}
	}
})

</script>
