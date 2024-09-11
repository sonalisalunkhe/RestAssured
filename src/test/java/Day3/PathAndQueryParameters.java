package Day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class PathAndQueryParameters {

	@Test
public void test_PathAndQueryParameters() {
	
	given()
	.pathParam("pathpara", "users")
	.queryParam("page", "1")
	.queryParam("id", "2")
	.when()
	.get("https://reqres.in/api/{pathpara}")
	.then()
	.log().all();
}
}
