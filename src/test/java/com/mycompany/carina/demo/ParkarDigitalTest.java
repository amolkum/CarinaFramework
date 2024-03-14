package com.mycompany.carina.demo;

import org.testng.annotations.Test;



import com.mycompany.carina.demo.gui.pages.common.ParkarContactUsPageBase;
import com.mycompany.carina.demo.gui.pages.common.ParkarHomePageBase;
import com.mycompany.carina.demo.gui.pages.desktop.ParkarContactUsPage;
import com.mycompany.carina.demo.gui.pages.desktop.ParkarHomePage;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;


//import extentReport.ExcelUtil;




public class ParkarDigitalTest implements IAbstractTest {
	ParkarHomePage parkarHomePage=new ParkarHomePage(getDriver());
	ParkarContactUsPage parkarContactUsPage=new ParkarContactUsPage(getDriver());
	ParkarContactUsPageBase parkarContactUsPageBase;
    
	   @Test
	    @MethodOwner(owner = "qpsdemo")
	    @TestPriority(Priority.P3)
	    @TestLabel(name = "feature", value = { "web", "regression" })
	    public void parkarContactUs() {
	        // Open GSM Arena home page and verify page is opened
	        ParkarHomePageBase homePage = initPage(getDriver(), ParkarHomePageBase.class);
	        homePage.open();
	       // Assert.assertTrue(homePage.isPageOpened(), "Home Page Opened");
	   }
	   
	   @Test
	   //(dataProvider = "getUIData", dataProviderClass = ExcelUtil.class)
	    @MethodOwner(owner = "Parkardemo")
	    @TestPriority(Priority.P3)
	    @TestLabel(name = "feature", value = { "web", "regression" })
	    public void contactUsParkar() {
	        // Open GSM Arena home page and verify page is opened
		   
		   
		   parkarContactUsPageBase=parkarContactUsPage.openContactUsPage();
		  // parkarContactUsPageBase=parkarContactUsPage.clickContactUsButton();
		   
	      
			
			
			
			  parkarContactUsPageBase=parkarContactUsPage.enterNameTxtOnContactUsPage();
			  parkarContactUsPageBase=parkarContactUsPage.enterEmailTxtOnContactUsPage();
			  parkarContactUsPageBase=parkarContactUsPage.enterPhoneTxtOnContactUsPage();
			  parkarContactUsPageBase=parkarContactUsPage.enterMessageTxtOnContactUsPage();
			  parkarContactUsPageBase=parkarContactUsPage.clickContactUsBtnOnContactUsPage(
			  );
			 
			 
			 
		   
			
				
				/*
				 * parkarContactUsPageBase=parkarContactUsPage.enterNameTxt(map.get("Name"));
				 * parkarContactUsPageBase=parkarContactUsPage.enterEmailTxt(map.get("Email"));
				 * parkarContactUsPageBase=parkarContactUsPage.enterPhoneTxt(map.get("Phone"));
				 * parkarContactUsPageBase=parkarContactUsPage.enterMessageTxt(map.get("Message"
				 * )); parkarContactUsPageBase=parkarContactUsPage.clickContactUsBtnt();
				 * 
				 */
	   }
	        
    }