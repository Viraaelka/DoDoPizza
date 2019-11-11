package com.main.pages;

import com.config.PageFactory;
import com.main.exceptions.AutotestException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WrapperPage {
    private WebDriver driver = PageFactory.getDriver();

    List<WebElement> navigationList;

    public String[] navigationNames = {"Pizza", "Snacks", "Desserts", "Drinks", "Deals", "Store info", "Live"};

    public WrapperPage(WebDriver driver) {
        this.driver = driver;
    }

    public void turnOffCokies() {
        PageFactory.getDriver().findElement(By.xpath("//div[@class='cookie-policy']//button")).click();
    }

    public List<WebElement> getList() {
        return navigationList = driver.findElements(By.xpath("//div[@class='navigation__inner']//li"));
    }

    public void checkNavigationMenu() {
        if (getList().size() != 0) {
            Assert.assertTrue("The size of String[] array does not match navigationList, expected = "
                            + navigationNames.length + " actual = " + getList().size(),
                    navigationNames.length == getList().size());
        } else
            throw new AutotestException("The navigition menu is not full, some elements are missing");
    }
}
// todo how to parse xpath path