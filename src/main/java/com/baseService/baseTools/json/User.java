package com.baseService.baseTools.json;

import java.util.Random;

public class User {
	
	private int id;
	private String name;
	private int age;
	
	public User(){
		Random random = new Random();
		id = random.nextInt(4);
		name = "test"+id;
		age =random.nextInt(7);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	
	
}
