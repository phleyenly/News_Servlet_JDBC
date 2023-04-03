<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
	
	
<div class="container-fluid px-4">
	<h1 class="mt-4 title"></h1>
	<ol class="breadcrumb mb-4">
		<li class="breadcrumb-item"><a href="./home">Trang chủ</a></li>
		<li class="breadcrumb-item active title"> Tất Cả Các Tài Khoản</li>
	</ol>
	
<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">UserName</th>
      <th scope="col">PassWord</th>
      <th scope="col">FullName</th>
      <th scope="col">Vai Trò</th>
      <th scope="col">Tác Vụ</th>
      
    </tr>
  </thead>
  <tbody>
  <c:forEach var="user" items="${user }">
    <tr>
      <th scope="row">${user.id }</th>
      <td>${user.userName}</td>
      <td>${user.passWord}</td>
       <td>${user.fullName}</td>
       <td>${user.roleModel.name}</td>
      <td>
      <span > <a href="./edituser?id=${user.id }"><i class="fa fa-pencil"></i>  Sửa</a></span><br />
      <span onclick="deleteuser('${user.id}')"><i class="fa fa-trash" ></i> Xóa</span>
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>

</div>
 
 
<script type="text/javascript">

const ulrPagram = new URLSearchParams(window.location.search)
var a = "Tất Cả Tài Khoản"
if(ulrPagram.get("rolecode") != null){
  a = "${role[0].name}"
}
var titleElements = document.getElementsByClassName("title")
for ( var i = 0; i < titleElements.length ; i++){
  titleElements[i].innerHTML = a;

}


function deleteuser(id){
  $.ajax({
    url : window.location.origin + '<c:url value="/admin/user"/>' +"?id=" + id,
    type: 'DELETE',
		data: JSON.stringify(),
		success: function(data) {
			alert(data.message)
			window.location.reload()
    }
  })
}
</script> 