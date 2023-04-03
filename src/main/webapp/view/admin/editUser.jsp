<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

<div class="container-fluid px-4">
	<h1 class="mt-4 title"> ${user[0].fullName } </h1>
	<ol class="breadcrumb mb-4">
		<li class="breadcrumb-item"><a href="./account">Tất Cả Tài Khoản</a></li>
		<li class="breadcrumb-item active title">${user[0].fullName } </li>
	</ol>



<div class="container">
<div class="row gutters">


<div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
<div class="card h-100">
	<div class="card-body">
		<div class="row gutters">
			<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
				<h6 class="mb-2 text-primary">Thông Tin Tài Khoản</h6>
			</div>
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
				<div class="form-group">
					<label for="fullName">User Name</label>
					<input type="text" class="form-control" id="userName" placeholder="Enter full name"   value="${user[0].userName}">
				</div>
			</div>
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
				
			</div>
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
				<div class="form-group">
					<label for="phone">Pass Word</label>
					<input type="text" class="form-control" id="passWord" placeholder="Enter phone number"  value="${user[0].passWord}">
				</div>
			</div>
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
				
			</div>
		</div>
		<div class="row gutters">
			<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
			</div>
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
				<div class="form-group">
					<label for="Street">Full Name</label>
					<input type="name" class="form-control" id="fullName" placeholder="Enter Street"  value="${user[0].fullName}">
				</div>
			</div>
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
				
			</div>
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
				<div class="form-group">
					<label for="sTate">Vai Trò</label>
					
					<input type="text" class="form-control" id="role" placeholder="Enter State" value="${user[0].roleModel.name}" disabled>
				</div>
			</div>
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
				
			</div>
		</div>
		<div class="row gutters">
			<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12"><br>
				<div class="text-right">
					<button type="button" id="submit" name="submit" class="btn btn-secondary" onclick="canceluser()">Cancel</button>
					<button type="button" id="submit" name="submit" class="btn btn-primary" onclick="edituser()">Update</button>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
</div>
</div>




</div>

<script type="text/javascript">
function edituser(){
	//console.log(window.location.origin + '<c:url value="/admin/user"/>');
$.ajax({
url : window.location.origin + '<c:url value="/admin/user"/>',
method: "PUT",
dataType: "json",
data: JSON.stringify({
	id: "${user[0].id}",
	userName: document.getElementById("userName").value,
	passWord: document.getElementById("passWord").value,
	fullName: document.getElementById("fullName").value,

}),
	success: function(data){
		if(data.message != null){
			alert(data.message)
            window.location.reload()
		}
	},

	error: function(data){
		console.log(error)
	}


})




}

function canceluser(){
	window.location.reload()
}

</script>

