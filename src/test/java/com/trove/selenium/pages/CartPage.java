package com.trove.selenium.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.trove.selenium.common.Base;

public class CartPage extends Base{
	private String pageTitle = "Used Outdoor Clothing & Gear: Deals on Top Brands | REI Co-op";

	public void waitForCheckOutBtnClickable() {
		utils.explicitWaitForElementIsClickAble(By.className("checkout-button"));
		//utils.validatePageTitle(pageTitle, driver.getTitle().trim());
	}
	
	public void clickCheckOutBtn() {
		utils.clickWithJSE((By.className("checkout-button")));
	}
	
	
	public void removeTheLastItemFromCart() {
		System.out.println("removing last item from cart");
		List<WebElement> removeBtns = utils.locateMultipleWebElems(By.cssSelector("button[type='button']"));
		utils.clickWithJSE(removeBtns.get(removeBtns.size()-1));
	}

}
