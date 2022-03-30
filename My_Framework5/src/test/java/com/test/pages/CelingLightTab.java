package com.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.test.constants.BaseClass;
import com.test.pages.LoginPage;
import com.test.utilities.ActionsClass;
import com.test.utilities.ScrollPage;
import com.test.utilities.Waits;

public class CelingLightTab extends BaseClass {


	@FindBy(xpath = "//span[@class='menu-link'][contains(.,'ceiling')]")
	WebElement celinglightmenu;
	@FindBy(xpath = "//a[@href='/chandeliers/'][contains(.,'Chandeliers')]")
	WebElement productchandlier;
	@FindBy(xpath = "//a[contains(.,'Rectangular Chandeliers')]")
	WebElement productrectanglur;
	@FindBy(xpath = "(//input[contains(@type,'checkbox')])[1]")
	WebElement filteroption;
	@FindBy(xpath = "//a[contains(.,'Tangent LED Chandelier')]")
	WebElement selectproduct;
	@FindBy(xpath = "(//button[contains(@id,'add-to-cart')])[1]")
	WebElement addtocart;
	@FindBy(xpath = "(//a[contains(.,'Checkout')])[1]")
	WebElement checkoutalert;
	@FindBy(xpath = "//span[contains(.,'Cart')]")
	WebElement cart;
	@FindBy(xpath = "//a[contains(.,'VIEW CART')]")
	WebElement viewcartoption;
	@FindBy(xpath = "//span[contains(.,'Remove')]")
	WebElement removeproductfromcart;
	
	Logger log=Logger.getLogger(CelingLightTab.class);
			
	
	/**
	 * PageFactory Intilisation
	 */
	public CelingLightTab(){
		PageFactory.initElements(driver,this);
		PropertyConfigurator.configure("log4j.properties");	
	}
	
	public void selectProduct()throws InterruptedException {
      LoginPage lp=new LoginPage();
      lp.clickLogin();
      Waits.waitperiod();
      driver.navigate().to("https://www.YLighting.com/");
      celinglightmenu.click();
      ScrollPage.scrollPagedown();
      Waits.waitperiod();
      // Waits.waitForVisibility(productchandlier);
       productchandlier.click();
       //ScrollPage.scrollPagedown();
       //Waits.waitForVisibility(productrectanglur);
       productrectanglur.click();
		log.info("CelingLightTab" + "---"+ "Your have slect the product in celinglight tab");
	  	}
	 
	public void applyFiter()throws InterruptedException{
		CelingLightTab cl=new CelingLightTab();
		cl.selectProduct();
		Waits.waitperiod();
	   filteroption.click();
	   Waits.waitForVisibility(selectproduct);
	  selectproduct.click();
		log.info("CelingLightTab" + "---"+ "Your have applied filter to your product");
}
	public void addselectedproductToCart() throws InterruptedException{
		CelingLightTab cl=new CelingLightTab();
		cl.applyFiter();
		ScrollPage.scrollPagedown();
		addtocart.click();
		checkoutalert.click();
		log.info("CelingLightTab" + "---"+ "Your have sucessfully added product to cart");
		}
	public void viewCart() throws InterruptedException{
		CelingLightTab cl=new CelingLightTab();
		cl.addselectedproductToCart();
		cart.click();
		ActionsClass.actionCode(viewcartoption);
	}
	
	public void productremoveCart() throws InterruptedException{
		LoginPage lp=new LoginPage();
		lp.clickLogin();
		cart.click();
		Waits.waitElemettoClickable(viewcartoption);
		removeproductfromcart.click();
		log.info("CelingLightTab" + "---"+ "Your product is removedfrom cart is Successful");

	}
}

