package com.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class PageFactory {
    private static WebDriver driver;

    //private static String driverPath = "/Users/halilovaelvira/IdeaProjects/MyOwnAE2/chromedriver";
    private static String driverPath = "/home/elvira/IdeaProject/Utils/chromedriver";
    public static String website = "https://dodopizza.com/oxford";
    //  public static String website = "https://dodopizza.ru/petergof/";

    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        //   options.addArguments("--user-data-dir=/Users/halilovaelvira/Library/Application Support/Google/Chrome/");
        //   options.addArguments("--profile-directory=NewProfile_1");
        System.setProperty("webdriver.chrome.driver", getDriverPath());
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(website);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getDriverPath() {
        return driverPath;
    }

    public void clearData() {
        driver.quit();
    }

}


/**
 * First of all input following: "chrome://version/" in the browser then find path "Путь к профилю	/Users/halilovaelvira/Library/Application"
 * <p>
 * chrome://version/
 */