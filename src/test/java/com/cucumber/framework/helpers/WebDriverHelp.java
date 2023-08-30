package com.cucumber.framework.helpers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cucumber.framework.helpers.utils.Utils;
import com.cucumber.page_objects.CasePage;
import com.relevantcodes.extentreports.LogStatus;

//public abstract class WebDriverHelp extends EventFiringWebDriver {
public class WebDriverHelp {// extends EventFiringWebDriver {
	private static final Logger LOG = LoggerFactory.getLogger(WebDriverHelp.class);
	// private static WebDriver REAL_DRIVER = null;
	public static Utils utility = new Utils();
	public static CasePage bobsLandingPage = new CasePage();

	private static String BROWSER;
	private static String PLATFORM;
	private static String DRIVER_PATH;
	private static String DRIVER_ROOT_DIR;
	private static String SELENIUM_HOST;
	private static String SELENIUM_PORT;
	private static String SELENIUM_REMOTE_URL;
	private static Dimension BROWSER_WINDOW_SIZE;
	private static Integer BROWSER_WINDOW_WIDTH;
	private static Integer BROWSER_WINDOW_HEIGHT;
	private static String SAUCE_LABS;

	public static URL basePath;
	public static URL trackerpath;
	private static URL backOficeBasePath;
	private static URL apiUrl;
	private static URL CMSCockpitBasePath;

	public static final String USERNAME = "bobssauceaccount";
	public static final String ACCESS_KEY = "5c729f75-a6ca-4d71-8e1d-a1cc38f63b4f";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	public void driverSetup(String FeatureName, String ScenarioName) throws Throwable {

		// static {
		Props.loadRunConfigProps("/environment.properties");
		SELENIUM_HOST = Props.getProp("driverhost");
		// SELENIUM_PORT = Props.getProp("driverport");
		PLATFORM = Props.getProp("platform");
		BROWSER = Props.getProp("browser");
		BROWSER_WINDOW_WIDTH = Integer.parseInt(Props.getProp("browser.width"));
		BROWSER_WINDOW_HEIGHT = Integer.parseInt(Props.getProp("browser.height"));
		BROWSER_WINDOW_SIZE = new Dimension(BROWSER_WINDOW_WIDTH, BROWSER_WINDOW_HEIGHT);
		DRIVER_ROOT_DIR = Props.getProp("driver.root.dir");
		SAUCE_LABS = Props.getProp("saucelabs");

		try {
			if (!Props.getProp("url").isEmpty()) {
				basePath = new URL(Props.getProp("url"));
			} else {
				System.out.println("NOT a Valid env");
			}
			if (!Props.getProp("trackerurl").isEmpty()) {
				trackerpath = new URL(Props.getProp("trackerurl"));
			} else {
				System.out.println("NOT a valid tracker link");
			}
			// basePath = new URL(Props.getProp("site.url"));
			// backOficeBasePath = new URL(Props.getProp("backOffice.url"));
			// apiUrl = new URL(Props.getProp("api.url"));
			// CMSCockpitBasePath= new URL(Props.getProp("CMSCockpit.url"));

		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (!DRIVER_ROOT_DIR.equals("DEFAULT_PATH")) {
			// System.setProperty("webdriver.gecko.driver",getDriverPath());
			System.setProperty("webdriver.chrome.driver", getDriverPath());
			System.setProperty("webdriver.ie.driver", getDriverPath());
			System.setProperty("phantomjs.binary.path", getDriverPath());
			// System.out.println("BROWSER.toLowerCase() "+BROWSER.toLowerCase());
		}

		try {
			System.gc();
			// System.out.println("inside TRYYYYYYYYYYYYYYYYYYY ");
			switch (BROWSER.toLowerCase()) {
			case ("chrome"):
				startChromeDriver(FeatureName, ScenarioName);
				break;
			case ("firefox"):
				startFireFoxDriver();
				break;
			case ("iexplore"):
				startIEDriver();
				break;
			/*
			 * case ("appium"): startAppiumDriver(); break;
			 */
			case ("sauce"):
				// startSauceDriver();
				break;
			default:
				throw new IllegalArgumentException(
						"Browser " + BROWSER + " or Platform " + PLATFORM + " type not supported");

			}

		} catch (IllegalStateException e) {
			LOG.error("FIX path for driver.root.dir in pom.xml " + DRIVER_ROOT_DIR + " Browser parameter " + BROWSER
					+ " Platform parameter " + PLATFORM + " type not supported", e);
		}
		// }
	}

	public WebDriverHelp() {
		// super(REAL_DRIVER);
		// System.out.println("WebDriverHelpWebDriverHelpWebDriverHelpWebDriverHelp");
		// setDriver();
		// TODO Auto-generated constructor stub
		// Props.loadRunConfigProps("/environment.properties");
	}

	public static void startFireFoxDriver() {
		// FirefoxOptions options = new FirefoxOptions().setProfile(new
		// FirefoxProfile());
		WebDriver driver = new FirefoxDriver();
		LocalDriverManager.setWebDriver(driver);
		LocalDriverManager.getDriver().manage().window().maximize();
		// driver.manage().window().maximize();
		// driver.navigate().to(appURL);
		// return driver;
	}

	public static void startAtBackOfficeHomePage() {
		LocalDriverManager.getDriver().navigate().to(backOficeBasePath);

		// REAL_DRIVER.get("javascript:document.getElementById('overridelink').click()");
	}

	public static void startAtHomePage() {
		try {
			LocalDriverManager.getDriver().navigate().to(basePath);
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Launching the URL " + basePath);
			Cookie ck = new Cookie("ltkpopup-suppression-1d233a12-cebe-41cb-9d38-5fb4f4ec55f7", "1");
			LocalDriverManager.getDriver().manage().addCookie(ck);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL, "Exception occured while landing on the Home Page " + e);
			e.printStackTrace();
			System.out.println("Exception" + e);
		}
	}

