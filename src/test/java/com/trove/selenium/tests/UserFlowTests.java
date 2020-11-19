package com.trove.selenium.tests;

import org.testng.annotations.Test;

import com.trove.selenium.common.Base;
import com.trove.selenium.pages.CartPage;
import com.trove.selenium.pages.ItemContainerPage;
import com.trove.selenium.pages.ItemPage;
import com.trove.selenium.pages.ShippingPage;
import com.trove.selenium.pages.UsedPage;

public class UserFlowTests extends Base{
	UsedPage usedPage = new UsedPage();
	ItemContainerPage itemContainerPage = new ItemContainerPage();
	ItemPage itemPage = new ItemPage();
	CartPage cartPage = new CartPage();
	ShippingPage shippingPage = new ShippingPage();
	
	private String navigationUrl = "https://www.rei.com/used/shop/womens-footwear?category=Sandals%20%26%20Water%20Shoes";
	
	@Test
	public void userFlowTest() {
		usedPage.goToUsedPage();
		utils.quickNavigateToUrl(navigationUrl);
		itemContainerPage.clickRandomItem();
		itemPage.waitForAddToCartBtnToBeClickable();
		itemPage.addItemToCart();
		cartPage.validateNumberofItemAvailableInCart(1);
		utils.navigateBack();
		itemContainerPage.clickRandomItem();
		itemPage.waitForAddToCartBtnToBeClickable();
		itemPage.addItemToCart();
		itemPage.goToCartPage();
		cartPage.waitForCheckOutBtnClickable();
		cartPage.validateNumberofItemAvailableInCart(2);
		cartPage.removeTheLastItemFromCart();
		cartPage.validateNumberofItemAvailableInCart(1);
		cartPage.clickCheckOutBtn();
		shippingPage.waitForEmailFieldClickable();
		shippingPage.filloutEmailAndConfirmEmail();
	}
}
