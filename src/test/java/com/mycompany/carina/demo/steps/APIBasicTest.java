package com.mycompany.carina.demo.steps;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.RestAssured.responseSpecification;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
//import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//import org.json.simple.JSONObject;

import com.google.gson.JsonObject;
import com.zebrunner.carina.core.IAbstractTest;

import extentReport.ExtentManager;
import extentReport.ExtentTestManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.codec.binary.Base64;
public class APIBasicTest implements IAbstractTest{

	public Response response;
	public Scenario scenario=null;
	long petID;
	/*
	 * ExtentReports extent = new ExtentReports(); ExtentSparkReporter spark = new
	 * ExtentSparkReporter("extentReportsAPI.html");
	 */
	ExtentTestManager extent=new ExtentTestManager();
	
	
	String path="C:\\Carina\\project-qa\\Automation_Reports";
	File file =(File)((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
	
   byte[] encoded=null;
   //encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
	
	
	
	@Given("Get the API Base URI")
	public void get_the_api_base_uri() throws IOException {
		ExtentTestManager.createTest("API Get Call", "API get call");
		encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
		
		//ExtentTest test=extent.createTest("GET API response");
		System.out.println("Commaon steps");
		RequestSpecBuilder requestSpec = new RequestSpecBuilder();
		requestSpec.setBaseUri("https://petstore.swagger.io");
		requestSpec.setContentType(ContentType.JSON);
		requestSpec.log(LogDetail.ALL);
		requestSpec.addHeader("accept", "application/json");
		requestSpecification = requestSpec.build();

		ResponseSpecBuilder responseSpec = new ResponseSpecBuilder();
		responseSpec.expectStatusCode(200);
		responseSpec.expectContentType(ContentType.JSON);
		responseSpec.log(LogDetail.ALL);
		responseSpecification = responseSpec.build();
		//ExtentManager.takeScreenshot(scenario.getName(), getDriver());
		ExtentTestManager.getTest().info("Screenshot of failed Test case",
				MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		ExtentTestManager.getTest().info("Encoded screenshot of failed Test case", MediaEntityBuilder
				.createScreenCaptureFromBase64String(new String(encoded, StandardCharsets.US_ASCII)).build());
		//ExtentTestManager.getTest().fail(result.getThrowable());
		/*
		 * test.log(Status.PASS, "get API response"); test.pass("Get API Successful");
		 */
	}

	@Given("Get call to url test the API")
	public void get_call_to_https_reqres_in_api_users_page() throws Exception {
		ExtentTestManager.createTest("Get API Call to test The api", "Get Call API Performed");
		
		encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
		// baseURI = "https://reqres.in/api";
		//ExtentTest test=extent.createTest("GET API response");
		Response response = given().spec(requestSpecification)
				.expect()
				.spec(responseSpecification)
				.when()
				.get("/v2/pet/findByStatus?status=pending");

		System.out.println("1----------------------------------end");
		//ExtentManager.takeScreenshot(scenario.getName(), getDriver());
		ExtentTestManager.getTest().info("Screenshot of failed Test case",
				MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		ExtentTestManager.getTest().info("Encoded screenshot of failed Test case", MediaEntityBuilder
				.createScreenCaptureFromBase64String(new String(encoded, StandardCharsets.US_ASCII)).build());
		
		/*
		 * test.log(Status.PASS, "get API response"); test.pass("Get API Successful");
		 */
	}

	@Then("Response code is storing PostPet")
	public void response_code_is() throws IOException {
		ExtentTestManager.createTest("Get Post Call to test The api", "Post Call API Performed");
		//ExtentTest test=extent.createTest("GET Post response");

		// given().get("/users?page=2").then().statusCode(200).log().all();
		System.out.println("-------------Test 2 Post pet ------------");
		//String payload = "id":0;etc
		
		Response response = given().spec(requestSpecification)
				.header("accept", "application/json")
				.body(new File("./payload.json"))
				.expect()
				.spec(responseSpecification)
				.when().post("/v2/pet");
		//System.out.println(response.asPrettyString());
		petID = response.path("id");
		System.out.println(petID);
		System.out.println("2------------------------end");
		//ExtentManager.takeScreenshot(scenario.getName(), getDriver());
	/*	test.log(Status.PASS, "get API response");
		test.pass("Post API Successful");
*/
		ExtentTestManager.getTest().info("Screenshot of failed Test case",
				MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	}

	@And("Update pet details PutPet")
	public void update_pet_details_put_pet() throws IOException {
		ExtentTestManager.createTest(" Put Call to test The api", "Put Call API Performed");
		System.out.println("-------------Test 3 put pet ------------");
		//ExtentTest test=extent.createTest("Put API response");

		String jsonBody = "{"
				+ "  \"id\": "+petID+","
				+ "  \"category\": {"
				+ "    \"id\": 0,"
				+ "    \"name\": \"updated string\""
				+ "  },"
				+ "  \"name\": \"doggie name updated\","
				+ "  \"photoUrls\": ["
				+ "    \"string\""
				+ "  ],"
				+ "  \"tags\": ["
				+ "    {"
				+ "      \"id\": 0,"
				+ "      \"name\": \"string updated\""
				+ "    }"
				+ "  ],"
				+ "  \"status\": \"sold\""
				+ "}";
		Response response = given()
				.spec(requestSpecification)
				.header("accept", "application/json")
				
				.body(jsonBody)
				.expect()
				.spec(responseSpecification)
				.when().put("/v2/pet/");
		//System.out.println(response.asPrettyString());
		System.out.println("3rd -------------------------end");
		ExtentTestManager.getTest().info("Screenshot of failed Test case",
				MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		ExtentTestManager.getTest().info("Encoded screenshot of failed Test case", MediaEntityBuilder
				.createScreenCaptureFromBase64String(new String(encoded, StandardCharsets.US_ASCII)).build());
		
		//ExtentManager.takeScreenshot(scenario.getName(), getDriver());
		/*
		 * test.log(Status.PASS, "get API response"); test.pass("Put API Successful");
		 */
		
	}

	@And("Update pet details PostUpdate")
	public void update_pet_details_post_update() throws IOException {
		ExtentTestManager.createTest("Update Put Call to test The api", "Update Put Call API Performed");
		System.out.println("----------postUpdate---------");
		//ExtentTest test=extent.createTest("Update Post API response");
		Response response = given()
				.spec(requestSpecification)
				.header("Content-Type","application/x-www-form-urlencoded")
				.formParam("name", "DogUpdated")
				.formParam("status", "sold")
				.expect()
				.spec(responseSpecification)
				.when()
				.post("/v2/pet/"+petID);
				//.patch 
		//System.out.println(response.asPrettyString());
		
		System.out.println("4th -------------------end");
		ExtentTestManager.getTest().info("Screenshot of failed Test case",
				MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		ExtentTestManager.getTest().info("Encoded screenshot of failed Test case", MediaEntityBuilder
				.createScreenCaptureFromBase64String(new String(encoded, StandardCharsets.US_ASCII)).build());
		
		//ExtentManager.takeScreenshot(scenario.getName(), getDriver());
		/*
		 * test.log(Status.PASS, "get API response");
		 * test.pass("Update Post API Successful");
		 */
	}

	@Then("Delete the pet DeletePet")
	public void delete_the_pet_delete_pet() throws IOException {
		ExtentTestManager.createTest(" Delete Call to test The api", "Delete Call API Performed");
		//ExtentTest test=extent.createTest("Delete API response");
		System.out.println("---------Delete---------------");
		Response response = given()
				.spec(requestSpecification)
				.expect()
				.spec(responseSpecification)
				.when()
				.delete("/v2/pet/"+petID);
		//System.out.println(response.asPrettyString());
		System.out.println("5th ---------------------end");
		ExtentTestManager.getTest().info("Screenshot of failed Test case",
				MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		ExtentTestManager.getTest().info("Encoded screenshot of failed Test case", MediaEntityBuilder
				.createScreenCaptureFromBase64String(new String(encoded, StandardCharsets.US_ASCII)).build());
		
		//ExtentManager.takeScreenshot(scenario.getName(), getDriver());
		/*
		 * test.log(Status.PASS, "get API response");
		 * test.pass("Delete API Successful");
		 */
	}
	/*
	 * @Before public void beforeTest() { extent.attachReporter(spark); }
	 * 
	 * @After public void afterTest() { extent.flush(); }
	 */
}
