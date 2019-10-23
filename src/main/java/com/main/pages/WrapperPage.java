package com.main.pages;

import com.config.PageFactory;
import com.main.exceptions.AutotestError;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WrapperPage {

    public void turnOffCokies(){
        PageFactory.getDriver().findElement(By.xpath("//div[@class='cookie-policy']//button")).click();
    }
    public void checkTitle(String xpathPath, String actualValue){
        WebElement element = PageFactory.getDriver().findElement(By.xpath(xpathPath));
        if(!element.isDisplayed())
            throw new AutotestError(String.format("Element %s has been not found on the page %s",
                    element.getText(), this.getClass()));
        //todo check if Assert class can be declared in non-hooky class?
            Assert.assertEquals("Titles do not match", element.getText(), actualValue);
    }
}
