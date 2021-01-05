package com.tekarch.SalesForceTesting;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AccountTestingAccountLink extends SFUtility{

	public static void main(String[] args) throws Exception {
		
		launchBrowser();
		goToSalesForceURL();
		loginToSalesForce();
		openAccountTab();
		closePopUpWindow();
		
//		testingCreateNewAccount();
//		testingCreateNewView();
//		testingEditView();
//		testingMergeAccounts();
		testingCreateAccountReport();
		
		quitBrowser();

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
		waitExplicitly(5, driver.findElement(By.xpath("//input[@id='ext-gen20']")));
		driver.findElement(By.xpath("//input[@id='ext-gen20']")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Created Date')]")).click();//selecting option from date field
		
		waitExplicitly(5, driver.findElement(By.xpath("//*[@id='ext-gen152']")));//from date
		driver.findElement(By.xpath("//*[@id='ext-gen152']")).click();
		waitExplicitly(2, driver.findElement(By.xpath("//button[contains(text(),'Today')]")));
		driver.findElement(By.xpath("//button[contains(text(),'Today')]")).click();
		
		waitExplicitly(2, driver.findElement(By.xpath("//*[@id='ext-gen154']")));//to date
		driver.findElement(By.xpath("//*[@id='ext-gen152']")).click();
		waitExplicitly(2, driver.findElement(By.xpath("//button[contains(text(),'Today')]")));
		driver.findElement(By.xpath("//button[contains(text(),'Today')]")).click();
		
		driver.findElement(By.xpath("//button[@id='ext-gen49']")).click();//save
		
		driver.switchTo().activeElement();
		
		driver.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']")).sendKeys("Hackathon");//assigning name to report
		driver.findElement(By.xpath("//input[@id='saveReportDlg_DeveloperName']")).click();//assigning unique name
		
		//driver.findElement(By.id("ext-gen317")).click();
		waitExplicitly(5, driver.findElement(By.xpath("//table[@id='dlgSaveAndRun']")));//save and run report //button[contains(text(),'Save and Run Report')]
		driver.findElement(By.xpath("//table[@id='dlgSaveAndRun']")).click();
//		Actions action = new Actions(driver);
//		WebElement mHover = driver.findElement(By.xpath("//button[contains(text(),'Save and Run Report')]"));
//		action.moveToElement(mHover).click().build().perform();
		
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		System.out.println("Report with defined credentials saved and generated.");


	}

}
