package com.POJO;

public class Spouse {

	String name;
	int [] phone;
	
	public Spouse(String name,int [] phone)
	{
		this.name=name;
		this.phone=phone;
	}
	public Spouse()
	{
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getPhone() {
		return phone;
	}
	public void setPhone(int[] phone) {
		this.phone = phone;
	}	
}
