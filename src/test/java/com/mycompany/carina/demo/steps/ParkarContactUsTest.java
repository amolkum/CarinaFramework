package com.mycompany.carina.demo.steps;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.mycompany.carina.demo.gui.pages.common.ParkarContactUsPageBase;

import com.mycompany.carina.demo.gui.pages.desktop.HomePage;
import com.mycompany.carina.demo.gui.pages.desktop.ParkarContactUsPage;
import com.mycompany.carina.demo.gui.pages.desktop.ParkarHomePage;
import com.zebrunner.carina.core.IAbstractTest;

import extentReport.ExtentManager;
import extentReport.ExtentTestManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
//import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This sample shows how create Web test.
 *
 * @author qpsdemo
 */

public class ParkarContactUsTest implements IAbstractTest{
	ExtentTestManager extent=new ExtentTestManager();
	
	String path="C:\\Carina\\project-qa\\Automation_Reports\\Screenshots";
	File file =(File)((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
	
   byte[] encoded=null;
	//ParkarHomePageBase homePage = initPage(getDriver(), ParkarHomePageBase.class);
	ParkarHomePage parkarHomePage=new ParkarHomePage(getDriver());
	ParkarContactUsPage parkarContactUsPage=new ParkarContactUsPage(getDriver());
	ParkarContactUsPageBase parkarContactUsPageBase;
	
	//ExtentReports extent = new ExtentReports();
	//ExtentSparkReporter spark = new ExtentSparkReporter("extentReportsUI.html");
	
	@Given("the user is on the homepage")
	public void the_user_is_on_the_homepage() throws IOException {
        // Open GSM Arena home page and verify page is opened
		//ExtentTest test=extent.createTest("Parkar Home Page");
		
		
		ExtentTestManager.createTest("Parkar Home Page", "Parkar home page is launched");
		encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        String ss=extent.captureScreen();
        
        //ExtentTestManager.getTest().addScreenCaptureFromPath(ss,"Parkar Home Page");
        
        
        ExtentTestManager.getTest().info("Screenshot of Test case-Home Page",
				MediaEntityBuilder.createScreenCaptureFromPath(ss).build());
		ExtentTestManager.getTest().info("Encoded screenshot of failed Test case", MediaEntityBuilder
				.createScreenCaptureFromBase64String(new String(encoded, StandardCharsets.US_ASCII)).build());
		ExtentTestManager.reporterLog("Parkar Home Page Launched");
		
		
		
    }

	@When("the user clicks on the Contact Us page")
	public void the_user_clicks_on_the_contact_us_page() throws IOException {
		ExtentTestManager.createTest("Parkar Contact Us Page", "Parkar Contact Us page is launched");
		//ExtentTest test=extent.createTest("Parkar Contact Us Page");
		
	    // Write code here that turns the phrase above into concrete actions
		parkarContactUsPageBase=parkarContactUsPage.openContactUsPage();
		 //ExtentManager.takeScreenshot(scenario.getName(), getDriver());
		//test.log(Status.PASS, "Parkar Contact Us");
		//test.pass("Parkar Contact Us Successfully launched");
		String ss1=extent.captureScreen();
		//ExtentTestManager.getTest().addScreenCaptureFromPath(ss1);
		 ExtentTestManager.getTest().info("Screenshot of the Test case",
					MediaEntityBuilder.createScreenCaptureFromPath(ss1).build());
			ExtentTestManager.getTest().info("Encoded screenshot of the Test case", MediaEntityBuilder
					.createScreenCaptureFromBase64String(new String(encoded, StandardCharsets.US_ASCII)).build());
			ExtentTestManager.reporterLog("Parkar Contact Us Page Launched");

		
		//throw new io.cucumber.java.PendingException();
	}

	@When("the user enter the details")
	public void the_user_enter_the_details() throws IOException {
		ExtentTestManager.createTest("Parkar Contact Us Page form filling", "Parkar contact us page data filler");
		//ExtentTest test=extent.createTest("Parkar Contact Us Filling up of data");
	    // Write code here that turns the phrase above into concrete actions
		parkarContactUsPageBase=parkarContactUsPage.enterNameTxtOnContactUsPage();
		parkarContactUsPageBase=parkarContactUsPage.enterEmailTxtOnContactUsPage();
		parkarContactUsPageBase=parkarContactUsPage.enterPhoneTxtOnContactUsPage();
		parkarContactUsPageBase=parkarContactUsPage.enterMessageTxtOnContactUsPage();
		 //ExtentManager.takeScreenshot(scenario.getName(), getDriver());
		//test.log(Status.PASS, "Parkar Contact Us Page Data Filled");
		//test.pass("Parkar Contact Us Successfully Filled");
		String ss2=extent.captureScreen();
		//ExtentTestManager.getTest().addScreenCaptureFromPath(ss2);

		//throw new io.cucumber.java.PendingException();
		ExtentTestManager.getTest().info("Screenshot of the Test case",
				MediaEntityBuilder.createScreenCaptureFromPath(ss2).build());
		ExtentTestManager.getTest().info("Encoded screenshot of the Test case", MediaEntityBuilder
				.createScreenCaptureFromBase64String(new String(encoded, StandardCharsets.US_ASCII)).build());
		ExtentTestManager.reporterLog("Parkar Contact Us Page form filling staretd");
	}

	@Then("the user click on submit button")
	public void the_user_click_on_submit_button() throws IOException {
		ExtentTestManager.createTest("Parkar Conatct Us Page Submit", "Parkar contact us page submit button clicked");
		//ExtentTest test=extent.createTest("Parkar Contact Us Filling up of data");
	    // Write code here that turns the phrase above into concrete actions
		parkarContactUsPageBase=parkarContactUsPage.clickContactUsBtnOnContactUsPage();
		//ExtentManager.takeScreenshot(scenario.getName(), getDriver());
		String ss3=extent.captureScreen();
		//ExtentTestManager.getTest().addScreenCaptureFromPath(ss3);
		ExtentTestManager.getTest().info("Screenshot of the Test case",
				MediaEntityBuilder.createScreenCaptureFromPath(ss3).build());
		ExtentTestManager.getTest().info("Encoded screenshot of the Test case", MediaEntityBuilder
				.createScreenCaptureFromBase64String(new String(encoded, StandardCharsets.US_ASCII)).build());
		ExtentTestManager.reporterLog("Parkar Contact Us Page Submit button Clicked");
		getDriver().close();
		//test.log(Status.PASS, "Parkar Contact Us Submit Clicked");
		//test.pass("Parkar Contact Us Successfully Submitted");
		
		//throw new io.cucumber.java.PendingException();
	}
/*
 * @Before public void beforeTest() { extent.attachReporter(spark); }
 * 
 * @After public void afterTest(Scenario scenario) {
 * 
 * 
 * extent.flush();} }
 */
	
}