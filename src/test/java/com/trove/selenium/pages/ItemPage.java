package com.trove.selenium.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.trove.selenium.common.Base;

public class ItemPage extends Base{
	
	ItemContainerPage itemContainerPage = new ItemContainerPage();
		
	public void waitForAddToCartBtnToBeClickable() {
		utils.explicitWaitForElementIsClickAble(By.className("add-to-cart"));
	}
	
	public void addItemToCart() {
		Boolean added = addOneItemToCart();
		while(!added) {//if multiple combination didn't work, choose a diffetent item
			utils.navigateBack();
			itemContainerPage.clickRandomItem();
			added = addOneItemToCart();
		}
	}
	
	public Boolean addOneItemToCart() {
		Boolean itemAddedToCart = false;
		if(!itemUnavailable()) {
			System.out.println("clicking add to cart button");
			WebElement addToCartBttn = utils.locateWebElement(By.className("add-to-cart"));
			//utils.moveMouseToElementThenClick(addToCartBttn);
			utils.clickWithJSE(addToCartBttn);
		}
		
		//check if warning occured
		if(!utils.elementIsPresent(By.cssSelector("div[class='add-to-cart-button-wrap']>strong"))){
			itemAddedToCart = true;
		} else {
			System.out.println("need to choose size and conditions");
			String suggestionText = utils.extractText(By.cssSelector("div[class='add-to-cart-button-wrap']>strong"));
			
			//First Available option will be selected if condition and/or sizes were hinted for suggestion
			List<WebElement> sizes = new ArrayList<WebElement>();
			List<WebElement> conditions = new ArrayList<WebElement>();
			if(suggestionText.toLowerCase().contains("condition")) {
				conditions = getAvailableOptions("conditions");
			}
			
			if(suggestionText.toLowerCase().contains("sizes")) {
				sizes = getAvailableOptions("sizes");
			}
			
			
			for(WebElement size: sizes) {
				if(itemAddedToCart) {
					break;
				}
				for(WebElement condition: conditions) {
					utils.clickWithJSE(size);
					utils.clickWithJSE(condition);
					if(!itemUnavailable()) {
						WebElement addToCartBttn = utils.locateWebElement(By.className("add-to-cart"));
						utils.clickWithJSE(addToCartBttn);
						//utils.moveMouseToElementThenClick(addToCartBttn);
						itemAddedToCart = true;
						break;
					}
				}
			}
		}
		return itemAddedToCart;
	}
	
	
	private List<WebElement> getAvailableOptions(String category) {
		String locator = "div[class='" + category + "']>article>label";
		List<WebElement> availableOptions = new ArrayList<WebElement>();
		List<WebElement> options = utils.locateMultipleWebElems(By.cssSelector(locator));
		for(WebElement elem: options) {
			if(utils.extractAttribute(elem, "class") == "unavailable") {
				availableOptions.add(elem);
			}
		}
		return availableOptions;
	}
	
	public void goToCartPage() {
		System.out.println("navigating to Cart Page");
		utils.click(By.className("cart"));
	}
	
	public Boolean itemUnavailable() {
		return utils.elementIsPresent(By.className("itemUnavailable-container"));
	}
	
	
	

}
