package Day4;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class JSONSchemaValidations {
	@Test
	public void test_validateSchema() {
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonschema.json"));
		
	}

}
