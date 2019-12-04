package com.main.pages;

import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class ProductCard extends WrapperPage {
    @FindBy(xpath = "//div[contains(@class, 'ProductCard')]")
    WebElement sizeAndPastry;

    public ProductCard(WebDriver driver) {
        super(driver);
    }

    public void checkSizeAndPastry(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        dataMap.forEach((k, v) -> {
            StringBuilder temp = new StringBuilder();
            switch (k) {
                case "Size":
                    temp.append(v).append("\", ");
                    break;
                case "Kind of pastry":
                    temp.append(v);
                    break;
            }
            System.out.println("Siiiize = " + temp);
            Assert.assertEquals("Incorrect value of size and pastry", sizeAndPastry.getText(), temp);
        });
    }
}
