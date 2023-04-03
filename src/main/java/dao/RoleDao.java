package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RoleModel;

public class RoleDao extends connect {

	public List<RoleModel> findAll() {
		List<RoleModel> roleModel = new ArrayList<>();
		Connection con = getConnect();
		PreparedStatement prsmt = null;
		ResultSet rs = null;
		try {
			prsmt = con.prepareStatement("SELECT * FROM role");
			rs= prsmt.executeQuery();
			
			while (rs.next()) {
				RoleModel role = new RoleModel();
				role.setId(rs.getLong("id"));
				role.setName(rs.getString("Name"));
				role.setCode(rs.getString("code"));
				roleModel.add(role);
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roleModel;
	}
		
}
