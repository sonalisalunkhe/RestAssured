package Day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CockiesDemo {
	
	@Test(priority=1)
	public void test_Cookies() {
		given()
		.when()
		.get("https://www.google.com/")
		.then()
		.log();
	}
	@Test(priority=2)
	public void test_getCookiesInfo() {
		Response res=
				given()
				.when()
				.get("https://www.google.com/");	
		
		//get single cookie info
		String AEC=res.getCookie("AEC");
		
		System.out.println("value of cookie AEC is"+AEC);
		
		//get all cookie info

		
		Map<String, String> map=res.getCookies();
		
		for(String k:map.keySet()) {
			System.out.println(k+"="+res.getCookie(k));
		}
		}
}
