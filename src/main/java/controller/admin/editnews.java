package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CategoryModel;
import model.NewsModel;
import service.CategoryService;
import service.NewsService;

/**
 * Servlet implementation class Home
 */
@WebServlet("/admin/editnews")
public class editnews extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoryService cateService;
	@Inject
	private NewsService newsService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		request.setAttribute("news", newsService.findById(id));
		
		request.setAttribute("bantheloai", cateService.findAll());
		 RequestDispatcher rq = request.getRequestDispatcher("/view/admin/editNews.jsp");
		rq.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
