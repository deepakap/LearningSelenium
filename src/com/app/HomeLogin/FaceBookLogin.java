package com.app.HomeLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.app.pomModel.HomeBasePage;
import com.app.pomModel.LoginBasePage;

public class FaceBookLogin {
	private WebDriver driver ;
	private HomeBasePage homePage;
	
  @BeforeTest
  public void dispHomePage(){
	  this.driver = new FirefoxDriver();
  }
  	
  @Test(priority=0)
  public void TestLoginPage() {
	  LoginBasePage page = new LoginBasePage(driver);
	  page.launchFaceBookHomePage("https://www.facebook.com/");
	  page.passCredentials("-----.com", "-----@face");
	  this.homePage = page.clickLogin();
	  System.out.println("page is"+homePage.getClass());
  }
  
  @Test(priority=1)
  public void TestHomePage() throws InterruptedException{
	  Thread.sleep(3000l);
	  if(null!=homePage){
		  homePage.clickHomeLink();
	  }
	  
  }
  
  
}
