package com.pojoimplementation;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.POJO.Employee;

public class MainEmployeeDeserialization {
	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper ob=new ObjectMapper();
		Employee e=ob.readValue(new File("./emp.json"), Employee.class);
		System.out.println(e.getName());
		int [] m=e.getMob();
		System.out.println(m[0]);
		System.out.println(e);
	}
}