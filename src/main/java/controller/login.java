package controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import model.UserModel;
import service.UserService;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private UserService userService;

	public login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rq = request.getRequestDispatcher("/view/login.jsp");
		rq.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		BufferedReader reader = request.getReader();
		Gson gson = new Gson();
		String mess = "";
		JsonObject js = new JsonObject();

		UserModel userModel = gson.fromJson(reader, UserModel.class);
//		System.out.println(userModel.getUserName());
//		System.out.println(userModel.getPassWord());

		UserModel userReturn = userService.findByUserName(userModel.getUserName());
		// System.out.println(userReturn.getFullName());
		if (userReturn == null) {
			mess = "Tên đăng nhập hoặc mật khẩu không đúng";
		} else if (!userReturn.getPassWord().equals(userModel.getPassWord())) {
			mess = "Tên đăng nhập hoặc mật khẩu không đúng";
		} else {
			mess = "Đăng nhập thành công";
			UserModel usResponse = new UserModel(userReturn.getFullName(), userReturn.getRoleModel());
			
			request.getSession().setAttribute("user", usResponse);
			js.addProperty("role",usResponse.getRoleModel().getName() );
			
		}
		// System.out.println(mess);
		js.addProperty("mess", mess);
		response.getWriter().print(js);
	}
}
