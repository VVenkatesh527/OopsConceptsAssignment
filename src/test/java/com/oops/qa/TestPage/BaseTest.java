package com.oops.qa.TestPage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.omayo.dev.Contants.finalValues;
import com.omayo.dev.driverManager.BasePage;
import com.omayo.dev.driverManager.DriverManager;

public class BaseTest {
	
	WebDriver driver;
	public DriverManager dm;

	@BeforeMethod
	@Parameters(value= { "browser" })
	public void setup(String browser) {
	
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("no such browser available in xml file");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(finalValues.url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(finalValues.pageLoadTimeout));
		
		dm = new BasePage(driver);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
