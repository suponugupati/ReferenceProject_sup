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

public class LoginPage extends PageObject {

	public LoginPage() {
		// System.out.println("Inside SleepCountryLanding PAGEEEEEEEEEEEEEEEEEEEEEE");
	}

	Utils utility = new Utils();

	// Login Page Xpaths
	public static By Username = By.xpath("//input[@id='username']");\]

	public By password = By.xpath("//input[@id='password']");
	public By LoginButton = By.xpath("//input[@id='Login']");

	public By AppLauncher = By.xpath("//nav[contains(@class,'appLauncher')]//button");
	
}