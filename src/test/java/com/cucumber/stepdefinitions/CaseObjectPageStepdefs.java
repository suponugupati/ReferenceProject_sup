package com.cucumber.stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
import com.cucumber.page_objects.CasePage;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CaseObjectPageStepdefs {

	private static final Logger LOG = LoggerFactory.getLogger(CaseObjectPageStepdefs.class);

	CasePage casePage = new CasePage();

	Utils utility = new Utils();
	WebDriverWait wait = new WebDriverWait(LocalDriverManager.getDriver(), 120);
	Actions action = new Actions(LocalDriverManager.getDriver());
	public static Boolean isFailed = false;
	public static Map<Object, Object> errorMap= new HashMap<>();

	String imagePath=Props.getProp("imagePath");
	
	@Given("^I click on Service Console")
	public void IClickServiceConsole() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(casePage.ViewAllBtn));
			LocalDriverManager.getDriver().findElement(casePage.ViewAllBtn).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(casePage.ServiceConsole));
			LocalDriverManager.getDriver().findElement(casePage.ServiceConsole).click();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Clicked on the Service Console button"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + " occurred while clicking on Login Page"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
			errorMap.put("IClickServiceConsole", null);
			
		}
	}

	@Then("^I see Service Console Application")
	public void ISeeServiceConsole() throws InterruptedException, IOException {
		try {

			Assert.assertTrue("Service Console Application not open",
					LocalDriverManager.getDriver().findElement(casePage.ServiceConsoleApp).isDisplayed());
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Service Console is not the application in focus"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + " occurred while navigating to Serivce console"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
			errorMap.put("ISeeServiceConsole", null);
			
		}
	}

	@Given("^I click Show Navigation Menu")
	public void IClickShowNavMenu() throws InterruptedException, IOException {
		try {

			LocalDriverManager.getDriver().findElement(casePage.ShowNavMenu).click();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Clicked on the Show Navigation button"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + " occurred while clicking on Show Navigation Menu"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
			errorMap.put("IClickShowNavMenu", null);
			
		}
	}
	
	@When("^I click Case List Item")
	public void IClickCaseListItem() throws InterruptedException, IOException {
		try {

			LocalDriverManager.getDriver().findElement(casePage.CaseListItem).click();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Clicked on the Case List Item"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			 
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + " occurred while clicking on Case List Item"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
			errorMap.put("IClickCaseListItem", null);
			 
		}
	}

	@Then("^I see page with Case title Opened")
	public void ISeeCasePageOpened() throws InterruptedException, IOException {
		try {

			Assert.assertTrue("Case page dint open",
					LocalDriverManager.getDriver().findElement(casePage.CasePageTitle).isDisplayed());
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Cases Page Opened"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + " occurred while navigating to Cases Page"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
			errorMap.put("ISeeCasePageOpened", null);
			 
		}
	}

	@When("^I click New button")
	public void IClickNewButton() throws InterruptedException, IOException {
		try {

			LocalDriverManager.getDriver().findElement(casePage.CaseNewButton).click();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Clicked on the New Case button"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
			Thread.sleep(10000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + " occurred while clicking on New Case button"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
			errorMap.put("IClickNewButton", null);
			
		}
	}

	@Given("^I enter Case Origin")
	public void IEnterCaseOrigin() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(casePage.CaseOriginDD));
			LocalDriverManager.getDriver().findElement(casePage.CaseOriginDD).click();
			Thread.sleep(1000);
			LocalDriverManager.getDriver().findElement(casePage.CaseOriginDDValues).click();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Selected the Case Origin Dropdown"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
			Thread.sleep(3000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception " + e + " occurred while selecting case origin"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
			errorMap.put("IEnterCaseOrigin", null);
			
		}
	}

	@Given("^I enter Contact")
	public void IEnterContactField() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(casePage.CaseSearchContacts));
			LocalDriverManager.getDriver().findElement(casePage.CaseSearchContacts).click();
			Thread.sleep(1000);
			LocalDriverManager.getDriver().findElement(casePage.CaseSearchContacts).sendKeys("Thanos Test");
			Thread.sleep(1000);
			LocalDriverManager.getDriver().findElement(casePage.CaseSearchContactResults).click();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Selected the Contact"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception " + e + " occurred while selecting contact"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
			errorMap.put("IEnterContactField", null);
			
		}
	}

	@Given("^I enter Account")
	public void IEnterAccountField() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(casePage.CaseSearchAccounts));
			// LocalDriverManager.getDriver().findElement(casePage.CaseSearchAccounts).click();
			Thread.sleep(1000);
			LocalDriverManager.getDriver().findElement(casePage.CaseSearchAccounts).clear();
			Thread.sleep(1000);
			LocalDriverManager.getDriver().findElement(casePage.CaseSearchAccounts).sendKeys("Avengers");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(casePage.CaseSearchAccountResults));
			LocalDriverManager.getDriver().findElement(casePage.CaseSearchAccountResults).click();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Selected the Account"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
			Thread.sleep(3000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception " + e + " occurred while selecting Account"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
			errorMap.put("IEnterAccountField", null);
			
		}
	}

	@Given("^I enter Subject")
	public void IEnterSubjectField() throws InterruptedException, IOException {
		try {
			action.moveToElement(LocalDriverManager.getDriver().findElement(casePage.CaseDesc)).click().build();
			Thread.sleep(1000);
			action.moveToElement(LocalDriverManager.getDriver().findElement(casePage.CaseDesc)).click().build()
					.perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(casePage.CaseSubject));
			LocalDriverManager.getDriver().findElement(casePage.CaseSubject).click();
			Thread.sleep(1000);
			LocalDriverManager.getDriver().findElement(casePage.CaseSubject).sendKeys("Test Subject");
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Entering the Subject"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
			Thread.sleep(3000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception " + e + " occurred while entering the subject"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
			errorMap.put("IEnterSubjectField", null);
			
		}
	}

	@When("^I click Save button")
	public void IClickSaveButton() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(casePage.CaseSavebtn));
			LocalDriverManager.getDriver().findElement(casePage.CaseSavebtn).click();
			Thread.sleep(1000);
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Save button clicked"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
			Thread.sleep(3000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception " + e + " occurred while saving the case"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
			errorMap.put("IClickSaveButton", null);
		}
	}

	@Then("^I see new case is created successfully")
	public void ISeeCaseCreatedSuccessfully() throws InterruptedException, IOException {
		try {
			
			Assert.assertTrue("Case creation not successful",
					LocalDriverManager.getDriver().findElement(casePage.CaseSubHeader).isDisplayed());
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Case Creation Success"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
			Thread.sleep(3000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception " + e + " occurred while creating case"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
			errorMap.put("ISeeCaseCreatedSuccessfully", null);
			
		}
	}

	@When("^I Edit the case status")
	public void Ieditcase() throws InterruptedException, IOException{
	       try {
	       wait.until(ExpectedConditions.visibilityOfElementLocated(casePage.Editbutton));
	       LocalDriverManager.getDriver().findElement(casePage.Editbutton).click();
	             Thread.sleep(5000);
	       wait.until(ExpectedConditions.visibilityOfElementLocated(casePage.Statusdropdown));
	       LocalDriverManager.getDriver().findElement(casePage.Statusdropdown).click();
	             
	       wait.until(ExpectedConditions.visibilityOfElementLocated(casePage.Workinglink));
	       LocalDriverManager.getDriver().findElement(casePage.Workinglink).click();
	             
	       LocalDriverManager.getDriver().findElement(casePage.CaseSavebtn).click();
	       Thread.sleep(5000);
	             ExecutionHelper.getLogger().log(LogStatus.PASS, "Case Status Changed"+ExecutionHelper.getLogger()
		 			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
	             
	       }
	       catch (Exception e) {
	             ExecutionHelper.getLogger().log(LogStatus.FAIL,
	                          "Exception " + e + "Case Status not changed"+ExecutionHelper.getLogger()
	          	 			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
	             isFailed=true;
	 			errorMap.put("Ieditcase", null);
	             
	       }
	}

	
	@Given("^I click on Feed Link")
	public void IclickonFeed() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(casePage.Feed));
			LocalDriverManager.getDriver().findElement(casePage.Feed).click();
			Thread.sleep(3000);
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Clicked on the Feed Link"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
		}

		catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception " + e + "Not clicked on Feed"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
 			errorMap.put("IclickonFeed", null);
		
		}

	}

	@Given("^I enter details in Share feed")
	public void Ienterdetails() throws InterruptedException, IOException {
		try {
			LocalDriverManager.getDriver().findElement(casePage.ShareAnUpdateBtn).click();
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(casePage.ShareUpdatebox));
			LocalDriverManager.getDriver().findElement(casePage.ShareUpdatebox).sendKeys(casePage.Textt);
			Thread.sleep(1000);
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Details entered in feed section"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			

		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception " + e + "No details entered in Feed"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
 			errorMap.put("Ienterdetails", null);
			
		}
	}

	@When("^I share the feed")
	public void Isharethefeed() throws InterruptedException, IOException {
		try {
			LocalDriverManager.getDriver().findElement(casePage.Sharebutton).click();
			Thread.sleep(10000);
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Feed Shared"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception " + e + "Not Shared"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
 			errorMap.put("Isharethefeed", null);
			
		}
	}

	@Then("^I verify the feed in Text Posts")
	public void Iverifythefeed() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			LocalDriverManager.getDriver().findElement(casePage.TextPosts).click();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(casePage.TextEnteredinPosts));

			String bodyText = LocalDriverManager.getDriver().findElement(casePage.TextEnteredinPosts).getText();
			Assert.assertTrue("Text not found!", bodyText.contains(casePage.Textt));

			ExecutionHelper.getLogger().log(LogStatus.PASS, "Feed in Text Post section Verified"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception " + e + "No details entered in Feed"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
 			errorMap.put("Iverifythefeed", null);
			
		}
	}

	@Then("^I verify the Status Changes")
	public void IverifytheStatus() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(casePage.StatusChanges));
			LocalDriverManager.getDriver().findElement(casePage.StatusChanges).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(casePage.StatusResults));
			String feedOldStatus = LocalDriverManager.getDriver().findElement(casePage.StatusResults).getText();
			
			Assert.assertTrue("Text not found!", feedOldStatus.contains(casePage.New));
			String feedNewStatus = LocalDriverManager.getDriver().findElement(casePage.StatusResultsNew).getText();
			Assert.assertTrue("New Status text not found", feedNewStatus.contains("Working"));
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Status Change is Posted"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception " + e + "Status Change details not available"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
 			errorMap.put("IverifytheStatus", null);
			
		}
	}
	
	@When("^I click Open Activities related list")
	public void IClickOpenActivities() throws InterruptedException, IOException
	{
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(casePage.OpenActivitiesLink));
			LocalDriverManager.getDriver().findElement(casePage.OpenActivitiesLink).click();
			Thread.sleep(2000);
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Opem Activities Link clicked"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
			
			
		}
		catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception " + e + "Open Activities related list not clicked"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
 			errorMap.put("IClickOpenActivities", null);
			
		}
	}
	
	@Then("^I see page with Open Activities title Opened")
	public void ISeePageOpenActivities() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(casePage.OpenActivitiesPageTitle));
			Assert.assertTrue("Open Activities page not opened", LocalDriverManager.getDriver().findElement(casePage.OpenActivitiesPageTitle).isDisplayed());

			ExecutionHelper.getLogger().log(LogStatus.PASS, "Status Change is Posted"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception " + e + "Error occured while navigating to Open activities page"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
 			errorMap.put("ISeePageOpenActivities", null);
		}
	}
	
	
	@When("^I click New Task button")
	public void IClickNewTaskButton() throws InterruptedException, IOException
	{
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(casePage.NewTask));
			LocalDriverManager.getDriver().findElement(casePage.NewTask).click();
			Thread.sleep(2000);
			ExecutionHelper.getLogger().log(LogStatus.PASS, "New Task button clicked"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
		}
		catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception " + e + "Error occured while clicking on New Task button"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
 			errorMap.put("IClickNewTaskButton", null);
			
		}
	}
	
	
	@Then("^I see New Task window opened")
	public void ISeeNewTaskWindow() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(casePage.NewTaskPageTitle));
			Assert.assertTrue("New task page not opened", LocalDriverManager.getDriver().findElement(casePage.NewTaskPageTitle).isDisplayed());
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Status Change is Posted"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception " + e + "Error occured while navigating to new task page"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
 			errorMap.put("ISeeNewTaskWindow", null);
			
		}
	}
	
	
	@Given("^I enter task subject")
	public void IEnterTaskSubject() throws InterruptedException, IOException {
		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(casePage.taskSubject));
			LocalDriverManager.getDriver().findElement(casePage.taskSubject).sendKeys("Email");
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Subject entered in task window section"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			

		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception " + e + "Error occured when entering subject in New task"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
 			errorMap.put("IEnterTaskSubject", null);
			
		}
	}

	@Given("^I enter task comments")
	public void IEnterTaskComments() throws InterruptedException, IOException {
		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(casePage.taskComments));
			LocalDriverManager.getDriver().findElement(casePage.taskComments).sendKeys("Test comments in task");
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Comments entered in task window section"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			

		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception " + e + "Error occured when entering comments in New task"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
 			errorMap.put("IEnterTaskComments", null);
			
		}
	}
	
	
	@Then("^I see new Task is created successfully")
	public void ISeeTaskCreated() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(casePage.TaskPageTitle));
			Assert.assertTrue("New task not created", LocalDriverManager.getDriver().findElement(casePage.TaskPageTitle).isDisplayed());
			ExecutionHelper.getLogger().log(LogStatus.PASS, "New Task Creation SUCCESS"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
			
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception " + e + "Error occured while creating a new task"+	ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
 			errorMap.put("ISeeTaskCreated", null);
		
		}
	}
	
}