package com.POJO;

import java.util.Arrays;

public class Employee {
	//step 1 : declare the variable globally
	public int rollno;
	public String name;
	public int [] mob;
	//step 2: cteate a constructor to initialize value
	public Employee(int rollno,String name,int [] mob)
	{
		this.rollno=rollno;
		this.name=name;
		this.mob=mob;
	}
	//step 3: to trigger the execution for serialization and decerialization
	public Employee()
	{
		
	}

	//step 4: provide getter and setter
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getMob() {
		return mob;
	}
	public void setMob(int[] mob) {
		this.mob = mob;
	}
	@Override
	public String toString() {
		return "Employee { rollno=" + rollno + ", name=" + name + ", mob=" + Arrays.toString(mob) + "}";
	}

}
