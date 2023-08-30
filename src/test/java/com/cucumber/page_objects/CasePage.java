package com.cucumber.page_objects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.framework.PageObject;
import com.cucumber.framework.helpers.LocalDriverManager;
import com.cucumber.framework.helpers.Props;
import com.cucumber.framework.helpers.WebDriverHelp;
import com.cucumber.framework.helpers.utils.DataHelper;
import com.cucumber.framework.helpers.utils.Utils;

import cucumber.api.java.en.Then;

public class CasePage extends PageObject {

	public CasePage() {
		// System.out.println("Inside SleepCountryLanding PAGEEEEEEEEEEEEEEEEEEEEEE");
	}

	Utils utility = new Utils();

	public By ServiceConsole = By.xpath("//p[text()='Service Console']");
	public By ServiceConsoleApp = By.xpath("//div//span[contains(@title,'Service Console')]");
	public By ShowNavMenu = By.xpath("//button[contains(@title,'Show Navigation')]");
	public By CaseListItem = By.xpath("//div[@role='listbox']//a[@title='Cases']");
	public By CasePageTitle = By.xpath("//nav//span[text()='Cases']");
	public By CaseNewButton = By.xpath("//a[@title='New']");
	public By ViewAllBtn = By.xpath("//button[text()='View All']");

	public By CaseSearchContacts = By.xpath("//div//input[@title='Search Contacts']");
	public By CaseSearchContactResults = By.xpath("//div[@title='Thanos Test']/mark");
	public By CaseSearchAccounts = By.xpath("//div//input[@title='Search Accounts']");
	public By CaseSearchAccountResults = By.xpath("//div[@title='Avengers']/mark");
	public By CaseOriginDD = By.xpath("//span[text()='Case Origin']//parent::span/following-sibling::div//a");
	public By CaseOriginDDValues = By.xpath("//a[contains(@title,'Email')]");
	public By CaseSubject = By.xpath("//span[contains(text(),'Subject')]//parent::label//following-sibling::input");
	public By CaseDesc = By.xpath("//span[contains(text(),'Description')]//parent::label//following-sibling::textarea");
	public By CaseSavebtn = By.xpath("//button[@title='Save']");
	public By CaseSubHeader = By.xpath("//h1//span[text()='Test Subject']");

	public By Feed = By.xpath("//a//span[text()='Feed']");
	public By ShareUpdatebox = By.xpath("//div[contains(@class,'ql-editor')]");
	public By ShareAnUpdateBtn = By.xpath("//button[@title='Share an update...']/span");
	public By Sharebutton = By.xpath("//button[text()='Share']");
	public By TextPosts = By.xpath("//a[@title='Text Posts']//span[@class='title']");
	public By StatusChanges = By.xpath("//a[@title='Status Changes']//span[@class='title']");
	public By FeedAction = By.xpath("//span[text()='Actions for this Feed Item ']");
	public By TextEnteredinPosts = By
			.xpath("//div[contains(@class,'feedBodyInner')]//span[contains(@class,'uiOutputText')]");
	public By StatusResults = By.xpath("//div//span[contains(@class,'cuf-ftcFieldOldValue')]");
	public By StatusResultsNew = By.xpath("//div//span[contains(@class,'cuf-ftcFieldNewValue')]");

	public String Textt = "Testing";
	public String New = "New";

	public By Editbutton = By.xpath("//a[@title='Edit']");
	public By Statusdropdown = By
			.xpath("//label[text()='Status']/following-sibling::div//div//input[contains(@id,'input-')]");
	public By Workinglink = By.xpath("//lightning-base-combobox-item//span[@title='Working']");

	public By OpenActivitiesLink = By.xpath("//a[contains(@class,'slds-card')]//span[@title='Open Activities']");
	public By OpenActivitiesPageTitle = By.xpath("//div//h1[@title='Open Activities']");
	public By NewTask = By.xpath("//a[@title='New Task']");
	public By NewTaskPageTitle = By.xpath("//h2[contains(text(),'New Task')]");
	public By taskSubject = By.xpath("//div//label[contains(text(),'Subject')]/following-sibling::div//input");
	public By taskComments = By.xpath("//span[contains(text(),'Comments')]/parent::label/parent::div/textarea");
	public By taskSaveBtn = By.xpath("//button[@title='Save']");
	public By TaskPageTitle = By.xpath("//h1//div[text()='Task']");

}
