package com.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.test.constants.BaseClass;
import com.test.utilities.ScrollPage;

public class CoupinCode extends BaseClass{

	@FindBy(xpath = "//input[@alt='Enter Promo Code']")
	WebElement promocode;
	@FindBy(xpath = "//span[contains(.,'Apply')]")
	WebElement applybutton;
	@FindBy(xpath = "//input[@placeholder='Enter ZIP']")
	WebElement zipcode;
	@FindBy(xpath = "//input[contains(@value,'Go')]")
	WebElement gobutton;
	@FindBy(xpath = "//span[@class='taxCalcErr show']")
	WebElement zipcodemsg;
	@FindBy(xpath = "//span[contains(@class,'qty-increment-decrement qty-increment')]")
	WebElement quantityincrease;
	
	Logger log=Logger.getLogger(CoupinCode.class);
	
	/**
	 * PageFactory Intilisation
	 */
	public CoupinCode(){
		PageFactory.initElements(driver,this);
		PropertyConfigurator.configure("log4j.properties");	
	}
	
	public void applyCoupincode() throws InterruptedException{
		CelingLightTab cl=new CelingLightTab();
		cl.viewCart();
		ScrollPage.scrollPagedown();
		promocode.sendKeys(prop.getProperty("CouponCode"));
		applybutton.click();
		log.info("CoupinCode" + "---"+ "Your have applied Coupin sucessfully");
	}
	
	public void invalidZipcode() throws InterruptedException{
		CelingLightTab cl=new CelingLightTab();
		cl.viewCart();
		ScrollPage.scrollPagedown();
		zipcode.sendKeys(prop.getProperty("ZipCode"));
		gobutton.click();
		String actualmsg = zipcodemsg.getText();
		String expectedmsg = "Please provide a valid US ZIP Code or Canadian Postal Code";
		if (actualmsg.equalsIgnoreCase(expectedmsg)) {
			Reporter.log("You entered correct zipcode");
		} else {
			Reporter.log("You entered incorrect zipcode");
		}
		log.info("CoupinCode" + "---"+ "Your have entered invalid zipcode");
	}
	
	public void quantitycheck() throws InterruptedException{
		CelingLightTab cl=new CelingLightTab();
		cl.viewCart();
		quantityincrease.click();
		log.info("CoupinCode" + "---"+ "quantity is increased");
	}
}
