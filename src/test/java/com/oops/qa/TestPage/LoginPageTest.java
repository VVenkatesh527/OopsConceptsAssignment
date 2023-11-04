package com.oops.qa.TestPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.omayo.dev.PageClassObject.HomePage;
import com.omayo.dev.PageClassObject.LoginPage;
import com.omayo.dev.driverManager.BasePage;

public class LoginPageTest extends BaseTest{

	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		String title = dm.getInstance(BasePage.class).getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Cogmento CRM");
		String user = dm.getConfigValue("username");
		String pwd = dm.getConfigValue("password");
		HomePage homepage =dm.getInstance(LoginPage.class).loginIntoApplication(user, pwd);
		dm.waitForElementPresent(dm.getInstance(HomePage.class).getHomePageHeaderLocator());
		String homePageHeader = homepage.getHomePageHeaderLocator().getText();
		System.out.println(homePageHeader);
		Assert.assertEquals(homePageHeader, "Venkatesh Valandas");
	}
	
}
