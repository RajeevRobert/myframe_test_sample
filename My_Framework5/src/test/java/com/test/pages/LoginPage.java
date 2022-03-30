package com.test.pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.constants.BaseClass;
import com.test.utilities.ActionsClass;
import com.test.utilities.Waits;



public class LoginPage extends BaseClass {
	static Logger log = Logger.getLogger(LoginPage.class);
	
	@FindBy(xpath ="//*[@id='ltkpopup-close-button']")
	WebElement alertclose;
	@FindBy(xpath = "//div[contains(@class,'btn-group dropdown-group')]")
	WebElement account;
	@FindBy(xpath = "//a[contains(.,'Sign In')]")
	WebElement signinoption;
	@FindBy(xpath = "//input[contains(@name,'username')]")
	WebElement email;
	@FindBy(xpath = "//input[contains(@placeholder,'Password')]")
	WebElement password;
	@FindBy(xpath = "//span[contains(.,'Sign In')]")
	WebElement buttonsignin;
	@FindBy(xpath = "//a[@href='https://www.ylighting.com/']")
	WebElement apptitle;
	@FindBy(xpath = "//input[@id='searchinput']")
	WebElement searchtextbox;
	@FindBy(xpath= "//*[@id=\'simplesearchbtn\']/i")
	WebElement searchicon;
	@FindBy(xpath = "(//div[contains(.,'Live Chat')])[9]")
	WebElement livechatlink;
	@FindBy(xpath = "(//input[@class='lp_input-field'])[1]")
	WebElement name;
	@FindBy(xpath = "//input[contains(@id,'4167838')][@class='lp_input-field']")
	WebElement emaillivechat;
	@FindBy(xpath = "//button[contains(@data-lp-point,'submit_button')]")
	WebElement submitbutton;
	

	/**
	 * PageFactory Intilisation
	 */
	public LoginPage() {
		PageFactory.initElements(driver, this);
		PropertyConfigurator.configure("log4j.properties");	
	}

	
	
	/**
	 * Login process
	 */
	public void clickLogin() {
		Waits.waitperiod();
		alertclose.click();
		ActionsClass.actionCode(account);
		Waits.waitForVisibility(signinoption);
		signinoption.click();
		try{
		email.sendKeys(prop.getProperty("Email"));
		}catch(Exception e){
			email.sendKeys(prop.getProperty("Email"));
		}
		password.sendKeys(prop.getProperty("Password"));
		buttonsignin.click();
		log.info("LoginPage" + "---"+ "Your Login to account is Successful");
	}
	/**
	 * Verify the application title
	 */
	public void verifyTitle() {
		Waits.waitperiod();
		String actual = driver.getTitle();
		String expected = prop.getProperty("title");
		
		if (actual.equals(expected))
		{
		System.out.println( "Verification Successfull - Title Matched") ;
		}
		else {
		System.out.println( "Verification Failed - Title Not Matched");
		}
		log.info("VerifyHomePageTitleTest" + "---"+ "Verify Homepage title is Successful");
	}
	
	
	public void searchProduct(){
		LoginPage lp=new LoginPage();
		lp.clickLogin();
		searchtextbox.sendKeys(prop.getProperty("product"));
		searchicon.click();
		log.info("LoginPage" + "---"+ "Sucessfully product is selected");

	}
	
	public void livechatLogin(){
		Waits.waitperiod();
		alertclose.click();
		livechatlink.click();
		name.sendKeys(prop.getProperty("Name"));
		emaillivechat.sendKeys(prop.getProperty("Email"));
		submitbutton.click();
		log.info("LivechatLogin" + "---"+ "Sucessfully login to Livechat");

	}
	public void livechatLoginWrongDetails(){
		livechatlink.click();
		name.sendKeys(prop.getProperty("Name"));
		emaillivechat.sendKeys(prop.getProperty("InvalidEmail"));
		submitbutton.click();
		log.info("LivechatLogin" + "---"+ "wrongly login to Livechat");
	}
}
