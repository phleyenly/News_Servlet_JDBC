<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="login-page">
	<div class="form">
			<input id="username" type="text" placeholder="username"  name="username"/> 
			<input id="password" type="password" placeholder="password"  name="password"/>
			<p id="mess"></p>
			<button id="login-button">login</button>
			<p class="message">
				Not registered? <a href="#">Create an account</a>
			</p>
		
	</div>
</div>

<script type="text/javascript">
$("#login-button").click(() => {
	//console.log("hhajjaajajjaj")
$.ajax({
	
	method: "POST",
	url:"http://localhost:8080/Web_Lesson1/login",
	contentType: 'application/json',
	dataType: 'json',
	data: JSON.stringify({
		userName: $("#username").val(),
		passWord: $("#password").val(),
		//console.log($("#username").val());

	}),
	success: function(data) {
		if(data!=null){
			document.getElementById("mess").innerHTML = data.mess
			if(data.role =="admin"){
				location.replace('http://localhost:8080/Web_Lesson1/admin/home')
			}else if(data.role =="user"){
				location.replace('http://localhost:8080/Web_Lesson1/home')

			}
		}

	}

})




})

</script>