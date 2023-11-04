package com.omayo.dev.Contants;

import org.openqa.selenium.WebDriver;

import com.omayo.dev.driverManager.BasePage;

public class finalValues extends BasePage{

	public finalValues(WebDriver driver) {
		super(driver);
	}

	public static final String url  = "https://ui.cogmento.com/";
	public static final long pageLoadTimeout = 10;
	public static final long explicityWaitLoad = 20;
}
