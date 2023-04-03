package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import mapper.UserMap;
import model.UserModel;

public class UserDao  extends connect{
	@Inject
	private UserMap usermap;
	public List<UserModel> findAll(){
		List<UserModel> userModel = new ArrayList<>();
		Connection con = getConnect();
		PreparedStatement prsmt = null;
		ResultSet rs = null;
		
		
		try {
			prsmt = con.prepareStatement("SELECT * FROM user LEFT JOIN ROLE ON user.roleid = role.id");
			rs = prsmt.executeQuery();
			
			userModel= usermap.mapper(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userModel;
	}
	
	
	public List<UserModel> findByRoleCode(String code){
		List<UserModel> userModel = new ArrayList<>();
		Connection con = getConnect();
		PreparedStatement prsmt = null;
		ResultSet rs = null;
		
		
		try {
			prsmt = con.prepareStatement("SELECT * FROM user LEFT JOIN ROLE ON user.roleid = role.id WHERE role.code = ?");
			prsmt.setString(1, code);
			rs = prsmt.executeQuery();
			userModel= usermap.mapper(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userModel;
	}

	
	public List<UserModel> findById(Long id){
		List<UserModel> userModel = new ArrayList<>();
		Connection con = getConnect();
		PreparedStatement prsmt = null;
		ResultSet rs = null;
		
		
		try {
			prsmt = con.prepareStatement("SELECT * FROM user LEFT JOIN ROLE ON user.roleid = role.id WHERE user.id = ?");
			prsmt.setLong(1, id);
			rs = prsmt.executeQuery();
			userModel= usermap.mapper(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userModel;
	}
	
	public String editById(UserModel userModel) {
		Connection con = getConnect();
		PreparedStatement prsmt = null;
		
		try {
			con.setAutoCommit(false);
			prsmt = con.prepareStatement("UPDATE user SET username=?, password =?, fullname=? where id=?");
			prsmt.setString(1, userModel.getUserName());
			prsmt.setString(2, userModel.getPassWord());
			prsmt.setString(3, userModel.getFullName());
			prsmt.setLong(4, userModel.getId());
			prsmt.executeUpdate();
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
	
	public String addUser(UserModel userModel) {
		Connection con = getConnect();
		PreparedStatement prsmt = null;
		
		try {
			con.setAutoCommit(false);
			prsmt = con.prepareStatement("INSERT INTO user (username, password, fullname, roleid) VALUES (?, ?, ?, ?)");
			prsmt.setString(1, userModel.getUserName());
			prsmt.setString(2, userModel.getPassWord());
			prsmt.setString(3, userModel.getFullName());
			prsmt.setLong(4, userModel.getRoleId());
			prsmt.executeUpdate();
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
	
	public String deleteById(Long id) {
		Connection con = getConnect();
		PreparedStatement prsmt = null;
		
		try {
			con.setAutoCommit(false);
			prsmt = con.prepareStatement("DELETE FROM user WHERE (id = ?)");
			prsmt.setLong(1, id);
			prsmt.executeUpdate();
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
	//ham tra ve theo username
	
	public UserModel findByUserName(String userName){
		UserModel userModel = new UserModel();
		Connection con = getConnect();
		PreparedStatement prsmt = null;
		ResultSet rs = null;
		
		
		try {
			prsmt = con.prepareStatement("SELECT * FROM user LEFT JOIN ROLE ON user.roleid = role.id WHERE user.username = ?");
			prsmt.setString(1, userName);
			rs = prsmt.executeQuery();
			//rs.next();
			if(!rs.next()) return null;
			userModel= usermap.mapperModel(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userModel;
	}

}
