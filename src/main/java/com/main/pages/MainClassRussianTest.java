package com.main.pages;

import com.config.PageFactory;
import com.main.exceptions.AutotestException;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class MainClassRussianTest extends WrapperPage {
    //   private WebDriver webdriver = com.config.PageFactory.getDriver();

    public String framePizzaWindow = "//div[@class='popup__dialog-inner']";

    @FindBy(xpath = "(//div[@id='pizzas']//button[1]")
    public WebElement chooseButton;

    @FindBy(xpath = "//div[@class='popup__dialog-inner']/descendant::span[contains(@class, ProductCardNameValue)][1]")
    public WebElement titleInChosenWindow;

    /* ============================ Applying promocode ==========================================*/
    @FindBy(xpath = "//div[@class = 'menu__promocode']/descendant-or-self::input")
    public WebElement promocodeInput;

    @FindBy(xpath = "//div[@class = 'menu__promocode']/descendant-or-self::button[text()='Применить']")
    public WebElement applyPromoButton;

    @FindBy(xpath = "//div[@class = 'tooltip-base__content']")
    public WebElement promoPopupMessage;

    @FindBy(xpath = "//div[@class='secret-buyer-section']//a[text()='Заполнить анкету']")
    public WebElement fillUpMistyrShopperButton;

    public MainClassRussianTest(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div[@class='popup__dialog-inner']//following-sibling::span")
    public WebElement pizzaTitle;

}
