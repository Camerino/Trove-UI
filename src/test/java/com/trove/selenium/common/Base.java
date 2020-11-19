package com.trove.selenium.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Base {
	public static WebDriver driver;
	public static Utility utils = new Utility();
	
	@BeforeClass
	public void beforeAlltests() throws Exception {
		
	}
	
	@BeforeMethod
	public void beforeEachTest() {
		driver = utils.startChromeBrowser();
	}
	
	@AfterMethod
	public void afterEachTest() {
		utils.customWait(10);
		driver.close();
		driver.quit();
	}

}
