package com.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainTestClass{
    private WebDriver webdriver;

    public MainTestClass(WebDriver webdriver){
        this.webdriver = webdriver;
    }
/*   public List<WebElement> navigationMenu = webdriver.findElements(By.xpath("//li[@class='navigation__item']"));

    public void getElementDisplayedOnNavigationPanel(){
        int count = 0;
        for(WebElement element : navigationMenu){
            if(element.isDisplayed()){
                count++;
            }
        }
        System.out.println(count + " getTitle() = " + webdriver.getTitle());
        //   return navigationMenu.stream().filter(webElement -> webElement.isDisplayed()).peek();
        // return count;
    }
    */
    public void clickOnItem(){
        webdriver.findElement(By.xpath("(//a[@class=' navigation__link link'])[1]")).click();
    }
}
