package model;

public class UserModel {
	private long id;
	private String userName;
	private String passWord;
	private String fullName;
	private long roleId;
	private RoleModel roleModel;
	
	public UserModel(long id, String userName, String name, String passWord, String fullName, long roleId,
			RoleModel roleModel) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.fullName = fullName;
		this.roleId = roleId;
		this.roleModel = roleModel;
	}
	
	
	public UserModel(String fullName, RoleModel roleModel) {
		super();
		this.fullName = fullName;
		this.roleModel = roleModel;
	}


	public UserModel() {
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public RoleModel getRoleModel() {
		return roleModel;
	}
	public void setRoleModel(RoleModel roleModel) {
		this.roleModel = roleModel;
	}
	
	
	

}
