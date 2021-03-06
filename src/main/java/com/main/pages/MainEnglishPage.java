package com.main.pages;

import com.config.PageFactory;
import com.main.exceptions.AutotestException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainEnglishPage extends WrapperPage {
    public static final Logger LOG = LoggerFactory.getLogger(MainEnglishPage.class);
    // todo and add the line to WAIT the next element
    public static String itemXpath = "//*[contains(text(), '%s')]//ancestor::div[contains(@class,'product__inner')]//span[text()='%s']";
    public static String addToCartXath = "//ancestor::div[contains(@class, 'product__cart')]//button[text()='Add to cart']";
    public static String popUpXpath = "//div[contains(text(),'%s:')]";

    public MainEnglishPage(WebDriver driver) {
        super(driver);
    }

    public void selectItem(String nameOfItem, String price) {
        try {
            if (!nameOfItem.equals("") && !price.equals("")) {
                getItemElement(nameOfItem, price).click();
                Assert.assertTrue(String.format("Unable to find %s element at the price %s", nameOfItem, price), !isElementToBeClickable(getItemElement(nameOfItem, price)));
                LOG.info(String.format("The item \"%s\" has been chosen and added to cart"));
            }
        } catch (NoSuchElementException e) {
            throw new AutotestException("Could not fine the element on the home page");
        }
    }

    public void verificationPopUpMessage() {
        String realMessage = "";
        try {
            realMessage = PageFactory.getDriver().findElement(By.xpath(String.format(popUpXpath, "Added"))).getText();
            Assert.assertEquals("Message on popup window does not match", realMessage, "Added:");
            LOG.info("The correct popup message appeared once we added the necessary product to card");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public WebElement getItemElement(String nameOfItem, String price) {
        try {
            return PageFactory.getDriver().findElement(By.xpath(String.format(itemXpath, nameOfItem, price) + addToCartXath));
        } catch (NoSuchElementException e) {
            throw new AutotestException("Could not fine the element on the home page");
        }
    }
}
