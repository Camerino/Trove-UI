package com.trove.selenium.pages;

import com.trove.selenium.common.Base;

public class UsedPage extends Base{
	private String pageTitle = "[[Used Outdoor Clothing &amp; Gear: Deals on Top Brands]]";
	public void goToUsedPage() {
		driver.get("https://www.rei.com/used");
		String title = driver.getTitle().strip();
		//utils.validatePageTitle(pageTitle, title);
	}
	
}
