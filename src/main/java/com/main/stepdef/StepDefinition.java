package com.main.stepdef;

import com.main.MainTestClass;
import com.main.exceptions.AutotestException;
import com.main.hooks.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class StepDefinition {
   // private WebDriver driver;
    MainTestClass mainTestClass = PageFactory.initElements(Hooks.driver, MainTestClass.class);

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
    @When("applying a code to get a sale for pizza order")
    public void applyPromo(DataTable dataTable){
        List<String> promoList = dataTable.asList();
        if(promoList.size() < 1)
            throw new AutotestException("No Giveaway code has been found");
        else if(promoList.size() == 1) {
           // if (isElementVisible(mainTestClass.promocodeInput) && isElementVisible(mainTestClass.applyPromoButton)) {
                mainTestClass.promocodeInput.sendKeys(promoList.iterator().next().toString());
                mainTestClass.applyPromoButton.click();
         //   }
       //     com.config.PageFactory.getDriver().findElement(By.xpath("//div[@class = 'menu__promocode']/descendant-or-self::input")).sendKeys(promoList.iterator().next().toString());
        //    com.config.PageFactory.getDriver().findElement(By.xpath("//div[@class = 'menu__promocode']/descendant-or-self::button")).click();

        }
        if (promoList.size() > 1) {

           /* int count = promoList.size();
            do{
                if (isElementVisible(mainTestClass.promocodeInput) && isElementVisible(mainTestClass.applyPromoButton)){
                    mainTestClass.promocodeInput.sendKeys();
                }

                count--;
            }while(count > 0); */
        }

    }
    public boolean isElementVisible(WebElement element){
        try{
          //  new WebDriverWait(com.config.PageFactory.getDriver(), 5).until(ExpectedConditions.visibilityOf(element));
            if(!element.isDisplayed())
                new Actions(com.config.PageFactory.getDriver()).moveToElement(element).build();
        }catch (NoSuchElementException e){
            return false;
        }
        return true;
    }
}