	public static void startTrackerApp() {
		try {
			LocalDriverManager.getDriver().navigate().to(trackerpath);
			ExecutionHelper.getLogger().log(LogStatus.PASS, "Launching tracker " + trackerpath);
		} catch (Exception e) {
			ExecutionHelper.getLogger().log(LogStatus.FAIL,
					"Exception occured while landing on the Tracker Home Page " + e);
			e.printStackTrace();
			System.out.println("Exception" + e);
		}
	}

	/*
	 * public WebDriver getDriver(){ //setDriver(); return REAL_DRIVER; }
	 */

	public static void startAtCMSCockpitHomePage() {
		LocalDriverManager.getDriver().navigate().to(CMSCockpitBasePath);

		// REAL_DRIVER.get("javascript:document.getElementById('overridelink').click()");
	}

	private static String getDriverPath() {
		DRIVER_PATH = Props.getProp("driver.root.dir");
		// System.out.println("DRIVER_PATH DRIVER_PATH DRIVER_PATH "+DRIVER_PATH);
		return DRIVER_PATH;
	}

	private static void startChromeDriver(String FeatureName, String ScenarioName) throws Throwable {
		// System.out.println("CREATING CHROME
		// DRIVER");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("--disable-notifications");
		options.addArguments("--js-flags=--expose-gc");
		options.addArguments("--disable-default-apps");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.managed_default_content_settings.geolocation", 2);
		options.setExperimentalOption("prefs", prefs);
		/*
		 * DesiredCapabilities dc = DesiredCapabilities.chrome();
		 * dc.setCapability(ChromeOptions.CAPABILITY, options);
		 */
		if (SAUCE_LABS.equalsIgnoreCase("Y")) {
			options.setCapability("platform", "Windows 10");
			options.setCapability("version", "64.0");
			options.setCapability("screenResolution", "1440x900");
			options.setCapability("name", FeatureName + " : " + ScenarioName);
			WebDriver driver = ThreadGuard.protect(new RemoteWebDriver(new URL(URL), options));
			LocalDriverManager.setWebDriver(driver);
			LocalDriverManager.getDriver().manage().window().maximize();

		} else {
			WebDriver driver = ThreadGuard.protect(new ChromeDriver());
			// REAL_DRIVER = driver;
			LocalDriverManager.setWebDriver(driver);
			LocalDriverManager.getDriver().manage().window().maximize();
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		}
		// return REAL_DRIVER;
	}

	private static void startIEDriver() {
		/*
		 * DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		 * capabilities.setCapability(InternetExplorerDriver.
		 * INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		 * capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		 * capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		 */
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();

		caps.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);

		caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		caps.setJavascriptEnabled(true);
		// capabilities.setVersion("11");
		InternetExplorerDriver driver = new InternetExplorerDriver(caps);
		LocalDriverManager.setWebDriver(driver);
		LocalDriverManager.getDriver().manage().window().maximize();
	}

	private static DesiredCapabilities getChromeDesiredCapabilities() {

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("disable-infobars");

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

		return capabilities;
	}

	private static DesiredCapabilities getInternetExploreDesiredCapabilities() {
		// LoggingPreferences logs = new LoggingPreferences();
		// logs.enable(LogType.DRIVER, Level.OFF);
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		// capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setVersion("11");
		return capabilities;
	}

	private static DesiredCapabilities getPhantomJsCapabilities() {
		// System.out.println("get phantomJsCapabilitiesssssssssssssssssssss ");
		LoggingPreferences logs = new LoggingPreferences();
		logs.enable(LogType.DRIVER, Level.OFF);
		DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
		capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
		capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, getDriverPath());
		return capabilities;
	}

	private static RemoteWebDriver getRemoteWebDriver(DesiredCapabilities capabilities) throws MalformedURLException {
		SELENIUM_REMOTE_URL = "http://" + SELENIUM_HOST + ":" + SELENIUM_PORT + "/wd/hub";
		LOG.info(SELENIUM_REMOTE_URL + " Checking Selenium Remote URL");
		return new RemoteWebDriver(new URL(SELENIUM_REMOTE_URL), (capabilities));
	}

	public static void resizeBrowserWindow(Dimension dimension) {
		LocalDriverManager.getDriver().manage().window().setSize(dimension);
	}

	public static void quitDriver() {
		// super.close();
		LocalDriverManager.getDriver().quit();
	}

}