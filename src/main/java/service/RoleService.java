package service;

import java.util.List;

import javax.inject.Inject;

import dao.RoleDao;
import model.RoleModel;

public class RoleService {
	
	@Inject
	private RoleDao roleDao;
	
	public List<RoleModel> findAll(){
		return roleDao.findAll();
	}

}
