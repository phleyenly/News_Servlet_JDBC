<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

<div class="container-fluid px-4">
	<h1 id="title" class="mt-4">${ news.title }  <c:if test="${news == null }"> Thêm Bài Viết</c:if></h1>
	<ol class="breadcrumb mb-4">
		<li class="breadcrumb-item"><a href="./home">Trang chủ</a></li>

		<li class="breadcrumb-item active ">${ news.title } <c:if test="${news == null }"> Thêm Bài Viết</c:if></li>
	</ol>


	<main>
		<div class="container-fluid px-4">

			<div class="card mb-4">
				<div class="card-body">
					<div class="mb-3 row">
						<div class="col-md-3">
							<div class="form-group">
								<label for="idModel">ID</label> <input type="text"
									class="form-control" id="idModel" value="${news.id}" disabled>
							</div>
						</div>
						<div class="col-md-9">
							<div class="form-group">
								<label for="title">Tiêu đề</label> <input type="text"
									class="form-control" id="title2" name="title"
									value="${news.getTitle()}">
							</div>
						</div>
					</div>
					<div class="mb-3 row">
						<div class="col-md-4">
							<div class="form-group">
								<label for="thumbnail">Ảnh bìa</label> <input type="text"
									class="form-control" id="thumbnail" name="thumbnail"
									value="${news.getThumbnail()}">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="categoryId">Thể Loại</label> <select
									class="form-control" id="categoryId" name="categoryId">
									<option>Chọn thể loại</option>
									<c:forEach var="item" items="${bantheloai }">
										<option <c:if test="${item.id ==news.categoryId}"> selected</c:if > value="${ item.id }">${item.name}
										</option>
									</c:forEach>
								</select>

							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="shortdescripsion">Mô Tả Ngắn</label> <input
									type="text" class="form-control" id="shortdescripsion"
									name="shortdescripsion" value="${news.shortdescription}">
							</div>
						</div>
					</div>

					<div class="mb-3 row">
						<div class="form-group">
							<label for="content">Nội Dung</label>
							<textarea rows="7" class="form-control " id="content"
								name="content">${ news.getContent()}</textarea>
						</div>
					</div>
					</form>
					<c:if test="${news != null }">
					<button id="edit" class="btn btn-success waves-effect waves-light "
						onclick="editNews()">
						<i class="ri-save-fill "></i> Xác Nhận
					</button>
					</c:if>
					
					<c:if test="${news == null }">
					<button id="edit" class="btn btn-success waves-effect waves-light "
						onclick="createNews()">
						<i class="ri-save-fill "></i> Xác Nhận
					</button>
					</c:if>
				</div>
			</div>
		</div>
	</main>


</div>

<script type="text/javascript">
	function editNews() {
		console.log(window.location.origin + '<c:url value="/admin/news"/>');
		console.log(document.getElementById("idModel").value);
		console.log(document.getElementById("title2").value);
		console.log(document.getElementById("thumbnail").value);
		console.log(document.getElementById("shortdescripsion").value);
		console.log(document.getElementById("categoryId").value);
		console.log(document.getElementById("content").value);
        $.ajax({
            url: window.location.origin + '<c:url value="/admin/news"/>',
            method : "PUT",
            dataType: "json",
            data : JSON.stringify ({
                id: document.getElementById("idModel").value,
                title : document.getElementById("title2").value,
                thumbnail: document.getElementById("thumbnail").value,
                shortdescripsion: document.getElementById("shortdescripsion").value,
                categoryId: document.getElementById("categoryId").value,
                content: document.getElementById("content").value,

            }),
            success : function(data){
                if(data.message != null){
                    alert(data.message)
                    window.location.reload()
                }
            },
            error: function(error){
                console.log(error)
            }
        }

        )

	}
	
	//them san pham
	function createNews() {
		console.log(window.location.origin + '<c:url value="/admin/news"/>');
		console.log(document.getElementById("title2").value);
		console.log(document.getElementById("thumbnail").value);
		console.log(document.getElementById("shortdescripsion").value);
		console.log(document.getElementById("categoryId").value);
		console.log(document.getElementById("content").value);
		$.ajax({
            url: window.location.origin + '<c:url value="/admin/news"/>',
            method : "POST",
            dataType: "json",
            data : JSON.stringify ({
                title : document.getElementById("title2").value,
                thumbnail: document.getElementById("thumbnail").value,
                shortdescripsion: document.getElementById("shortdescripsion").value,
                categoryId: document.getElementById("categoryId").value,
                content: document.getElementById("content").value,

            }),
            success : function(data){
                if(data.mess != null){
                    alert(data.mess)
                    window.location.reload()
                }
            },
            error: function(error){
                console.log(error)
            }
        }

        )

	}

	
	
</script>
 