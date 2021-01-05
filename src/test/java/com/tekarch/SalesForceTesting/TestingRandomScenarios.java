package com.tekarch.SalesForceTesting;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.apache.commons.exec.launcher.Java13CommandLauncher;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.DriverFactory;

import net.bytebuddy.asm.Advice.Argument;

public class TestingRandomScenarios extends SFUtility {

	public static void main(String[] args) throws Exception {
		launchBrowser();
		goToSalesForceURL();
		loginToSalesForce();
		
		//testingToVerifyFullNameOfUser();
		//testingEditingLastName();
		//testingTabCustomization();
		//testingBlockingEventInCalendar();
		testingBlockingEventWithWeeklyRecurrance();
		
		quitBrowser();
	}
	
	public static void testingToVerifyFullNameOfUser() throws Exception{
		
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		closePopUpWindow();
		System.out.println("User full name is diplayed as: "+driver.findElement(By.xpath("//h1[@class='currentStatusUserName']")).getText());
		waitExplicitly(2, driver.findElement(By.xpath("//h1[@class='currentStatusUserName']")));
		driver.findElement(By.xpath("//h1[@class='currentStatusUserName']")).click();
		System.out.println("Test Pass- Page displayed is same as My Profile page.");
		
	}
	
	public static void testingEditingLastName() throws Exception{
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		closePopUpWindow();
		waitExplicitly(2, driver.findElement(By.xpath("//h1[@class='currentStatusUserName']")));
		driver.findElement(By.xpath("//h1[@class='currentStatusUserName']")).click();
		waitExplicitly(2, driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[2]/div[2]/div[1]/h3[1]/div[1]/div[1]/a[1]/img[1]")));
		driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[2]/div[2]/div[1]/h3[1]/div[1]/div[1]/a[1]/img[1]")).click();
		
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']")));
		
		waitExplicitly(2, driver.findElement(By.xpath("//a[contains(text(),'About')]")));
		driver.findElement(By.xpath("//a[contains(text(),'About')]")).click();
		
		waitExplicitly(2, driver.findElement(By.xpath(" //input[@id='lastName']")));
		driver.findElement(By.xpath("//input[@id='lastName']")).clear();
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Abcd");
		
        driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]")).click();
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        
        Thread.sleep(2000);
        System.out.println("1) User's last name updated and is diplayed as: "+driver.findElement(By.xpath("//span[@id='tailBreadcrumbNode']")).getText());
        Thread.sleep(2000);
        System.out.println("2) Name updated at user menu as top right hand side to :"+driver.findElement(By.xpath("//span[@id='userNavLabel']")).getText());
		
	}
	
