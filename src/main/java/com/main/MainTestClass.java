package com.main;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.JsonOutput;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.NoSuchElementException;

public class MainTestClass{
    private WebDriver webdriver;

    public MainTestClass(WebDriver webdriver){
        this.webdriver = webdriver;
    }
    public String framePizzaWindow = "//div[@class='popup__dialog-inner']";

    @FindBy (xpath = "(//button[text()='Выбрать'])[1]")
    public WebElement chooseButton;

    @FindBy (xpath = "//div[@class='popup__dialog-inner']/descendant::span[contains(@class, ProductCardNameValue)][1]")
    public WebElement titleInChosenWindow;

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

    public void clickOnItem(WebElement element){
        if(element.isDisplayed())
            element.click();
        else
            throw new NoSuchElementException("Unable to find and click on the element " + element.getText());
    }
}
