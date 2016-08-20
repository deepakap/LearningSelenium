package com.app.pomModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class  LoginBasePage {
	
	private WebDriver driver;
	
	@FindBy(id="email")
	private WebElement email; 
	
	@FindBy(id="pass")
	private WebElement password;
	
	@FindBy(id="u_0_o")
	private WebElement loginBtn;
	
	public LoginBasePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setEmail(String emailStr){
		email.clear();
		email.sendKeys(emailStr);
	}
	
	public void setPassword(String pwdStr){
		password.clear();
		password.sendKeys(pwdStr);
	}
	
	public void passCredentials(String usn,String pwd){
		setEmail(usn);
		setPassword(pwd);
		 	
	}
	
	public HomeBasePage clickLogin(){
		loginBtn.submit();
		return (HomeBasePage) new HomeBasePage(driver);
	}
	
	public void launchFaceBookHomePage(String pageUrl){
		driver.get(pageUrl);
	}

}
