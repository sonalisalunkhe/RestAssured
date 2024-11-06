package Day4;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJsonResponse {
	@Test
	public void test_parsingResponse() {
		
		
		Response res=given()
				.contentType(ContentType.JSON)
		.when()
		.get("https://reqres.in/api/users?page=2");
		
		/*
		.then()
		.statusCode(200)
		.header("Content-Type", "application/json; charset=utf-8")
		.body("page", equalTo(2))
		.and()
		.body("data[2].first_name", equalTo("Tobias"))
		.log().headers();
		*/
		
		AssertJUnit.assertEquals(res.statusCode(), 200);
		String name=res.jsonPath().get("data[2].first_name").toString();
		AssertJUnit.assertEquals(name, "Tobias");
		
		boolean status=false;
		JSONObject jo=new JSONObject(res.asString());
		
		for(int i=0;i<jo.getJSONArray("data").length();i++) {
		
			String name1=jo.getJSONArray("data").getJSONObject(i).get("first_name").toString();
			System.out.println(name1);
			
			if(name1.equals("Rachel")) {
				status=true;
				break;
				
			}
			
		}
		AssertJUnit.assertEquals(status, true);
	}
	

}
