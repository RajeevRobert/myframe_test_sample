package com.test.utilities;

import com.test.constants.BaseClass;

public class Alerts extends BaseClass {

	
	
	public void alertAccept(String s){
		driver.switchTo().alert().accept();
	}
	
	public void alertCancel(){
		driver.switchTo().alert().dismiss();
	}
}
