package com.test.testscripts;


	   import java.io.FileNotFoundException;
		import org.testng.ITestResult;
		import org.testng.annotations.AfterMethod;
		import org.testng.annotations.BeforeMethod;
		import org.testng.annotations.Parameters;
        import org.testng.annotations.Test;

import com.test.constants.BaseClass;
import com.test.pages.CelingLightTab;

		public class ViewCartTestScript    extends BaseClass {

			/**
			 * Constuctor of ViewCartTestScript
			 */
			public ViewCartTestScript() {
				super();
			}

			CelingLightTab cl;

			/**
			 * Launch the url
			 * 
			 * @param browser
			 */
			@Parameters({"browser"})
			@BeforeMethod
			public void beforemethod(String browser) throws FileNotFoundException {
				openURL(browser);
				cl=new CelingLightTab();
			}

			/**
			 * @throws InterruptedException 
			 * @Test testcase of viewproductinCart(TC_07)
			 */
			@Test
			public void   viewCart() throws InterruptedException {
				cl.viewCart();
				try {
					BaseClass.takeSnapShot(driver,"ViewCart");
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