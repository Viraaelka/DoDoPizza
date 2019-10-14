package com.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.JsonOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.NoSuchElementException;

public class MainTestClass{
    private WebDriver webdriver;

    public MainTestClass(WebDriver webdriver){
        this.webdriver = webdriver;
    }


    /*  public void getElementDisplayedOnNavigationPanel(){
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
    public List<WebElement> getNavigationMenuList(){
        for(WebElement elem : webdriver.findElements(By.xpath("//ul[@class='navigation__list']/descendant::a"))){
            System.out.println(elem.getText());
        }
        return webdriver.findElements(By.xpath("//ul[@class='navigation__list']/descendant::a"));
    }
    public int findAmountOfElements(List<WebElement> array){
        if(array.isEmpty())
            throw new NoSuchElementException("The list of elements is empty " + array.toString());
        return array.size();
    }
    public void clickOnItem(){
        webdriver.findElement(By.xpath("(//a[@class=' navigation__link link'])[1]")).click();
    }
}
