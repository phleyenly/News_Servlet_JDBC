package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import mapper.newsMap;
import model.NewsModel;

public class NewsDao extends connect {
	@Inject
	newsMap mapper;

	public List<NewsModel> findAll() {
		List<NewsModel> newsModel = new ArrayList<>();
		Connection con = getConnect();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT news.*, category.*" + " From news" + " left join category"
					+ " on news.categoryid = category.id");
			newsModel = mapper.mapNews(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newsModel;
	}
	
	//tao ham findall moi
	
	public List<NewsModel> findAll( int limit, int offset) {
		List<NewsModel> newsModel = new ArrayList<>();
		Connection con = getConnect();
		//Statement stmt = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			ptmt = con.prepareStatement("SELECT news.*, category.*" + " From news" + " left join category"
					+ " on news.categoryid = category.id LIMIT ? Offset ?");
			ptmt.setLong(1, limit);
			ptmt.setLong(2, offset);
			
			rs = ptmt.executeQuery();
			newsModel = mapper.mapNews(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newsModel;
	}
	
	public List<NewsModel> findByCategoryCode(String catogoryCode) {
		List<NewsModel> newsModel = new ArrayList<>();
		Connection con = getConnect();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT n.*, c.* From news n"
					+ " left join category c"
					+ " on n.categoryid = c.id"
					+ " where c.code = '" + catogoryCode + "'");
			newsModel = mapper.mapNews(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newsModel;
	}
	
	public List<NewsModel> findByTitle(String title) {
		List<NewsModel> newsModel = new ArrayList<>();
		Connection con = getConnect();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT n.*, c.* From news n"
					+ " left join category c"
					+ " on n.categoryid = c.id"
					+ "  where n.title = '" + title + "'");
			newsModel = mapper.mapNews(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newsModel;
	}
	
	//tao ham findbyID
	
	public NewsModel findById(Long id) {
		List<NewsModel> newsModel = new ArrayList<>();
		Connection con = getConnect();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT n.*, c.* From news n"
					+ " left join category c"
					+ " on n.categoryid = c.id"
					+ "  where n.id = '" + id + "'");
			newsModel = mapper.mapNews(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newsModel.get(0);
	}
	
	public String updateById (NewsModel news) {
		Connection con = getConnect();
		PreparedStatement prstmt = null;;
		StringBuilder sql = new StringBuilder("UPDATE news SET title=? , ");
		sql.append("thumbnail=?, content=?, shortdescription=?, categoryId=? where id=?");
		try {
			con.setAutoCommit(false);
			prstmt = con.prepareStatement(sql.toString());
			prstmt.setString(1, news.getTitle());
			prstmt.setString(2, news.getThumbnail());
			prstmt.setString(3, news.getContent());
			prstmt.setString(4, news.getShortdescription());
			prstmt.setLong(5, news.getCategoryId());
			prstmt.setLong(6, news.getId());
			prstmt.executeUpdate();
			con.commit();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			return "Thất Bại";
		}
		
		return "Thành Công";
	}
	
	// phuong thuc them bai viet moi
	
	public String create (NewsModel news) {
		Connection con = getConnect();
		PreparedStatement prstmt = null;;
		StringBuilder sql = new StringBuilder("INSERT INTO news (title, thumbnail, shortdescription, content, categoryid) VALUES ");
		sql.append("(?, ?, ?, ?,?)");
		try {
			con.setAutoCommit(false);
			prstmt = con.prepareStatement(sql.toString());
			prstmt.setString(1, news.getTitle());
			prstmt.setString(2, news.getThumbnail());
			prstmt.setString(3, news.getShortdescription());
			prstmt.setString(4, news.getContent());
			prstmt.setLong(5, news.getCategoryId());
			prstmt.executeUpdate();
			con.commit();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			return "Thất Bại";
		}
		
		return "Thành Công";
	}
	
	// tạo ra hàm xóa
	
	public String deleteById (Long id) {
		Connection con = getConnect();
		PreparedStatement prstmt = null;;
		StringBuilder sql = new StringBuilder("DELETE FROM news WHERE id = ?");
		try {
			con.setAutoCommit(false);
			prstmt = con.prepareStatement(sql.toString());
			prstmt.setLong(1, id);
			prstmt.executeUpdate();
			con.commit();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			return "Thất Bại";
		}
		
		return "Thành Công";
	}
	//dem tong bai viet
	
			public int countNews () {
				int total = 0;
				Connection con = getConnect();
				PreparedStatement prsmt = null;
				ResultSet rs = null;
				try {
					prsmt = con.prepareStatement("SELECT COUNT(*) FROM news");
					rs = prsmt.executeQuery();
					while(rs.next()) {
						total= rs.getInt(1);
					}
					
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return total;
			}
}
