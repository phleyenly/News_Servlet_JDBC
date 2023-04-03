package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

/**
 * Servlet implementation class logout
 */
@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		JsonObject js = new JsonObject();
		String mess = "";
		if(request.getSession().getAttribute("user") != null) {
			request.getSession().removeAttribute("user");
			mess = "Đăng Xuất Thành Công";
			js.addProperty("mess", mess);
			response.getWriter().print(js);
			
			response.sendRedirect(request.getContextPath() + "/login");
		} else {
			mess = "Bạn chưa đăng nhập";
			js.addProperty("mess", mess);
			response.getWriter().print(js);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
