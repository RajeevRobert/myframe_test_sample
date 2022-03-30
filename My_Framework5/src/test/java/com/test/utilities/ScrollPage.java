package com.test.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.test.constants.BaseClass;



public class ScrollPage extends BaseClass {

	public static JavascriptExecutor js = (JavascriptExecutor) driver;

	/**
	 * Scroll-Pageup
	 */
	public static void scrollPageup() {
		js.executeScript("window.scrollBy(0,-1000");
	}

	/**
	 * Scroll-Pagedown
	 */
	public static void scrollPagedown() {

		js.executeScript("window.scrollBy(0,500)");
		
	}
	public static void ScrollByVisibleElement (WebElement element) {
	js.executeScript("arguments[0].scrollIntoView();", element);
	}
}
