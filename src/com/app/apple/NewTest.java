package com.app.apple;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.ios.IOSDriver;


public class NewTest {
	
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	    // create a selenium desiredCapabilities object with the right values.
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "ios");
		capabilities.setCapability("platformVersion", "9.3");
		capabilities.setCapability("deviceName", "iPhone 6");
		//capabilities.setCapability("app", "/Users/deepakkumar/Desktop/InternationalMountains.app");
		capabilities.setCapability("app","/Users/deepakkumar/Library/Developer/Xcode/DerivedData/EasyPay-gkphhinimhvllseiqfrklypklhbj/Build/Products/Debug-iphonesimulator/AppleEasyPay.app");
		capabilities.setCapability("no-reset", true);
		 IOSDriver driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
	
		
		//capabilities.setCapability("app", "/Users/deepakkumar/Library/Developer/Xcode/DerivedData/EasyPay-gkphhinimhvllseiqfrklypklhbj/Build/Products/Debug-iphonesimulator/AppleEasyPay.app");
		//RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
		//driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).click();
		//Thread.sleep(2000l);
		//driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIANavigationBar[1]/UIAButton[1]")).click();
		//Thread.sleep(2000l);
		//driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[9]/UIAStaticText[1]")).click();
		Thread.sleep(6000l);
	
	}

}
