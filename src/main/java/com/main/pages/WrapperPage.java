package com.main.pages;

import com.config.PageFactory;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;

public class WrapperPage {



    public void turnOffCokies(){
        PageFactory.getDriver().findElement(By.xpath("")).click();
    }
}
