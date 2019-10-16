package com.main.hooks;


import com.config.PageFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver;
    // Note - don't use ".exe" for MAC !!!
    private static String driverPath = "/Users/halilovaelvira/IdeaProjects/MyOwnAE2/src/chromedriver";
    // private static String driverPath = "/home/elvira/IdeaProject/Utils/chromedriver";
    public static String website = "https://dodopizza.ru/peterburg";

    @Before
    public void setUp() {
        new PageFactory().setUp();
    }

    @After
    public void clearData() {
        new PageFactory().clearData();
    }
}
