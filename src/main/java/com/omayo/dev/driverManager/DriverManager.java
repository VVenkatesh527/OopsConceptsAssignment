package com.omayo.dev.driverManager;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.omayo.dev.Contants.finalValues;




public abstract class DriverManager {

	 WebDriver driver;
	WebDriverWait wait;
	
	/*
	 * Inheritance
	 * and Abstraction
	 * 
	 */
	public DriverManager(WebDriver driver) {
		this.driver = driver;
		this.wait  = new WebDriverWait(this.driver, Duration.ofSeconds(finalValues.explicityWaitLoad));
	}
	
	public abstract String getPageTitle();
	
	public abstract WebElement getElement(By locator);
	
	public abstract void waitForElementPresent(WebElement locator);
	
		
	private static Properties readConfigFile() {
		  
		File file = new  File(".\\config.properties");
		Properties prop = new Properties();
		try {
			FileInputStream intputStream = new  FileInputStream(file);
			prop.load(intputStream);
		} catch (Exception e) {
			System.out.println("File Not Found at user Directory");
			e.printStackTrace();
		}
		return prop;
	}
	public String getConfigValue(String input) {
	
		Properties prop = readConfigFile();
		String property = prop.getProperty(input);
		
		return property; 
	}
		
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		
		try {
			
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
	
}
