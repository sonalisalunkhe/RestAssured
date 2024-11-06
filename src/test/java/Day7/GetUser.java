package Day7;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {
	@Test
	public void test_getUser(ITestContext context)
	{
		
	int id=(int) context.getAttribute("userid");
		
		given()
		.pathParam("id", id)
		.when()
			.get("https://reqres.in/api/users/{id}")
		.then()
			.statusCode(200)
			.log().all();
	}

}
