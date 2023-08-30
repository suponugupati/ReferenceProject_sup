package com.cucumber.stepdefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cucumber.framework.helpers.ExecutionHelper;
import com.cucumber.framework.helpers.LocalDriverManager;
import com.cucumber.framework.helpers.Props;
import com.cucumber.framework.helpers.utils.Utils;
import com.cucumber.page_objects.LeadsPage;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LeadsObjectPageStepdefs {
	private static final Logger LOG = LoggerFactory.getLogger(LeadsObjectPageStepdefs.class);

	LeadsPage leadsPage = new LeadsPage();

	Utils utility = new Utils();
	WebDriverWait wait = new WebDriverWait(LocalDriverManager.getDriver(), 120);
	Actions action = new Actions(LocalDriverManager.getDriver());

	@When("^I click on Sales button")
	public void IClickSalesbutton() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(leadsPage.ViewAll));
			LocalDriverManager.getDriver().findElement(leadsPage.ViewAll).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(leadsPage.SalesConsole));
			LocalDriverManager.getDriver().findElement(leadsPage.SalesConsole).click();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "clicked on sales application"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + "occured while clicking on sales console"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()))); 
		}
	}
	@Then("^I see Sales Console Application")
	public void ISeeSalesConsole() throws InterruptedException, IOException {
		try {

			Assert.assertTrue("Sales Console Application not open",
					LocalDriverManager.getDriver().findElement(leadsPage.SalesConsoleApp).isDisplayed());
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Sales Console is not the application in focus"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + "occured while navigating to sales console"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()))); 
			
			
		}
	}

	@When("^I click Leads Listview")
	public void IClickLeadsListview() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(leadsPage.LeadsListItem));
			LocalDriverManager.getDriver().findElement(leadsPage.LeadsListItem).click();
			
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Clicked Leads list view"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			Thread.sleep(5000);
		}  catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + "occured while clicking leads listview"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));  
		}
	}
	@And("^I click New Button")
	public void IClickNewButton() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(leadsPage.LeadsNewButton));
			LocalDriverManager.getDriver().findElement(leadsPage.LeadsNewButton).click();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Clicked New Leads button"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + "Error occured while accesing New lead button"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()))); 
		}
	}
	@Then("^I see New Leads Page")
	public void ISeeNewLeads() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(leadsPage.SalutationName));
			Assert.assertTrue("New Lead page dint open",
					LocalDriverManager.getDriver().findElement(leadsPage.LeadsFirstName).isDisplayed());
			
			ExecutionHelper.getLogger().log(LogStatus.PASS, "New Leads Window opened"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + "Error occured while accesing New leads page"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()))); 
		}
	}
	@Given("^I create a New Lead")
	public void IcreateNewLead() throws InterruptedException, IOException {
		try {
			LocalDriverManager.getDriver().findElement(leadsPage.SalutationName).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(leadsPage.MrTitle));
			LocalDriverManager.getDriver().findElement(leadsPage.MrTitle).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(leadsPage.LeadsFirstName));
			LocalDriverManager.getDriver().findElement(leadsPage.LeadsFirstName).click();
			Thread.sleep(1000);
			LocalDriverManager.getDriver().findElement(leadsPage.LeadsFirstName).sendKeys("New");
			wait.until(ExpectedConditions.elementToBeClickable(leadsPage.LeadsLastName));
			LocalDriverManager.getDriver().findElement(leadsPage.LeadsLastName).click();
			Thread.sleep(1000);
			LocalDriverManager.getDriver().findElement(leadsPage.LeadsLastName).sendKeys("Lead");
			wait.until(ExpectedConditions.elementToBeClickable(leadsPage.LeadsCompany));
			LocalDriverManager.getDriver().findElement(leadsPage.LeadsCompany).click();
			Thread.sleep(1000);
			LocalDriverManager.getDriver().findElement(leadsPage.LeadsCompany).sendKeys("Deloitte");
			wait.until(ExpectedConditions.elementToBeClickable(leadsPage.LeadsSaveBtn));
			LocalDriverManager.getDriver().findElement(leadsPage.LeadsSaveBtn).click();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Lead is Saved"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + "Error occured while accesing leads page"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			}
	}
		@Then("^New Lead is created")
		public void LeadisCreated() throws InterruptedException, IOException {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(leadsPage.DetailsTab));
				LocalDriverManager.getDriver().findElement(leadsPage.DetailsTab).click();
				LocalDriverManager.getDriver().findElement(leadsPage.Leadspage).isDisplayed();
				ExecutionHelper.getLogger().log(LogStatus.PASS, "Lead is created"+ExecutionHelper.getLogger()
				.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			} catch (Exception e) {
				ExecutionHelper.getLogger().log(LogStatus.FAIL,
						"Exception " + e + "Leads not created succesfully"+ExecutionHelper.getLogger()
						.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
				}
		}
			
			@Given("^I try to Edit the Lead")
			public void ItrytoEdittheLead() throws InterruptedException, IOException {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(leadsPage.ShowMore));
				LocalDriverManager.getDriver().findElement(leadsPage.ShowMore).click();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(leadsPage.LeadsEdit));
				LocalDriverManager.getDriver().findElement(leadsPage.LeadsEdit).click();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(leadsPage.LeadStatus));
				LocalDriverManager.getDriver().findElement(leadsPage.LeadStatus).click();
				wait.until(ExpectedConditions.elementToBeClickable(leadsPage.LeadStatusWorking));
				LocalDriverManager.getDriver().findElement(leadsPage.LeadStatusWorking).click();
				wait.until(ExpectedConditions.elementToBeClickable(leadsPage.LeadsSaveBtn));
				LocalDriverManager.getDriver().findElement(leadsPage.LeadsSaveBtn).click();
				ExecutionHelper.getLogger().log(LogStatus.PASS, "Lead Status is Edited"+ExecutionHelper.getLogger()
				.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			}catch (Exception e) {
				ExecutionHelper.getLogger().log(LogStatus.FAIL,
						"Exception " + e + "Leads not created succesfully"+ExecutionHelper.getLogger()
						.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
				}
		}
			@And("^I submit the lead for approval")
			public void Isubmittheleadforapproval()throws InterruptedException, IOException {
				try {
					wait.until(ExpectedConditions.elementToBeClickable(leadsPage.SubmitforApproval));
					LocalDriverManager.getDriver().findElement(leadsPage.SubmitforApproval).click();
					Thread.sleep(1000);
					wait.until(ExpectedConditions.elementToBeClickable(leadsPage.Comments));
					LocalDriverManager.getDriver().findElement(leadsPage.Comments).click();
					Thread.sleep(1000);
					LocalDriverManager.getDriver().findElement(leadsPage.Comments).sendKeys("Testing");
					wait.until(ExpectedConditions.elementToBeClickable(leadsPage.SubmitButton));
					LocalDriverManager.getDriver().findElement(leadsPage.SubmitButton).click();
					Thread.sleep(2000);
					LocalDriverManager.getDriver().findElement(leadsPage.close).click();
					
					
					ExecutionHelper.getLogger().log(LogStatus.PASS, "Lead is Submitted for approval"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
				}catch (Exception e) {
					ExecutionHelper.getLogger().log(LogStatus.FAIL,
							"Exception " + e + "Leads not submitted for approval"+ExecutionHelper.getLogger()
							.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
					}
			}
			@Given("^I click on Campaign History tab")
			public void IclickCampaignHistory() throws InterruptedException, IOException {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(leadsPage.CampaignHistorylink));
				LocalDriverManager.getDriver().findElement(leadsPage.CampaignHistorylink).click();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(leadsPage.CampaignHistoryPage));
				Assert.assertTrue("Campaign History page dint open",
						LocalDriverManager.getDriver().findElement(leadsPage.CampaignHistoryPage).isDisplayed());
			
				ExecutionHelper.getLogger().log(LogStatus.PASS, "Campaign History Page is opened"+ExecutionHelper.getLogger()
				.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			}catch (Exception e) {
				ExecutionHelper.getLogger().log(LogStatus.FAIL,
						"Exception " + e + "Campaign History page not opened"+ExecutionHelper.getLogger()
						.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
				}
		}
			@When("^I Add an existing campaign")
			public void Iaddcampaign() throws InterruptedException, IOException {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(leadsPage.Addtocampaign));
				LocalDriverManager.getDriver().findElement(leadsPage.Addtocampaign).click();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(leadsPage.Chooseacampaign));
				Assert.assertTrue("Choose Campaign page dint open",
						LocalDriverManager.getDriver().findElement(leadsPage.Chooseacampaign).isDisplayed());
			
				ExecutionHelper.getLogger().log(LogStatus.PASS, "Choose Campaign Page is opened"+ExecutionHelper.getLogger()
				.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			}catch (Exception e) {
				ExecutionHelper.getLogger().log(LogStatus.FAIL,
						"Exception " + e + "Choose Campaign page not opened"+ExecutionHelper.getLogger()
						.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
				}
		}
			@And("^I Choose a campaign")
			public void Ichosecampaign() throws InterruptedException, IOException {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(leadsPage.SearchCampaign));
				LocalDriverManager.getDriver().findElement(leadsPage.SearchCampaign).click();
				LocalDriverManager.getDriver().findElement(leadsPage.SearchCampaign).sendKeys("Test Campaign");
				
				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(leadsPage.Selectcampaign));
				LocalDriverManager.getDriver().findElement(leadsPage.Selectcampaign).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(leadsPage.ClickNext));
				LocalDriverManager.getDriver().findElement(leadsPage.ClickNext).click();
			
				ExecutionHelper.getLogger().log(LogStatus.PASS, "Existing Campaign Page is selected"+ExecutionHelper.getLogger()
				.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			}catch (Exception e) {
				ExecutionHelper.getLogger().log(LogStatus.FAIL,
						"Exception " + e + "Existing campaign selection failed"+ExecutionHelper.getLogger()
						.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
				}
		}
			@Then("^I save the campaign")
			public void Isavecampaign() throws InterruptedException, IOException {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(leadsPage.NewCampaignMemberModal));
				Assert.assertTrue("New Campaign member page dint open",
						LocalDriverManager.getDriver().findElement(leadsPage.NewCampaignMemberModal).isDisplayed());
				LocalDriverManager.getDriver().findElement(leadsPage.SaveCampaign).click();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(leadsPage.CampaignHistoryPage));
				Assert.assertTrue("Campaign History page dint open",
						LocalDriverManager.getDriver().findElement(leadsPage.CampaignHistoryPage).isDisplayed());
			
				ExecutionHelper.getLogger().log(LogStatus.PASS, "Campaign is linked to the Lead"+ExecutionHelper.getLogger()
				.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			}catch (Exception e) {
				ExecutionHelper.getLogger().log(LogStatus.FAIL,
						"Exception " + e + "Campaign Linkage failed"+ExecutionHelper.getLogger()
						.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
				}
		}
}

				
				
			
			
				
			
		
	


