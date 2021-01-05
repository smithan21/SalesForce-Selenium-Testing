package com.tekarch.SalesForceTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestingOpportunities extends SFUtility{

	public static void main(String[] args) throws Exception {

		launchBrowser();
		goToSalesForceURL();
		loginToSalesForce();
		openOpportunityTab();
		closePopUpWindow();
		
		
		//testingOpportunitiesDropDown();
		//testingCreateNewOpp();
		//testingOppPipelineReport();
		//testingStuckOppReports();
		testingQuarterlySummaryReport();
		
		quitBrowser();
	}
	
	public static void testingOpportunitiesDropDown() throws Exception {
		
		Select se = new Select(driver.findElement(By.id("fcf")));
		System.out.println("Following options available: ");
		List<WebElement> e = se.getOptions();
		int listSize = e.size();
		
		for (int i =0; i <listSize; i++) {
			
			System.out.println(e.get(i).getText());
			
		}
	}
	
	public static void testingCreateNewOpp() throws Exception {
		
		driver.findElement(By.xpath("//input[@value=' New ']")).click();
		
		waitExplicitly(2, driver.findElement(By.xpath("//input[@id='opp3']")));
		driver.findElement(By.xpath("//input[@id='opp3']")).sendKeys("Testing Scenarios"); //new opp
		
		driver.findElement(By.xpath("//input[@id='opp4']")).sendKeys("Automation"); //account
		
		waitExplicitly(2, driver.findElement(By.xpath("//input[@id='opp9']"))); //close date
		driver.findElement(By.xpath("//input[@id='opp9']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Today')]")).click();
		
		driver.findElement(By.xpath("//div[@id='head_1_ep']")).click();
		
		waitExplicitly(2, driver.findElement(By.xpath("//select[@id='opp11']")));		
		driver.findElement(By.xpath("//select[@id='opp11']")).click();//stage
		driver.findElement(By.xpath("//option[@value='Needs Analysis']")).click();
		
		driver.findElement(By.xpath("//input[@id='opp12']")).click(); //prob
		
		waitExplicitly(2, driver.findElement(By.xpath("//select[@id='opp6']")));//lead
		driver.findElement(By.xpath("//select[@id='opp6']")).click();		
		driver.findElement(By.xpath("//option[contains(text(),'Web')]")).click();
		
		driver.findElement(By.xpath("//input[@value=' Save ']")).click();  
	}
	
	public static void testingOppPipelineReport() throws Exception {
		
		driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]")).click();
		waitExplicitly(2, driver.findElement(By.xpath("//h1[contains(text(),'Opportunity Pipeline')]")));
		System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Opportunity Pipeline')]")).getText());
	}
	
	public static void testingStuckOppReports() throws Exception {
		
		driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]")).click();
		waitExplicitly(2, driver.findElement(By.xpath("//h1[contains(text(),'Stuck Opportunities')]")));
		System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Stuck Opportunities')]")).getText());
		
	}
	
	public static void testingQuarterlySummaryReport() throws Exception {
		
		Select se1 = new Select(driver.findElement(By.id("quarter_q"))); //interval drop-down
		Select se2 = new Select(driver.findElement(By.xpath("//select[@id='open']"))); //include drop-down
		Thread.sleep(1000);
		se1.selectByVisibleText("Current FQ");
		Thread.sleep(1000);
		se2.selectByVisibleText("All Opportunities");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Run Report']")).click();
		Thread.sleep(2000);
		System.out.println("1)"+driver.findElement(By.xpath("//h2[contains(text(),'Report Generation Status:')]")).getText()+driver.findElement(By.xpath("//div[@id='status']")).getText());
		
		driver.findElement(By.xpath("//ul//li[@id='Opportunity_Tab']")).click();
		
		Select sel1 = new Select(driver.findElement(By.id("quarter_q")));
		Select sel2 = new Select(driver.findElement(By.xpath("//select[@id='open']")));
		Thread.sleep(1000);
		sel1.selectByVisibleText("Current FQ");
		Thread.sleep(1000);
		sel2.selectByVisibleText("Open Opportunities");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Run Report']")).click();
		Thread.sleep(2000);
		System.out.println("2)"+driver.findElement(By.xpath("//h2[contains(text(),'Report Generation Status:')]")).getText()+driver.findElement(By.xpath("//div[@id='status']")).getText());
		
		driver.findElement(By.xpath("//ul//li[@id='Opportunity_Tab']")).click();
		
		Select sele1 = new Select(driver.findElement(By.id("quarter_q")));
		Select sele2 = new Select(driver.findElement(By.xpath("//select[@id='open']")));
		Thread.sleep(1000);
		sele1.selectByVisibleText("Current FQ");
		Thread.sleep(1000);
		sele2.selectByVisibleText("Closed Opportunities");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Run Report']")).click();
		Thread.sleep(2000);
		System.out.println("3)"+driver.findElement(By.xpath("//h2[contains(text(),'Report Generation Status:')]")).getText()+driver.findElement(By.xpath("//div[@id='status']")).getText());
		
		driver.findElement(By.xpath("//ul//li[@id='Opportunity_Tab']")).click();
		
		Select selec1 = new Select(driver.findElement(By.id("quarter_q")));
		Select selec2 = new Select(driver.findElement(By.xpath("//select[@id='open']")));
		Thread.sleep(1000);
		selec1.selectByVisibleText("Next FQ");
		Thread.sleep(1000);
		selec2.selectByVisibleText("All Opportunities");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Run Report']")).click();
		Thread.sleep(2000);
		System.out.println("4)"+driver.findElement(By.xpath("//h2[contains(text(),'Report Generation Status:')]")).getText()+driver.findElement(By.xpath("//div[@id='status']")).getText());
		
		driver.findElement(By.xpath("//ul//li[@id='Opportunity_Tab']")).click();
		
		Select select1 = new Select(driver.findElement(By.id("quarter_q")));
		Select select2 = new Select(driver.findElement(By.xpath("//select[@id='open']")));
		Thread.sleep(1000);
		select1.selectByVisibleText("Next FQ");
		Thread.sleep(1000);
		select2.selectByVisibleText("Open Opportunities");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Run Report']")).click();
		Thread.sleep(2000);
		System.out.println("5)"+driver.findElement(By.xpath("//h2[contains(text(),'Report Generation Status:')]")).getText()+driver.findElement(By.xpath("//div[@id='status']")).getText());
		
		driver.findElement(By.xpath("//ul//li[@id='Opportunity_Tab']")).click();
		
		Select s1 = new Select(driver.findElement(By.id("quarter_q")));
		Select s2 = new Select(driver.findElement(By.xpath("//select[@id='open']")));
		Thread.sleep(1000);
		s1.selectByVisibleText("Next FQ");
		Thread.sleep(1000);
		s2.selectByVisibleText("Closed Opportunities");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Run Report']")).click();
		Thread.sleep(2000);
		System.out.println("6)"+driver.findElement(By.xpath("//h2[contains(text(),'Report Generation Status:')]")).getText()+driver.findElement(By.xpath("//div[@id='status']")).getText());
		
	}

}

