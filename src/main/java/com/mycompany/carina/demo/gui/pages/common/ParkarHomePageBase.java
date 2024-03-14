package com.mycompany.carina.demo.gui.pages.common;

import java.lang.invoke.MethodHandles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.carina.demo.gui.components.footer.FooterMenuBase;
import com.mycompany.carina.demo.gui.pages.desktop.ParkarHomePage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class ParkarHomePageBase extends AbstractPage {
		
	

    public ParkarHomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    

    @Override
    public void open() {
        super.open();
        //acceptCookies.clickIfPresent();
    }    

}
