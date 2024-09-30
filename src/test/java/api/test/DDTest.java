package api.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import io.restassured.response.Response;
import api.utilities.DataProviders;
import api.payload.User;

public class DDTest {
	

	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void test_PostUser(String UserID, String UserName, String FirstName, String LastName, String Email, String Password, String Phone) {
	
		User userPayload=new User();
		
		userPayload.setId(Integer.parseInt(UserID));
		userPayload.setUsername(UserName);
		userPayload.setFirstName(FirstName);
		userPayload.setLastName(LastName);
		userPayload.setEmail(Email);
		userPayload.setPassword(Password);
		userPayload.setPhone(Phone);
		
		
		
		
		Response response=UserEndpoints.createUser(userPayload);
		response.then().log().all();
		
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void test_deleteUserByUsername(String UserName) {
		Response response=UserEndpoints.deleteUser(UserName);
		response.then().log().all();
		
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
	}

}
