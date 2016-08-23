package com.app.page.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.app.waitEvt.PageLoad;

public class HomePage extends PageLoad {
	
	private WebDriver driver;
	
	@FindBy(linkText="PRIVACY POLICY")
	WebElement link;
	
	public void verifyTitle(String title){
		Assert.assertEquals(driver.getTitle(), title);
	}

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement findLinkWebElement(){
		return link;
	}
	
	public void loadWebPage(String urlStr){
		driver.get(urlStr);
	}
	
	public void maximizeWebPage(){
		driver.manage().window().maximize();
	}
}
