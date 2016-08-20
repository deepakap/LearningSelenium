package com.app.pomModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomeBasePage {
	
	private WebDriver homeDriverPage;
	
	@FindBy(xpath=".//*[@id='u_0_2']/div[1]/div[1]/div/a/span")
	private WebElement loginUser;
	
	@FindBy(id="u_0_3")
	private WebElement homeLnk;
	
	public HomeBasePage(WebDriver driver){
		this.homeDriverPage = driver;
		PageFactory.initElements(homeDriverPage, this);
	}
	
	public void clickHomeLink(){
		homeLnk.click();
	}
	
	public void verifyLoginUser(String usrName){
		//loginUser.getText().equalsIgnoreCase(usrName);
		Assert.assertEquals(loginUser.getText(), usrName);
	}
	
	
}
