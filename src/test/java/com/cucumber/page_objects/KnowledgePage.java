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

public class KnowledgePage extends PageObject {

	public KnowledgePage() {
		// System.out.println("Inside SleepCountryLanding PAGEEEEEEEEEEEEEEEEEEEEEE");
	}

	Utils utility = new Utils();
// Knowledge Article related Xpaths
	public By KnowledgeListItem = By.xpath("//a[@title = 'Knowledge' and @role = 'option']//span[text() = 'Knowledge']");
	public By KnowledgePageTitle = By.xpath("//li//span[text() = 'Knowledge']");
	public By KnowledgeNewButton = By.xpath("//a[@title = 'New']//div");
	public By KnowledgeSearchTitle = By.xpath("//span[text() = 'Title']//parent::label//following-sibling::input[@type='text']");
	public By KnowledgeSearchURLName = By.xpath("//span[text() = 'URL Name']//parent::label//following-sibling::input[@type='text']");
	public By KnowledgeSavebtn = By.xpath("//button[@title = 'Save']//span[text() = 'Save']");
	public By KnowledgeSubHeader = By.xpath("//span[text()='Draft']");
	public By KnowledgeListView = By.xpath("//a[@title = 'Select List View']");
	public By DraftArticlesListView = By.xpath("//span[text() = 'Draft Articles']");
	public By KnowledgePageDraftArticles = By.xpath("//span[text() = 'Draft Articles']//preceding-sibling::span[text() = 'Knowledge']");
	public By ArticleActionButton= By.xpath("//a[contains(text(),'Test automated script')]//parent::*//parent::*//parent::*//td[position()=last()]");
	public By PublishMenuItem = By.xpath("//a[@title = 'Publish' and @role = 'menuitem']");
	public By PublishButton = By.xpath("//span[text() = 'Publish']");
	public By PublishedArticlesListView = By.xpath("//span[text() = 'Published Articles']");
	public By KnowledgePagePublishedArticles = By.xpath("//span[text() = 'Knowledge']//following-sibling::span[text() = 'Published Articles']");
	public By SearchPublishedArticle = By.xpath("//a[@title = 'Test automated script']");
	public By EditArticleAsDraft = By.xpath("//a[@title = 'Edit as Draft']");
	public By EditArticleWindow = By.xpath("//h2[contains(text(),'Edit a draft of')]");
	public By EditAsDraftButton = By.xpath("//span[text() = 'Edit as Draft']");
    public By EditAsDraftWindow = By.xpath("//span[text() = 'Save & New']");
    public By URLEditField = By.xpath("//span[text() = 'URL Name']//parent::label//following-sibling::input");
    public By SaveButton = By.xpath("//button[@title = 'Save']//span[text() = 'Save']");
    public By ArticleSavedAsDraft = By.xpath("//span[text() = 'Draft']");
	
	
	
}
