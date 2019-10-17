package com.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageFactory {
    private static WebDriver driver;

    private static String driverPath = "/Users/halilovaelvira/IdeaProjects/MyOwnAE2/chromedriver";
   //  private static String driverPath = "/home/elvira/IdeaProject/Utils/chromedriver";
    public static String website = "https://dodopizza.ru/peterburg";

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", getDriverPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
