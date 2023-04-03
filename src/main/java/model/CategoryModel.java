package model;

public class CategoryModel {
	private long id;
	private String name;
	private String code;

	public CategoryModel(long id, String name, String code) {
		this.id = id;
		this.name = name;
		this.code = code;
	}

	public CategoryModel() {
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
