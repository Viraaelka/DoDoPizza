package com.main.stepdef;

import com.config.PageFactory;
import com.main.pages.MainClassRussianTest;
import com.main.exceptions.AutotestException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class MainClassRussianSteps {

    private WebDriver driver = PageFactory.getDriver();
    public MainClassRussianTest mainTestClass = org.openqa.selenium.support.PageFactory.initElements(driver, MainClassRussianTest.class);

    @И("^переходим на страницу <Тайный покупатель>$")
    public void goToFillUpMistyryForm() {
        WebElement title = driver.findElement(By.xpath("//div[@class = 'secret-buyer-section__desc']"));
        String homePage = driver.getWindowHandle();
        final Set<String> oldWindowSet = driver.getWindowHandles();
        if (checkIfElementIsPresent(mainTestClass.fillUpMistyrShopperButton, 3)) {
            Assert.assertEquals("The MysterForm is not present on " + this.getClass().getName(),
                    "Стань тайным покупателем Додо Пиццы и получи пиццу в подарок",
                    title.getText());
            mainTestClass.fillUpMistyrShopperButton.click();
        }
        String newWindow = (new WebDriverWait(driver, 5)).until(new ExpectedCondition<String>(){
            public String apply (WebDriver driver) {
                Set<String> newWindowSet = driver.getWindowHandles();
                newWindowSet.removeAll(oldWindowSet);
                return newWindowSet.size() > 0 ? newWindowSet.iterator().next() : null;
            }
        });
        driver.switchTo().window(newWindow);
        Assert.assertEquals("Texts do not fully match:", driver.findElement(By.xpath("//h1")).getText(), "КАК НАСЧЕТ БЕСПЛАТНОЙ ПИЦЦЫ?");
    }



    public boolean checkIfElementIsPresent(WebElement element, int time) {
        try {
            Actions actions = new Actions(PageFactory.getDriver());
            actions.moveToElement(element).build().perform();
            new WebDriverWait(com.config.PageFactory.getDriver(), time)
                    .until(ExpectedConditions.visibilityOf(element));
            return true;

        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("Element with text .. is not located on the page"); // Log
            return false;
        }
    }
}
// https://stackoverflow.com/questions/44912203/selenium-web-driver-java-element-is-not-clickable-at-point-x-y-other-elem