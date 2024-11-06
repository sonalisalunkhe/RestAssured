package Day1;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HttpRequests {
	
	int ID;
	
	@Test(priority=1)
	public void getSingleUser() {
		given()
		.when().get("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.log()
		.all();
	}

	@Test(priority=2)
	public void getMultipleUser() {
		given()
		.when().get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200).body("page", equalTo(2)).log().all();
	}
	@Test(priority=3)
	public void createUser() {
		HashMap hm=new HashMap();
		
		hm.put("name", "morpheus");
		hm.put("job", "leader");
		
		ID=given()
		.contentType("application/json")
		.body(hm)
		.when().post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.log()
		.all().extract().response().jsonPath().getInt("id");
		
	}
	@Test(priority=4,dependsOnMethods= {"createUser"})
	public void updateUser() {
		HashMap data=new HashMap();
		data.put("name", "Sonu");
		data.put("job", "lead");
		
		given()
		.contentType("application/json")
		.body(data)
		.when().put("https://reqres.in/api/users/"+ID)
		.then()
		.statusCode(200)
		.log()
		.all();
	}
	@Test(priority=5)
	public void deleteUser() {
		given()
		.when().delete("https://reqres.in/api/users/"+ID)
		.then()
		.statusCode(204)
		.log()
		.all();
	}
}
