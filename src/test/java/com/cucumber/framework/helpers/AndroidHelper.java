package com.cucumber.framework.helpers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidHelper extends EventFiringWebDriver {
    private static final Logger LOG = LoggerFactory
            .getLogger(AndroidHelper.class);
    private static final String RUN_CONFIG_PROPERTIES = "/environment.properties";
    private static AndroidDriver<WebElement> ANDROID_DRIVER = null;
    //private static AndroidElement ANDROID_DRIVER = null;
    //private static WebElement ANDROID_DRIVER = null;
    private static final Thread CLOSE_THREAD = new Thread() {

        @Override
        public void run() {
            ANDROID_DRIVER.quit();
        }
    };

    static {
        Props.loadRunConfigProps(RUN_CONFIG_PROPERTIES);
        ANDROID_DRIVER = startAppiumDriver();
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }

    private AndroidHelper() {
        super(ANDROID_DRIVER);
    }


    private static AndroidDriver<WebElement> startAppiumDriver() {
        DesiredCapabilities capabilities = getAppiumDesiredCapabilities();
        try {
            ANDROID_DRIVER = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return ANDROID_DRIVER;
    }


    /*private static DesiredCapabilities getAppiumDesiredCapabilities() {
        File app = new File("C:\\projectAppium\\ContactManager.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.example.android.contactmanager");
        capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, ".ContactManager");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        //capabilities.setCapability("deviceName", "42f7ab1fb7b59fab");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        return capabilities;
    }*/
    
    private static DesiredCapabilities getAppiumDesiredCapabilities() {
    	DesiredCapabilities capabilities = new DesiredCapabilities();
    	//capabilities.setCapability("device", "Andriod");
    	capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "ce061606edb28f3c03"); //"emulator-5554");//"mygeny510");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");//(CapabilityType.BROWSER_NAME, "chrome");
        capabilities.setCapability("appiumVersion", "1.7.0");
        //capabilities.setCapability(MobileCapabilityType.VERSION, "7.0"); 
         
        //capabilities.setCapability(MobileCapabilityType.ACCEPT_SSL_CERTS, true);

        return capabilities;
    }

    public static AndroidDriver<WebElement> getAndroidWebDriver() {
        return ANDROID_DRIVER;
    }

    @Override
    public void close() {
        if (Thread.currentThread() != CLOSE_THREAD) {
            throw new UnsupportedOperationException(
                    "You shouldn't close this WebDriver. It's shared and will close when the JVM exits.");
        }
        super.close();
    }
}
