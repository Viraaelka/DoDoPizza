package com.main.pages;

import com.config.PageFactory;
import com.main.exceptions.AutotestException;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;
import java.util.NoSuchElementException;

public class ProductCard extends WrapperPage {
    public static String productXpath = "//div[contains(@class, 'ProductCard')]//*[contains(text(), '%s')]";
    public static String pizzaMyButtonCounter = myButtonXpath + "/div[@data-quantity='%s']";

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
        });
    }

    public void changePizzaDiameter(String size) {
        WebElement element;
        String endXpath = "//label[contains(text(), '%s')]";
        try {
            element = PageFactory.getDriver().findElement(By.xpath(String.format(productXpath, size)));
            element.click();
        } catch (NoSuchElementException e) {
        }
    }
    public void addProductToCart(){
        PageFactory.getDriver().findElement(By.xpath(String.format(productXpath, "Add to cart"))).click();
    }
    public void checkPizzaAmount(String pizzaAmount){
        WebElement element;
        try{
            element = PageFactory.getDriver().findElement(By.xpath(String.format(pizzaMyButtonCounter, pizzaAmount)));
            Assert.assertEquals("The amount of pizza is not equal to the choosen one", element.getText(), pizzaAmount);
        }
        catch (NoSuchElementException e){
            throw new AutotestException("Unable to determine the amount of pizza selected");
        }
    }
}
