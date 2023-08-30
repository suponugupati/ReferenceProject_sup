package com.cucumber.framework;

import io.appium.java_client.android.AndroidDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cucumber.framework.helpers.AndroidHelper;

import java.util.ResourceBundle;

public abstract class AndroidObject {
    private static final long DRIVER_WAIT_TIME = 10;
    private static final Logger LOG = LoggerFactory.getLogger(AndroidObject.class);
    //@Getter
    //private final ResourceBundle props;
    //@Getter
    protected AndroidDriver androidDriver;


    protected AndroidObject() {
    	System.out.println("Inside Andriod objecttttttttttttttttt");
        this.androidDriver = AndroidHelper.getAndroidWebDriver();
        //this.props = ResourceBundle.getBundle("props/messages");
    }

    public void swipe(int startx, int starty, int endx, int endy, int duration) {
        androidDriver.swipe(startx, starty, endx, endy, duration);
    }
    
    public AndroidDriver getAndroidDriver(){
    	return this.androidDriver;
    			
    }

}
