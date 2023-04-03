package controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.RoleService;
import service.UserService;

/**
 * Servlet implementation class createuser
 */
@WebServlet("/admin/createuser")
public class createuser extends HttpServlet {
	@Inject
	private RoleService role ;
	@Inject 
	private UserService userService;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createuser() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("roleId", role.findAll());
		request.setAttribute("user", userService.findAll());
		RequestDispatcher rq = request.getRequestDispatcher("/view/admin/createUser.jsp");
		rq.forward(request, response);
	}


}
