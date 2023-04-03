package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CategoryModel;

public class CategoryMap {
 public List<CategoryModel> mapModel(ResultSet rs){
	List<CategoryModel> categoryModels = new ArrayList<>();
	
	try {
		while(rs.next()) {
		CategoryModel category = new CategoryModel();
		category.setId(rs.getLong("id"));
		category.setName(rs.getNString("name"));
		category.setCode(rs.getNString("code"));
		categoryModels.add(category);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return categoryModels;
}
}
