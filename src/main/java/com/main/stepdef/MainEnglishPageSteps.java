package com.main.stepdef;

import com.config.PageFactory;
import com.main.pages.MainEnglishPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class MainEnglishPageSteps {
    WebDriver driver = PageFactory.getDriver();
    MainEnglishPage mainEnglishPage = new MainEnglishPage();

    @Then("^clicking 'Add To Cart' to choose \"([^\"]*)\" (?:pizza |item |beverage |)at the price \"([^\"]*)\"$")
    public void selectItem(String nameOfItem, String price) {
        mainEnglishPage.selectItem(nameOfItem, price);
    }

    @And("^checking if the necessary product has been 'Added'$")
    public void verificationPopUpMessage() {
        mainEnglishPage.verificationPopUpMessage();
    }
}
