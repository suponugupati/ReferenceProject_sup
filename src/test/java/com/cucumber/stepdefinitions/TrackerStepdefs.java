package com.cucumber.stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
import com.cucumber.framework.helpers.WebDriverHelp;

import cucumber.api.java.en.Then;
import com.cucumber.framework.helpers.utils.EncryptDecrypt;
import com.cucumber.page_objects.TrackerExecution;
import com.relevantcodes.extentreports.LogStatus; 

public class TrackerStepdefs {
	
	private static final Logger LOG = LoggerFactory.getLogger(TrackerStepdefs.class);

	TrackerExecution trackerPage = new TrackerExecution();
	
	@Then("^I execute the \"(.*)\" script in test tracker")
	public void IOpenSalesforceTracker(String ScriptID) throws InterruptedException, IOException {
		EncryptDecrypt testdata=new EncryptDecrypt();
		WebDriverWait wait = new WebDriverWait(LocalDriverManager.getDriver(), 120);
		String key="lockUnlock";
		Actions action = new Actions(LocalDriverManager.getDriver());
		Map errorMap = CaseObjectPageStepdefs.errorMap;
		errorMap.keySet();
		// System.out.println(CaseObjectPageStepdefs.isFailed);
		try {
 {
			// Launching the test tracker URL
			WebDriverHelp.startTrackerApp();
			wait.until(ExpectedConditions.elementToBeClickable(trackerPage.loginButton));

			// Entering the credentials of the test tracker
			LocalDriverManager.getDriver().findElement(trackerPage.username).clear();
			LocalDriverManager.getDriver().findElement(trackerPage.username).sendKeys(testdata.decrypt("HwcKHTQcDx1NU1svBAY0BwBBAAQB", key));
			LocalDriverManager.getDriver().findElement(trackerPage.Password).clear();
			LocalDriverManager.getDriver().findElement(trackerPage.Password).sendKeys(testdata.decrypt("Pg4KCD0bHi9SW14=", key));
			Thread.sleep(1000);
			LocalDriverManager.getDriver().findElement(trackerPage.loginButton).click();
			Thread.sleep(5000);

			// Clicking on App launcher and opening up Test Scripts
			wait.until(ExpectedConditions.elementToBeClickable(trackerPage.appLauncher));
			LocalDriverManager.getDriver().findElement(trackerPage.appLauncher).click();
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(trackerPage.ViewAll));
			LocalDriverManager.getDriver().findElement(trackerPage.ViewAll).click();
			
			Thread.sleep(3000);
			LocalDriverManager.getDriver().findElement(trackerPage.SearchApps).clear();
			LocalDriverManager.getDriver().findElement(trackerPage.SearchApps).sendKeys("Test Scripts");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(trackerPage.TestScripts));
			LocalDriverManager.getDriver().findElement(trackerPage.TestScripts).click();
			Thread.sleep(2000);

			// Clicking on the Test Script ID
			LocalDriverManager.getDriver().findElement(trackerPage.getXpathforScriptID(ScriptID)).click();
			Thread.sleep(3000);

			// Navigating to the Related tab
			LocalDriverManager.getDriver().findElement(trackerPage.RelatedTab).click();
			Thread.sleep(3000);
			action.moveToElement(LocalDriverManager.getDriver().findElement(trackerPage.TestersLink)).build().perform();
			JavascriptExecutor js = (JavascriptExecutor) LocalDriverManager.getDriver();
			js.executeScript("window.scrollBy(0,1000)");
			Thread.sleep(3000);
			action.moveToElement(LocalDriverManager.getDriver().findElement(trackerPage.ClickToExecuteLink)).click()
					.build().perform();
			LocalDriverManager.getDriver().findElement(trackerPage.ClickToExecuteLink).click();
			Thread.sleep(40000);
			LocalDriverManager.getDriver().switchTo().frame(2);
			Thread.sleep(3000);
			
            if (!CaseObjectPageStepdefs.isFailed)
            {
            List<WebElement> TestOutcomes = LocalDriverManager.getDriver().findElements(trackerPage.TestOutCome);
            int len=TestOutcomes.size();
            for (int i = 0; i <len ; i++) {
                           action.moveToElement(TestOutcomes.get(i)).build().perform();
                           Select testOutcome = new Select(TestOutcomes.get(i));
                           testOutcome.selectByIndex(1);
                           Thread.sleep(2000);
            }

			js.executeScript("window.scrollBy(0,1000)");
			Thread.sleep(1000);
			Select FinalOutcome = new Select(LocalDriverManager.getDriver().findElement(trackerPage.OverallOutcome));
			FinalOutcome.selectByVisibleText("Passed");
			Thread.sleep(2000);
			LocalDriverManager.getDriver().findElement(trackerPage.OverallComments).clear();
			LocalDriverManager.getDriver().findElement(trackerPage.OverallComments).sendKeys("Passed successfully");
			LocalDriverManager.getDriver().findElement(trackerPage.SaveExecutionBtn).click();
			}
			else
            {
                   js.executeScript("window.scrollBy(0,1000)");
                   Thread.sleep(1000);
                   Select FinalOutcome = new Select(LocalDriverManager.getDriver().findElement(trackerPage.OverallOutcome));
                   FinalOutcome.selectByVisibleText("Failed");
                   Thread.sleep(2000);
            LocalDriverManager.getDriver().findElement(trackerPage.OverallComments).clear();
            LocalDriverManager.getDriver().findElement(trackerPage.OverallComments).sendKeys("Failed due to an error"+errorMap.keySet());
            LocalDriverManager.getDriver().findElement(trackerPage.SaveExecutionBtn).click();
                   
            }

			Thread.sleep(10000);
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Tracker Execution Completed"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
}

		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + " occurred while tracker execution"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
		}
	}

}
