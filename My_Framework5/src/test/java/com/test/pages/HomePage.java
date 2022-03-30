package com.test.pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.constants.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//a[@href='/pendant-lighting/'][contains(.,'Pendant Lights')]")
	WebElement product;
	@FindBy(xpath = "//a[@class='logo-link lu-sprite']")
	WebElement logo;
	
	Logger log=Logger.getLogger(HomePage.class);

	/**
	 * PageFactory Intilisation
	 */
	public HomePage(){
		PageFactory.initElements(driver,this);
		PropertyConfigurator.configure("log4j.properties");	
	}
	
	
	public void navigateHomePage(){
		LoginPage l=new LoginPage();
	l.clickLogin();
	product.click();
	driver.navigate().to("https://www.YLighting.com/");
		}
	
	public  void verifyLogo(){
			if( logo.isDisplayed()){
			System.out.println("Logo is Visible");
			log.info("VerifyLogo" + "---"+ "Logo verified sucessfully");
			}else{
			System.out.println("Logo is not Visible");
			log.info("VerifyLogo" + "---"+ "Logo is not verified");
			}
	}
}
