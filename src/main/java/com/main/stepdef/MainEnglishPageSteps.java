package com.main.stepdef;

import com.config.PageFactory;
import com.main.pages.MainEnglishPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class MainEnglishPageSteps {
    WebDriver driver = PageFactory.getDriver();
    MainEnglishPage mainEnglishPage = new MainEnglishPage(driver);

    @Then("^clicking \"Add To Cart\" to choose \"([^\"]*)\" (?:pizza| beverage | item|)$")
    public void selectItem(String itemName){
        mainEnglishPage.selectItem(itemName);
    }
}
