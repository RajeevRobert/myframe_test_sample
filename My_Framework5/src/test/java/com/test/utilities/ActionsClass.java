package com.test.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.test.constants.BaseClass;


public class ActionsClass extends BaseClass {

	/**
	 * Mouse Over Action
	 */
	public static void actionCode(WebElement ele) {

		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
	}

	/**
	 * Drag and Drop
	 */
	public static void drag(WebElement ele, WebElement ele1) {
		Actions a = new Actions(driver);
		a.dragAndDrop(ele, ele1).perform();
	}

	/**
	 * Double Click
	 */
	public static void doubleClick(WebElement ele) {
		Actions a = new Actions(driver);
		a.doubleClick(ele).perform();
	}

	/**
	 * Right Click
	 */
	public static void rightClick(WebElement ele) {
		Actions a = new Actions(driver);
		a.contextClick(ele);
	}
	/**
	 *  Click and hold
	 */
	public static void clickandhold(WebElement ele,WebElement ele1) {
	   Actions pointer = new Actions(driver);
	    pointer.clickAndHold(ele).build().perform();
	    pointer.moveToElement(ele1).click().build().perform();
}
}