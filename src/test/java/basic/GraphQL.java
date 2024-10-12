package basic;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class GraphQL {

	@Test
	public void test()
	{
		baseURI="https://www.rahulshettyacademy.com";
		//passing query in graphQl
		int locationId=1950;
		String responseQuery=given().log().all().contentType(ContentType.JSON)
		.body("{\"query\":\"query{\\n  location(locationId:"+locationId+")\\n  {\\n    id\\n    name\\n    type\\n    dimension\\n  }\\n character(characterId:1483)\\n  {\\n    id\\n    name\\n    type\\n    status\\n    species\\n    gender\\n    image\\n    origin {\\n      id\\n    }\\n    location {\\n      id\\n    }\\n    episodes {\\n      id\\n    }\\n    \\n  }\\n  episode(episodeId:1099)\\n  {\\n    id\\n    name\\n    air_date\\n    episode\\n    characters{id,name,type,status,species,gender,image}\\n  }\\n}\",\"variables\":null}")
		.when().post("/gq/graphql")
		.then().assertThat().statusCode(200).extract().asString();
		System.out.println(responseQuery);
		JsonPath js1=new JsonPath(responseQuery);
		String location=js1.get("data.location.name");
		System.out.println("the location name is "+location);
		
		//passing the mutation in graph ql
		String locationName="USA";
		String responseMutation=given().log().all().contentType(ContentType.JSON)
		.body("{\"query\":\"mutation($locationName:String!,$characterName:String!,$episodeName:String!){\\n  createLocation(location: {name:$locationName,type:\\\"southzone\\\",dimension:\\\"234\\\"})\\n  {\\n    id\\n  }\\n  createCharacter(character:{name:$characterName,type:\\\"actor\\\",status:\\\"single\\\",species:\\\"homosapiens\\\",gender:\\\"male\\\",image:\\\"ss.png\\\",originId:141,locationId:432})\\n  {\\n    id\\n  }\\n  createEpisode(episode:{name:$episodeName,air_date:\\\"24-03-2023\\\",episode:\\\"142\\\"})\\n  {\\n    id\\n  }\\n  deleteLocations(locationIds:[1942,1939])\\n  {\\n    locationsDeleted \\n  }\\n}\",\"variables\":{\"locationName\":\""+locationName +"\",\"characterName\":\"Angilena_joulie\",\"episodeName\":\"hunter\"}}")
		.when().post("/gq/graphql")
		.then().assertThat().statusCode(200).extract().asString();
		System.out.println(responseMutation);
		JsonPath js2=new JsonPath(responseMutation);
		int id=js2.get("data.createLocation.id");
		System.out.println("the location id is "+id);
	}
	
}
