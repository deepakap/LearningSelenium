package com.app.testGuru.first;

import java.awt.print.Pageable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import com.app.waitEvt.*;

import com.app.baseLogic.*;

public class SortWebElements extends PageLoad {
   private WebDriver driver;
   private String url = "http://live.guru99.com/index.php/";
   private List <String> strList = new ArrayList<String>();

   @BeforeTest
   public void beforeTest() {
	 driver = new FirefoxDriver();
	 driver.get(url);
	 driver.manage().window().maximize();
  }
	
  @Test(priority=0, enabled=true)
  public void verifyMobileApp() throws InterruptedException {
	  Assert.assertEquals(driver.getTitle(), "Home page");
	  WebElement ele = driver.findElement(By.linkText("Privacy Policy".toUpperCase()));
	  waitExplicitDuration(driver, ele);
  }
  
  @Test(priority=1, enabled=true)
  public void testMobilePage(){
	  driver.findElement(By.linkText("Mobile".toUpperCase())).click();
	  WebElement ele = driver.findElement(By.linkText("Privacy Policy".toUpperCase()));
	  waitExplicitDuration(driver, ele);
	  Assert.assertEquals(driver.getTitle(), "Mobile");
	  Select dropDown = new Select(driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")));
	  dropDown.selectByVisibleText("Name");
  }
  
  @Test(priority=2, enabled=true)
  public void pageSortByName(){
	  WebElement webEle = driver.findElement(By.className("copyright"));
	  WebElement ele = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul"));
	  waitExplicitDuration(driver, webEle);
	  List<WebElement> list = ele.findElements(By.tagName("a"));
	  strList = new ArrayList<String>();
	  for(WebElement elem : list){
		  if(elem.getText()!="" && !elem.getText().isEmpty() && (!elem.getText().equalsIgnoreCase("Add to Wishlist") && !elem.getText().equalsIgnoreCase("Add to Compare")) ){
			  strList.add(elem.getText());
		  }
	  }
	  Boolean flag = new SortLogic().verifyItemsSortOrder((ArrayList<String>) strList);
	  Assert.assertTrue(flag, "Listed Items are sorted by Name !");
  }
  
  @Test(priority=3, enabled=false)
  public void verifyItemPrice(){
	  WebElement webItem = driver.findElement(By.xpath(".//*[@id='product-price-1']/span"));
	  String itemPrice  = webItem.getText();
	  System.out.println( " item price :"+itemPrice);
	  driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/h2/a")).click();
	  Assert.assertEquals(itemPrice, driver.findElement(By.className("price")).getText());	
	  //driver.navigate().back();
  }
  
  @Test(priority=4, enabled=false)
  public void verifyAddCartItems(){
	  String actualStr = "You have no items in your shopping cart.";
	  driver.findElement(By.xpath(".//*[@id='product_addtocart_form']/div[4]/div/div/div[2]/button")).submit();
	  driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/input")).sendKeys("1000");
      driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/button")).submit();
	  String actual = "Some of the products cannot be ordered in requested quantity.";
      Assert.assertEquals(actual, driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div/div/ul/li/ul/li/span")).getText());
      //Assert.assertEquals("", driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[2]/p")).getText().toString());
      driver.findElement(By.id("empty_cart_button")).click();
      Assert.assertEquals(actualStr, driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div/div[2]/p[1]")).getText().toString());
  }
  
  @Test(priority=5, enabled = false)
  public void verifyCartItems(){
	 driver.findElement(By.linkText("Mobile".toUpperCase())).click();
	 WebElement wele = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/ul/li[2]/a"));
	 waitExplicitDuration(driver, wele);
	 ArrayList<String> msgList = new ArrayList<String>();
	 msgList.add("The product IPhone has been added to comparison list.");
	 msgList.add("");
	 msgList.add("The product Sony Xperia has been added to comparison list.");
	 driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a")).click();
	 String strTxt = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/ul/li/ul/li/span")).getText().trim();
	 Assert.assertEquals(msgList.get(0).toString(), strTxt);
	 driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/ul/li[2]/a")).click();	
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }
  
  @Test(priority=6, enabled=false)
  public void verifyItemsOnCart(){
	  String phone1= "IPHONE";
	  String phone2= "SONY XPERIA";
	  Actions actions = new Actions(driver);
	  WebElement spanEle = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[3]/div[2]/div[2]/div/button/span/span"));
	  //actions.moveToElement(spanEle).perform();
	  actions.moveToElement(spanEle).click(spanEle).build().perform();
	  waitImplicitDuration(driver);
	  Set<String> eleSet = driver.getWindowHandles();
	  Iterator<String> itr = eleSet.iterator();
	 
	  String parentWindow = itr.next();
	  String childWindow = itr.next();
	  driver.switchTo().window(childWindow);
	  
	  String popupMobile1 = driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();
	  String popupMobile2 = driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText(); 
	  
	  Assert.assertEquals(popupMobile1, phone1);
	  Assert.assertEquals(popupMobile2, phone2);
	  driver.findElement(By.xpath("//button[@title='Close Window']")).click();
	  driver.switchTo().window(parentWindow);
	  driver.navigate().refresh();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }
  
  @Test(priority=7, enabled=false)
  public void registerUserLogin(){
	  String link = "REGISTER";
	  driver.findElement(By.xpath(".//*[@id='header']/div/div[2]/div/a/span[2]")).click();
	  WebElement ele = driver.findElement(By.id("header-account"));
	  
	  List<WebElement> list = ele.findElements(By.tagName("li"));
	  Iterator<WebElement> itr = list.iterator();
	  while(itr.hasNext()){
		  WebElement regEle = itr.next();
		  if(regEle.getText().equalsIgnoreCase(link)){
			  regEle.click();
			  break;
		  }
	  }
	  String title = driver.getTitle().toString();
	  String expString = "CREATE NEW CUSTOMER ACCOUNT";
	  Assert.assertEquals(title.toUpperCase(),expString);
	  
	  driver.findElement(By.id("firstname")).sendKeys("Nissan");
	  driver.findElement(By.id("lastname")).sendKeys("altima");
	  driver.findElement(By.id("email_address")).sendKeys("nissan_Xnew.altimaX@gmail.com");
	  driver.findElement(By.id("password")).sendKeys("welcome");
	  driver.findElement(By.id("confirmation")).sendKeys("welcome");
	  driver.findElement(By.id("is_subscribed")).click();
	  driver.findElement(By.xpath(".//*[@id='form-validate']/div[2]/button")).submit();
	  
  }
  
  @Test(priority=8, enabled=false)
  public void verifyRegisteration(){
	  String regTxt = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div/div/ul/li/ul/li/span")).getText();
      Assert.assertEquals(regTxt, "Thank you for registering with Main Website Store.");
  }
  
  @Test(priority=9, enabled=false)
  public void addToWishList(){
	  driver.findElement(By.linkText("TV")).click();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.findElement(By.linkText("Add to Wishlist")).click();
	  String title = "My Wishlist";
	  Assert.assertEquals(driver.getTitle().toString(), title);
	  driver.findElement(By.xpath(".//*[@id='wishlist-view-form']/div/div/button[1]")).click();
	  WebElement shareBtn = driver.findElement(By.xpath(".//*[@id='form-validate']/div[2]/button"));
	  waitExplicitDuration(driver, shareBtn);
	  driver.findElement(By.id("email_address")).sendKeys("nissan_new.altima@gmail.com");
	  driver.findElement(By.id("message")).sendKeys("This is Test message from automation user");
	  shareBtn.click();
	  String shareTxt = "Your Wishlist has been shared.";
	  WebElement shareEle = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span"));
	  Assert.assertEquals(shareEle.getText(), shareTxt);
  }
  
  @Test(priority=10, enabled=false)
  public void loginToAccount(){
	  
  }
  
  @AfterTest
  public void afterTest() {
  }

}
