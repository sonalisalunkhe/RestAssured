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

import io.restassured.response.Response;

public class CreateUser {

	@Test
	public void test_createUser(ITestContext context) {
		Faker faker = new Faker();
		JSONObject data = new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("role", faker.job().position());

		int id = given().contentType("application/json").body(data.toString()).when()
				.post("https://reqres.in/api/users").jsonPath().getInt("id");

		System.out.println(id);
		System.out.println("----" + faker.job().position());

		context.setAttribute("userid", id);
	}
}
