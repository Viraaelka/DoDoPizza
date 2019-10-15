package ru.tests;

import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BeforeAfterSetup {

    public static WebDriver driver;
    // Note - don't use ".exe" for MAC !!!
   //  private static String driverPath = "/Users/halilovaelvira/IdeaProjects/MyOwnAE2/src/chromedriver";
    private static String driverPath = "/home/elvira/IdeaProject/Utils/chromedriver";
    private static String website = "https://dodopizza.ru/peterburg";

  //  @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(website);
    }

    public void goToDodoPage(){
        driver.get(website);
    }

  //  @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
