package Day6;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Authentications {
	@Test
	public void basicAuthentication() {
		given()
		.auth().basic("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	@Test
	public void digestAuthentication() {
		given()
		.auth().digest("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	@Test
	public void PreemptiveAuthentication() {
		given()
		.auth().preemptive().basic("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	@Test
	public void bearerToken() {
		
		String token="";
		given()
		.headers("Authorization","Bearer"+token)
		.when()
		.get("")
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test
	public void Oauth1Authentiication() {
		given()
			.auth().oauth("", "", "", "")
		.when()
			.get("url")
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test
	public void Oauth2Authentication() {
		given()
		.auth().oauth2("")
		.when()
			.get("")
		.then()
		.statusCode(200)
		.log().all();
	}
}
