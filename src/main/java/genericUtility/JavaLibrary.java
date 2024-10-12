package genericUtility;

import java.util.Random;

public class JavaLibrary {
	
	public int getRandom()
	{
		Random ran=new Random();
		return ran.nextInt(500);
	}

}
