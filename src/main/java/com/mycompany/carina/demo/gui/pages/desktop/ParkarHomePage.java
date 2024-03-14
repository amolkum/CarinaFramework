package com.mycompany.carina.demo.gui.pages.desktop;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.mycompany.carina.demo.gui.pages.common.ParkarHomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;


@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ParkarHomePageBase.class)
public class ParkarHomePage extends ParkarHomePageBase {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass()); 
	   public ParkarHomePage(WebDriver driver) {
	        super(driver);
	        //setUiLoadedMarker(newsColumn);
	    }
	   
	   
}