package com.cucumber.page_objects;

import org.openqa.selenium.By;

import com.cucumber.framework.PageObject;

public class TrackerExecution extends PageObject {
	
	public TrackerExecution() {
	
	}
	
	public static By username = By.xpath("//input[@id='username']");
	public By Password = By.xpath("//input[@id='password']");
	public By loginButton = By.xpath("//input[@id='Login']");
	public By appLauncher = By.xpath("//nav[contains(@class,'appLauncher')]//button");
	public By ViewAll = By.xpath("//button[text()='View All']");
	public By TestScripts = By.xpath("//p//mark[text()='Test Scripts']");
	//public By 
	//public By TestScriptID = By.xpath("//a[@title='TS-000001']");
	public By RelatedTab = By.xpath("//div[contains(@class,'active')]//a[text()='Related']");
	public By ClickToExecuteLink = By.xpath("//a[text()='Click to Execute']");
	public By TestersLink = By.xpath("//a//span[@title='Testers']");
	public By TestOutCome = By.xpath("//form//tbody//tr//td/select");
	public By TestComments = By.xpath("//tbody//tr//td[7]/textarea");
	public By OverallOutcome = By
			.xpath("//label[contains(text(),'Overall Test Outcome')]//parent::th//following-sibling::td/select");
	public By OverallComments = By
			.xpath("//label[contains(text(),'Overall Test Comments')]//parent::th//following-sibling::td/textarea");
	public By SaveExecutionBtn = By.xpath("//input[@value='Save & Close Test Execution']");
	public By SearchApps = By.xpath("//input[@placeholder='Search apps or items...']");
    public By getXpathforScriptID(String testcaseID)
    {
          String xpath;
          xpath="//a[@title='"+testcaseID+"']";
          By TestScriptID = By.xpath(xpath);
          return TestScriptID;
    }


}
