package com.main.pages;

import com.config.PageFactory;
import com.main.exceptions.AutotestException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainEnglishPage extends WrapperPage {
    public static String itemXpath = "//div[@class='page__wrapper']//*[contains(text(),'%s')]//ancestor::div[contains(@data-testid,'menu__product')]//button";
    public MainEnglishPage(WebDriver driver) {
        super(driver);
    }

    //todo -> stopped the progress here -> continue from this method
    public void selectItem(String itemName){
        WebElement addToCartButton;
        try{
            addToCartButton = PageFactory.getDriver().findElement(By.xpath(String.format(itemXpath, itemName)));
            addToCartButton.click();
            Assert.assertTrue(String.format("Unable to find %s element", itemName), addToCartButton.getText(), );
        }
        catch(NoSuchElementException e){
            throw new AutotestException(String.format("Unable to find the item \"%s\"",itemName));
        }
    }
}
