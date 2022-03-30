package com.test.testscripts;


import java.io.FileNotFoundException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import org.testng.annotations.Test;

import com.test.constants.BaseClass;
import com.test.pages.LoginPage;


/**
 * Unit test for LiveChatLoginTestScript.
 */
public class LiveChatLoginTestScript extends BaseClass {

		/**
		 * Constuctor of LiveChatLoginTestScript
		 */
		public LiveChatLoginTestScript() {
			super();
		}

		LoginPage lp;

		/**
		 * Launch the url
		 * 
		 * @param browser
		 */
		@Parameters({"browser"})
		@BeforeMethod
		public void beforemethod(String browser) throws FileNotFoundException {
			openURL(browser);
			lp = new LoginPage();
		}

		
		
		/**
		 * @Test testcase of loginLivechat(TC_09)
		 */
		@Test(enabled = false, priority = 1)
		public void loginLivechat() {
			lp.livechatLogin();
			try {
				BaseClass.takeSnapShot(driver,"loginLivechat");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/**
		 * @Test testcase of livechatLoginWrongDetails(TC_10)
		 */
		@Test(enabled = false, priority = 2)
		public void loginInvalid() {
			lp.livechatLoginWrongDetails();
			try {
				BaseClass.takeSnapShot(driver,"livechatLoginWrongDetails");
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
