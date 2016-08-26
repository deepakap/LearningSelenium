package com.app.page.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MobilePage {
	
	private WebDriver driver;
	
	@FindBy(tagName="select")
	WebElement select;
	
	public MobilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyTitle(String title){
		Assert.assertEquals(driver.getTitle(), title);
	}
	
	public MobilePage sortItemsByName(){
		Select dropDown = new Select(select);
		dropDown.selectByVisibleText("Name");
		return new MobilePage(driver);
	}
	
}
