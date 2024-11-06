package Day7;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class DeleteUser {
	
	@Test
	public void test_DeleteUser(ITestContext context)
	{
		Faker faker=new Faker();
		
		int id=(int) context.getAttribute("userid");
		given()
		.pathParam("id", id)
		.when()
			.delete("https://reqres.in/api/users/{id}")
		.then()
			.statusCode(204)
			.log().all();
	}
	

}
