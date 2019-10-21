package com.main.pages;

import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChoosePizza { // extends MainTestClass {

 /*   public ChoosePizza(WebDriver webdriver) {
        super(webdriver);
    } */

    @FindBy(xpath = "//div[@class='popup__dialog-inner']//following-sibling::span")
    public WebElement pizzaTitle;

  //  @And("^checking that$")
    public void titleCheck(){
   //     chooseButton.click();
        // How to check that the page is opened?
        if(pizzaTitle.isDisplayed())
            Assert.assertEquals("Пепперони Фреш с перцем", pizzaTitle.getText());
    }
}
