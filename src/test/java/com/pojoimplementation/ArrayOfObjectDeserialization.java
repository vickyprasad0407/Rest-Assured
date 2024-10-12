package com.pojoimplementation;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.testng.annotations.Test;

import com.POJO.Employee;

public class ArrayOfObjectDeserialization {
	
	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper map=new ObjectMapper();
		Employee[] e=map.readValue(new File("./employee.json"), Employee[].class);
        for(Employee emp:e)
        {
        	System.out.println(emp.name);
        }
        List<Employee> e1=map.readValue(new File("./employee.json"), new TypeReference<List<Employee>>() {});
        for (Employee employee : e1) {
			System.out.println(employee.name);
		}
	}
}
