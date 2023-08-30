package com.cucumber.framework.helpers;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.Scenario;

public class ExecutionHelper {
	
	public static ExtentReports extent;
	public static Scenario scenario = null;
	public static ThreadLocal<ExtentTest> logger = new ThreadLocal<ExtentTest>();
	//public static ExtentTest logger;
	public static boolean isExecuted;
	public static String LOCK = "lock";
   /* public static void executeOnce() { 
    	synchronized (LOCK) {
        	System.out.println("is Execute +"+isExecuted);
            if (ExecutionHelper.isExecuted) {
                return;
            } else {
            	try {
            		ExecutionHelper.isExecuted = true;
            		System.out.println("Synchronized");
    				extentReportInitialize();
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            }
		}
    }*/
    static {
    	try {
			extentReportInitialize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	/*public static void loadResources() throws Exception, Throwable {
		try {
			System.out.println("*********Before Cucumber*******");
			extentReportInitialize();
		} catch (Exception exception) {
		}
	}*/
	
	public static String scenarioName(){
		String scenarioName = scenario.getName();
		System.out.println("Scenario"+scenarioName);
		String featureName = scenario.getId().split(";")[0]; 
		return scenarioName;
	}
	
	public static void extentReportInitialize() throws Exception {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_SSS");
			Date date = new Date();
			String extentReportLocation = System.getProperty("user.dir")+"/ExtentReports/ExtentReport"+dateFormat.format(date)+".html";
			System.out.println("extentReport" + extentReportLocation);
			System.out.println("SystemDirectory"+System.getProperty("user.dir"));
			extent = new ExtentReports(extentReportLocation, true);
			
		} catch (Exception exception) {
		}
	}
	
	 public static void startTest(String scenarioID) throws Throwable{
		 try {
			 setLogger(extent.startTest(scenarioID));
		 } catch (Exception exception) {
                     exception.printStackTrace();
         }
     }
	 
	 public static void setLogger(ExtentTest test){
			logger.set(test);
		}
	 public static ExtentTest getLogger(){
			return logger.get();
		}
	     
	    public static String takeScreenshot(WebDriver driver) throws IOException {
	    	File source = ((TakesScreenshot) LocalDriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
	    	String destination= System.getProperty("user.dir")+"/Screenshot/"+"sfdcscreenshot_"+System.currentTimeMillis()+".png";
	    	File finalDestination = new File(destination);
	    	FileUtils.copyFile(source,finalDestination);
	    	return destination;
	    	}  
	    
	 public static void tearDown(Scenario scenario) {
	    	if (scenario.isFailed()) {
	    	// Take a screenshot...
	    	final byte[] screenshot = ((TakesScreenshot) LocalDriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
	    	// embed it in the report.
	    	scenario.embed(screenshot, "image/png");
	    	}
	    	}
	 
	public static void extentReportFlush() throws Exception {
		try {
			extent.endTest(getLogger());
			extent.flush();
		} catch (Exception exception) {
		}
	} 

}
