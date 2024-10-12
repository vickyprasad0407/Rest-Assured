package com.pojoimplementation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.POJO.Employee;

public class ArrayOfObjectSerialization {

	@Test
	public void serialization() throws JsonGenerationException, JsonMappingException, IOException
	{
	int [] arr1= {123,456};
	int [] arr2= {145,987};
	
	ArrayList al=new ArrayList();
	al.add(new Employee(101,"fd",arr1));
	al.add(new Employee(102,"umesh",arr2));
	ObjectMapper ob=new ObjectMapper();
	ob.writeValue(new File("./employee.json"), al);
	}
} 
