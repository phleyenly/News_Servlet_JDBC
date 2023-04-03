package service;

import java.util.List;

import javax.inject.Inject;

import dao.UserDao;
import model.UserModel;

public class UserService {
	@Inject
	private UserDao userDao;

	public List<UserModel> findAll() {
		return userDao.findAll();
	}

	public List<UserModel> findByRoleCode(String code) {
		return userDao.findByRoleCode(code);
	}

	public List<UserModel> findById(Long id) {
		return userDao.findById(id);
	}
	
	public String editById (UserModel userModel) {
		return userDao.editById(userModel);
	}
	
	public String addUser (UserModel userModel) {
		return userDao.addUser(userModel);
	}
	
	public String  deleteById(Long id) {
		return userDao.deleteById(id);
	}
	
	public UserModel findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}
}
