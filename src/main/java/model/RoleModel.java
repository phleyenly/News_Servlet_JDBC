package model;

public class RoleModel {
private long id;
private String name;
private String code;
public RoleModel(long id, String name, String code) {
	super();
	this.id = id;
	this.name = name;
	this.code = code;
}
public RoleModel() {
	// TODO Auto-generated constructor stub
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}


}
