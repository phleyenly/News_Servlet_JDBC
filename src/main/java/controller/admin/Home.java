package controller.admin;

import java.io.IOException;


import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CategoryService;
import service.NewsService;
import service.RoleService;

/**
 * Servlet implementation class Home
 */
@WebServlet("/admin/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoryService cateService;
	@Inject
	private NewsService newsService;
	@Inject
	private RoleService roleService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("bantheloai", cateService.findAll());
		request.setAttribute("bannews", newsService.findAll());
		request.setAttribute("role", roleService.findAll());
		request.getRequestDispatcher("/view/admin/home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
