package basic;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import reuablefiles.Payload;
import reuablefiles.ReusableClass;

public class BookPriceDemo {

	@Test
	public void test()
	{
		Payload p=new Payload();
		ReusableClass r=new ReusableClass();
        JsonPath js = r.stringToJson(p.bookPrice());
        int count=js.getInt("courses.size()");
        System.out.println(count);
        double expAmount=js.getInt("dashboard.purchaseAmount");
        System.out.println(js.get("courses[0].title")+"......."+js.get("courses[0].price")+"......."+js.get("courses[0].copies"));
        System.out.println("all books title are.....");
        for (int i = 0; i <count; i++) {
			System.out.println(js.get("courses["+i+"].title")+"......."+js.get("courses["+i+"].price"));
		}
        System.out.println("sum of all book price......");
        double sum=0;
        double totalPrice=0;
        for (int i = 0; i < count; i++) {
			float price=js.get("courses["+i+"].price");
			int noOfBooks=js.get("courses["+i+"].copies");
			sum=sum+price;
			totalPrice=totalPrice+price*noOfBooks;
			System.out.println(sum+"......."+totalPrice);
		}
        System.out.println("overall total sum and total price are "+sum+"......."+totalPrice);
        Assert.assertEquals(expAmount, totalPrice);
	}
}
