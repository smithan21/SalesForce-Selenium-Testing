package com.tekarch.SalesForceTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class TestingContactsTab extends SFUtility {

	public static void main(String[] args) throws Exception {
		launchBrowser();
		goToSalesForceURL();
		loginToSalesForce();
		openContactsTab();
		closePopUpWindow();
		
		//testingCreateNewAccount();
		//testingCreateNewView();
		//testingRecentlyCreatedContact();
		//testingMyContactsView();
		testingViewContact();
		//testingErrorMessageCreatingNewView();
		//testingCancelButtonInCreateNewView();
		//testingSaveAndNewButtonNewContact();
		
		quitBrowser();
	
	}
	
	public static void testingCreateNewAccount() throws Exception {
		waitExplicitly(2, driver.findElement(By.xpath("//input[@value=' New ']")));
		driver.findElement(By.xpath("//input[@value=' New ']")).click();
		waitExplicitly(2, driver.findElement(By.xpath("//input[@id='name_lastcon2']")));
		driver.findElement(By.xpath("//input[@id='name_lastcon2']")).sendKeys("Nair");
		waitExplicitly(2, driver.findElement(By.xpath("//input[@id='con4']")));
		driver.findElement(By.xpath("//input[@id='con4']")).sendKeys("Automation");
		waitExplicitly(2, driver.findElement(By.xpath("//input[@value=' Save ']")));
		driver.findElement(By.xpath("//input[@value=' Save ']")).click();
	}
	
	public static void testingCreateNewView() throws Exception{
		waitExplicitly(2, driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
		waitExplicitly(2, driver.findElement(By.xpath("//input[@id='fname']")));
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("ContactB");
		waitExplicitly(2, driver.findElement(By.xpath("//input[@id='devname']")));
		driver.findElement(By.xpath("//input[@id='devname']")).click();
		
		driver.findElement(By.xpath("//input[@value=\" Save \"]")).click();
	}
	
	public static void testingRecentlyCreatedContact() throws Exception{
		Select c = new Select(driver.findElement(By.id("hotlist_mode")));
		c.selectByVisibleText("Recently Created");
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Recent Contacts')]")).getText()+" is displayed!");
		
	}
	
	public static void testingMyContactsView() throws Exception {
		Select c1 = new Select(driver.findElement(By.id("fcf")));
		c1.selectByVisibleText("My Contacts");
		waitExplicitly(2, driver.findElement(By.xpath("//input[@value=' Go! ']")));
		driver.findElement(By.xpath("//input[@value=' Go! ']")).click();
	}
	
	public static void testingViewContact() throws Exception{
		waitExplicitly(2, driver.findElement(By.xpath("//a[contains(text(),'Mohan')]")));
		driver.findElement(By.partialLinkText("Mohan")).click();
	}
	
	public static void testingErrorMessageCreatingNewView() throws Exception{
		waitExplicitly(2, driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
		waitExplicitly(2, driver.findElement(By.xpath("//input[@id='devname']")));
		driver.findElement(By.xpath("//input[@id='devname']")).sendKeys("EFGH");
		driver.findElement(By.xpath("//input[@value=\" Save \"]")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='errorMsg']")).getText());
		
	}
	
	public static void testingCancelButtonInCreateNewView() throws Exception{
		waitExplicitly(2, driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
		waitExplicitly(2, driver.findElement(By.xpath("//input[@id='fname']")));
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("ABCD");
		waitExplicitly(2, driver.findElement(By.xpath("//input[@id='devname']")));
		driver.findElement(By.xpath("//input[@id='devname']")).sendKeys("EFGH");
		driver.findElement(By.xpath("//input[@value='Cancel']")).click();
	}
	
	public static void testingSaveAndNewButtonNewContact() throws Exception{
		waitExplicitly(2, driver.findElement(By.xpath("//input[@value=' New ']")));
		driver.findElement(By.xpath("//input[@value=' New ']")).click();
		waitExplicitly(2, driver.findElement(By.xpath("//input[@id='name_lastcon2']")));
		driver.findElement(By.xpath("//input[@id='name_lastcon2']")).sendKeys("Indian");
		waitExplicitly(2, driver.findElement(By.xpath("//input[@id='con4']")));
		driver.findElement(By.xpath("//input[@id='con4']")).sendKeys("Global Media");
		waitExplicitly(2, driver.findElement(By.xpath("//input[@value='Save & New']")));
		driver.findElement(By.xpath("//input[@value='Save & New']")).click();
		System.out.print("Fail: "+ driver.findElement(By.xpath("//div[@class='errorMsg']")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@id='errorDiv_ep']")).getText());
	}
}

