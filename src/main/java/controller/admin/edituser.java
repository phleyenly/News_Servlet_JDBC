package controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CategoryService;
import service.NewsService;
import service.RoleService;
import service.UserService;

/**
 * Servlet implementation class edituser
 */
@WebServlet("/admin/edituser")
public class edituser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private UserService userService;
	
    public edituser() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		request.setAttribute("user", userService.findById(id));
		
		
		RequestDispatcher rq = request.getRequestDispatcher("/view/admin/editUser.jsp");
		rq.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
