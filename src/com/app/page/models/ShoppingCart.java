/**
 * 
 */
package com.app.page.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * @author deepakkumar
 *
 */
public class ShoppingCart {
	
	private WebDriver driver;
	
	private static String UPDATE_MSG = "Some of the products cannot be ordered in requested quantity.";
	private static String SHOPPIN_CART_ERROR_MSG="* The maximum quantity allowed for purchase is 500.";
	
	@FindBy(xpath="//*[@title='Qty']")
	WebElement qtyField;

	@FindBy(name="update_cart_action")
	WebElement updateBtn;
	
	@FindBy(xpath=".//*[@id='top']/body/div[1]/div/div[2]/div/div/div/ul/li/ul/li/span")
	WebElement spanTxt;
	
	@FindBy(css="p.item-msg")
	WebElement errorMsgElement;
	
	public ShoppingCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void updateItemQuantity(){
		qtyField.sendKeys("1000");
	}
	
	public void submitUpdateAndVerify(){
		updateBtn.submit();
		Assert.assertEquals(spanTxt.getText(), UPDATE_MSG);
		Assert.assertEquals(errorMsgElement.getText(), SHOPPIN_CART_ERROR_MSG);
		
	}
	
	public WebElement quantityTextField(){
		return qtyField;
	}
		
}
