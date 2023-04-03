package controller.admin.API;

import java.io.BufferedReader;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import model.UserModel;
import service.UserService;

/**
 * Servlet implementation class userr
 */
@WebServlet("/admin/user")
public class userr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @Inject
       private UserService userService;
       
    public userr() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		request.setCharacterEncoding("UTF-8");
		
		BufferedReader userRead = request.getReader();
		Gson gson = new Gson();
		UserModel userModel = gson.fromJson(userRead, UserModel.class);
		System.out.println(userModel);
		
		String message = userService.addUser(userModel);
		
		JsonObject json = new JsonObject();
		json.addProperty("message", message);
		response.getWriter().print(json);
		
		
		
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		request.setCharacterEncoding("UTF-8");
		
		BufferedReader userRead = request.getReader();
		Gson gson = new Gson();
		UserModel userModel = gson.fromJson(userRead, UserModel.class);
		System.out.println(userModel);
		
		String message = userService.editById(userModel);
		
		JsonObject json = new JsonObject();
		json.addProperty("message", message);
		response.getWriter().print(json);
		
	}
 
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		System.out.println(id);
		
		resp.setContentType("application/json");
		String message = userService.deleteById(id);
		
		JsonObject json = new JsonObject();
		json.addProperty("message", message);
		resp.getWriter().print(json);
	}

	
}
