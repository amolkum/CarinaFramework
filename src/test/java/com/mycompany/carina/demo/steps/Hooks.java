package com.mycompany.carina.demo.steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.zebrunner.carina.core.IAbstractTest;

//import extentReport.ExtentManager;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks implements IAbstractTest{
	
		
	@After
	public void afterScenario(Scenario scenario){
	    try{
	        if(scenario.isFailed()){
	        	 byte[] screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
	             scenario.attach(screenshot, "image/png","failed test");
	          
	        }
	    }
	    catch(Exception e){
	        scenario.isFailed();
	    }
	}
}
