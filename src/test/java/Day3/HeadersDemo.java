package Day3;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HeadersDemo {
	
	@Test
	public void test_Header() {
		given()
		.when()
		.get("https://www.google.com/")
		.then()
		.header("Server", "gws");
		
	}
	

	@Test
	public void test_getHeaders() {
		Response ress=given()
		.when()
		.get("https://www.google.com/");
		
		
		Headers myheaders=ress.getHeaders();
		
		for(Header hd:myheaders) {
			
			System.out.println(hd.getName()+":::"+hd.getValue());
			
		}
		
	}
}
