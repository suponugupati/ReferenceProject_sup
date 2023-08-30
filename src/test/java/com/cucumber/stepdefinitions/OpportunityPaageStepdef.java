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
import com.cucumber.page_objects.OpportunityPage;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OpportunityPaageStepdef {
	private static final Logger LOG = LoggerFactory.getLogger(LeadsObjectPageStepdefs.class);

	OpportunityPage opportunityPage = new OpportunityPage();

	Utils utility = new Utils();
	WebDriverWait wait = new WebDriverWait(LocalDriverManager.getDriver(), 120);
	Actions action = new Actions(LocalDriverManager.getDriver());
	@Given("^I click on Existing Leads")
	public void IClickSalesbutton() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(opportunityPage.Leaddata));
			LocalDriverManager.getDriver().findElement(opportunityPage.Leaddata).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(opportunityPage.ShowMoreactions));
			
			ExecutionHelper.getLogger().log(LogStatus.PASS, "clicked on Lead"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + "occured while clicking Lead"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()))); 
		}
	}
	@When("^I try to convert Lead")
	public void Iconvertlead() throws InterruptedException, IOException {
		try {
			
			LocalDriverManager.getDriver().findElement(opportunityPage.ShowMoreactions).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(opportunityPage.ConvertLead));
			LocalDriverManager.getDriver().findElement(opportunityPage.ConvertLead).click();
			
			ExecutionHelper.getLogger().log(LogStatus.PASS, "clicked on Convert button"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + "occured while converting lead"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()))); 
		}
	}
	@Then("^I see convert lead window")
	public void Iseeconvertlead() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(opportunityPage.ConvertPage));
			
			Assert.assertTrue("Lead Conversion page dint open",
					LocalDriverManager.getDriver().findElement(opportunityPage.ConvertPage).isDisplayed());
			
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Lead Convert modal is displayed"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + "occured while convert modal window opened"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()))); 
		}
	}
	@When("^I give new opportunity name while conversion")
	public void Iconvertleadwithnewoppty() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(opportunityPage.OpportunityName));
			LocalDriverManager.getDriver().findElement(opportunityPage.OpportunityName).click();
			LocalDriverManager.getDriver().findElement(opportunityPage.OpportunityName).sendKeys("New Opportunity");
			
			ExecutionHelper.getLogger().log(LogStatus.PASS, "New Account details entered while conversion"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + "occured while entering account details"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver()))); 
		}
	}
	@And("^I click on Convert")
	public void Iclickonconvert() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(opportunityPage.ConvertBtn));
			LocalDriverManager.getDriver().findElement(opportunityPage.ConvertBtn).click();
			
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Clicked on Convert"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + "occured while clicking on convert"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
		}
	}
	@Then("^Lead is converted into Opportunity")
	public void Leadconversion() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(opportunityPage.Leadhasbeenconverted));
			Assert.assertTrue("Lead din't get converted",
					LocalDriverManager.getDriver().findElement(opportunityPage.Leadhasbeenconverted).isDisplayed());
			LocalDriverManager.getDriver().findElement(opportunityPage.CloseConversionwindow).click();
			
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Lead is converted"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + "occured while converting"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
		}
	}
	@Given("^I Click on Opportunity List View")
	public void ClickOpptylist() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(opportunityPage.Oppotunitylistitem));
			LocalDriverManager.getDriver().findElement(opportunityPage.Oppotunitylistitem).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(opportunityPage.Opportunitiespage));
			Assert.assertTrue("Opportunity Page din't get opened",
					LocalDriverManager.getDriver().findElement(opportunityPage.Opportunitiespage).isDisplayed());
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Opportunity page opened"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + "occured while opening opportunity page"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
		}
	}
	@When("I select All Opportunities List View")
	public void AllOpportunitylist() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(opportunityPage.Selectlistview));
			LocalDriverManager.getDriver().findElement(opportunityPage.Selectlistview).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(opportunityPage.ListviewCombobox));
			LocalDriverManager.getDriver().findElement(opportunityPage.ListviewCombobox).click();
			Thread.sleep(1000);
			LocalDriverManager.getDriver().findElement(opportunityPage.ListviewCombobox).sendKeys("All Opportunities");
			wait.until(ExpectedConditions.elementToBeClickable(opportunityPage.AllOpportunitylink));
			LocalDriverManager.getDriver().findElement(opportunityPage.AllOpportunitylink).click();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "All Opportunity list view selected"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			Thread.sleep(5000);
			
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + "occured while selecting All Opportunity list view"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
		}
	}
	@Then("All Opportunities are displayed")
	public void AllOpportunitiesdisplay() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(opportunityPage.AllOpportunitiestext));
			Assert.assertTrue("All Opportunity din't get opened",
					LocalDriverManager.getDriver().findElement(opportunityPage.AllOpportunitiestext).isDisplayed());
			
			ExecutionHelper.getLogger().log(LogStatus.PASS, "All Opportunity Filter page opened"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + "occured while opening All Opportunity page"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
		}
	}
	@When("I select My Opportunities List View")
	public void MyOpportunitylist() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(opportunityPage.Selectlistview));
			LocalDriverManager.getDriver().findElement(opportunityPage.Selectlistview).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(opportunityPage.ListviewCombobox));
			LocalDriverManager.getDriver().findElement(opportunityPage.ListviewCombobox).clear();
			Thread.sleep(1000);
			LocalDriverManager.getDriver().findElement(opportunityPage.ListviewCombobox).click();
			LocalDriverManager.getDriver().findElement(opportunityPage.ListviewCombobox).sendKeys("My Opportunities");
			wait.until(ExpectedConditions.elementToBeClickable(opportunityPage.MyOpportunitylink));
			LocalDriverManager.getDriver().findElement(opportunityPage.MyOpportunitylink).click();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "My Opportunity list view selected"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			Thread.sleep(5000);
			
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + "occured while selecting My Opportunity list view"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
		}
	}
	@Then("My Opportunities are displayed")
	public void MyOpportunitiesdisplay() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(opportunityPage.MyOpportunitiestext));
			Assert.assertTrue("My Opportunity din't get opened",
					LocalDriverManager.getDriver().findElement(opportunityPage.MyOpportunitiestext).isDisplayed());
			
			ExecutionHelper.getLogger().log(LogStatus.PASS, "My Opportunity Filter page opened"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + "occured while opening My Opportunity page"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
		}
	}
	@When("I select Opportunities Closing next month List View")
	public void ClosingOpportunitylist() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(opportunityPage.Selectlistview));
			LocalDriverManager.getDriver().findElement(opportunityPage.Selectlistview).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(opportunityPage.ListviewCombobox));
			LocalDriverManager.getDriver().findElement(opportunityPage.ListviewCombobox).clear();
			Thread.sleep(1000);
			LocalDriverManager.getDriver().findElement(opportunityPage.ListviewCombobox).click();
			LocalDriverManager.getDriver().findElement(opportunityPage.ListviewCombobox).sendKeys("Closing Next Month");
			wait.until(ExpectedConditions.elementToBeClickable(opportunityPage.OpportunityClosingnextmonthlink));
			LocalDriverManager.getDriver().findElement(opportunityPage.OpportunityClosingnextmonthlink).click();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Closed Opportunity list view selected"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			Thread.sleep(5000);
			
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + "occured while selecting Closed Opportunity list view"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
		}
	}
	@Then("Closing Opportunities are displayed")
	public void ClosedOpportunitiesdisplay() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(opportunityPage.OpportunityClosingnextmonthtext));
			Assert.assertTrue("Closed Opportunity din't get opened",
					LocalDriverManager.getDriver().findElement(opportunityPage.OpportunityClosingnextmonthlink).isDisplayed());
			
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Closing Opportunity Filter page opened"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + "occured while opening Closed Opportunity page"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
		}
	}
	@When("I try to edit the Opportunity")
	public void EditOpportunities() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(opportunityPage.ShowMoreOpptybtn));
			LocalDriverManager.getDriver().findElement(opportunityPage.ShowMoreOpptybtn).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(opportunityPage.OpptyEdit));
			LocalDriverManager.getDriver().findElement(opportunityPage.OpptyEdit).click();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Clicked on Edit Opportunity"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + "occured while clicking on Edit Opportunity"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
		}
	}
	@Then("Opportunity Edit Window is opened")
	public void OpportunityEditwindow() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(opportunityPage.OpptyEditWindow));
			Assert.assertTrue("Edit Opportunity din't get opened",
					LocalDriverManager.getDriver().findElement(opportunityPage.OpptyEditWindow).isDisplayed());
			
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Opportunity Edit Window is opened"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + "occured while Edit Opportunity window opening"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
		}
	}
	@When("I try to edit the Opportunity Stage to Closed Won")
	public void EditStage() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(opportunityPage.OpportunityStage));
			LocalDriverManager.getDriver().findElement(opportunityPage.OpportunityStage).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(opportunityPage.OpportunitySavebtn));
			LocalDriverManager.getDriver().findElement(opportunityPage.OpportunitySavebtn).click();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Opportunity Stage Edited"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + "occured while changing Opportunity stage"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
		}
	}
	@Then("Opportunity is saved with Closed Won Stage")
	public void OpportunityStage() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(opportunityPage.Opportunitiespage));
			Assert.assertTrue("Opportunity Page din't get opened",
					LocalDriverManager.getDriver().findElement(opportunityPage.Opportunitiespage).isDisplayed());
			
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Opportunity stage changed to Closed Won"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + "occured while Saving Opportunity"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
		}
	}
}
