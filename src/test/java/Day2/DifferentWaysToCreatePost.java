package Day2;
import org.testng.annotations.Test;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class DifferentWaysToCreatePost {
	
	//post request body with HashMap
	int id;
	
	//@Test
	@Test
	public void test_PostHashMap() {
		
		HashMap data=new HashMap();
		data.put("name", "soni");
		data.put("role", "teacher");
		
		
		
		id=given()
		.contentType("application/json")
		.body(data)
		.when().post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.body("name", equalTo("soni"))
		.body("role", equalTo("teacher"))
		.log().all()
		.extract().response().jsonPath().getInt("id");
	}
	//@Test
		@Test
		public void test_PostWithOrgJson() {
			
			JSONObject data=new JSONObject();
			data.put("name", "soni1");
			data.put("role", "teacher1");
			
			
			id=given()
			.contentType("application/json")
			.body(data.toString())
			.when().post("https://reqres.in/api/users")
			.then()
			.statusCode(201)
			.body("name", equalTo("soni1"))
			.body("role", equalTo("teacher1"))
			.log().all()
			.extract().response().jsonPath().getInt("id");
		}
	//@Test
	@Test
	public void test_PostWithPojoClass() {
		
		Pojo_PostRequest data2=new Pojo_PostRequest();
		data2.setName("soni2");
		data2.setRole("teacher3");
		
		
		id=given()
		.contentType("application/json")
		.body(data2)
		.when().post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.body("name", equalTo("soni2"))
		.body("role", equalTo("teacher3"))
		.log().all()
		.extract().response().jsonPath().getInt("id");
	}
	@Test
	public void test_PostWithExternalJsonFile() throws FileNotFoundException {
		
		File f=new File(".//body.json");
		FileReader fr=new FileReader(f);
		JSONTokener jt=new JSONTokener(fr);
		JSONObject data3=new JSONObject(jt);
		
		
		id=given()
		.contentType("application/json")
		.body(data3.toString())
		.when().post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.body("name", equalTo("soni5"))
		.body("role", equalTo("teacher6"))
		.log().all()
		.extract().response().jsonPath().getInt("id");
	}
	@Test
	public void test_delete() {
		given()
		.when()
		.delete("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(204);
		
	}

}
