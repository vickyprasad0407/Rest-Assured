package genericUtility;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;
 
public class DatabaseLibrary {
	Driver driver;
	Connection con;
	/**
	 * this method is used to connect with datbase
	 */
	public void connectToDB()
	{
		try {
	    driver=new Driver();
	    DriverManager.registerDriver(driver);
	    con=DriverManager.getConnection(IConstant.dbURL, IConstant.dbUserName, IConstant.dbpwd);
		}
	    catch(SQLException e)
		{
	    	e.printStackTrace();
		}
	}
	
	public void closeDB()
	{
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String validateDB(String query,int columnIndex, String expData)
	{
		boolean flag=false;
		try {
			ResultSet result=con.createStatement().executeQuery(query);
			
			while(result.next())
			{
				//try {
				if(expData.equalsIgnoreCase(result.getString(columnIndex)))
				{
					flag=true;
					System.out.println("the actual data is "+result.getString(columnIndex));
					break;
				}
				//}
				//catch (NullPointerException e) {//in rmg database there is a null value in project name
				//}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(flag)
		{
			System.out.println("data verified in database");
			return expData;
		}
		else
		{
			System.out.println("data not verified in database");
			return "";
		}
	}
	public void insertRowUsingDB(String query) throws SQLException
	{
		int result=0;
		try {
		Statement state = con.createStatement();
		result=state.executeUpdate(query);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally {
			if(result==1)
				System.out.println("Data updated sucessfully");
			else
				System.out.println("not updated");
	}

	}
	 
}
