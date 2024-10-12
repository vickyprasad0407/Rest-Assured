package practice;

import org.testng.annotations.Test;

import genericUtility.DatabaseLibrary;

public class DemoDB {
DatabaseLibrary db=new DatabaseLibrary();
@Test
public void test()
{
   String query="select * from project";
   db.connectToDB();
   db.validateDB(query, 4, "xylem");
   db.closeDB();
}
}
