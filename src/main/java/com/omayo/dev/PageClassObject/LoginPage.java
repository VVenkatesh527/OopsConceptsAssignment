package com.omayo.dev.PageClassObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.omayo.dev.driverManager.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private By userName = By.xpath("//input[@name='email']");
	
	private By password = By.xpath("//input[@name='password']");
	
	private By loginBtn = By.xpath("//div[normalize-space()='Login' and contains(@class,'submit button')]");
	
	private By invalidData = By.xpath("//div[text()='Something went wrong...']");
	
	//Encapsulation by using getter methods(Locators and getter methods)
	public WebElement getUserName() {
		return getElement(userName);
	}

	public WebElement getPassword() {
		return getElement(password);
	}

	public WebElement getLoginBtn() {
		return getElement(loginBtn); 
	}
	
	public WebElement getinvalidData() {
		return getElement(invalidData);
	}

	public HomePage loginIntoApplication(String userName,String password) {
		
		if(!userName.isEmpty()||password.isEmpty()) {
		if(getUserName().isEnabled()) {
			getUserName().sendKeys(userName);
		}
		else {
			System.out.println("Element not found");
		}
		if(getPassword().isEnabled()) {
			waitForElementPresent(getInstance(LoginPage.class).getPassword());
		getPassword().sendKeys(password);
		}
		else {
			System.out.println("Element not found");
		}
		if(getLoginBtn().isEnabled()) {
			waitForElementPresent(getInstance(LoginPage.class).getLoginBtn());
		getLoginBtn().click();
		}
		else {
			System.out.println("Element not found");
		}
		}
		return getInstance(HomePage.class);
	}
	
	//Method OverLoading
	public String loginIntoApplication() {
		
		getUserName().sendKeys(" ");
		getPassword().sendKeys(" ");
		getLoginBtn().click();
		
		return getinvalidData().getText();
	}
	
	public String loginIntoApplication(String usercredials) {
		
		getUserName().sendKeys(" ");
		getPassword().sendKeys(usercredials);
		getLoginBtn().click();
		
		return getinvalidData().getText();
	}
	 
}
