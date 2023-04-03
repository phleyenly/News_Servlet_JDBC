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

import model.NewsModel;
import service.NewsService;

/**
 * Servlet implementation class newss
 */
@WebServlet("/admin/news")
public class newss extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private NewsService newsService;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		request.setCharacterEncoding("UTF-8");
		
		BufferedReader newsReader  = request.getReader();
		Gson gs = new Gson();
		NewsModel newsModel = gs.fromJson(newsReader, NewsModel.class);
		System.out.println(newsModel);
		String mess = newsService.create(newsModel);
	
		JsonObject json = new JsonObject();
		json.addProperty("mess", mess);
		response.getWriter().print(json);
	}


	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		req.setCharacterEncoding("UTF-8");
		
		BufferedReader newsReader =  req.getReader();
		Gson gson = new Gson();
		NewsModel news = gson.fromJson(newsReader, NewsModel.class );
		System.out.println(news.getId());
		String message = newsService.updateById(news);
		JsonObject js = new JsonObject();
		js.addProperty("message", message);
		
		resp.getWriter().print(js);
		
	}

	

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		System.out.println(id);
		
		resp.setContentType("application/json");
		
		String message = newsService.deleteById(id);
		System.out.println(message);
		
		JsonObject js = new JsonObject();
		js.addProperty("message", message);
		resp.getWriter().print(js);
		
		
	}
	
	

}
