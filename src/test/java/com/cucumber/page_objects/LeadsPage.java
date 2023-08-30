package com.cucumber.page_objects;

import org.openqa.selenium.By;

import com.cucumber.framework.PageObject;

public class LeadsPage extends PageObject {

	public LeadsPage() {
		
	}
	public By SalesConsole = By.xpath("//p[text()='Sales']");
	public By SalesConsoleApp = By.xpath("//div//span[contains(@title,'Sales Console')]");
	public By LeadsListItem = By.xpath("//a[@title='Leads']//span[text()='Leads']");
	public By LeadsNewButton = By.xpath("//a[@role='button']//div[@title='New']");
	public By SalutationName = By.xpath("//div[contains(@class,'salutation')]");
	public By MrTitle = By.xpath("//a[@title='Mr.']");
	public By LeadsFirstName = By.xpath("//input[contains(@class,'firstName')]");
	public By LeadsLastName = By.xpath("//input[contains(@class,'lastName')]");
	public By LeadsCompany = By.xpath("//span[text()='Company']//parent::label/following-sibling::input");
	public By LeadsPhone = By.xpath("//span[text()='Phone']//parent::label/following-sibling::input");
	public By LeadStatus = By.xpath("//a[text()='Open - Not Contacted']");
	public By LeadStatusWorking = By.xpath("//li[contains(@class,'uiMenuItem')]//a[@title='Working - Contacted']");
	public By DetailsTab = By.xpath("//a[text()='Details']");
	public By Leadspage = By.xpath("//div[text()='Lead']");
	public By ShowMore = By.xpath("//a[@title='Show 6 more actions']");
	public By SubmitforApproval = By.xpath("//div[@title='Submit for Approval']");
	public By Comments = By.xpath("//textarea[contains(@class,'inputTextArea')]");
	public By SubmitButton = By.xpath("//span[(text()='Submit')]");
	public By LeadText = By.xpath("//div[text()='Lead']");
	public By ViewAll = By.xpath("//button[text()='View All']");
	public By ShowNavMenu = By.xpath("//button[contains(@title,'Show Navigation')]");
	public By LeadsSaveBtn = By.xpath("//button[@title='Save']");
	public By LeadsEdit = By.xpath("//a[@title='Edit']");
	public By close = By.xpath("//span[(text()='Close this window')]");
	public By CampaignHistorylink = By.xpath("//span[text()='Campaign History']");
	public By CampaignHistoryPage = By.xpath("//h1[text()='Campaign History']");
	public By Addtocampaign = By.xpath("//div[@title='Add to Campaign']");
	public By Chooseacampaign = By.xpath("//h2[text()='Choose a Campaign']");
	public By SearchCampaign = By.xpath("//input[@title='Search Campaigns']");
	public By Selectcampaign = By.xpath("//div[@title='Test Campaign']");
	public By ClickNext = By.xpath("//span[text()='Next']");
	public By NewCampaignMemberModal = By.xpath("//h2[text()='New Campaign Member']");
	public By SaveCampaign = By.xpath("//button[@title='Save']");
	
}