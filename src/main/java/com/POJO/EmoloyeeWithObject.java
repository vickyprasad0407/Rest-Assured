package com.POJO;

public class EmoloyeeWithObject {
	String name;
	Spouse spouse;
	
	public EmoloyeeWithObject(String name,Spouse spouse)
	{
		this.name=name;
		this.spouse=spouse;
	}
	public EmoloyeeWithObject()
	{
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Spouse getSpouse() {
		return spouse;
	}
	public void setSpouse(Spouse spouse) {
		this.spouse = spouse;
	}
}
