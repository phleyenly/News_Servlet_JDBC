package service;

import java.util.List;

import javax.inject.Inject;

import dao.NewsDao;
import model.NewsModel;

public class NewsService {
	@Inject
	private NewsDao newsDao;

	public List<NewsModel> findAll() {
		List<NewsModel> newsModels = newsDao.findAll();
		return newsModels;

	}
	
	public List<NewsModel> findAll( int limitInt, int offset) {
		List<NewsModel> newsModels = newsDao.findAll( limitInt, offset);
		return newsModels;

	}
	
	public List<NewsModel> findByCategoryCode(String CategoryCode) {
		List<NewsModel> newsModels = newsDao.findByCategoryCode(CategoryCode);
		return newsModels;

	}
	
	public List<NewsModel> findByTitle(String title) {
		List<NewsModel> newsModels = newsDao.findByTitle(title);
		return newsModels;

	}
	
	public NewsModel findById(Long id) {
		NewsModel newsModels = newsDao.findById(id);
		return newsModels;

	}
	
	public String updateById(NewsModel news) {
		return newsDao.updateById(news);
	}
	
	public String create(NewsModel news) {
		return newsDao.create(news);
	}
	
	public String deleteById(Long id) {
		return newsDao.deleteById(id);
	}
	public int countNews() {
		return newsDao.countNews();
	}
}
