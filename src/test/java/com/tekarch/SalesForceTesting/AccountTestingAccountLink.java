package com.tekarch.SalesForceTesting;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class AccountTestingAccountLink extends SFUtility{

	public static void main(String[] args) throws Exception {
		
		launchBrowser();
		goToSalesForceURL();
		loginToSalesForce();
		openAccountLink();
		
		Thread.sleep(5000);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ESCAPE);
		rb.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(5000);
		
		//testingCreateNewAccount();
		//testingCreateNewView();
		//testingEditView();
		//testingMergeAccounts();
		testingCreateAccountReport();
		
		//quitBrowser();

	}
	
	public static void testingCreateNewAccount() throws Exception {		
		
		driver.findElement(By.xpath("//input[@value=\" New \"]")).click();
		waitExplicitly(2, driver.findElement(By.xpath("//input[@id='acc2']")));
		driver.findElement(By.xpath("//input[@id='acc2']")).sendKeys("Automation");
		
		Select se = new Select(driver.findElement(By.id("acc6")));
		se.selectByVisibleText("Technology Partner");
		
		Select se1 = new Select(driver.findElement(By.xpath("//select[@tabindex='26']")));
		se1.selectByVisibleText("High");
		
		driver.findElement(By.xpath("//input[@value=\" Save \"]")).click();
		
		
	}
	
	public static void testingCreateNewView() throws Exception {
		
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
		waitExplicitly(2, driver.findElement(By.xpath("//input[@id='fname']")));
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("qaAutomationAB");
		waitExplicitly(2, driver.findElement(By.xpath("//input[@id='devname']")));
		driver.findElement(By.xpath("//input[@id='devname']")).click();
		
		driver.findElement(By.xpath("//input[@value=\" Save \"]")).click();
		
		
	}
	
	public static void testingEditView() throws Exception {
		
		Select se2 = new Select(driver.findElement(By.id("fcf")));
		se2.selectByVisibleText("qaAutomationAB");
		
		driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
		waitExplicitly(2, driver.findElement(By.xpath("//input[@id='fname']")));
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("qaAutomationABA");
		
		Select se3 = new Select(driver.findElement(By.id("fcol1")));
		se3.selectByVisibleText("Account Name");
		
		Select se4 = new Select(driver.findElement(By.id("fop1")));
		se4.selectByVisibleText("contains");
		
		driver.findElement(By.xpath("//input[@id='fval1']")).sendKeys("a");
		
		driver.findElement(By.xpath("//input[@value=\" Save \"]")).click();
		
		
	}
	
	public static void testingMergeAccounts() throws Exception {
		
		driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]")).click();
		waitExplicitly(2, driver.findElement(By.xpath("//input[@id='srch']")));
		driver.findElement(By.xpath("//input[@id='srch']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@value=\"Find Accounts\"]")).click();
		driver.findElement(By.xpath("//input[@value=\" Next \"]")).click();
		driver.findElement(By.xpath("//input[@value=\" Merge \"]")).click();
		
		Alert alert = driver.switchTo().alert();
		driver.switchTo().alert();
		alert.accept();
		
	}
	
	public static void testingCreateAccountReport() throws Exception {
		
		driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]")).click();
//		waitExplicitly(2, driver.findElement(By.xpath("//input[@id='ext-gen20']")));
//		driver.findElement(By.xpath("//input[@id='ext-gen20']")).click();
		
		driver.findElement(By.xpath("//input[@id='ext-gen20']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Created Date')]")).click();
		
		waitExplicitly(2, driver.findElement(By.xpath("//img[@id='ext-gen152']")));
		driver.findElement(By.xpath("//img[@id='ext-gen152']")).click();
		waitExplicitly(2, driver.findElement(By.xpath("//button[@id='ext-gen311']")));
		driver.findElement(By.xpath("//button[@id='ext-gen311']")).click();
		
		waitExplicitly(2, driver.findElement(By.xpath("//img[@id='ext-gen154']")));
		driver.findElement(By.xpath("//img[@id='ext-gen152']")).click();
		waitExplicitly(2, driver.findElement(By.xpath("//button[@id='ext-gen330']")));
		driver.findElement(By.xpath("//button[@id='ext-gen330']")).click();
		
		driver.findElement(By.xpath("//save //button[@id='ext-gen49']")).click();
		

//		
//		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
//		System.out.println(windows.size());
//		driver.switchTo().window(windows.get(1));
//		Thread.sleep(5000);
//		
//		driver.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']")).sendKeys("Testing");
//		waitExplicitly(1, driver.findElement(By.xpath("//input[@id='saveReportDlg_DeveloperName']")));
//		driver.findElement(By.xpath("//input[@id='saveReportDlg_DeveloperName']")).click();
//		driver.findElement(By.xpath("//button[@id='ext-gen356']")).click();
//		
//		driver.switchTo().window(windows.get(0));
		
		
		//div[contains(text(),'Created Date')]
		
		//from-//img[@id='ext-gen152']  //button[@id='ext-gen311']
		//img[@id='ext-gen154'] //button[@id='ext-gen330']
		
		//save //button[@id='ext-gen49']
		
		//input[@id='saveReportDlg_reportNameField']
		//input[@id='saveReportDlg_DeveloperName']
		//button[@id='ext-gen356']
	}

}
