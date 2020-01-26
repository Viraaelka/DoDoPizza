package com.main.stepdef;

import com.config.PageFactory;
import com.main.pages.WrapperPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.ru.Когда;

public class CommonSteps {
    WrapperPage wrapperPage = org.openqa.selenium.support.PageFactory.initElements(PageFactory.getDriver(), WrapperPage.class);

    @Когда("^мы заходим на главную страницу и отключаем куки$")
    public void turnOffCokies() {
        wrapperPage.turnOffCokies();
    }

    @When("^we go to DodoPage and turn off cookies$")
    public void startPageAndturnOffCokies() {
        wrapperPage.turnOffCokies();
    }

    @When("^checking titles on the navigation menu$")
    public void checkNavigationMenu() {
        wrapperPage.checkNavigationMenu();
    }

    @And("^checking what is going on when the mouse is navigated to the MyOrder button$")
    public void myOrderButtonNavigating() {
        wrapperPage.myOrderButtonNavigating();
    }

    @And("^verifying that we get to \"([^\"]*)\" page$")
    public void clickToVerifyPage(String pageName) {
        wrapperPage.clickToVerifyPage(pageName);
    }

    @And("^checking if the Camera container appears when the Live button is clicked$")
    public void checkCameraContainer() {
        wrapperPage.checkCameraContainer();
    }

    @And("^choosing \"([^\"]*)\" pizza$")
    public void selectPizza(String pizzaName) {
        wrapperPage.selectPizza(pizzaName);
    }

    @Given("^that we are choosing the city to be tested further - \"([^\"]*)\"$")
    public void chooseCityPage(String cityName) {
        wrapperPage.chooseCityPage(cityName);
    }

    @And("^checking that the city \"([^\"]*)\" has been chosen$")
    public void checkCityPage(String cityName) {
        wrapperPage.checkCityPage(cityName);
    }

}
