package com.app.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestIOS {

	public static void main(String[] args) throws Exception {
		
	        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	        desiredCapabilities.setCapability("device", "Simulator");
	        desiredCapabilities.setCapability("version", "6");
	        desiredCapabilities.setCapability("app", "safari");
	        URL url = null;
	        try {
	            url = new URL("http://127.0.0.1:4723/wd/hub");
	        } catch (MalformedURLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        WebDriver remoteWebDriver = new RemoteWebDriver(url,desiredCapabilities);
	        remoteWebDriver.get("http://www.google.com");
	        WebElement ele = remoteWebDriver.findElement(By.name("q"));
	        ele.click();
	        ele.sendKeys("Packt Publishing");
	        WebElement searchButton = remoteWebDriver.findElement(By.name("btnG"));
	        System.out.println(searchButton.getSize());
	        searchButton.click();
	        remoteWebDriver.quit();
	    }

	
}
