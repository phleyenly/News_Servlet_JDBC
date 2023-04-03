package controller.client;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NewsModel;
import service.CategoryService;
import service.NewsService;

/**
 * Servlet implementation class Home
 */
@WebServlet("/list")
public class list extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private CategoryService cateService;
	@Inject
	private NewsService newsService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("bantheloai", cateService.findAll());
//		request.setAttribute("bannews", newsService.findAll());
//		RequestDispatcher rq = request.getRequestDispatcher("/view/client/List.jsp");
//		rq.forward(request, response);

		String categoryCode = request.getParameter("categoryCode");
		System.out.println(categoryCode);
		List<NewsModel> news = null;
		if (categoryCode != null) {
			news = newsService.findByCategoryCode(categoryCode);
		} else {
			news = newsService.findAll();
		}

		System.out.println(news);
		request.setAttribute("bannews", news);
		RequestDispatcher rq = request.getRequestDispatcher("/view/client/List.jsp");
		rq.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
