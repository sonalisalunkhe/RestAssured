package api.endpoints;
import static io.restassured.RestAssured.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {
	
	public static Response createUser(User payload)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Roots.create_user_url);
		
		return response;
	}
	public static Response getUser(String UserName)
	{
		Response response=given()
				.pathParam("username", UserName)
		.when()
		.get(Roots.get_user_url);
		
		return response;
	}
	public static Response updateUser(String UserName,User payload)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", UserName)
		.body(payload)
		.when()
		.put(Roots.update_user_url);
		
		return response;
	}
	public static Response deleteUser(String UserName)
	{
		Response response=given()
				.pathParam("username", UserName)
		.when()
		.delete(Roots.delete_user_url);
		
		return response;
	}
}
