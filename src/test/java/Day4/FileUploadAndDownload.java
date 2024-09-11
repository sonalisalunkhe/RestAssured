package Day4;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class FileUploadAndDownload {
	@Test
	public void test_singleFileUpload() {
		File myfile=new File(" ");
		given()
		.multiPart("file",myfile)
		.contentType("multiPart/form-data")
		.when()
		.post("https://.....")
		.then()
		.statusCode(200)
		.body("filename", equalTo("text1.txt"))
		.log().all();
	}
	@Test
	public void test_multipleFileUpload() {
		File myfile=new File(" ");
		File myfile1=new File(" ");

		given()
		.multiPart("file",myfile)
		.multiPart("file1",myfile1)
		.contentType("multiPart/form-data")
		.when()
		.post("https://.....")
		.then()
		.statusCode(200)
		.body("[0].filename", equalTo("text1.txt"))
		.body("[0].filename", equalTo(""))
		.log().all();
	}
}
