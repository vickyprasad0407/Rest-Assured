package com.pojoimplementation;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.POJO.EmoloyeeWithObject;

public class EmployeeWithObjectDeserialization {
	
	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper map=new ObjectMapper();
		EmoloyeeWithObject e = map.readValue(new File("./object.json"), EmoloyeeWithObject.class);
		System.out.println(e.getSpouse().getName());
		System.out.println(e);
	}
}
