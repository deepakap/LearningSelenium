package com.app.pomTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver = new FirefoxDriver();
	LoginPage page;
	String expTitle = "Facebook - Log In or Sign Up";
	
  @BeforeTest
  public void performSetUp() throws InterruptedException{
	  driver.get("https://www.facebook.com/");
      Thread.sleep(2000l);	  
  }
	
  @Test
  public void homePage() {
	  page = new LoginPage(driver);
	  //Assert.assertEquals(page.getPageTitle(),expTitle);
	  page.setUserName("swift007.deepak@gmail.com");
	  page.setPassword("04087064@face");
	  page.clickLogin();
	   
  }
  
}
