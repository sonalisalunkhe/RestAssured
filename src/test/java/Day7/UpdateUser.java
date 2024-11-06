package Day7;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {
	@Test
	public void test_UpdateUser(ITestContext context)
	{
		Faker faker=new Faker();
		JSONObject data=new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("role", "teacher");
		
		int id=(int) context.getAttribute("userid");
		given()
		.contentType("application/json")
		.body(data.toString())
		.pathParam("id", id)
		.when()
			.put("https://reqres.in/api/users/{id}")
		.then()
			.statusCode(200)
			.log().all();
	}
	

}
