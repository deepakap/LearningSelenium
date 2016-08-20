package com.app.baseUtil;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.app.pomModel.LoginBasePage;

public class BasePageUtil {
	
	private WebDriver driver;
	
	@Test(priority=0)
	public void setUpPage(){
		this.driver = (WebDriver) new LoginBasePage(driver);
	}
	
	

}
