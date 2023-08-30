package com.cucumber.stepdefinitions;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.cucumber.page_objects.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.cucumber.framework.helpers.utils.EncryptDecrypt;
import com.cucumber.framework.helpers.utils.ReadExcel; 


public class LoginPageStepdefs {
	private static final Logger LOG = LoggerFactory.getLogger(LoginPageStepdefs.class);

	LoginPage loginPage = new LoginPage();
	EncryptDecrypt testdata=new EncryptDecrypt();
	String key="lockUnlock";

	Utils utility = new Utils();
	WebDriverWait wait = new WebDriverWait(LocalDriverManager.getDriver(), 120);
	Actions action = new Actions(LocalDriverManager.getDriver());
	public static Boolean isFailed = false;
	public static Map errorMap= new HashMap<>();
	
	@Given("^I launch the Salesforce application")
	public void ILaunchTheSleepCountryApp() throws InterruptedException, IOException {
		try {
			// Launching the Application
			WebDriverHelp.startAtHomePage();
			wait.until(ExpectedConditions.elementToBeClickable(loginPage.LoginButton));
			ExecutionHelper.getLogger().log(LogStatus.PASS, "SFDC is launched"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + " occurred while navigating to Login Page"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
			errorMap.put("ILaunchTheSleepCountryApp", null);
		}
	}

	@When("^I enter the \"(.*)\" and \"(.*)\"")
	public void IEnterUsernameAndPassword(String Username, String password) throws InterruptedException, IOException {
		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loginPage.Username));
			LocalDriverManager.getDriver().findElement(loginPage.Username).sendKeys(testdata.decrypt(ReadExcel.getData("TestData", "ValidateCaseCreate", Username), key));
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Entered the user name"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
			Thread.sleep(3000);
			LocalDriverManager.getDriver().findElement(loginPage.password).sendKeys(testdata.decrypt(ReadExcel.getData("TestData", "ValidateCaseCreate", password), key));
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Entered the password"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			Thread.sleep(2000);

		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + " occurred while entering user name password"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));	
			isFailed=true;
			errorMap.put("IEnterUsernameAndPassword", null);
		}
	}

	@When("^I click on LogIn Button")
	public void IClickOnSignInBtn() throws InterruptedException, IOException {
		try {

			LocalDriverManager.getDriver().findElement(loginPage.LoginButton).click();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Clicked on the Login/SignIn button"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			Thread.sleep(5000);
			LocalDriverManager.getDriver().navigate().refresh();
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + " occurred while clicking on Login Page"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
			errorMap.put("IClickOnSignInBtn", null);
			
		}
	}

	@Then("^I logged into the Salesforce application successfully")
	public void ILoggedInSuccessfully() throws InterruptedException, IOException {
		try {
			Thread.sleep(20000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.AppLauncher));
			Assert.assertTrue("Login was not successful",
					LocalDriverManager.getDriver().findElement(loginPage.AppLauncher).isDisplayed());
			System.out.println("LOGIN SUCCESS!!");
			ExecutionHelper.getLogger().log(LogStatus.PASS, "LOGIN Was Successfully completed"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception " + e + " occurred while Home page"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
			errorMap.put("ILoggedInSuccessfully", null);
			
		}
	}

	@Given("^I click on Applauncher")
	public void IClickAppLauncher() throws InterruptedException, IOException {
		try {
			LocalDriverManager.getDriver().findElement(loginPage.AppLauncher).click();
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Clicked on the AppLauncher button"+ExecutionHelper.getLogger()
			.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			
			Thread.sleep(5000);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception " + e + " occurred while clicking on Login Page"+ExecutionHelper.getLogger()
					.addScreenCapture(ExecutionHelper.takeScreenshot(LocalDriverManager.getDriver())));
			isFailed=true;
			errorMap.put("IClickAppLauncher", null);
			
		}
	}
}