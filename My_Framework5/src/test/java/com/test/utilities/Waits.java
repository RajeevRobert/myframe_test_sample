package com.test.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.constants.BaseClass;



public class Waits extends BaseClass{

	public static long IMPLICIT_WAIT = 80;
	
	/**
	 *Implicity wait
	 */
	public static void waitperiod() {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	/**
	 *Explicit wait
	 */
	public static void waitForVisibility(WebElement element) {
           new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOf(element));
    }
	
	public static void waitElemettoClickable(WebElement element) {
		
        new WebDriverWait(driver, 50)
	     .until(ExpectedConditions.elementToBeClickable(element));
		
	}
   public static void staleException(WebElement element) {
		
        new WebDriverWait(driver, 50)
        .ignoring(StaleElementReferenceException.class)
        .ignoring(NullPointerException.class)
        .ignoring(java.lang.ClassCastException.class)
        .ignoring(org.openqa.selenium.NoSuchElementException.class)
        .until(ExpectedConditions.visibilityOf(element));
   }
}