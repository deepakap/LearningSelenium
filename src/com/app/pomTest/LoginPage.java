package com.app.pomTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(id="email")
	WebElement userName;
	
	@FindBy(id="pass")
	WebElement psswd;
	
	@FindBy(id="pageTitle")
	WebElement titleTxt;
	
	@FindBy(id="u_0_o")
	WebElement loginBtn;
		
	public LoginPage(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String usrNameStr){
		userName.clear();
		userName.sendKeys(usrNameStr);
	}
	
	public void setPassword(String passString){
		psswd.clear();
		psswd.sendKeys(passString);
	}

	public String getPageTitle(){
		return titleTxt.getText();
	}
	
	public void clickLogin(){
		loginBtn.click();
	}
	
	public void inputCredentials(String usn, String pwd){
		this.setUserName(usn);
		this.setPassword(pwd);
		this.clickLogin();
	}
	
}
