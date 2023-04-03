package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import javax.inject.Inject;

import com.mysql.cj.jdbc.Driver;

import mapper.CategoryMap;
import model.CategoryModel;
//import com.mysql.cj.xdevapi.Statement;

public class CategoryDao extends connect{

@ Inject
public CategoryMap cate;

	public List<CategoryModel> findAll(){
		List<CategoryModel> categoryModels = new ArrayList<>();
		Connection con = getConnect();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from category");
			categoryModels = cate.mapModel(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return categoryModels;
	}

}
