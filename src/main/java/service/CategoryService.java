package service;

import java.util.List;

import javax.inject.Inject;

import dao.CategoryDao;
import model.CategoryModel;



public class CategoryService {
	
	@Inject 
	private CategoryDao categoryDao;

	public List<CategoryModel> findAll (){
		List<CategoryModel> cateModels = categoryDao.findAll();
		return cateModels;
	}
}
