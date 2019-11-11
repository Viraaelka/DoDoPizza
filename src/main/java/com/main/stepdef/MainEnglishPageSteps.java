package com.main.stepdef;

import com.config.PageFactory;
import com.main.pages.MainEnglishPage;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

public class MainEnglishPageSteps {
    WebDriver driver = PageFactory.getDriver();
    MainEnglishPage mainEnglishPage = new MainEnglishPage(driver);

}
