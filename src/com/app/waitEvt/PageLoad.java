package com.app.waitEvt;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageLoad {
	
	public void waitExplicitDuration(WebDriver driver, WebElement ele){
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitImplicitDuration(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

}
