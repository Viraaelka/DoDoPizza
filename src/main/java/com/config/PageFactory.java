package com.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class PageFactory {
    private static WebDriver driver;
    private static String driverPath = "/home/aelya/Загрузки/chromedriver";
    public static String website = "https://dodopizza.com/germantown";
    //  public static String website = "https://dodopizza.ru/petergof/";

    public void setUp() {
        ChromeOptions options = new ChromeOptions();
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

    public void quitDriver() {
        driver.quit();
    }

}
