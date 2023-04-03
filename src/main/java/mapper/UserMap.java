package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RoleModel;
import model.UserModel;

public class UserMap {
	public List<UserModel> mapper(ResultSet rs) {
		List<UserModel> userModel = new ArrayList<>();

		try {
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getLong("id"));
				user.setUserName(rs.getString("username"));
				user.setFullName(rs.getString("fullname"));
				user.setPassWord(rs.getString("password"));
				user.setRoleId(rs.getLong("roleid"));

				RoleModel role = new RoleModel();
				role.setCode(rs.getString("code"));
				role.setId(rs.getLong("id"));
				role.setName(rs.getString("Name"));
				user.setRoleModel(role);

				userModel.add(user);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userModel;
	}
	
	//
	
	public UserModel mapperModel (ResultSet rs) {
		UserModel userModel = new UserModel();

		try {
			//rs.next();
				userModel.setId(rs.getLong("id"));
				userModel.setUserName(rs.getString("username"));
				userModel.setFullName(rs.getString("fullname"));
				userModel.setPassWord(rs.getString("password"));
				userModel.setRoleId(rs.getLong("roleid"));

				RoleModel role = new RoleModel();
				role.setCode(rs.getString("code"));
				role.setId(rs.getLong("id"));
				role.setName(rs.getString("Name"));
				userModel.setRoleModel(role);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userModel;
	}

}
