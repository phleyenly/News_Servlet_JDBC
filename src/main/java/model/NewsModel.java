package model;

public class NewsModel {
	private long id;
	private String title;
	private String thumbnail;
	private String content;
	private String shortdescription;
	private long categoryId;
	private CategoryModel category;
	
	
	public NewsModel(long id, String title, String thumbnail, String content, String shortdescription, long categoryId,
			CategoryModel category) {
		this.id = id;
		this.title = title;
		this.thumbnail = thumbnail;
		this.content = content;
		this.shortdescription = shortdescription;
		this.categoryId = categoryId;
		this.category = category;
	}
	public NewsModel() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "NewsModel [id=" + id + ", title=" + title + ", thumbnail=" + thumbnail + ", content=" + content
				+ ", shortdescription=" + shortdescription + ", categoryId=" + categoryId + ", category=" + category
				+ "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getShortdescription() {
		return shortdescription;
	}
	public void setShortdescription(String shortdescription) {
		this.shortdescription = shortdescription;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public CategoryModel getCategory() {
		return category;
	}
	public void setCategory(CategoryModel category) {
		this.category = category;
	}

	
}
