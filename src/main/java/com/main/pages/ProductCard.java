package com.main.pages;

import com.config.PageFactory;
import com.main.exceptions.AutotestException;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.NoSuchElementException;

public class ProductCard extends WrapperPage {
    public static final Logger LOG = LoggerFactory.getLogger(ProductCard.class);

    public static String productXpath = "//div[contains(@class, 'ProductCard')]//*[contains(text(), '%s')]";
    public static String pizzaMyButtonCounter = myButtonXpath + "/div[@data-quantity='%s']";
    private static String extraToppingXpath = "//span[text()='%s']";

    public ProductCard(WebDriver driver) {
        super(driver);
    }

    public void checkSizeAndPastry(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        dataMap.forEach((k, v) -> {
            WebElement element = null;
            switch (k) {
                case "Size":
                    element = PageFactory.getDriver().findElement(By.xpath(String.format(productXpath, v)));
                    Assert.assertEquals("Incorrect value of size and pastry", element.getText().replaceAll("\\D", ""), v);
                    break;
                case "Kind of pastry":
                    element = PageFactory.getDriver().findElement(By.xpath(String.format(productXpath, v)));
                    Assert.assertEquals("Incorrect value of size and pastry", element.getText().replaceAll("\\d+\\W+", ""), v.toLowerCase());
                    break;
            }
            LOG.info("You have chosen the pizza with following parameters: " + k + ": " + v);
        });
    }

    public void changePizzaDiameter(String size) {
        WebElement element;
        String endXpath = "//label[contains(text(), '%s')]";
        try {
            element = PageFactory.getDriver().findElement(By.xpath(String.format(productXpath, size)));
            element.click();
            LOG.info("The button " + element.getText() + " has been clicked");
        } catch (NoSuchElementException e) {
        }
    }

    public void addProductToCart() {
        PageFactory.getDriver().findElement(By.xpath(String.format(productXpath, "Add to basket"))).click();
        LOG.info("The pizza has been added to the basket");
    }

    public void checkPizzaAmount(String pizzaAmount) {
        WebElement element;
        try {
            element = PageFactory.getDriver().findElement(By.xpath(String.format(pizzaMyButtonCounter, pizzaAmount)));
            Assert.assertEquals("The amount of pizza is not equal to the choosen one", element.getText(), pizzaAmount);
            LOG.info("The amount of chosen items is equal to " + pizzaAmount);
        } catch (NoSuchElementException e) {
            throw new AutotestException("Unable to determine the amount of pizza selected");
        }
    }

    public void addToppings(String toppingName) {
        String plusXpath = String.format(extraToppingXpath, toppingName) + "/parent::button//i";
        try {
            PageFactory.getDriver().findElement(By.xpath(plusXpath))
                    .click();
            LOG.info("The topping \"" + toppingName + "\" has been added to the order");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void checkToppings(String toppingName) {
        WebElement extraToppingElement = null;
        try {
            extraToppingElement = PageFactory.getDriver()
                    .findElement(By.xpath(String.format(extraToppingXpath, toppingName)));
            Assert.assertEquals("Values do not match",
                    toppingName.trim().toLowerCase(),
                    extraToppingElement.getText());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

}
