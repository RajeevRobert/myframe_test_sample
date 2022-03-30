package com.test.testscripts;

import java.io.FileNotFoundException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.constants.BaseClass;
import com.test.pages.HomePage;

public class VerifyLogoTestScript extends BaseClass {

	/**
	 * Constuctor of VerifyLogoTestScript
	 */
	public VerifyLogoTestScript() {
		super();
	}

	HomePage hp;

	/**
	 * Launch the url
	 * 
	 * @param browser
	 */
	@Parameters({"browser"})
	@BeforeMethod
	public void beforemethod(String browser) throws FileNotFoundException {
		openURL(browser);
		hp=new HomePage();
	}

	/**
	 * @Test testcase of verifyLogo(TC_18)
	 */
	@Test
	public void   verifyLogo() {
		hp.verifyLogo();
		try {
			BaseClass.takeSnapShot(driver,"invalidZipcode");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
				
	/**
	 * Get status of testcase and close the browse
	 */
	@AfterMethod()
	public void aftermethod(ITestResult result) {
		String name = result.getName().toString().trim();
		if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println(name + "--------passed");
		}
		else if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println(name + "-----failed");

			try {
				takeSnapShot(driver,name);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println(name + "---------Skiped");
		}
		driver.close();
		driver.quit();

	}

}