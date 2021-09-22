package com.qa.petstore.models;

public class Pet {
	
	long id = 0;
	Category category;
	String name;
	String[] photoUrls;
	Tag[] tags;
	String status = "available";
	
	public Pet(String name, String categoryName, String photoUrl, String tagName ){
		this.id = 0;
		this.category = new Category(0, categoryName);
		this.name = name;
		this.photoUrls = new String[] {"photoUrl"};
		this.tags = new Tag[] {new Tag(0, tagName)};
		this.status = "available";
		
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getPhotoUrls() {
		return photoUrls;
	}

	public void setPhotoUrls(String[] photoUrls) {
		this.photoUrls = photoUrls;
	}

	public Tag[] getTags() {
		return tags;
	}

	public void setTags(Tag[] tags) {
		this.tags = tags;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
