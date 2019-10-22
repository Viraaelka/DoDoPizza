package com.main.stepdef;

import com.config.PageFactory;
import com.main.pages.MainTestClass;
import com.main.exceptions.AutotestException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class MainClassSteps {

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

    @When("^applying a code to get a sale for pizza order$")
    public void applyPromo(DataTable dataTable) {
        List<String> promoList = dataTable.asList();
        if (promoList.size() < 1) {
            throw new AutotestException("No Giveaway code has been found");
        }
        else if (promoList.size() == 1) {
            if (checkIfElementIsPresent(mainTestClass.promocodeInput, 3) && checkIfElementIsPresent(mainTestClass.applyPromoButton, 3)) {
            if (promoList.get(0).equals("")) {
                mainTestClass.promocodeInput.sendKeys(promoList.iterator().next().toString());
                mainTestClass.applyPromoButton.click();
                checkIfElementIsPresent(mainTestClass.promoPopupMessage, 3);
                Assert.assertEquals(mainTestClass.promoPopupMessage.getText(), "Используйте цифры и латинские буквы");
            } else {
                    mainTestClass.promocodeInput.sendKeys(promoList.iterator().next().toString());
                    mainTestClass.applyPromoButton.click();
                    //   Assert.assertTrue("Promocode is applied", mainTestClass.promoPopupMessage.getText().equals(""));
                    System.out.println("Promocode is applied"); // Log
                Assert.assertEquals(mainTestClass.promoPopupMessage.getText(), "Промокод не найден. Попробуйте другой");
                }
            }
            //     com.config.PageFactory.getDriver().findElement(By.xpath("//div[@class = 'menu__promocode']/descendant-or-self::input")).sendKeys(promoList.iterator().next().toString());
            //    com.config.PageFactory.getDriver().findElement(By.xpath("//div[@class = 'menu__promocode']/descendant-or-self::button")).click();

        }
        if (promoList.size() > 1) {
            promoList.forEach(s -> {
                try {
                       mainTestClass.promocodeInput.sendKeys(s);
                       mainTestClass.applyPromoButton.click();
                       new WebDriverWait(PageFactory.getDriver(), 5).until(ExpectedConditions.visibilityOf(mainTestClass.promoPopupMessage));
                    if(s.equals("")) {
                        Assert.assertEquals(mainTestClass.promoPopupMessage.getText(), "Используйте цифры и латинские буквы");
                    } else{
                        Assert.assertEquals(mainTestClass.promoPopupMessage.getText(), "Промокод не найден. Попробуйте другой");
                    }
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

    @And("^going to the page \"Mistery Shopper\" to fill up a form for a free pizza$")
    public void goToFillUpMistyryForm(){
        if (checkIfElementIsPresent(mainTestClass.fillUpMistyrShopperButton, 3))
           mainTestClass.fillUpMistyrShopperButton.click();

        // TODO input windowHandles to go to control page
        // todo: refactor page to make them fully the same as URLs

        Assert.assertEquals("Texts do not fully match", PageFactory.getDriver().findElement(By.xpath("//h1")).getText(), "КАК НАСЧЕТ БЕСПЛАТНОЙ ПИЦЦЫ?");
    }
    @And("^turning off a cookie pop-up message$")
    public void turnOffCokies(){
        mainTestClass.turnOffCokies();
        // todo: implement method to turn off cookies
    }

    public boolean checkIfElementIsPresent(WebElement element, int time) {
        try {
            Actions actions = new Actions(PageFactory.getDriver());
            actions.moveToElement(element).build().perform();
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
     /*   checkingMap.forEach((k,v) -> {
            if (k instanceof MainTestClass)

        }); */
    }


}
// https://stackoverflow.com/questions/44912203/selenium-web-driver-java-element-is-not-clickable-at-point-x-y-other-elem