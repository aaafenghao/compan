package com.example.demo.restful.model;

public class IndexModel {
	
	private Long id;
	
	private String name;
	
	private String age;
	
	private String sex;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public IndexModel(Long id, String name, String age, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public IndexModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
