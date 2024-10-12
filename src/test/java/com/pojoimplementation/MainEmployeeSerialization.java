package com.pojoimplementation;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.POJO.Employee;

public class MainEmployeeSerialization {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException  {
		int [] arr1= {123,456};
		Employee  e1=new Employee(101, "vicky", arr1);
		ObjectMapper ob=new ObjectMapper();
		//Serialization
		ob.writeValue(new File("./emp.json"), e1);	
	}
}
