package com.trove.selenium.pages;

import org.openqa.selenium.By;

import com.trove.selenium.common.Base;

public class ShippingPage extends Base{
	
	public void waitForEmailFieldClickable() {
		utils.explicitWaitForElementIsClickAble(By.className("email"));
	}
	
	public void filloutEmailAndConfirmEmail() {
		utils.typeText(By.className("email"), "trove@gmail.com");
		utils.typeText(By.className("emailConfirm"), "trove@gmail.com");
	}

}
