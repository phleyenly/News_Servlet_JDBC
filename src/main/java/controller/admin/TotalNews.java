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
import service.RoleService;

/**
 * Servlet implementation class Home
 */
@WebServlet("/admin/totalnews")
public class TotalNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoryService cateService;
	@Inject
	private NewsService newsService;
	@Inject
	private RoleService roleService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("bantheloai", cateService.findAll());
		
		String categoryCode = request.getParameter("category-code");
		
		String limit = request.getParameter("limit");
		String page = request.getParameter("page");
		int limitInt =0;
		int pageInt =0;
		int offset =0;
		int totalNews = 0;
		totalNews =	newsService.countNews();
		int totalpage =0;
		if(categoryCode== null) {
			if(limit ==null || page ==null) {
				request.setAttribute("bannews", newsService.findAll());
			}else {
				limitInt = Integer.parseInt(limit);
				pageInt = Integer.parseInt(page);
				if(limitInt <=0 && pageInt <=0 ) {
					request.setAttribute("bannews", newsService.findAll());
				}else {
					offset = (pageInt-1)*limitInt;
					request.setAttribute("bannews", newsService.findAll(limitInt, offset));
					totalpage = (int) Math.ceil((double)totalNews/limitInt);
				}
			}
			
			
		} else {
			request.setAttribute("bannews", newsService.findByCategoryCode(categoryCode));
		}
		
		
//		int totalNews = newsService.countNews();
		//System.out.println(totalNews);
//		int totalpage =0;
//		totalpage = (int) Math.ceil((double)(totalpage/limitInt));
		System.out.println(totalpage);
		request.setAttribute("totalPage", totalpage);
		request.setAttribute("Page", pageInt);
		System.out.println(pageInt);
		request.setAttribute("role", roleService.findAll());
		
		
		 RequestDispatcher rq = request.getRequestDispatcher("/view/admin/totalNews.jsp");
		rq.forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
