package com.main.pages;

import com.main.exceptions.AutotestException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainEnglishPage extends WrapperPage {
    public static String itemXpath = "//div[@class='page__wrapper']//*[contains(text(),'%s')]";
    public MainEnglishPage(WebDriver driver) {
        super(driver);
    }

    //todo -> stopped the progress here -> continue from this method
    public void selectItem(String itemName){
        try{

        }
        catch(NoSuchElementException e){
            throw new AutotestException(String.format("Unable to find the item \"%s\"",itemName));
        }
    }
}
