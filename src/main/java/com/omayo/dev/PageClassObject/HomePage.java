package com.omayo.dev.PageClassObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.omayo.dev.driverManager.BasePage;

public class HomePage extends BasePage{

	private By homePageHeaderLocator = By.xpath("//span[@class='user-display' and text()='Venkatesh Valandas']");
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getHomePageHeaderLocator() {
		return getElement(homePageHeaderLocator);
	}
	
	//Method OverLoading
	public WebElement getHomePageHeaderLocator(By Locator) {
		return getElement(Locator);
	}

}