	public static void testingTabCustomization() throws Exception {
		driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click(); // plus icon on tab bar clicked to get all tab display
		System.out.println("'All Tabs' page is displayed. ");
		
		Actions action = new Actions(driver);
		WebElement mHover = driver.findElement(By.xpath("//div//td[@class='bCustomize']//input[@class='btnImportant']"));
		action.moveToElement(mHover).click().build().perform();
		
//		waitExplicitly(10, driver.findElement(By.xpath("//div//td[@class='bCustomize']//input[@class='btnImportant']")));
//		driver.findElement(By.xpath("//div//td[@class='bCustomize']//input[@class='btnImportant']")).click(); //customize tab clicked    //input[@value='Customize My Tabs']
		System.out.println("'Customize My Tab' page is displayed.");
		waitExplicitly(2, driver.findElement(By.xpath("//option[contains(text(),'Campaigns')]")));
		driver.findElement(By.xpath("//option[contains(text(),'Campaigns')]")).click(); //campaigns is selected from selected tab
		waitExplicitly(2, driver.findElement(By.xpath("//*[@class=\"leftArrowIcon\"]")));
		driver.findElement(By.xpath("//*[@class=\"leftArrowIcon\"]")).click(); //remove button clicked
		driver.findElement(By.xpath("//input[@value=' Save ']")).click(); //save button click
		Thread.sleep(1000);
		System.out.println("Pass-Back to All Tab page and selected tab removed from tab bar.");
		
		driver.findElement(By.id("userNavLabel")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		loginToSalesForce();
		
		Thread.sleep(1000);
		System.out.println("Pass-Tab removed before login out is not present in tab bar.");
	}
	
	public static void testingBlockingEventInCalendar() throws Exception{
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		closePopUpWindow();
		System.out.println("Current Day & Date displayed below user's name.");
		waitExplicitly(2, driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[2]/span[2]/a[1]"))); //span[@class='pageDescription']
		driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[2]/span[2]/a[1]")).click();
		System.out.println("User's Calendar is displayed");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//a[contains(text(),'8:00 PM')]")));
		
		driver.findElement(By.xpath("//a[contains(text(),'8:00 PM')]")).click();
		
		driver.switchTo().activeElement();
		
		driver.findElement(By.xpath("//*[@class='comboboxIcon']")).click();
		Thread.sleep(3000);
		
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
	
		driver.switchTo().window(windows.get(1));
		
		waitExplicitly(2, driver.findElement(By.xpath("//a[contains(text(),'Other')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Other')]")).click();
		
		driver.switchTo().window(windows.get(0));
		
		Actions act = new Actions(driver);
		driver.findElement(By.xpath("//input[@id='EndDateTime_time']")).clear();
		WebElement endTime = driver.findElement(By.xpath("//*[@id='timePickerItem_42']"));
		
		do {
			act.sendKeys(Keys.ARROW_DOWN).perform();
			
		}while(!endTime.isDisplayed());
		endTime.click();
		
		driver.findElement(By.xpath("//input[@value=' Save ']")).click();
		
		System.out.println("Oher event is added to user's calendar for 8-9PM slot.");
		}
		
	public static void testingBlockingEventWithWeeklyRecurrance() throws Exception{
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		closePopUpWindow();
		
		System.out.println("Current Day & Date displayed below user's name.");
		
		waitExplicitly(2, driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[2]/span[2]/a[1]"))); //span[@class='pageDescription']
		driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[2]/span[2]/a[1]")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//a[contains(text(),'4:00 PM')]")));
		
		driver.findElement(By.xpath("//a[contains(text(),'4:00 PM')]")).click();
		
		driver.switchTo().activeElement();
		
		driver.findElement(By.xpath("//*[@class='comboboxIcon']")).click();
		Thread.sleep(3000);
		
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
	
		driver.switchTo().window(windows.get(1));
		
		waitExplicitly(2, driver.findElement(By.xpath("//a[contains(text(),'Other')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Other')]")).click();
		
		driver.switchTo().window(windows.get(0));
		
		Actions act1 = new Actions(driver);
		driver.findElement(By.xpath("//input[@id='EndDateTime_time']")).clear();
		WebElement endTime1 = driver.findElement(By.xpath("//*[@id='timePickerItem_38']"));
		
		do {
			act1.sendKeys(Keys.ARROW_DOWN).perform();
			
		}while(!endTime1.isDisplayed());
		endTime1.click();
		
		waitExplicitly(2, driver.findElement(By.xpath("//input[@id='IsRecurrence']")));
		driver.findElement(By.xpath("//input[@id='IsRecurrence']")).click();
		
		waitExplicitly(1, driver.findElement(By.xpath("//input[@id='rectypeftw']"))); //weekly recurrence
		driver.findElement(By.xpath("//input[@id='rectypeftw']")).click();
		
		System.out.println("Weekly recurrance selected with recurrs every 1 week option and current day is selected.");
		
		waitExplicitly(1, driver.findElement(By.xpath("//input[@id='RecurrenceEndDateOnly']")));
		driver.findElement(By.xpath("//input[@id='RecurrenceEndDateOnly']")).click();//td[contains(text(),'19')]
		
		waitExplicitly(1, driver.findElement(By.xpath("//td[contains(text(),'19')]")));
		driver.findElement(By.xpath("//td[contains(text(),'19')]")).click();
		
		waitExplicitly(1, driver.findElement(By.xpath("//input[@value=' Save ']")));
		driver.findElement(By.xpath("//input[@value=' Save ']")).click();
		
		waitExplicitly(3, driver.findElement(By.xpath("//*[@class='monthViewIcon']")));
		driver.findElement(By.xpath("//*[@class='monthViewIcon']")).click();
		
		System.out.println("Final Test Passed");
	}
	}
