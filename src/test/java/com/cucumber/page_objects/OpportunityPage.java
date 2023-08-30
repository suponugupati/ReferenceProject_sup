package com.cucumber.page_objects;

import org.openqa.selenium.By;

import com.cucumber.framework.PageObject;

public class OpportunityPage extends PageObject{

	public OpportunityPage() {
		
	}
	public By Oppotunitylistitem = By.xpath("//a[@title='Opportunities']//span[text()='Opportunities']");
	public By Opportunitiespage = By.xpath("//li//span[text()='Opportunities']");
	public By OpportunityPage = By.xpath("//h1//div[text()='Opportunity']");
	public By Leaddata = By.xpath("//a[@title='New Lead']");
	public By ShowMoreactions = By.xpath("//a[@title='Show 9 more actions']");
	public By ConvertLead = By.xpath("//a[@title='Convert']");
	public By ConvertPage = By.xpath("//h2[text()='Convert Lead ']");
	public By ConvertBtn = By.xpath("//span[text()='Convert']");
	public By Leadhasbeenconverted = By.xpath("//span[text()='Your lead has been converted']");
	public By ShowMoreOpptybtn = By.xpath("//a[contains(text(),'New Opportunity')]//parent::*//parent::*//parent::*//td[position()=last()]");
	public By OpptyEdit = By.xpath("//a[@title='Edit']");
	public By OpptyEditWindow = By.xpath("//h2[contains(text(),'Edit')]");
	public By OpportunityName = By.xpath("//span[text()='Opportunity Name']//parent::label//following-sibling::input");
	public By OpportunityStage = By.xpath("//a[text()='Prospecting']");
	public By OpportunitySavebtn = By.xpath("//button[@title='Save']");
	public By OpportunityClosedWon = By.xpath("//a[@title='Closed Won']");
	public By OpportunityClosingnextmonthtext = By.xpath("//span[contains(text(),'Filtered by all opportunities - Close Date, Closed')]");
	public By AllOpportunitiestext = By.xpath("//span[contains(text(),'Filtered by all opportunities')]");
	public By MyOpportunitiestext = By.xpath("//span[contains(text(),'Filtered by my opportunities')]");
	public By CloseConversionwindow = By.xpath("//button[@title='Close this window']");
	public By Recentlyviewedlist = By.xpath("//span[text()='Recently Viewed']");
	public By Selectlistview = By.xpath("//a[@title='Select List View']");
	public By ListviewCombobox = By.xpath("//input[@class='slds-input default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input']");
	public By OpportunityClosingnextmonthlink = By.xpath("//mark[text()='Closing Next Month']");
	public By MyOpportunitylink = By.xpath("//mark[text()='My Opportunities']");
	public By AllOpportunitylink = By.xpath("//mark[text()='All Opportunities']");
	
}
