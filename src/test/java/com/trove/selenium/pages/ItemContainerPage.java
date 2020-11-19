package com.trove.selenium.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.trove.selenium.common.Base;

public class ItemContainerPage extends Base{
	
	public void clickRandomItem() {
		utils.customWait(2);
		Random random = new Random();
		int itemIdx = 0;
		while (true){
			itemIdx = random.nextInt(5);
		    if(itemIdx !=0) break;
		}
		System.out.println("clicking item num: " + itemIdx);
		WebElement itemElem = utils.locateMultipleWebElems(By.className("TileItem")).get(itemIdx);
		//utils.moveMouseByOffsetThenClick(itemElem, 70, 70);
		utils.clickWithJSE(itemElem.findElement(By.cssSelector("a>div[class='img-wrap']>img")));
	}
	
}
