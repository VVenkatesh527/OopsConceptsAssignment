package com.omayo.dev.driverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

//inheritance
public class BasePage extends DriverManager{

	public BasePage(WebDriver driver) {
		super(driver);
	}

	//Method Overridding
	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element;
		try {
			element = driver.findElement(locator);
			return element;
		}catch(Exception e){
			System.out.println("Element not found ");
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void waitForElementPresent(WebElement locator) {
		
		wait.until(ExpectedConditions.visibilityOf(locator));
	}


	
}
