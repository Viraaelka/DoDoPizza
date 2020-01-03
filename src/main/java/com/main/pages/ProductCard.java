package com.main.pages;

import com.config.PageFactory;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class ProductCard extends WrapperPage {

    public ProductCard(WebDriver driver) {
        super(driver);
    }

    public void checkSizeAndPastry(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String xpathEnd = "//div[contains(@class, 'ProductCard')]//span[contains(text(), '%s')]";
        dataMap.forEach((k, v) -> {
            WebElement element = null;
            switch (k) {
                case "Size":
                    element = PageFactory.getDriver().findElement(By.xpath(String.format(xpathEnd, v)));
                    Assert.assertEquals("Incorrect value of size and pastry", element.getText().replaceAll("\\D", ""), v);
                    break;
                case "Kind of pastry":
                    element = PageFactory.getDriver().findElement(By.xpath(String.format(xpathEnd, v)));
                    Assert.assertEquals("Incorrect value of size and pastry", element.getText().replaceAll("\\d+\\W+", ""), v.toLowerCase());
                    break;
            }
        });
    }
}
