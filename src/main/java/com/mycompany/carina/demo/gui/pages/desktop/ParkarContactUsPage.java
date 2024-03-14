package com.mycompany.carina.demo.gui.pages.desktop;

import java.lang.invoke.MethodHandles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.mycompany.carina.demo.gui.pages.common.ParkarContactUsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ParkarContactUsPageBase.class)
public class ParkarContactUsPage extends ParkarContactUsPageBase {
	 public ParkarContactUsPage(WebDriver driver) {
		 
	        super(driver);
	        //setUiLoadedMarker(newsColumn);
	    }
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@class='ast-custom-button']")
    private ExtendedWebElement conatctUsButton;

    @FindBy(xpath = "//input[@id='form-field-name']")
    private ExtendedWebElement nameTxt;

    @FindBys({ @FindBy(xpath = "//input[@id='form-field-email']")})
    private ExtendedWebElement emailTxt;

    @FindBy(xpath= "//input[@placeholder='Phone']")
    private ExtendedWebElement phoneTxt;

    @FindBy(xpath = "//textarea[@placeholder='Message']")
    private ExtendedWebElement messageTxt;

    @FindBy(xpath = "(//span[contains(text(),'Contact Us')])[3]")
    private ExtendedWebElement conatctUsBtn;
  

    public ParkarContactUsPage clickContactUsButton(){
    	 assertElementPresent(conatctUsButton);
         
    	conatctUsButton.click();
    	return this;
        //return initPage(driver, ParkarContactUsPage.class);
    }
    
    public ParkarContactUsPage enterNameTxt(){
    	assertElementPresent(nameTxt);
    	nameTxt.type("Amol Kumbhare");
    	return this;
        //return initPage(driver, ParkarContactUsPage.class);
    }
    
    public ParkarContactUsPage enterEmailTxt(){
    	//assertElementPresent(emailTxt);
    	emailTxt.type("ak@gmail.com");
    	return this;
       // return initPage(driver, ParkarContactUsPage.class);
    }
    
    public ParkarContactUsPage enterPhoneTxt(){
    	assertElementPresent(phoneTxt);
    	phoneTxt.type("1234567890");
    	return this;
        //return initPage(driver, ParkarContactUsPage.class);
    }
    public ParkarContactUsPage enterMessageTxt(){
    	assertElementPresent(messageTxt);
    	messageTxt.type("test");
    	return this;
        //return initPage(driver, ParkarContactUsPage.class);
    }
    
    public ParkarContactUsPage clickContactUsBtnt(){
   	   assertElementPresent(conatctUsBtn);
        
   	   conatctUsBtn.click();
   	   return this;
       //return initPage(driver, ParkarContactUsPage.class);
   }

	
	
	   public ParkarContactUsPageBase openContactUsPage() {
	        return clickContactUsButton();
	    }
	   
	   public ParkarContactUsPageBase enterNameTxtOnContactUsPage() {
	        return enterNameTxt();
	    }
	   
	   public ParkarContactUsPageBase enterEmailTxtOnContactUsPage() {
	        return enterEmailTxt();
	    }
	   
	   public ParkarContactUsPageBase enterPhoneTxtOnContactUsPage() {
	        return enterPhoneTxt();
	    }
	   
	   public ParkarContactUsPageBase enterMessageTxtOnContactUsPage() {
	        return enterMessageTxt();
	    }
	   
	   public ParkarContactUsPageBase clickContactUsBtnOnContactUsPage() {
	        return clickContactUsBtnt();
	    }

		/*
		 * @Override public ParkarContactUsPageBase enterNameTxt() { // TODO
		 * Auto-generated method stub return null; }
		 * 
		 * @Override public ParkarContactUsPageBase enterEmailTxt() { // TODO
		 * Auto-generated method stub return null; }
		 * 
		 * @Override public ParkarContactUsPageBase enterPhoneTxt() { // TODO
		 * Auto-generated method stub return null; }
		 * 
		 * @Override public ParkarContactUsPageBase enterMessageTxt() { // TODO
		 * Auto-generated method stub return null; }
		 * 
		 * 
		 */
}
