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
 * Servlet implementation class TotalAccount
 */
@WebServlet("/admin/account")
public class TotalAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private NewsService newsService;
	@Inject
	private CategoryService cateService;
	@Inject
	private RoleService roleService;
	@Inject 
	private UserService userService;
       
    public TotalAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("bantheloai", cateService.findAll());
		request.setAttribute("bannews", newsService.findAll());
		request.setAttribute("role", roleService.findAll());
		//request.setAttribute("user", userService.findAll());
		RequestDispatcher rq = request.getRequestDispatcher("/view/admin/totalAccount.jsp");
		
		String RoleCode = request.getParameter("rolecode");
		if(RoleCode == null) {
			request.setAttribute("user", userService.findAll());
		}else {
			request.setAttribute("user", userService.findByRoleCode(RoleCode));
		}
		
		rq.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
