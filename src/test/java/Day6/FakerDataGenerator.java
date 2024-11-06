package Day6;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerator {
	
	@Test
	public void test_geerateDummyData() {
		Faker faker=new Faker();
		
		String fullname=faker.name().fullName();
		String first=faker.name().firstName();
		String last=faker.name().lastName();
		String username=faker.name().username();
		String phone=faker.phoneNumber().cellPhone();
		String email=faker.internet().safeEmailAddress();
		String password=faker.internet().password(4, 8, true);
		
		System.out.println("fullname :"+fullname);
		System.out.println("first :"+first);

		System.out.println("last :"+last);
		System.out.println("username :"+username);
		System.out.println("phone :"+phone);
		System.out.println("email :"+email);
		System.out.println("password :"+password);

		
		
	}

}
