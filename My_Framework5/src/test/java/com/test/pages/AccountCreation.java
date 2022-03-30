package com.test.pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.constants.BaseClass;
import com.test.utilities.ActionsClass;
import com.test.utilities.ScrollPage;
import com.test.utilities.Waits;


public class AccountCreation extends BaseClass {

	static Logger log= Logger.getLogger(AccountCreation.class);

	
	@FindBy(xpath ="//*[@id=\'ltkpopup-close-button\']")
	WebElement alertclose;
	@FindBy(xpath = "//div[contains(@class,'btn-group dropdown-group')]")
	WebElement account;
	@FindBy(xpath = "//a[contains(.,'My Account')]")
	WebElement myaccountoption;
	@FindBy(xpath = "//input[contains(@name,'firstname')]")
	WebElement firstname;
	@FindBy(xpath = "//input[contains(@id,'lastname')]")
	WebElement lastname;
	@FindBy(xpath = "(//input[contains(@name,'email')])[1]")
	WebElement email;
	@FindBy(xpath = "//input[contains(@id,'emailconfirm')]")
	WebElement confirmemail;
	@FindBy(xpath = "(//input[contains(@type,'password')])[1]")
	WebElement password;
	@FindBy(xpath = "//input[@placeholder='Confirm Password']")
	WebElement confirmpassword;
	@FindBy(xpath = "//span[contains(.,'Create Account')]")
	WebElement createaccount;

	
	/**
	 * Pagefactorty Intilisation
	 */
	public AccountCreation() {
		PageFactory.initElements(driver, this);
		PropertyConfigurator.configure("log4j.properties");	
	}

	/**
	 * Sign in Account
	 */
	public void clicksignin() {
		Waits.waitperiod();
		alertclose.click();
		ActionsClass.clickandhold(account,myaccountoption);
	}

	/**
	 * Account Creation with all required details
	 */
	public void createAccount() {
		Waits.waitperiod();
		firstname.clear();
		firstname.sendKeys(prop.getProperty("FirstName"));
		lastname.clear();
		lastname.sendKeys(prop.getProperty("LastName"));
		email.sendKeys(prop.getProperty("Email"));
		ScrollPage.scrollPagedown();
		confirmemail.sendKeys(prop.getProperty("ConfirmEmail"));
		password.sendKeys(prop.getProperty("Password"));
		confirmpassword.sendKeys(prop.getProperty("ConfirmPassword"));
		createaccount.click();
		log.info("AccountCreation" + "---"+ "Your  account is created Successful");

			}

	}
