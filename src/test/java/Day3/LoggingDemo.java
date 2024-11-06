package Day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class LoggingDemo {
	
	@Test
	public void test_logs() {
		
		given()
		.when()
		.get("https://www.google.com/")
		.then()
		.log().headers();
		
	}

}
