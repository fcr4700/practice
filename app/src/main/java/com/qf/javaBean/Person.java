package com.qf.javaBean;

public class Person {
	String name;
	String imageUrl;
	public Person(){}
	public Person(String name, String imageUrl) {
		super();
		this.name = name;
		this.imageUrl = imageUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", imageUrl=" + imageUrl + "]";
	}
	
}
