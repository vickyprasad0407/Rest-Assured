package reuablefiles;

public class Payload {

	public String postLibrary()
	{
		return "{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
				"\"isbn\":\"bcd\",\r\n" + 
				"\"aisle\":\"227\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}\r\n" + 
				"";
	}
	public String bookPrice()
	{
		return "{\r\n" + 
				"\"dashboard\":{\r\n" + 
				"             \"purchaseAmount\":910,\r\n" + 
				"              \"website\":\"amazon.com\"\r\n" + 
				"             },\r\n" + 
				"              \"courses\":[\r\n" + 
				"                        {\r\n" + 
				"                        \"title\":\"selenium python\",\r\n" + 
				"                        \"price\":50,\r\n" + 
				"                        \"copies\":6\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                        \"title\":\"cypress\",\r\n" + 
				"                         \"price\":40,\r\n" + 
				"                        \"copies\":4\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                       \"title\":\"RPA\",\r\n" + 
				"                        \"price\":45,\r\n" + 
				"                       \"copies\":10\r\n" + 
				"                        }\r\n" + 
				"                      ]\r\n" + 
				" }";
	}
}
