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

/**
 * Servlet implementation class CreateNews
 */
@WebServlet("/admin/createnews")
public class CreateNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoryService cateService;
	@Inject
	private NewsService newsService;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Long id = Long.parseLong(request.getParameter("id"));
//		request.setAttribute("news", newsService.findById(id));
//		
		request.setAttribute("bantheloai", cateService.findAll());
		System.out.println("123");
		 RequestDispatcher rq = request.getRequestDispatcher("/view/admin/editNews.jsp");
		rq.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
