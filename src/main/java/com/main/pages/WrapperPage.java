package com.main.pages;

import com.config.PageFactory;
import com.main.exceptions.AutotestException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

public class WrapperPage {
    private WebDriver driver = PageFactory.getDriver();

   // @FindBy(xpath = "//div[@class='navigation__inner']//li")
    List<WebElement> navigationList = driver.findElements(By.xpath("//div[@class='navigation__inner']//li"));

    String[] navigationNames = {"Pizza", "Snacks", "Desserts", "Drinks", "Deals", "Store info", "Live"};

    public WrapperPage(WebDriver driver){
        this.driver = driver;
    }

    public void turnOffCokies(){
        PageFactory.getDriver().findElement(By.xpath("//div[@class='cookie-policy']//button")).click();
    }
    public void checkTitle(String xpathPath, String actualValue){
        WebElement element = PageFactory.getDriver().findElement(By.xpath(xpathPath));
        if(!element.isDisplayed())
            throw new AutotestException(String.format("Element %s has been not found on the page %s",
                    element.getText(), this.getClass()));
        //todo check if Assert class can be declared in non-hooky class?
            Assert.assertEquals("Titles do not match", element.getText(), actualValue);
    }
    public void checkNavigationTitles(){
        for(int i = 0; i < navigationList.size(); i++) {
            checkTitle("//div[@class='navigation__inner']//li[" + i + "]", navigationNames[i]);
        }
    }


}
 // todo how to parse xpath path