package com.main.stepdef;

import com.config.PageFactory;
import com.main.pages.WrapperPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.ru.Когда;
import com.main.pages.MainClassRussianTest;

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
}
