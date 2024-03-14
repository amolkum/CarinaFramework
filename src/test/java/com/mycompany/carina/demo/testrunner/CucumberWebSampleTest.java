package com.mycompany.carina.demo.testrunner;

import org.testng.annotations.Listeners;

import com.zebrunner.carina.cucumber.CucumberBaseTest;

import extentReport.ListenersExtent;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/ParkarContactUs.feature",
glue = "com.mycompany.carina.demo.steps",
monochrome = true,  //Proper formatting in console
dryRun = false,        //Verify connections and flow
//strict = true,        //To supress warnings from cucumber
		plugin = {"pretty",
				//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber-reports/report.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                }
		//publish=true
		
		
)

@Listeners({ListenersExtent.class})
public class CucumberWebSampleTest extends AbstractTestNGCucumberTests{
	
	}
