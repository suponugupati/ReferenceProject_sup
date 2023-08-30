package com.cucumber.framework.helpers;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UrlBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(UrlBuilder.class);
    private static final String RUN_CONFIG_PROPERTIES = "/environment.properties";
    private static URL basePath;
    private static URL apiUrl;

    static {
        try {
            Props.loadRunConfigProps(RUN_CONFIG_PROPERTIES);
            basePath = new URL(Props.getProp("site.url"));
            apiUrl = new URL(Props.getProp("api.url"));
            //System.out.println("URIBUILDER URIBUILDER  URIBUILDER URIBUILDER URIBUILDER URIBUILDER");
        } catch (MalformedURLException e) {
            LOG.error(e.getMessage());
        }

    }

    public static void startAtHomePage() {
    	//System.out.println("STARTHOMEPAGE STARTHOMEPAGE STARTHOMEPAGE STARTHOMEPAGE STARTHOMEPAGE STARTHOMEPAGE STARTHOMEPAGE");
        //WebDriverHelp.getWebDriver().navigate().to((basePath));
    	LocalDriverManager.getDriver().navigate().to(basePath);
        //Hooks.driver.navigate().to(basePath);
    	
    }
    
    public static void startAtHomePageMobile() {
        //WebDriverHelper.getWebDriver().navigate().to((basePath));
        AndroidHelper.getAndroidWebDriver().navigate().to(basePath);
    }


    public static URL getApiUrlForEndPoint(String endpoint) {
        return createApiUrl(endpoint);
    }

    public static URI getBasePathURI() {
        return URI.create(Props.getProp("api.url"));
    }


    public static String getUrl(String applicationUrl) {
        return Props.getProp(applicationUrl);
    }


    public static URL createApiUrl(String endpoint) {
        try {
            return new URL(apiUrl.getProtocol(), apiUrl.getHost(), apiUrl.getPort(), endpoint);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    public static URL createUrl(String path) {
        try {
            return new URL(basePath.getProtocol(), basePath.getHost(), basePath.getPort(), path);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
