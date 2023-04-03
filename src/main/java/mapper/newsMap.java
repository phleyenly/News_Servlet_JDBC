package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.client.list;
import model.CategoryModel;
import model.NewsModel;

public class newsMap {
	public List<NewsModel> mapNews (ResultSet rs){
		List<NewsModel> newsModel = new ArrayList<>();
	try {
		while(rs.next()) {
			NewsModel news = new NewsModel();
			news.setId(rs.getLong("id"));
			news.setTitle(rs.getString("title"));
			news.setThumbnail(rs.getString("thumbnail"));
			news.setContent(rs.getString("content"));
			news.setCategoryId(rs.getLong("categoryid"));
			news.setShortdescription(rs.getString("shortdescription"));
			
			CategoryModel categoryModel = new CategoryModel();
			categoryModel.setCode(rs.getString("code"));
			categoryModel.setName(rs.getString("name"));
			categoryModel.setId(rs.getLong("id"));
			news.setCategory(categoryModel);
			
			newsModel.add(news);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return newsModel;
}
}