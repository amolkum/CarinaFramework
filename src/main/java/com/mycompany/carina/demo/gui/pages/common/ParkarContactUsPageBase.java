package com.mycompany.carina.demo.gui.pages.common;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.mycompany.carina.demo.gui.components.compare.ModelSpecs;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class ParkarContactUsPageBase extends AbstractPage {
	
	protected ParkarContactUsPageBase(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public abstract ParkarContactUsPageBase clickContactUsButton();
	public abstract ParkarContactUsPageBase enterNameTxt();
	public abstract ParkarContactUsPageBase enterEmailTxt();
	public abstract ParkarContactUsPageBase enterPhoneTxt();
	public abstract ParkarContactUsPageBase enterMessageTxt();
	public abstract ParkarContactUsPageBase clickContactUsBtnt();
	
}
