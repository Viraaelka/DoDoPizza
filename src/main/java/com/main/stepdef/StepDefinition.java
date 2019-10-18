package com.main.stepdef;

import com.config.PageFactory;
import com.main.MainTestClass;
import com.main.exceptions.AutotestException;
import com.main.hooks.Hooks;
import com.oracle.tools.packager.windows.WinExeBundler;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class StepDefinition {

    MainTestClass mainTestClass = org.openqa.selenium.support.PageFactory.initElements(PageFactory.getDriver(), MainTestClass.class);

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
    public void clickOn(DataTable elementName, WebElement element) {
        //   CHECK HOW TO GET ARRAYLIST FROM DATATABLE
        //    List<String> elementList = elementName.
        if (!element.isDisplayed())
            throw new AutotestException(String.format("Elemenet %s was not displayed", element.getText()));
        element.click();
    }

    @And("^checking that$")
    public void titleCheck() {
        mainTestClass.chooseButton.click();
        // How to check that the page is opened?
        if (mainTestClass.pizzaTitle.isDisplayed())
            Assert.assertEquals("Пепперони Фреш с перцем", mainTestClass.pizzaTitle.getText());
    }

    @When("applying a code to get a sale for pizza order")
    public void applyPromo(DataTable dataTable) {
        List<String> promoList = dataTable.asList();
        if (promoList.size() < 1)
            throw new AutotestException("No Giveaway code has been found");
        else if (promoList.size() == 1) {
            if (isElementVisible(mainTestClass.promocodeInput, 3) && isElementVisible(mainTestClass.applyPromoButton, 3)) {
                mainTestClass.promocodeInput.sendKeys(promoList.iterator().next().toString());
                mainTestClass.applyPromoButton.click();
                Assert.assertTrue("Promocode is applied", mainTestClass.promoPopupMessage.getText().equals(""));
                System.out.println("Promocode is applied"); // Log
            }
            //     com.config.PageFactory.getDriver().findElement(By.xpath("//div[@class = 'menu__promocode']/descendant-or-self::input")).sendKeys(promoList.iterator().next().toString());
            //    com.config.PageFactory.getDriver().findElement(By.xpath("//div[@class = 'menu__promocode']/descendant-or-self::button")).click();

        }
        if (promoList.size() > 1) {
            promoList.forEach(s -> {
                try {
                    mainTestClass.promocodeInput.sendKeys(s);
                    mainTestClass.applyPromoButton.click();
                } catch (NoSuchElementException e) {
                    throw new AutotestException("No such elements");
                }
            });
           /* int count = promoList.size();
            do{
                if (isElementVisible(mainTestClass.promocodeInput) && isElementVisible(mainTestClass.applyPromoButton)){
                    mainTestClass.promocodeInput.sendKeys();
                }

                count--;
            }while(count > 0); */
        }

    }

    public boolean checkIfElementIsPresent(WebElement element, int time) {
        try {
            new WebDriverWait(com.config.PageFactory.getDriver(), time)
                    //  .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(., '" + text + "')]")));
                    .until(ExpectedConditions.visibilityOf(element));
            return true;

        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("Element with text .. is not located on the page"); // Log
            return false;
        }
    }

    public void checkIfElementPresent(DataTable dataTable) {
        Map<String, String> checkingMap = dataTable.asMap(String.class, String.class);
        checkingMap.forEach((k,v) -> {
            if (k instanceof MainTestClass)
        });
    }
}
