package com.tekarch.SalesForceTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class UserMenuTestingMySettings extends SFUtility {

	public static void main(String[] args) throws Exception {
		launchBrowser();
		goToSalesForceURL();
		loginToSalesForce();
		userMenuDropDown();
		driver.findElement(By.xpath("//a[contains(text(),'My Settings')]")).click();
		
		//testingPersonalLink();
		//testingDisplayLayoutLink();
		//testingEmailLink();
		testingCalendarReminder();
		
		quitBrowser();

	}
	
	public static void testingPersonalLink() throws Exception {
		driver.findElement(By.xpath("//div[@id='PersonalInfo']")).click();
		waitExplicitly(2,driver.findElement(By.xpath("//a[@id='LoginHistory_font']")));
		driver.findElement(By.xpath("//a[@id='LoginHistory_font']")).click();
		waitExplicitly(2, driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]")).click();
		
	}
	
	public static void testingDisplayLayoutLink() throws Exception {
	
		driver.findElement(By.xpath("//div[@id='DisplayAndLayout']")).click();
		waitExplicitly(2,driver.findElement(By.xpath("//a[@id='CustomizeTabs_font']")));
		driver.findElement(By.xpath("//a[@id='CustomizeTabs_font']")).click();
		
		Select se = new Select(driver.findElement(By.id("p4")));
		se.selectByVisibleText("Salesforce Chatter");
		
		Actions action = new Actions(driver);
		WebElement mHover = driver.findElement(By.xpath("//label[contains(text(),'Available Tabs')]"));
		action.moveToElement(mHover).build().perform();
		
		driver.findElement(By.xpath("//option[contains(text(),'Reports')]")).click();
		driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[2]/a[1]/img[1]")).click();
		driver.findElement(By.xpath("//input[@value=\" Save \"]")).click();
		
	}
	
	public static void testingEmailLink() throws Exception {
		
		driver.findElement(By.xpath("//div[@id='EmailSetup']")).click();
		waitExplicitly(2, driver.findElement(By.xpath("//a[@id='EmailSettings_font']")));
		driver.findElement(By.xpath("//a[@id='EmailSettings_font']")).click();
		waitExplicitly(2, driver.findElement(By.xpath("//input[@id='auto_bcc1']")));
		driver.findElement(By.xpath("//input[@id='auto_bcc1']")).click();
		driver.findElement(By.xpath("//input[@value=' Save ']")).click();
		System.out.println(driver.findElement(By.xpath("//td[@class='messageCell']")).getText());	
	}
	
	public static void testingCalendarReminder() throws Exception {
		
		driver.findElement(By.xpath("//div[@id='CalendarAndReminders']")).click();
		waitExplicitly(2, driver.findElement(By.xpath("//a[@id='Reminders_font']")));
		driver.findElement(By.xpath("//a[@id='Reminders_font']")).click();
		waitExplicitly(2, driver.findElement(By.xpath("//input[@id='testbtn']")));
		driver.findElement(By.xpath("//input[@id='testbtn']")).click();
		
		Thread.sleep(5000);
		quitBrowser();
	}
}



