package com.trove.selenium.common;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utility {
	private WebDriver driver;
	
	public WebDriver startChromeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	public void click(By by) {
		try {
			driver.findElement(by).click();
		} catch (Exception e) {
			e.printStackTrace();;
		}
	}
	
	public void click(By by, int index) {
		try {
			driver.findElements(by).get(index).click();
		} catch (Exception e) {
			e.printStackTrace();;
		}
	}
	
	public void customWait(int inSeconds) {
		try {
			Thread.sleep(inSeconds * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void explicitWaitForElementIsClickAble(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	public void validatePageTitle(String expectedTitle, String actualTitle) {
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	public void quickNavigateToUrl(String url) {
		driver.get(url);
	}
	
	public void navigateBack() {
		driver.navigate().back();
	}
	
	public Boolean elementIsPresent(By by) {
		return driver.findElements(by).size() > 0;
	}
	
	public String extractText(By by) {
		return driver.findElement(by).getText();
	}
	
	public String extractAttribute(By by, String name) {
		return driver.findElement(by).getAttribute(name);
	}
	
	public String extractAttribute(WebElement elem, String name) {
		return elem.getAttribute(name);
	}
	
	public WebElement locateWebElement(By by) {
		return driver.findElement(by);
	}
	
	public List<WebElement> locateMultipleWebElems(By by) {
		return driver.findElements(by);
	}
	
	public void typeText(By by, String text) {
		driver.findElement(by).sendKeys(text);
	}
	
	public void moveMouseToElementThenClick(WebElement toElement) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(toElement).build().perform();
			action.click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void moveMouseByOffsetThenClick(WebElement toElement, int x, int y) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(toElement, x, y).build().perform();
			action.click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void clickWithJSE(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickWithJSE(By by) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", driver.findElement(by));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void navigateToPdb(String productName, String sku, String color) {
		String pdBaseURL = "https://www.rei.com/used/p/";
		String pdbFullURL = pdBaseURL + productName + "/" + sku + "?" + color;
		driver.get(pdbFullURL);
		
	}


}
