package com.cucumber.stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.cucumber.framework.PageObject;
import com.cucumber.framework.helpers.ExecutionHelper;
import com.cucumber.framework.helpers.LocalDriverManager;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.ITest;

import cucumber.api.Scenario;
import cucumber.api.java.Before;



public class Hooks extends PageObject  {
	
	public List<HashMap<String,String>> datamap;
	ExecutionHelper helper = new ExecutionHelper();
	
	
    @Before
    public void beforeScenario(Scenario scenario) throws Throwable {
    	String scenarioName = scenario.getName();
		String featureName = scenario.getId().split(";")[0]; 
		String value = featureName.split("features/")[1];
		String FeatureName = value.split(".feature")[0];
		System.out.println("featureName : "+value.split(".feature")[0]);
		System.out.println("scenarioName : "+scenarioName);
		PageObject.initialize(FeatureName,scenarioName);
		ExecutionHelper.startTest(value.split(".feature")[0]+" : "+scenarioName); 
    }
   
}

