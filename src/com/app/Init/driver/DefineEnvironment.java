package com.app.Init.driver;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DefineEnvironment {
	
	public WebDriver driver;
	
	public WebDriver setEnvironment(String browserName){
		if(browserName.equalsIgnoreCase("IE")){
			File IEFile = new File("test path");
			System.setProperty("webdriver.ie.driver", IEFile.getAbsolutePath());
			return new InternetExplorerDriver();
		}else if(browserName.endsWith("Firefox")){
			return new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("Chrome")){
			return new ChromeDriver();
		}
		return driver;
	}

}
