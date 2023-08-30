package com.cucumber.framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cucumber.framework.helpers.LocalDriverManager;
import com.cucumber.framework.helpers.WebDriverHelp;

public abstract class PageObject {
    private static final long DRIVER_WAIT_TIME = 25;
    private static final Logger LOG = LoggerFactory.getLogger(PageObject.class);

    //@Getter
    //protected WebDriverWait wait;
    protected static WebDriverWait wait;
    
    //@Getter
    //protected WebDriver webDriver;
    //public static WebDriver webDriver;
    public static WebDriverHelp wDH;


    protected PageObject() {
    	//System.out.println("Inside Pageobject constructor PageobjectPageobjectPageobjectPageobject");
    }
    public static void initialize(String FeatureName , String ScenarioName ) throws Throwable{
    	WebDriverHelp wDH = new WebDriverHelp();
    	wDH.driverSetup(FeatureName ,ScenarioName);
//    	webDriver = wDH.getWebDriver();
    	wait = new WebDriverWait(LocalDriverManager.getDriver(), DRIVER_WAIT_TIME);
    }

    
    public void closeDriver(){
    	WebDriverHelp.quitDriver();
    }
    

    /**
     * Returns the current Url from page
     **/
    public String getCurrentUrl() {
        return LocalDriverManager.getDriver().getCurrentUrl();
    }
    public String getCurrentPageTitle() {
        return LocalDriverManager.getDriver().getTitle();
    }
    
    /**
     * Explicit wait till the element get visible 
     * 
     * @param by
     * @return
     */
    
    protected WebElement waitForExpectedElement(final By by) {
   
    	try{
    		final WebDriverWait wait = new WebDriverWait(LocalDriverManager.getDriver(), 20);
    		WebElement element = LocalDriverManager.getDriver().findElement(by);
    		return wait.until(ExpectedConditions.visibilityOf(element));
    	}catch (final Exception exception){
    		System.out.println(exception.getMessage());
    		LOG.error(exception.getMessage());
    		return null;
    	}
    }
    
    /**
     * Explicit wait till all the elements get visible 
     * 
     * @param by
     * @return
     */
    
    protected List<WebElement> waitForExpectedElements(final By by) {
    	try{
    		final WebDriverWait wait = new WebDriverWait(LocalDriverManager.getDriver(), 20);
    		List<WebElement> element = LocalDriverManager.getDriver().findElements(by);
    		return wait.until(ExpectedConditions.visibilityOfAllElements(element));
    	}catch (final Exception exception){
    		System.out.println(exception.getMessage());
    		LOG.error(exception.getMessage());
    		return null;
    	}
    }
    
    /**
     * Explicit wait till all the elements get visible 
     * 
     * @param <list> Web Elements
     * @return
     */
    
    protected List<WebElement> waitForExpectedElements(final List<WebElement> ele) {
    	try{
    		final WebDriverWait wait = new WebDriverWait(LocalDriverManager.getDriver(), 20);
    		return wait.until(ExpectedConditions.visibilityOfAllElements(ele));
    	}catch (final Exception exception){
    		System.out.println(exception.getMessage());
    		LOG.error(exception.getMessage());
    		return null;
    	}
    }

    
    /**
     * Explicit wait till the element get visible 
     * 
     * @param by
     * @return
     */
    
    protected WebElement waitForElement(final By by) {
    	try{
    		final WebDriverWait wait = new WebDriverWait(LocalDriverManager.getDriver(), 20);
    		WebElement element = LocalDriverManager.getDriver().findElement(by);
    		return wait.until(ExpectedConditions.visibilityOf(element));
    	}catch (final Exception exception){
    		System.out.println(exception.getMessage());
    		LOG.error(exception.getMessage());
    		return null;
    	}
    }
    
    
   protected static boolean isClickable(final WebElement element)
   {
	   try
	   {
	      wait.until(ExpectedConditions.elementToBeClickable(element));
	      return true;
	   }
	   catch (Exception e)
	   {
	     return false;
	   }
   }
    
    public WebElement waitForExpectedElement(final By by, long waitTimeInSeconds) {
    	try{
    		final WebDriverWait wait = new WebDriverWait(LocalDriverManager.getDriver(), 20);
    		WebElement element = LocalDriverManager.getDriver().findElement(by);
    		return wait.until(ExpectedConditions.visibilityOf(element));
    	}catch (final Exception exception){
    		System.out.println(exception.getMessage());
    		LOG.error(exception.getMessage());
    		return null;
    	}
    }
    
	public static boolean isExistElement(By by)
	{
		try {
			LocalDriverManager.getDriver().findElement(by);
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
		return true;
	}
    
	public static void scrollWithOffset(WebElement element, int x, int y)
	{
        
		
		try {
			//WebDriver driver= null;
			
			String code="window.scroll("+(element.getLocation().x+x)+"," +
		          (element.getLocation().y+y)+");";
			((JavascriptExecutor)LocalDriverManager.getDriver()).executeScript(code, element, x, y);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public void delay(long time){
    	try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void refreshCurrentPage()
	{
    	LocalDriverManager.getDriver().navigate().refresh();
	}
}
