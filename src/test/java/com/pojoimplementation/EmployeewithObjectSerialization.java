package com.pojoimplementation;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.POJO.EmoloyeeWithObject;
import com.POJO.Spouse;

public class EmployeewithObjectSerialization {

	@Test
	public void test() throws JsonGenerationException, JsonMappingException, IOException
	{
		int [] arr1= {123,456};
		int [] arr2= {987,654};
		Spouse s=new Spouse("dingi",arr1);
		EmoloyeeWithObject emp=new EmoloyeeWithObject("suman",s);
		ObjectMapper m=new ObjectMapper();
		m.writeValue(new File("./object.json"), emp);
	}
}

