package com.main.stepdef;

import com.main.MainTestClass;
import com.main.exceptions.AutotestException;
import gherkin.ast.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class StepDefinition {
   // private WebDriver driver;
    MainTestClass mainTestClass = PageFactory.initElements(com.config.PageFactory.getDriver(), MainTestClass.class);

    @Given("^some map of values$")
    public void givenMap(Map<String, Integer> map) {
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry);
        }
    }

  /*  @When("^going to the Home page$")
    public void goToHomePage() {
        Hooks.driver.get("https://www.dokwork.ru/2015/08/cucumber.html");
    } */

    @And("^clicking on (?:element |checkbox|) <(.?)>$")
    public void clickOn(DataTable elementName, WebElement element){
     //   CHECK HOW TO GET ARRAYLIST FROM DATATABLE
    //    List<String> elementList = elementName.
        if(!element.isDisplayed())
            throw new AutotestException(String.format("Elemenet %s was not displayed", element.getText()));
        element.click();
    }

    @And("^checking that$")
    public void titleCheck(){
        mainTestClass.chooseButton.click();
        // How to check that the page is opened?
        if(mainTestClass.pizzaTitle.isDisplayed())
            Assert.assertEquals("Пепперони Фреш с перцем", mainTestClass.pizzaTitle.getText());
    }
}
