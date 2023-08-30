package com.cucumber.stepdefinitions;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cucumber.framework.helpers.ExecutionHelper;
import com.cucumber.framework.helpers.LocalDriverManager;
import com.cucumber.framework.helpers.Props;
import com.cucumber.framework.helpers.WebDriverHelp;
import com.cucumber.framework.helpers.utils.Utils;

import com.cucumber.page_objects.CasePage;
import com.cucumber.page_objects.KnowledgePage;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class KnowledgeArticleObjectPageStepdefs {

	private static final Logger LOG = LoggerFactory.getLogger(CaseObjectPageStepdefs.class);

	// Objects and Variable Declarations
	Utils utility = new Utils();
	KnowledgePage knowledgePage = new KnowledgePage();
	//EncrypDecrypt testdata = new EncrypDecrypt();
	WebDriverWait wait = new WebDriverWait(LocalDriverManager.getDriver(), 120);
	Actions action = new Actions(LocalDriverManager.getDriver());
	//String key = "lockUnlock";

	
	@When("^I click Knowledge List Item")
	public void IClickKnowledgeListItem() throws InterruptedException, IOException {
		try {
			Thread.sleep(3000);
			action.moveToElement(LocalDriverManager.getDriver().findElement(knowledgePage.KnowledgeListItem)).click().build();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Clicked on the Knowledge List Item");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + " occurred while clicking on Knowledge List Item");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
		}
	}
	
	@Then("^I see Knowledge page is Opened")
	public void ISeeKnowledgePageOpened() throws InterruptedException, IOException {
		try {

			Assert.assertTrue("Knowledge page dint open",
					LocalDriverManager.getDriver().findElement(knowledgePage.KnowledgePageTitle).isDisplayed());
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Knowledge Page Opened");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + " occurred while navigating to Knowledge Page");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
		}
	}
	
	@Given("^I click New button on Knowledge page")
	public void IClickKnowledgeNewButton() throws InterruptedException, IOException {
		try {

			LocalDriverManager.getDriver().findElement(knowledgePage.KnowledgeNewButton).click();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Clicked on the New Knowledge button");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
			Thread.sleep(10000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + " occurred while clicking on New Knowledge button");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
		}
	}
	
	@When("^I enter Knowledge Article Title")
	public void IEnterKnowlwdgeTitleField() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(knowledgePage.KnowledgeSearchTitle));
			LocalDriverManager.getDriver().findElement(knowledgePage.KnowledgeSearchTitle).click();
			Thread.sleep(1000);
			LocalDriverManager.getDriver().findElement(knowledgePage.KnowledgeSearchTitle).sendKeys("New Article");
			Thread.sleep(1000);
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Knowledge Article Title is set");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception " + e + "occurred while setting Knowledge Title");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
		}
	}
	
	@And("^I enter URL Name")
	public void IEnterURLNameField() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(knowledgePage.KnowledgeSearchURLName));
			LocalDriverManager.getDriver().findElement(knowledgePage.KnowledgeSearchURLName).click();
			Thread.sleep(1000);
			LocalDriverManager.getDriver().findElement(knowledgePage.KnowledgeSearchURLName).sendKeys("www.NewArticle");
			Thread.sleep(1000);
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Knowledge Article URLName is set");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception " + e + "occurred while setting the URL Name");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
		}
	}
	
	@And("^I click Save Knowledge button")
	public void IClickSaveButton() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(knowledgePage.KnowledgeSavebtn));
			LocalDriverManager.getDriver().findElement(knowledgePage.KnowledgeSavebtn).click();
			Thread.sleep(1000);
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Save Knowledge button clicked");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
			Thread.sleep(3000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception " + e + " occurred while saving the Knowledge Article");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
		}
	}

	@Then("^I see new draft Article is created successfully")
	public void ISeeArticleCreatedSuccessfully() throws InterruptedException, IOException {
		try {

			Assert.assertTrue("Article creation not successful",
					LocalDriverManager.getDriver().findElement(knowledgePage.KnowledgeSubHeader).isDisplayed());
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Article Creation Success");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
			Thread.sleep(3000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception " + e + " occurred while creating Knowledge");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
		}
	}
	@Given("^I click to view the available Knowledge List Views")
	public void IClickArticleListView() throws InterruptedException, IOException {
		try {
			LocalDriverManager.getDriver().findElement(knowledgePage.KnowledgeListView).click();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "List View names of Knowledge Articles displayed");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + " occurred while viewing list of Knowledge Article views");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
		}
	}
	@When("^I click on Draft Articles list view")
	public void IClickDraftArticleView() throws InterruptedException, IOException {
		try {

			LocalDriverManager.getDriver().findElement(knowledgePage.DraftArticlesListView).click();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Clicked on Draft Articles List View"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			Thread.sleep(5000);
			LocalDriverManager.getDriver().navigate().refresh();
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + " occurred while clicking on Draft Articles List View"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
		}
	}
	
	@Then("^I can view the list of Draft Articles")
	public void ISeeDraftArticlesList() throws InterruptedException, IOException {
		try {

			Assert.assertTrue("Draft Articles page dint open",
					LocalDriverManager.getDriver().findElement(knowledgePage.KnowledgePageDraftArticles).isDisplayed());
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Draft Articles Page Openend");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + " occurred while navigating to Draft Articles Page");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
		}
	}
	@Given("^I click to view options on the Action button")
	public void IClickActionButton() throws InterruptedException, IOException {
		try {
			LocalDriverManager.getDriver().findElement(knowledgePage.ArticleActionButton).click();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "User is able to view options on clicking the Action button");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + " occurred while clicking on the Action button");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
		}
	}
	@When("^I select the Publish option")
	public void IClickSelectPublish() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(knowledgePage.PublishMenuItem));
			LocalDriverManager.getDriver().findElement(knowledgePage.PublishMenuItem).click();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Clicked on the Publish Action ");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + " occurred while clicking on the Publish Action");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
		}
	}
	@And("^I click the Publish button")
	public void IClickPublishButton() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(knowledgePage.PublishButton));
			LocalDriverManager.getDriver().findElement(knowledgePage.PublishButton).click();
			Thread.sleep(1000);
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Publish button clicked");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
			Thread.sleep(3000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception " + e + " occurred while clicking the Publish button");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
		}
	}
	@When("^I click on Publish Articles list view")
	public void IClickPublishedArticleView() throws InterruptedException, IOException {
		try {

			LocalDriverManager.getDriver().findElement(knowledgePage.PublishedArticlesListView).click();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Clicked on Published Articles List View"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			Thread.sleep(5000);
			LocalDriverManager.getDriver().navigate().refresh();
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + " occurred while clicking on Published Articles List View"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
		}
	}
	@Then("^I can view the list of Published Articles")
	public void ISeeLublishedArticlesList() throws InterruptedException, IOException {
		try {

			Assert.assertTrue("Published Articles page didn't open",
					LocalDriverManager.getDriver().findElement(knowledgePage.KnowledgePagePublishedArticles).isDisplayed());
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Published Articles Page Opened");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + " occurred while navigating to Published Articles Page");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
		}
	}
	@And("^I can view the new draft Artcle Published")
	public void ISeePublishedArticle() throws InterruptedException, IOException {
		try {

			//Assert.assertTrue("Published Article not present",
					LocalDriverManager.getDriver().findElement(knowledgePage.SearchPublishedArticle).isDisplayed();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Published Article not Found in the list view");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + " occurred while searching the Published Article in the list view");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
		}
	}
	@Given("^Action button of a Published Article is clicked")
	public void IClickActionButtonOfPublishedArticle() throws InterruptedException, IOException {
		try {
			LocalDriverManager.getDriver().findElement(knowledgePage.ArticleActionButton).click();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "User is able to view options on clicking the Action button on Published Article");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + " occurred while clicking on the Action button on Published Article");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
		}
	}
	@When("^I select Edit as Draft")
	public void ISelectEditAsDraft() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(knowledgePage.EditArticleAsDraft));
			LocalDriverManager.getDriver().findElement(knowledgePage.EditArticleAsDraft).click();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Clicked on the Edit As Draft Action ");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + " occurred while clicking on the Edit As Draft Action");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
		}
	}
	@Then("^window to confirm Edit as Draft is displayed")
	public void ISeeEditButtonWindow() throws InterruptedException, IOException {
		try {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(knowledgePage.EditArticleWindow));
			Assert.assertTrue("Edit as Draft window not opened",
			LocalDriverManager.getDriver().findElement(knowledgePage.EditArticleWindow).isDisplayed());
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Edit Article window is displayed");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + " occurred while Edit Article window displayed");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
		}
	}
	@Given("^I click the Edit as Draft button")
	public void IClickEditAsDraftButton() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(knowledgePage.EditAsDraftButton));
			LocalDriverManager.getDriver().findElement(knowledgePage.EditAsDraftButton).click();
			Thread.sleep(1000);
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Edit as Draft button clicked");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
			Thread.sleep(3000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception " + e + " occurred while clicking the Edit as Draft button");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
		}
	}
	@When("^I Edit the Knowledge Article URL")
	public void IeditPublishedArticle() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(knowledgePage.URLEditField));
			LocalDriverManager.getDriver().findElement(knowledgePage.URLEditField).click();
			Thread.sleep(5000);
			LocalDriverManager.getDriver().findElement(knowledgePage.URLEditField).sendKeys("EditURL");
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Knowledge Article URL changed");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception " + e + "occurred while changing Knowledge Article URL");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
		}
	}
	@Then("^The Publication Status changed to Draft")
	public void ISeePublicationStatusChanged() throws InterruptedException, IOException {
		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated(knowledgePage.ArticleSavedAsDraft));
			Assert.assertTrue("Publication Status changed to Draft page didn't open",
					LocalDriverManager.getDriver().findElement(knowledgePage.ArticleSavedAsDraft).isDisplayed());
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Article Publication Status changed to Draft");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + " occurred while the changed Published Artcle is Saved");
			ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()));
		}
	}
}