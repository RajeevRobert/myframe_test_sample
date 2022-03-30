package com.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.test.constants.BaseClass;
import com.test.utilities.ActionsClass;

public class LogoutPage extends BaseClass{
  
	@FindBy(xpath = "//div[contains(@class,'btn-group dropdown-group')]")
	WebElement account;
	@FindBy(xpath = "//a[@href='/logout'][contains(.,'Sign Out')]")
	WebElement logoutoption;
			
	Logger log = Logger.getLogger(LogoutPage.class);

	

	/**
	 * PageFactory Intilisation
	 */
	public LogoutPage() {
		PageFactory.initElements(driver, this);
		PropertyConfigurator.configure("log4j.properties");	
	}
	
	public void logout(){
		LoginPage lp=new LoginPage();
		lp.clickLogin();
		ActionsClass.clickandhold(account,logoutoption);
		log.info("AccountLogoutTest" + "---"+ "Your Logout to account is Successful");
	}
}
